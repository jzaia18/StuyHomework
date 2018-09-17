#Zaia, Jake
#Intro2, PD2
#Lab 01
#2016-03-01

def triangleArea(b,h):
    return (b*h)*.5

def distance(x1,y1,x2,y2):
    return (((y2-y1)**2)+((x2-x1)**2))**.5

def disc(a,b,c):
    return (b**2) - (4*a*c)

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
