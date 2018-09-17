#!/usr/bin/python
print "content-type: text/html\n"

#Zaia, Jake
#Intro2,PD2
#Lab12
#2016-04-22

import cgitb
cgitb.enable()

import cgi
form=cgi.FieldStorage()

f=open('MOCK_DATA.csv','r')
wholeList=f.read()
f.close()

page = 0 
if 'page' in form: 
   page=int(form.getvalue('page'))
linesperpage=10
if 'linesperpage' in form:
   linesperpage=int(form.getvalue('linesperpage'))

addtourl=''
if 'nameterm' in form:
   addtourl+='&nameterm='+form.getvalue('nameterm')
if 'nametype' in form:
   addtourl+='&nametype='+form.getvalue('nametype')
if 'state' in form:
   addtourl+='&state='+form.getvalue('state')
if 'namesearch' in form:
   addtourl+='&namesearch='+form.getvalue('namesearch')
if 'statesearch' in form:
   addtourl+='&statesearch='+form.getvalue('statesearch')
if 'submitted' in form:
   addtourl+='&submitted='+form.getvalue('submitted')

def splitList(s):
   s=s.split("\n")
   for i in range(len(s)):
       s[i]=s[i].split(",")
   while [''] in s:
       s.remove([''])
   return s
wholeList=splitList(wholeList)[1:]

tablehead='     <tr>\n      <td><b>ID</b></td>\n      <td><b>First</b></td>\n      <td><b>Last</b></td>\n      <td><b>Email</b></td>\n      <td><b>State</b></td>\n     </tr>\n'

printlater=''


def findInList(L,term,ind):
   Lcopy=L[:]
   i=0
   while i<len(Lcopy):
       if Lcopy[i][ind].lower().find(term.lower())>=0:
           i+=1
       else:
           Lcopy.pop(i)
   return Lcopy

def findSearchType():
   thelist=wholeList
   if 'namesearch' in form:
       thelist=handleNameSearch(thelist)
   if 'statesearch' in form:
       thelist=findInList(thelist,form.getvalue('state'),4)
   print '   <p>Found '+str(len(thelist))+' results:</p>'
   print makeNavbarTable(thelist)

def makeNavbarTable(L):
   output=''
   output+='  <table border=1>'+navHelper(L)
   output+= '\n   <tr>\n    <td>\n'+listToTable(L[page*linesperpage:(page+1)*linesperpage])
   output+=navHelper(L)+'\n  </table>'
   return output

def navHelper(L):
   output=''
   output+='\n   <tr>\n    <td>\n    Navbar: \n'
   if page>0:
      output+='    <a href="lab13.py?page='+str(page-1)+'&linesperpage='+str(linesperpage)+addtourl+'">'+'&lt Previous'+'</a>\n'
   output+= '    Page '+str(page+1)+" of "+str((len(L)/linesperpage)+1)+"\n"
   if page<(len(L)/linesperpage):
      output+='    <a href="lab13.py?page='+str(page+1)+'&linesperpage='+str(linesperpage)+addtourl+'">'+'Next &gt'+'</a>\n'
   output+='    </td>\n   </tr>'
   return output
   
def listToTable(L):
   for i in range(len(L)):
       L[i]="</td>\n      <td>".join(L[i])
   L="</td>\n     </tr>\n     <tr>\n      <td>".join(L)
   return "    <table border=1>\n"+tablehead+"     <tr>\n      <td>"+L+"</td>\n     </tr>\n"+"    </table>"

def handleNameSearch(thelist):
   if form.getvalue('nametype')=='Firstname':
       return findInList(thelist,form.getvalue("nameterm"),1)
   elif form.getvalue('nametype')=='Lastname':
       return findInList(thelist,form.getvalue("nameterm"),2)
   else:
       return findInList(thelist,form.getvalue("nameterm"),3)    


#                               Actual Printing of the website:
print """<!DOCTYPE html>
<html>
 <head>
  <title> Not The NSA </title>
 </head>
 <body>"""
print 

print """  <form method="GET" action="lab13.py">
   Search by Name: <input type="checkbox" name="namesearch"><input type="text" name="nameterm">
    <select name="nametype" size="1">
     <option>Firstname</option>
     <option>Lastname</option>
     <option>Email</option>
    </select>
    </br>
   Search by State:<input type="checkbox" name="statesearch" value="on">
   <select name="state" size="1">
    <option>Alabama</option>
    <option>Alaska</option>
    <option>Arizona</option>
    <option>Arkansas</option>
    <option>California</option>
    <option>Colorado</option>
    <option>Connecticut</option>
    <option>Delaware</option>
    <option>Florida</option>
    <option>Georgia</option>
    <option>Hawaii</option>
    <option>Idaho</option>
    <option>Illinois</option>
    <option>Indiana</option>
    <option>Iowa</option>
    <option>Kansas</option>
    <option>Kentucky</option>
    <option>Louisiana</option>
    <option>Maine</option>
    <option>Maryland</option>
    <option>Massachusetts</option>
    <option>Michigan</option>
    <option>Minnesota</option>
    <option>Mississippi</option>
    <option>Missouri</option>
    <option>Montana</option>
    <option>Nebraska</option>
    <option>Nevada</option>
    <option>New Hampshire</option>
    <option>New Jersey</option>
    <option>New Mexico</option>
    <option>New York</option>
    <option>North Carolina</option>
    <option>North Dakota</option>
    <option>Ohio</option>
    <option>Oklahoma</option>
    <option>Oregon</option>
    <option>Pennsylvania</option>
    <option>Rhode Island</option>
    <option>South Carolina</option>
    <option>South Dakota</option>
    <option>Tennessee</option>
    <option>Texas</option>
    <option>Utah</option>
    <option>Vermont</option>
    <option>Virginia</option>
    <option>Washington</option>
    <option>West Virginia</option>
    <option>Wisconsin</option>
    <option>Wyoming</option>
    <option>District of Columbia</option>
   </select>
   </br></br>
   <input type="submit" name="submitted" value="Search">
   <input type="text" name="linesperpage" size="2" value="10"> Lines Per Page
  </form></br></br>"""

if 'submitted' in form:
   findSearchType()
    
print printlater+' </body>\n</html>'
