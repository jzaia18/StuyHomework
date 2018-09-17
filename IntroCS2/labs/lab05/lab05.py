#!/usr/bin/python
print "content-type: text/html\n"
#=========================================================================================
#Zaia, Jake
#Intro2, PD2
#Lab05
#2016-03-10

#1
def startPage(title):
    return "<!DOCTYPE html>\n<html>\n <head><title>"+title+"</title></head>\n <body>"
#startPage("Bazinga")
#startPage("WHOA!")

def endPage(): #I know it isn't necessary, but its nice for readability.
    return " </body>\n</html>"

#2
def makeRow(numCols,startValue):
    storage=""
    while numCols>0:
        storage=storage+"     <td>"+str(startValue)+": '"+chr(startValue)+"'</td>\n"
        numCols=numCols-1
        startValue=startValue+1
    return "   <tr>\n"+storage+"   </tr>\n"
#makeRow(2,1)
#makeRow(2,12)
#makeRow(4,99) 

#3
def makeTable(Rows,Cols,startValue):
    storage=""
    while Rows>0:
        storage=storage+makeRow(Cols,startValue)
        Rows=Rows-1
        startValue=startValue+Cols
    return "  <table border=1>\n"+storage+"  </table>"
#makeTable(2,4,11)
#makeTable(4,2,133)

#4
#print startPage("ASCII")
#print makeTable(3,4,5)
#print endPage() #Doesn't have to be a function, but nice for readability

#5
print startPage("ASCII")
print makeTable(14,16,32)
print endPage() #Doesn't have to be a function, but nice for readability

