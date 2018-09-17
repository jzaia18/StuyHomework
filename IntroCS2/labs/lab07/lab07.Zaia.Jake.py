#!/usr/bin/python
print "content-type: text/html\n"

#Zaia, Jake
#Intro2, PD2
#Lab07
#2016-3-25

import random
import cgitb
cgitb.enable()

#needed this
def hasNumber(s):
    return False
    for c in "0123456789":
        if c in s:
            return True;
    return False;

#process a url appliying your function to each word
def modifySite(url,f):
    #to get info from the URL string
    import cgi
    form = cgi.FieldStorage()
    if "url" in form:
        url = form.getvalue('url')
    #to load a web page into a string
    import urllib2
    req = urllib2.Request(url)
    response = urllib2.urlopen(req)
    page = response.read()
    #to get the root of the website this is a hacky way for valid urls..
    if("://" in url):
        url = url[:url.find("/",8)+1]
    else:
        url = url[:url.find("/")+1]

    #in case not a valid html page:
    head = "<html><head><title>Random Page?</title></head>\n<body>"
    if "<body" in page:
        head = page.split("<body")[0]
        page = page.split("<body")[1]
        page = "<body>\n"+page[page.find(">")+1:]

    #This is just a quick and dirty solution
    #that will fix SOME broken links and css. (Works on wikis)
    head = head.replace('src="','href="'+url)
    page = page.replace('src="','href="'+url)
    head = head.replace(url+'/',url)
    page = page.replace(url+'/',url)
    head = head.replace('href="/','href="'+url)
    page = page.replace('href="/','href="'+url)
   
    #process the words not in tags.
    tag = False;
    quote = False;
    last =''
    ans = ""
    index = 0;
    start = 0;
    end = 0;
    justended = False;
    line = []
    for c in page:
        if c == "<" and not quote:
            tag = True
            end = index
            justended = True;
        elif c == ">" and not quote:
            tag = False
            ans+=c
            start = index+1
        elif not tag and c =='"':
            quote = not quote
        if tag:
            if(justended):
                justended=False;
                line = page[start:end]
                words = line.split();
                for word in words:
                    prefix =""
                    suffix =""
                    #check for punctuation!
                    if len(word) > 0 and not word[0].isalpha():
                        prefix = word[0]
                        word = word[1:]
                    if len(word) > 0 and not word[-1].isalpha():
                        suffix = word[-1]
                        word = word[:-1]
                    if not hasNumber(word) and len(word) > 0:
                        if len(word) > 0 and word[0]>='A' and word[0]<='Z':
                            word = f(word).capitalize()
                        else:
                            word = f(word)
                    ans+= prefix + word +suffix+" "
            ans+=c
        index += 1
    return head + ans

######################################################
#PLACE YOUR FUNCTIONS HERE:

#pigLatin
def pigLatin(c):
    if len(c)>2:
        if c[0]=='A'or c[0]=='E' or c[0]=='I' or c[0]=='O' or c[0]=='U' or c[0]=='a' or c[0]=='e' or c[0]=='i' or c[0]=='o' or c[0]=='u':
            return c + "hay"
        if c[0:2]=='br' or c[0]=='bl' or c[0]=='gl' or c[0]=='gr' or c[0]=='fr' or c[0]=='fl' or c[0]=='ch' or c[0]=='cl' or c[0]=='cr' or c[0]=='sh' or c[0]=='dr' or c[0]=='gl' or c[0]=='gr' or c[0]=='ph' or c[0]=='pr' or c[0]=='pl' or c[0]=='qu' or c[0]=='sc' or c[0]=='sk' or c[0]=='sl' or c[0]=='sm' or c[0]=='sn' or c[0]=='sp' or c[0]=='st' or c[0]=='sw' or c[0]=='th' or c[0]=='tr' or c[0]=='tl' or c[0]=='tw' or c[0]=='wh' or c[0]=='wr':
            return c[2:]+c[0:2]+"ay"
        else:
            return c[1:]+c[0]+"ay"
    else:
        return c

#rot13
def rot13char(c):
    if (c>='A' and c<='M') or (c>='a' and c<='m'):
        c=chr(ord(c)+13)
    elif (c>='N' and c<='Z') or (c>='n' and c<='z'):
        c=chr(ord(c)-13)
    return c

def rot13(c):
    i=0
    output=''
    while i<len(c):
        output=output+rot13char(c[i])
        i=i+1
    return output

#romanize
def romanize(s):
    s = s.replace("U","V")
    s = s.replace("u","v")
    return s

#no change
def noChange(s):
    return s

#make silly changes
def addIsh(s):
    return s+"ishkabibble"

#modifyWord
def modifyWord(s):
    if random.randint(0,1)==0:
        return pigLatin(s)
    else:
        return rot13(s)



url ='https://en.wikipedia.org/wiki/Latin'
######################################################
#which function to use? (notice do not CALL the function, just give the function name!)
function = modifyWord
#Replace noChange to whichever function you would like to be applied to the website:

#this uses 
print modifySite(url,function)
