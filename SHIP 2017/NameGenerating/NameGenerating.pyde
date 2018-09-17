import time

## Sets up display
size(800, 600)
background(250)

data = {} # The data the Markov chain has ben trained on


#######################################################################[ User Modifiables ]################################################################################

##############[ Debug Tools ]##############

PRINT_OUTPUT = True # Prints completed sentences to console

PRINT_DATA = False # Prints the dictionary of all phrases and values to console

PRINT_OPERATION_TIME = True # Prints how long for all operations to take place


##############[ Variables ]################

# File to be read
FILE = 'Names/surnames/hindi.txt'
    
# Number of characters in each phrase (Must be > 0)
KEYLENGTH = 2

###########################################################################[ The Code ]####################################################################################

start_time = time.time()

## Where n is the key length
def makeKeys(n):
    names = open(FILE).read().split('\n')
    global data
    for name in names:
        name = name.capitalize()
        if len(name) > n and name.isalpha():
            for i in xrange(len(name) - n + 1):
                currchars = ''
                if i != len(name) - n:
                    nextchar = name[i+n]
                else:
                    nextchar = ''
                for j in xrange(n):
                    currchars += name[i+j]
                if not currchars in data:
                    data[currchars] = {}
                if not nextchar in data[currchars]:
                    data[currchars][nextchar] = 1
                else:
                    data[currchars][nextchar] += 1
    
## Fills 'data'
makeKeys(KEYLENGTH)    
    
print "Keys have been made"

## Finds a random word that is capitalized to start a sentence
def getRandomStart():
    keyList = data.keys()
    onlyCaps = []
    
    # Separate the caps from the non-caps
    for each in keyList:
        if len(each) > 0 and each[0] == each[0].upper() and each[0].isalpha():
            onlyCaps.append(each)
    
    # Return a random element of the caps
    i = int(random(len(onlyCaps)))
    return onlyCaps[i]
    
    
## Get a random entry from a dictionary based on int values
def getRandomWeighted(dic):
    sum = 0
    for each in dic.values():
        sum += each
    # Ends on a random value
    count = int(random(sum))
    for each in dic.keys():
        count -= dic[each]
        if count <= 0:
            return each
    
## Make one sentence
def makeSentence():
    ret = curr = getRandomStart()
    next = getRandomWeighted(data[curr])
    while next != '':
        ret += next
        if KEYLENGTH > 1:
            curr = curr[1:] + next
        else:
            curr = next
        next = getRandomWeighted(data[curr])
    return ret

## Displays text on screen as a steam
def textStream():
    textSize(12)
    fill(0)
    textLeading(10)
    y = 20
    while y < height - 40:
        sent = makeSentence()
        if PRINT_OUTPUT:
            print sent
        text(sent, 0, y, width - 300, y + 40)
        y += 30    
    
    
if PRINT_DATA:
    print data
    
textStream()

if PRINT_OPERATION_TIME:
    print str(time.time() - start_time) + 's'