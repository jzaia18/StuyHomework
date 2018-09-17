#!/usr/bin/python
print 'content-type: text/html'

#Zaia, Jake
#Intro2, PD2
#Lab15
#2016-05-12

#import cgitb
#cgitb.enable()

import cgi
form=cgi.FieldStorage()

import hashlib

directory='data/'
f=open(directory+'masterlist.txt','a')

g=open(directory+'masterlist.txt','r')
passlist=g.read()
g.close()
passlist=passlist.split('\n')
for each in range(len(passlist)):
    passlist[each]=passlist[each].split(',')

def checkLogin(usr,pas):
    for each in passlist:
        if each[0]==usr:
            if each[1]==pas:
                return True
            else:
                return False
    return False

print '''
<!DOCTYPE html>
<html>
 <head>
 </head>
 <body>'''

if 'login' in form and 'username' in form and 'password' in form:
    if checkLogin(form.getvalue('username'),(hashlib.sha256(form.getvalue('password')).hexdigest())):
        print 'Logged in successfully. Welcome.'
    else:
        print 'Incorrect username or password, please try again.'
elif 'login' in form:
    print 'Username AND password required to log in.'
else:
    print '''  <table border="1">
   <tr><th> Log In: </th></tr>
   <form method="GET" action="login.py">
    <tr><td><table><tr><td>Username:</td><td><input type="text" name="username" size="10"></td></tr>
    <tr><td>Password:</td><td><input type="text" name="password" size="10"></td></tr></table></td></tr>
   </table>
   <input type="submit" name="login" value="Log In">
  </form>'''

print ''' </body>
</html>'''

f.close()
