//Jake Zaia
//APCS PD5
//HW#16 Wayne's World
//2016-10-11

public class Coin {
    //Instance Vars
    private int value;
    private String upFace;
    private String name;
    private int flipCtr;
    private int headsCtr;
    private int tailsCtr;
    private double bias;

    //Constructors
    public Coin(){
        setBias(.5);
	assignvalue();
	upFace = "heads";
    }
    public Coin(String newName){
	this();
	setName(newName);
    }
    public Coin(String newName, String newFace){
	this(newName);
	setUpFace(newFace);
    }

    //Overwritten Built-ins
    public String toString(){
	return name + " -- " +  upFace;
    }
    public boolean equals(Coin check){
	return (upFace == check.getUpFace());
    }

    //Mutators
    public String setName(String newName){
	String oldName = name;
	name = newName;
	return oldName;
    }
    public String setUpFace(String newFace){
	String oldFace = upFace;
	upFace = newFace;
	return oldFace;
    }
    public double setBias(double newBias){
	double oldBias = bias;
	bias = newBias;
	return oldBias;
    }

    //Accessors
    public String getUpFace(){
	return upFace;
    }

    //Main flipping function
    public String flip(){
	flipCtr+=1;
	if (Math.random() > bias){
	    tailsCtr+=1;
	    upFace = "tails";
	    return "tails";
	}
	else {
	    headsCtr+=1;
	    upFace = "heads";
	    return "heads";
	}	
    }

    public void assignvalue(){
	if (name == "penny"){ value = 1; }
	else if (name == "nickel"){ value = 5; }
	else if (name == "dime"){ value = 10; }
	else if (name == "quarter"){ value = 25; }
	else if (name == "dollar"){ value = 100; }
	else { value = 0; }
    }
}
