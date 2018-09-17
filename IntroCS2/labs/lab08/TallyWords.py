#!/usr/bin/python
print "content-type: text/html\n"

#Zaia, Jake
#Intro2, PD2
#TallyWords Lab
#2016-03-31

import random

def TallyWords(text):
    words=[]
    tallys=[]
    i=0
    text=text.split('"--"')
    text=" ".join(text)
    text=text.split()
    while i<len(text):
        text[i]=text[i].lower()
        text[i]=text[i].strip(''''.,"?!`~=+;<>":-)([]*''')
        if text[i]=="" or text[i]==" " or text[i].isdigit():
            text.remove(text[i])
            i-=1
        i+=1
    for x in text:
        if not x in words:
            words.append(x)
            tallys.append(1)
        else:
            tallys[words.index(x)]+=1
    return words,tallys

def printWordCount(x):
    a,b=TallyWords(x)
    i=0
    toprint=""
    while i<len(a):
        toprint=toprint+"      <tr><td>"+a[i]+"</td>  <td>"+str(b[i])+"</td></tr>\n"
        i+=1
    print "    <table border=1>\n"+toprint+"    </table>"

def firstUniqueWords(a,b,num):
    rot=0
    i=0
    outp=""
    while rot<num and i<len(a):
        if b[i]==1:
            outp=outp+"      "+a[i]+"</br>\n"
            b.remove(1)
            a.remove(a[i])
            rot+=1
        else:
            i+=1
    return outp

def arrangeTable(a,b):
    c=[]
    d=[]
    while 0<len(a):
        i=0
        stori=0
        curmax=0
        while i<len(b):
            if b[i]>curmax:
                stori=i
                curmax=b[i]
            i+=1
        c.append(a[stori])
        d.append(b[stori])
        a.remove(a[stori])
        b.remove(b[stori])
    return c,d

def listToTable(c,d):
    i=0
    outp=""
    while i<len(c):
        outp=outp+"\n      <tr><td>"+c[i]+"</td><td>"+str(d[i])+"</tr>"
        i+=1
    return outp
                   
    
if random.randint(0,1)==0:
    fileName="bigmac.txt"
else:
    fileName="dante.txt"
f = open(fileName,'r')
text = f.read()

a,b=TallyWords(text)
c,d=arrangeTable(a,b)
a,b=TallyWords(text)


print "<!DOCTYPE html>\n<html>\n <head><title>A Seemingly Unending Barrage of Tallys</title></head>\n <body>"
print "   <h2>A Large Amount of <strike> Useless</strike> Helpful Information About "+fileName+"</h2>"
print "   Total Characters: " + str(len(text))+"</br>"
print "   Total Words: "+str(len(" ".join(text.split("--")).split()))+"</br>"
print "   Total Different Words: "+str(len(b))+"</br>"
print "   Total Unique Words: "+str(b.count(1))+"</br>"
print '  <table width=75%>\n    <tr valign="top">\n     <td><center><h4>First 100 Unique Words:</h4></center>\n'+firstUniqueWords(a,b,100)+"\n     </td>"
print "     <td><center><h4>Most Common Words:</h4>\n    <table border=1>"+listToTable(c,d)+"\n    </table>\n     </center></td>"
print "     <td><center><h4>Tally of ALL Words in the Order in Which They Appear:</h4>"
printWordCount(text)
print "       </center></td>\n    </tr>"
print " </body>\n</html>"
