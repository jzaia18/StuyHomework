#!/usr/bin/python
print "content-type: text/html\n"
#Zaia, Jake
#Intro2, PD2
#CSV Table Lab
#2016-04-18

import cgitb
cgitb.enable()

f=open("SAT.csv")
data=f.read()
f.close()

def fixCommas(L):
   if [""] in L:
      L.remove([""])
   for inner in L:
      i=0
      while i < len(inner):
          res = ''
          if inner[i][0]=='"':
              while inner[i][-1] != '"' and i<len(inner):
                  res += inner[i]+","
                  inner.pop(i)
              inner[i]=(res+inner[i]).strip('"')
          i+=1
   return L

def makeList(allLines):
   allLines=allLines.split("\n")
   i=0
   for i in range(len(allLines)):
      allLines[i]=allLines[i].split(',')
   return fixCommas(allLines)

def makeTotals(L):
   L[0].append("Total")
   i=1
   while i<len(L):
      L[i].append(addIgnore(L[i][-3:]))
      i+=1

def addIgnore(L):
   i=0
   total=0
   while i<len(L):
      if not L[i]=="s":
         total+=int(L[i])
      i+=1
   if total != 0:
      return str(total)
   else:
      return "s"

data=makeList(data)
makeTotals(data)
   
def makeTableBody(allLines):
   for i in range(len(allLines)):
      allLines[i]="</td>\n    <td>".join(allLines[i])
   allLines="</td>\n   </tr>\n   <tr>\n    <td>".join(allLines)
   return "  <table border=1>\n   <tr>\n    <td>"+allLines+"</td>\n   </tr>\n  </table>"

totalstudents=0
for each in data[1:]:
   if not each[2]=='s':
      totalstudents+=int(each[2])

def makeAverages(L):
   total=0
   i=1
   while i<len(L):
      if not L[i][2]=='s' and not L[i][6]=='s':
         total+=int(L[i][2])*int(L[i][6])
      i+=1
   return total/totalstudents

print "<!DOCTYPE html>\n<html>\n <head></head>\n <body>"
print "  Total Students That Took The Exam: "+str(totalstudents)+"</br>"
print "  Average SAT Score: "+str(makeAverages(data))
print makeTableBody(data)
print " </body>\n</html>"
