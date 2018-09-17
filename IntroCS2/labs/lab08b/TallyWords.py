#!/usr/bin/python
print "content-type: text/html\n"

#Zaia, Jake
#Intro2, PD2
#TallyWords Lab
#2016-03-31

import random


def textToList(text):
    i=0
    text=text.split('"--"')
    text=' '.join(text)
    text=text.split()
    while i<len(text):
        text[i]=text[i].lower()
        text[i]=text[i].strip(''''.,"?!`~=+;<>":-)([]*1234567890''')
        if text[i]=='' or text[i]==' ' or text[i].isdigit():
            text.remove(text[i])
        else:
            i+=1
    return text
    
def TallyWords(text):
    d={}
    for word in text:
        if not word in d:
            d[word]=1
        else:
            d[word]+=1
    return d

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
    
def printWordCount(text):
    i=0
    ntext=text[:]
    removeDuplicates(ntext)
    print '    <table border=1>'
    for each in ntext:
        print '       <tr><td>'+each+'</td>  <td>'+str(d[each])+'</td></tr>'
    print '    </table>'

def firstUniqueWords(d,text,stop):
    i=0
    ntext=text[:]
    removeDuplicates(ntext)
    while i<len(ntext) and i<stop:
        if d[ntext[i]]==1:
            print ntext[i]+'</br>'
            i+=1
        ntext.pop(i)

def sortWords(d):
    print '    <table border=1>'
    while len(d)>0:
        highest=0
        nextkey=''
        for each in d:
            if d[each]>highest:
                highest=d[each]
                nextkey=each
        print '     <tr><td>'+nextkey+'</td><td>'+str(highest)+'</td></tr>'
        d.pop(nextkey)
    print '    </table>\n   </center></td'

def countUniqueWords(d):
    total=0
    for each in d:
        if d[each]==1:
            total+=1
    return total

if random.randint(0,1)==0:
    fileName='bigmac.txt'
else:
    fileName='dante.txt'
    
f = open(fileName,'r')
wholetext = f.read()
f.close()


text=textToList(wholetext)
d=TallyWords(text)


print "<!DOCTYPE html>\n<html>\n <head><title>A Seemingly Unending Barrage of Tallys</title></head>\n <body>"
print "   <h2>A Large Amount of <strike> Useless</strike> Helpful Information About "+fileName+"</h2>"
print "   Total Characters: " + str(len(wholetext))+"</br>"
print "   Total Words: "+str(len(text))+"</br>"
print "   Total Different Words: "+str(len(d))+"</br>"
print "   Total Unique Words: "+str(countUniqueWords(d))+"</br>"
print '  <table width=80%>\n    <tr valign="top">\n     <td><center><h4>First 100 Unique Words:</h4></center>'
firstUniqueWords(d,text,100)
print '     </td>'
print "     <td><center><h4>Most Common Words:</h4>"
sortWords(d)
print '     </td>'
print "     <td><center><h4>Tally of ALL Words in the Order in Which They Appear:</h4>"
d=TallyWords(text)
printWordCount(text)
print "     </center></td>"
print "     <td><center><h4>Tally of ALL Words in Alphabetical Order:</h4>"
printWordCount(sorted(text))
print "   </tr>\n  </table>"
print " </body>\n</html>"
