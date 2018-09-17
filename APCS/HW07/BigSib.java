//Jake Zaia
//APCS1 pd5
//HW #07: On BigSib Individuality and the Elimination of Radio Fuzz
//2016-09-22

public class BigSib {
    public String helloMsg;

    public void setHelloMsg(String newMsg){
	helloMsg = newMsg;
    }

    public String greet(String name){
	return helloMsg + ' ' + name;
    }

}
