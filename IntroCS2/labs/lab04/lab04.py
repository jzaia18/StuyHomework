#!/usr/bin/python
print "content-type: text/html\n"

#Zaia, Jake
#Intro2, PD2,
#Lab04
#2016-03-09

#Huge Table of Death
def HugeTableHelper(num,expt):
    print "    <tr><td> " + str(num) + " </td><td> " + str(expt) + " </td></tr> "

print "<!DOCTYPE html>"
print "<html>"
print " <head></head>"
print " <body>"
print "  <table border=1>"
x=0
while x<=100:
    HugeTableHelper(x,x**2)
    x=x+1
print "  </table>"
print " </body>"
print "</html>"
