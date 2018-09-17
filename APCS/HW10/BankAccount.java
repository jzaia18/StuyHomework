//Team Build A Wall: Joelle Lum, Jake Zaia, Brandon Zhang
//APCS1 pd5
//HW10 -- CMYM
//2016-09-27

public class BankAccount {

    //Instance variables
    private String name;
    private String pass;
    private int PIN;
    private int accNum;
    private float balance;


    //Setup methods
    public void setAll(String newName, String newPass, int newPIN, int newNum, float newBal){
	name = newName;
	pass = newPass;
	PIN = newPIN;
	accNum = newNum;
	balance = newBal;    
}
    public void setName(String newName){
	name = newName;
    }
    public void setPass(String newPass){
	pass = newPass;
    }
    public void setPIN(int newPIN){
	PIN = newPIN;
    }
    public void setNum(int newNum){
	accNum = newNum;
    }
    public void setBal(float newBal){
	balance = newBal;
    }


    public void printAccInfo(){
	System.out.print("Account owner's name: ");
	System.out.println(name);
	System.out.print("Account password: ");
	System.out.println(pass);
	System.out.print("Account PIN: ");
	System.out.println(PIN);
	System.out.print("Account number: ");
	System.out.println(accNum);
	System.out.print("Account balance: ");
	System.out.println(balance);
    }

    public void deposit(float depAmt){
	balance += depAmt;
	System.out.print("Successfully deposited $");
	System.out.println(depAmt);
}

    public void withdraw(float depAmt){
	balance -= depAmt;
	System.out.print("Successfully deposited $");
	System.out.println(depAmt);
}
}

 