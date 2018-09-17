#Zaia, Jake
#Intro2, PD2
#Lab 02
#2016-03-03

import math

#3.1
def triangleArea(b,h):
    return (b*h)*.5
#print triangleArea(5,10)  (Should be 25.0)


#3.2
def distance(x1,y1,x2,y2):
    return (((y2-y1)**2)+((x2-x1)**2))**.5
#print distance(0,0,3,4)   (Should be 5.0)


#3.3
def disc(a,b,c):
    return (b**2) - (4*a*c)
#disc(2,3,4)   (Should be -23)
#disc(1,2,1)   (Should be 0)


#3.4
def gradePicker(score):
    if score >= 90:
        return 'A'
    elif score >= 80:
        return 'B'
    elif score >= 70:
        return 'C'
    elif score >= 65:
        return 'D'
    else:
        return 'F'
#gradePicker(5)    (Should be 'F')
#gradePicker(92)   (Should be 'A')


#3.5
def closestPoints(ax,ay,bx,by,cx,cy):
    ab = distance(ax,ay,bx,by)
    ac = distance(ax,ay,cx,cy)
    bc = distance(bx,by,cx,cy)
    if ab <= bc and ab <= ac:
        return 1
    elif ac <= ab and ac <= bc:
        return 2
    else:
        return 3
#closestPoints(0,0,1,1,5,5)         (Should be 1) 
#closestPoints(0,0,1,1,0.1,0.1)     (Should be 2)
#closestPoints(-1,0,0,1,1,0)        (Should be 1)
#closestPoints(0,10,1,0,-1,0)       (Should be 3)


#3.6
def numRoots(a,b,c):
    dis = disc(a,b,c)
    if dis < 0:
        return 0
    elif dis == 0:
        return 1
    else:
        return 2
#print numRoots(1,2,-3)      (Should be 2)
#print numRoots(1,4,4)       (Should be 1)
#print numRoots(1,-10,34)    (Should be 0)


#3.7
def quadsolvePlus(a,b,c):
    if numRoots(a,b,c) == 0:
        return 'No Real Roots'
    else:
        return (-1*b + math.sqrt(disc(a,b,c)))/(2*a)
#print quadsolvePlus(1,2,-3)      (Should be 1.0)
#print quadsolvePlus(1,4,4)       (Should be -2.0)
#print quadsolvePlus(1,-10,34)    (Should be 'No Real Roots')


#3.8
def quadsolve(a,b,c,sign):
    if sign == 0:
        return "Sign can't be 0."
    elif sign > 0:
        return quadsolvePlus(a,b,c)
    else:
        return (-1*b - math.sqrt(disc(a,b,c)))/(2*a) #quadsolvePlus but using a minus instead.
#print quadsolve(1,2,-3,1)      (Should be 1.0)
#print quadsolve(1,2,-3,-1)     (Should be -3.0)
#print quadsolve(1,4,4,1)       (Should be -2.0)
#print quadsolve(1,4,4,-1)      (Should be -2.0)
#print quadsolve(1,-10,34,1)    (Should be 'No Real Roots')
#print quadsolve(1,-10,34,0)    (Should be 'Sign can't be 0.')


