//Jake Zaia
//APCS1 pd5
//HW #08: On the Origins of a BigSib
//2016-09-23

public class BigSib{
    private String helloMsg;

    public BigSib(){
	helloMsg = "Hello,";
    }
    
    public BigSib(String newMsg){
	helloMsg = newMsg;
    }

    public String greet(String name){
	return helloMsg + ' ' + name;
    }

}