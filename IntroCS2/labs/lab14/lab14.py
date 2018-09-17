#!/usr/bin/python
print "content-type: text/html\n"

#Zaia, Jake & Zhu, Michelle
#Intro2, PD2
#Lab 14
#2016-05-09

import cgitb
cgitb.enable()

import cgi
form=cgi.FieldStorage()

def textToList(text):
    i=0
    text=text.split('--')
    text=' '.join(text)    
    text=text.split()
    while i<len(text):
        text[i]=text[i].lower()
        text[i]=text[i].strip(''''.,"?!`~=+;<>":-)&([]*''')
        if text[i]=='' or text[i]==' ' or text[i].isdigit():
            text.remove(text[i])
        else:
            i+=1
    return text
    
def TallyWords(input1):
    a={}
    for word in input1:
        if not word in a:
            a[word]=1
        else:
            a[word]+=1
    return a

def removeDuplicates(L):
    i=0
    while i<len(L):
        searchi=i+1
        while searchi<len(L):
            if L[i]==L[searchi]:
                L.pop(searchi)
            else:
                searchi+=1
        i+=1
    
def printWordCount(w,text):
    print '    <table border=1>'
    print '     <tr><td>Word</td><td>Count</td><td>%</td></tr>'
    for each in sorted(w):
        per = round((w[each] * 100.0)/(len(text)*1.0),3)
        print '       <tr><td>'+each+'</td>  <td>'+str(w[each])+'</td><td>' + str(per) + '</tr>'
    print '    </table>'

def countUniqueWords(d):
    total=0
    for each in d:
        if d[each]==1:
            total+=1
    return total

def fillMissing(a,b):
    for each in a:
        if not each in b:
            b[each]=0

def comPare(a,b,bk1,bk2,tx1,tx2):
    print '<table border="1">\n  <tr><td>Book</td><td>Difference</td></tr>'
    for i in sorted(a):
        if (a[i] * 100.0)/(len(tx1)*1.0) > (b[i] * 100.0)/(len(tx2)*1.0):
           x = bk1
           print "  <tr><td>" + x + "</td><td>" + str(round(((a[i] * 100.0)/(len(tx1)*1.0))-((b[i] * 100.0)/(len(tx2)*1.0)),3)) + "%</td></tr>"
        elif (a[i] * 100.0)/(len(tx1)*1.0) < (b[i] * 100.0)/(len(tx2)*1.0):
           x = bk2
           print "  <tr><td>" + x + "</td><td>" + str(round(((b[i] * 100.0)/(len(tx2)*1.0))-((a[i] * 100.0)/(len(tx1)*1.0)),3)) + "%</td></tr>"
        else:
           print "  <tr><td>Same</td><td>Same</td></tr>"

def maxoccur(a):
   x,y = a.keys(),a.values()
   nums = 0
   L = []
   M = []
   while nums < 20:
          L.append(max(y))
          M.append(x[y.index(max(y))])
          x.pop(y.index(max(y)))
          y.remove(max(y))
          nums += 1
   return L,M

def mostCommon(a,book1):
   print "<table border = '1'>\n\t\t\t\t<tr><th>Tally</th><th>Word</th></tr>"
   L,M = maxoccur(a)
   i = 0
   while i < len(L):
         print "\n\t\t\t\t<tr><td>" + str(L[i]) + "</td><td>" + str(M[i]) + "</tr>"
         i += 1
   print "\n\t\t\t</table>\n\t\t</td>"
   
def length(a):
   x = 0
   y = 0
   z = 0
   for each in a:
         if len(each) < 5:
             x += a[each]
         elif len(each) < 10:
             y += a[each]
         else:
             z += a[each]
   print '<table border ="1">'+"\n   <tr><td>Length</td><td>Tally</td><tr>\n   <tr><td>Less than 5</td><td>" + str(x) + "</td></tr><tr><td>B/w 5 and 10</td><td>" + str(y) + "</td></tr><tr><td>10 or more</td><td>" + str(z) + "</td></tr>\n</table>"

###############################################
if 'book1' in form:
    book1=form.getvalue('book1')
else:
    book1='hamlet.txt'

if 'book2' in form:
    book2=form.getvalue('book2')
else:
    book2='othello.txt'
    
f = open(book1,'r')
origbook1 = f.read()
f.close()

g = open(book2,'r')
origbook2 = g.read()
g.close()

text1=textToList(origbook1)
d=TallyWords(text1)

text2=textToList(origbook2)
s=TallyWords(text2)

fillMissing(s.keys(),d)
fillMissing(d.keys(),s)


print "<!DOCTYPE html>\n<html>\n <head><title>A Seemingly Unending Barrage of Tallys</title></head>\n <body>"
print "   <h2>A Large Amount of <strike> Useless</strike> Helpful Information About "+book1+" & "+book2+"</h2>"
print """   <table border=1><tr><td><form method="GET" action="lab14.py">
    <select name="book1" size="1">
     <option>othello.txt</option>
     <option>hamlet.txt</option>
     <option>romeojuliet.txt</option>
     <option>macbeth.txt</option>
    </select>
    <select name="book2" size="1">
     <option>othello.txt</option>
     <option>hamlet.txt</option>
     <option>romeojuliet.txt</option>
     <option>macbeth.txt</option>
    </select>
    <input type="submit" value="Compare Texts">
    </form></td></tr></table></br>
"""
print "<table>\n   <tr><th>20 Most Common Words</th><th>Number of Words by Length</th></tr>\n   <tr><td>"
print "<table>\n   <tr><td>" + book1 + "</td><td>" + book2 + "</td></tr>\n   <tr><td>"
mostCommon(d,book1)
print "</td><td>"
mostCommon(s,book2)
print "</td></tr>\n</table>\n  </td><td style = 'vertical-align:top'>"+ book1
length(d)
print "</td><td style = 'vertical-align:top'>" + book2
length(s)
print "</td></tr></table>"
print "   <h2> A Bunch of Stats:</h2>"
print "   Total Characters for "+book1+": " + str(len(origbook1))+"</br>"
print "   Total Characters for "+book2+": " + str(len(origbook2))+"</br>"
print "   Total Words for "+book1+": "+str(len(text1))+"</br>"
print "   Total Words for "+book2+": "+str(len(text2))+"</br>"
print "   Total Different Words in "+book1+": "+str(len(d))+"</br>"
print "   Total Different Words in "+book2+": "+str(len(s))+"</br>"
print "   Total Unique Words in "+book1+": "+str(countUniqueWords(d))+"</br>"
print "   Total Unique Words in "+book2+": "+str(countUniqueWords(s))+"</br></br></br>"
print "<table>\n      <tr><th>"+book1+"</th><th>"+book2+"</th><th>Highest %</th></tr><tr><td>"
printWordCount(d,text1)
print "\n</td><td>"
printWordCount(s,text2)
print "\n</td><td>"
comPare(d,s,book1,book2,text1,text2)
print "</td></tr></table>"
print "   </tr>\n  </table>"
print " </body>\n</html>"
