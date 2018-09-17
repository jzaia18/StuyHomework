#!/usr/bin/python
print 'content-type: text/html'

#All this does is reset data:

import cgitb
cgitb.enable()

directory='data/'

print '''
<!DOCTYPE html>
<html>
 <head>
 </head>
 <body>'''

f=open(directory+'loggedin.txt','w')
f.write('')
f.close()

print ''' </body>
</html>'''
