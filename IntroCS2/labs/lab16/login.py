#!/usr/bin/python
print 'content-type: text/html'

#Zaia, Jake
#Intro2, PD2
#lab16
#2016-05-17

import cgitb
cgitb.enable()

import cgi
form=cgi.FieldStorage()

import hashlib

import random

import os
ip=os.environ["REMOTE_ADDR"]
#ip='127.0.0.1'

if 'username' in form:
    username=form.getvalue('username')
ID=str(1000000+random.randint(0,8999999))

directory='data/'

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

def checkUsrIn(usr,L):
    for each in range(len(L)):
        if L[each][0]==usr:
            return each
    return len(L)
    
def writeToFile(usr):
    logfile=open(directory+'loggedin.txt','r')
    loggedin=logfile.read()
    logfile.close()
    loggedin=loggedin.split('\n')
    i=0
    while i<len(loggedin):
        if loggedin[i]=='':
            loggedin.pop(i)
        else:
            loggedin[i]=loggedin[i].split(',')
            i+=1
    insert=checkUsrIn(usr,loggedin)
    logfile=open(directory+'loggedin.txt','w')
    convertSyntax(loggedin[0:insert],logfile)
    logfile.write(usr+','+ID+','+ip+'\n')
    convertSyntax(loggedin[insert+1:],logfile)
    logfile.close()

def convertSyntax(L,target):
    for each in range(len(L)):
        L[each]=','.join(L[each])
    L='\n'.join(L)
    target.write(L+'\n')

print '''
<!DOCTYPE html>
<html>
 <head>
 </head>
 <body>'''

if 'login' in form and 'username' in form and 'password' in form:
    if checkLogin(username,(hashlib.sha256(form.getvalue('password')).hexdigest())):
        writeToFile(username)
        print '  <a href="mainpage.py?user='+username+'&ID='+ID+'">Logged in successfully. Welcome.</a>'
    else:
        print 'Incorrect username or password, please try again.'
elif 'login' in form:
    print 'Username AND password required to log in.'
else:
    print '''  <table border="1">
   <tr><th> Log In: </th></tr>
   <form method="POST" action="login.py">
    <tr><td><table><tr><td>Username:</td><td><input type="text" name="username" size="10"></td></tr>
    <tr><td>Password:</td><td><input type="text" name="password" size="10"></td></tr></table></td></tr>
   </table>
   <input type="submit" name="login" value="Log In">
  </form>'''

print ''' </body>
</html>'''
