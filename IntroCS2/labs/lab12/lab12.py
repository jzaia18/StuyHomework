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

def splitList(s):
    s=s.split("\n")
    for i in range(len(s)):
        s[i]=s[i].split(",")
    while [''] in s:
        s.remove([''])
    return s
wholeList=splitList(wholeList)[1:]

tablehead='    <tr>\n    <td><b>Number</b></td>\n    <td><b>First</b></td>\n    <td><b>Last</b></td>\n    <td><b>Email</b></td>\n    <td><b>State</b></td>\n    </tr>\n'

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

def listToTable(L):
    for i in range(len(L)):
        L[i]="</td>\n     <td>".join(L[i])
    L="</td>\n    </tr>\n    <tr>\n     <td>".join(L)
    return "   <table border=1>\n"+tablehead+"    <tr>\n     <td>"+L+"</td>\n    </tr>\n   </table>"

def findSearchType():
    thelist=wholeList
    if 'namesearch' in form:
        thelist=handleNameSearch(thelist)
    if 'statesearch' in form:
        thelist=findInList(thelist,form.getvalue('state'),4)
    print listToTable(thelist)

def handleNameSearch(thelist):
    if form.getvalue('nametype')=='firstname':
        return findInList(thelist,form.getvalue("nameterm"),1)
    elif form.getvalue('nametype')=='lastname':
        return findInList(thelist,form.getvalue("nameterm"),2)
    else:
        return findInList(thelist,form.getvalue("nameterm"),3)    


#                               Actual Printing of the website:
print """<!DOCTYPE html>
<html>
 <head>
  <link rel="stylesheet" type="text/css" href="stylesheet.css">
 </head>
 <body>"""
print 

if not 'submitted' in form:
    print """  <form method="GET" action="lab12.py">
   Search by Name: <input type="checkbox" name="namesearch"></br>
   Name: <input type="text" name="nameterm"></br>
   First Name: <input type="radio" name="nametype" value="firstname" checked></br>
   Last Name: <input type="radio" name="nametype" value="lastname"></br>
   Email: <input type="radio" name="nametype" value="email"></br></br>
   Search by State:<input type="checkbox" name="statesearch" value="on"><br>
   <div class="states">
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
   </div>
   </br>
   <input type="submit" name="submitted" value="Search">
  </form>"""
else:
    findSearchType()
    
print printlater+' </body>\n</html>'
