#!/usr/bin/python
print 'content-type: text/html'

#Zaia, Jake
#Intro2 PD2
#lab16
#2016-05-17

import cgitb
cgitb.enable()

import cgi
form=cgi.FieldStorage()

if 'user' in form:
    user=form.getvalue('user')
else:
    user='<'

if 'ID' in form:
    ID=form.getvalue('ID')
else:
    ID='NOPE'

import os
ip=os.environ['REMOTE_ADDR']
#ip=127.0.0.1

directory='data/'

head='''
<!DOCTYPE html>
<html>
 <head>
 </head>
 <body>'''

body=' Success!'

foot=''' </body>
</html>'''

f=open(directory+'loggedin.txt','r')
entries=f.read()
f.close()


entries=entries.split('\n')
while '' in entries:
    entries.remove('')
for each in range(len(entries)):
    entries[each]=entries[each].split(',')

def isLoggedIn(usr,ID,ip):
    for each in entries:
        if usr==each[0]:
            if ID==each[1]:
                if ip==each[2]:
                    return True
    return False


print head
if isLoggedIn(user,ID,ip):
    print body
else:
    print '  <a href="login.py"> Something went wrong, please click here to log in again.</a>'

print foot
