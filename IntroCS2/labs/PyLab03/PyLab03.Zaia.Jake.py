#Zaia, Jake
#Intro2, PD2
#PyLab03
#2016-03-07

#0
#x=90
#while x>=0:
#    print x,
#    x=x-1
#print "\n"

#1
#x=13
#while x<500:
#    print x,
#    x=x+13
#print "\n"

#2
x=1
y=0
while x**2<=1000:
    y=y+x**2
    x=x+1
print y
print "\n"

#3
def tableofblah(blah,blah2):
    count=15
#    print "<!DOCTYPE html>"
#    print "<html>"
#    print " <head></head>"
#    print " <body>"
    print "  <table>"
    while count > 0:
        print "    <tr><td> " + blah + " </td><td> " + blah2 + " </td></tr>"
        count=count-1
    print "  </table>"
#    print " </body>"
#    print "</html>"

tableofblah('blah','blah2')
print "\n"

#4
x=1
y=0
while x<=1000:
    if x%3==0 or x%5==0:
        y=y+x
    x=x+1
print y
print "\n"

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
