#!/usr/bin/python
print "content-type: text/html\n"

print """
<!DOCTYPE html>
<html>
 <head></head>
 <body>
  <form method="GET" action="results.py">"""

printafterform=''

import cgitb
cgitb.enable()

import cgi
formResults=cgi.FieldStorage()

import math

if 'is' in formResults:
    printafterform+="   Hello, "+formResults.getvalue('is')+"</br></br>\n"
else:
    print """<h2>Self Evaluate: </h2>
     The Very Best Like No One Ever Was<input type="radio" name="is" value="poktheme"></br>
     John Cena<input type="radio" name="is" value="JC"></br>
     Pretty gr8, 8/8<input type="radio" name="is" value="gr8" checked></br>
     YOU LOSE, YOU GET NOTHING, GOOD DAY SIR<input type="radio" name="is" value="CnTCFref"></br>
     </br>"""

if 'value1' in formResults and 'value2' in formResults:
    printafterform+="   Value1: "+formResults.getvalue('value1')+"</br>\n   Value2: "+formResults.getvalue('value2')+"</br>\n"
    printafterform+="   Sum: "+str(int(formResults.getvalue('value1'))+int(formResults.getvalue('value2')))+"</br></br>\n"
    if 'sqrt' in formResults:
        printafterform+="   <b>Sqrt:</b></br>\n   Value 1: "+str(math.sqrt(float(formResults.getvalue('value1'))))+"</br>\n   Value2: "+str(math.sqrt(float(formResults.getvalue('value2'))))+"</br></br>\n"
else:
    print """    </br>
     <h4>Value 1:</h4><input type="text" name="value1"></br>
     <h4>Value 2:</h4><input type="text" name="value2"></br>
     <h4>Sqrt?<input type="checkbox" name="sqrt"></br>
     </br>"""

if 'pok1' in formResults and 'pok2' in formResults and 'pok3' in formResults and 'pok4' in formResults:
    printafterform+="   Good job, you put up with the pokemon references."
else:
    print """    <h2>Do you:</h2>
     Wanna be the very best like no one ever was?<input type="checkbox" name="pok1" value="True"></br>
     Want to catch them as if it were your real test, and to train them was your cause?<input type="checkbox" name="pok2" value="True"></br>
     Travel Across the land, searching far and wide?<input type="checkbox" name="pok3" value="True"></br>
     Help each pokemon understand the power thats inside?<input type="checkbox" name="pok4" value="True"></br>
     </br>"""

if 'pokref' in formResults:
    printafterform+="   Ahhh yes, the young trainer from "+formResults.getvalue('pokref')+ " Town</br>\n"
else:
    print """    <h2>Where Are You From?</h2>
     Yes.<input type="radio" name="pokref" value="Yes"></br>
     No?<input type="radio" name="pokref" value="No"></br>
     </br></br>"""

print printafterform+'     <input type="submit" name="submited" value="DO THE THING!">\n  </form>\n </body>\n</html>'
