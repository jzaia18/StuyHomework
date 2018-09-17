import time

## Sets up display
size(1200, 800)
background(250)

data = {} # The data the Markov chain has ben trained on


#######################################################################[ User Modifiables ]################################################################################

##############[ Debug Tools ]##############

PRINT_OUTPUT = True # Prints completed sentences to console

PRINT_ORDS = False # Requires PRINT_OUTPUT to be true

PRINT_DATA = False # Prints the dictionary of all phrases and values to console

PRINT_OPERATION_TIME = True # Prints how long for all operations to take place


##############[ Variables ]################

# File to be read
FILE = 'hbfinn.txt'
    
# Number of words in each phrase (Must be > 0)
KEYLENGTH = 4
    
# Marks that end sentences
PUNCTUATION = ['.', '!', '?', ';', '\r\n', '\n']
    
# Illegal characters (get removed immediately)
ILLEGALS = ['(', ')', '[', ']', '{', '}', '\x93', '\x94', '\x95', '\x96', '\x97']

###########################################################################[ The Code ]####################################################################################

start_time = time.time()

## Opens and formats file
def formatText():
    s = open(FILE).read()
    
    # Make sentence enders into separate words
    for mark in PUNCTUATION:
        s = s.replace(mark, ' ' + mark + ' ')
        
    # Remove illegal characters 
    for symbol in ILLEGALS:
        s = s.replace(symbol, '')
    
    # Replace a few specific characters
    s = s.replace('&nbsp', ' ')    
    s = s.replace('\x92', "'")
    s = s.replace('“', '"')
    s = s.replace('”', '"')
    s = s.replace('’', "'")
    s = s.replace('\u200b', ' ')
    
    # Cut down on extra spaces
    while '  ' in s:
        s = s.replace('  ',' ')
        
    # Split the text word by word
    return s.split(' ') 


## Generates the data from input file
def makeKeys(n):
    words = formatText()
    global data
    for i in xrange(len(words) - n):
        currphrase = ''
        for j in xrange(n):
            currphrase += ' ' + words[i+j]
        currphrase = currphrase[1:]
        nextword = words[i+n]
        if not currphrase in data:
            data[currphrase] = {}
        if not nextword in data[currphrase]:
            data[currphrase][nextword] = 1
        else:
            data[currphrase][nextword] += 1
    
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
    while not next in PUNCTUATION:
        ret += ' ' + next
        if KEYLENGTH > 1:
            curr = ' '.join(curr.split(' ')[1:]) + ' ' + next
        else:
            curr = next
        next = getRandomWeighted(data[curr])
    return (ret + next).replace('\n', '')

## Displays text on screen as a steam
def textStream():
    textSize(12)
    fill(0)
    textLeading(10)
    y = 40
    while y < height - 60:
        sent = makeSentence()
        if PRINT_OUTPUT:
            print sent
            if PRINT_ORDS:
                s = ''
                for each in sent:
                    s +=  each + ':' + str(ord(each)) + ' '
                print s + '\n'
        text(sent, 0, y, width - 150, y + 40)
        y += 40    
    
    
if PRINT_DATA:
    print data
    
textStream()

if PRINT_OPERATION_TIME:
    print str(time.time() - start_time) + 's'