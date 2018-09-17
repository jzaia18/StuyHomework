#Zaia, Jake
#Intro2, PD2
#Lab10
#2016-04-14

f=open("values.txt",'r')
values=f.read()
f.close()

f=open("operations.txt",'r')
ops=f.read()
f.close()

def splitList(v):
    v=v.split("\n")
    while '' in v:
        v.remove('')
    return v

def splitSublist(L,isvalues):
    if isvalues:
        i=0
        while i<len(L):
            L[i]=L[i].split(',')
            subi=0
            while subi<len(L[i]):
                L[i][subi]=int(L[i][subi])
                subi+=1
            i+=1
    else:
        i=0
        while i<len(L):
            L[i]=L[i].split(' ')
            i+=1
    return L
    
varindices=splitList(values)[0].split(',')
values=splitSublist(splitList(values)[1:],True)
ops=splitSublist(splitList(ops),False)

def lookup(let1,let2,vind):
    let1=vind.index(let1)
    let2=vind.index(let2)
    return let1,let2

def doOps(values,ops,vind):
    i=0
    while i<min(len(ops),len(values)):
        ind1,ind2=lookup(ops[i][0],ops[i][2],vind)
        print processOperator(values[i][ind1],values[i][ind2],ops[i][1])
        outfile.write(str(processOperator(values[i][ind1],values[i][ind2],ops[i][1]))+"\n")
        i+=1

def processOperator(thing1,thing2,oper):
    if oper=='+':
        return thing1+thing2
    elif oper=='-':
        return thing1-thing2
    elif oper=='*':
        return thing1*thing2
    elif oper=='/':
        return (1.0*thing1)/(1.0*thing2)
    else:
        return "Error in Operator"

outfile = open('output.txt','w')
doOps(values,ops,varindices)
outfile.close()
