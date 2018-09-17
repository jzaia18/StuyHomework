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

def duplicatesIn(usr):
    for each in passlist:
        if each[0]==usr:
            return True
    return False

print '''
<!DOCTYPE html>
<html>
 <head>
 </head>
 <body>'''

if 'ca' in form and 'username' in form and 'password' in form:
    if not form.getvalue('username').isalnum():
        print 'Usernames must be alphanumeric.'
    else:
        if not duplicatesIn(form.getvalue('username')):
            f.write(form.getvalue('username')+','+(hashlib.sha256(form.getvalue('password')).hexdigest())+'\n')
            print 'Account Created Successfully'
        else:
            print 'Username already in use.'
elif 'ca' in form:
    print 'Username AND Password required to create an account.'
else:
    print '''  <table border="1">
   <tr><th> Create An Account: </th></tr>
   <form method="GET" action="createaccount.py">
    <tr><td><table><tr><td>Username:</td><td><input type="text" name="username" size="10"></td></tr>
    <tr><td>Password:</td><td><input type="text" name="password" size="10"></td></tr></table></td></tr>
   </table>
   <input type="submit" name="ca" value="Create Account">
  </form>'''

print ''' </body>
</html>'''

f.close()
