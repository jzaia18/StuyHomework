def sumList(L):
	x = 0
	y = 0
	while x < len(L):
	    y  = L[x] + y
	    x = x + 1
	return y


def makeSentence(L):
    x = 0
    y = "" 
    while x < len(L):
	    y = y + L[x] + " "
	    x = x + 1
    return y

print makeSentence(['The','rain','in','Spain','falls','mainly'])


def makeListofSquares(n):
    x = 1
    y = [] 
    while x <= n:
        y.append(x**2)
        x = x + 1
    return y

print makeListofSquares(5)

def  makeFibList(n):
    n = n + 1
    x = 0
    y = 1
    z = 0
    whole = []
    while  n>0:
        whole.append(x)
        z = y + x
        x = y
        y = z
        n = n - 1 
    return whole
print makeFibList(5)
        
        
