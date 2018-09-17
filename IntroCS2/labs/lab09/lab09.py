#!/usr/bin/python
print "content-type: text/html\n"

#Zaia, Jake
#Intro2, PD2
#Madlibs
#2016-04-11

import random


def pickOne(L):
    return L[random.randint(0,len(L)-1)]


textlist=["text0.txt","text1.txt","text2.txt"]
f = open(pickOne(textlist),'r')
text = f.read()
f.close()

f=open("cssstyle.txt",'r')
cssstyle=f.read()
f.close()

def insertSpace(s):
    s=s.split("\n")
    i=0
    while i<len(s):
        s[i]="   "+s[i]
        i+=1
    s="</br>\n".join(s)
    return s[:-9]
text=insertSpace(text)

nouns=['laptop','chair','window','mouse','fox','tree','maple syrup','pancake','cactus','love','time','egg','baby','soup']
verbs=['run','swim','talk','die','shine','love','attack','flail','fling','slam','find','search','dance','type','write']
adjectives=['purple','small','smart','cute','fast','dangerous','big','civil','optional','effective','combined','swift','noticeable','nondescript']

def madlibs(storyString, nounList, verbList, adjectiveList):
    storyString=replaceWords(storyString,'NOUN',nounList)
    storyString=replaceWords(storyString,'VERB',verbList)
    storyString=replaceWords(storyString,'ADJ',adjectiveList)
    return storyString

def replaceWords(s,PoS,wlist):
    n=1
    while s.find(PoS+str(n))>0:
        s=s.replace(PoS+str(n),pickOne(wlist))
        n+=1
    while s.find(PoS)>0:
        s=s.replace(PoS,pickOne(wlist),1)
    return s

print '<!DOCTYPE html>\n<html>\n <head>\n'+cssstyle+'\n  <title>\n   Random Stories!\n  </title>'
print '</head>\n <body>'
print '  <center><h1>\n'+madlibs('   The ADJ NOUN that VERBed</br>\n',nouns,verbs,adjectives)+'  </h1>'
print madlibs(text,nouns,verbs,adjectives)
print '  </center>\n </body>\n</html>'
