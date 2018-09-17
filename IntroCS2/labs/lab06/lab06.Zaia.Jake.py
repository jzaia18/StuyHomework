#!/usr/bin/python
print "content-type: text/html\n"

#Zaia, Jake
#Intro2, PD2
#lab06
#2016-03-17

import random

def numToWords9(i):
    if i==9:
        return "nine"
    elif i==8:
        return "eight"
    elif i==7:
        return "seven"
    elif i==6:
        return "six"
    elif i==5:
        return "five"
    elif i==4:
        return "four"
    elif i==3:
        return "three"
    elif i==2:
        return "two"
    elif i==1:
        return "one"
    else:
        return ""
#print numToWords9(3)
#print numToWords9(9)

def numToWords99(i):
    if i<10:
        return numToWords9(i)
    elif i<20:
        if i==10:
            return "ten"
        elif i==11:
            return "eleven"
        elif i==12:
            return "twelve"
        elif i==13:
            return "thirteen"
        elif i==15:
            return "fifteen"
        elif i==18:
            return "eighteen"
        else:
            return numToWords9(i%10)+"teen"
    elif i>=90:
        return "ninety "+numToWords9(i%10)
    elif i>=80:
        return "eighty "+numToWords9(i%10)
    elif i>=70:
        return "seventy "+numToWords9(i%10)
    elif i>=60:
        return "sixty "+numToWords9(i%10)
    elif i>=50:
        return "fifty "+numToWords9(i%10)
    elif i>=40:
        return "forty "+numToWords9(i%10)
    elif i>=30:
        return "thirty "+numToWords9(i%10)
    else:
        return "twenty "+numToWords9(i%10)
#x=1
#while i<99:
#    print numToWords99(x)
#    x=x+1

def numToWords999(i):
    if i<100:
        return numToWords99(i)
    else:
        return numToWords9(i/100) + " hundred " + numToWords99(i%100)
#x=95
#while x<300:
#    print numToWords999(x)
#    x=x+5

def numToString(x):
    if x<0:
        return "negative "+numToWordsBig(abs(x)) 
    if x==0:
        return "zero"
    else:
        return numToWordsBig(x)

def numToWordsBig(i):
    return appendSuffix(i,0)

def appendSuffix(x,y):
    suf=""
    if y==1:
        suf=" thousand "
    if y==2:
        suf=" million "
    if y==3:
        suf=" billion "
    if y==4:
        suf=" trillion "
    if y==5:
        suf=" quadrillion "
    if y==6:
        suf=" quintillion "
    if y==7:
        suf=" sextillion "
    if y==8:
        suf=" septillion "
    if y==9:
        suf=" octillion "
    if y==10:
        suf=" nonillion "
    if y==11:
        suf=" decillion "
    if y==12:
        suf=" undecillion "
    if y==13:
        suf=" duodecillion "
    if y==14:
        suf=" tredecillion "
    if y==15:
        suf=" quattordecillion "
    if y==16:
        suf=" quindecillion "
    if y==17:
        suf=" sexdecillion "
    if y==18:
        suf=" septendecillion "
    if y==19:
        suf=" octodecillion "
    if y==20:
        suf=" novemdecillion"
    if y==21:
        suf=" vigintillion "
    if y>21:
        suf=" why so many digits ;-;"
    if x/1000>0:
        return appendSuffix(x/1000,y+1)+numToWords999(x%1000)+suf
    else:
        return numToWords999(x)+suf
#print numToString(314159265359)
#print numToString(1234567890987654321)
#print numToString(-123456789)

def numberTable(x1,x2,x3):
    return "  <table border=1>\n   <tr><td>"+str(x1)+"</td><td>"+numToString(x1)+"</td></tr>\n   <tr><td>"+str(x2)+"</td><td>"+numToString(x2)+"</td></tr>\n   <tr><td>"+str(x3)+"</td><td>"+numToString(x3)+"</td></tr>\n  </table>"


print "<!DOCTYPE html>\n<html>\n <head><title>An Endless barrage of Massive Numbers</title></head>\n <body>"
print numberTable(random.randint(-999,999),random.randint(-999999,999999),random.randint(-999999999,999999999))
print " </body>\n</html>"
