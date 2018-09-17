//Jake Zaia
//APCS1 pd5
//HW12 -- Mo Money Mo Problems
//2016-10-02
//Team Build a Wall - Joelle Lum, Jake Zaia, Brandon Zhang

public class BankAccount {
    
    //declare variables
    private String fullName;
    private String password;
    private int PIN;
    private int accountNumber;
    private double accountBalance;

    //constructors
    //Basically the setup for the bank account
    
    public BankAccount(String setName, String setPassword, int setPIN, int setAccountNumber){
	fullName = setName;
	password = setPassword;
	
	//Makes sure that the PIN only has 4 digits
	if (setPIN > 999 && setPIN < 10000){
	    PIN = setPIN;
	}
	else {
	    PIN = 9999;
	    System.out.println("Your PIN must be 4 digits");
	}

	//Makes sure that the account number has 9 digits
	if (setAccountNumber > 99999999 && setAccountNumber < 1000000000){
	    accountNumber = setAccountNumber;
	}
	else {
	    accountNumber = 999999999;
	    System.out.println("Your account number must be 9 digits");
	}

	accountBalance = 0;
	//accountBalance is set to 0 because there is no money in the account when you create one
    }

    //methods

    //In case you need to reset things

    //resets name
    public void setName (String newName){
	fullName = newName;
    }
    //resets password
    public void setPassword (String newPassword){
	password = newPassword;
    }
    //reset PIN (checks for digits)
    public void setPIN (int newPIN){
	if (newPIN > 999 && newPIN < 10000){
	    accountNumber = newPIN;
	}
	else {
	    accountNumber = 9999;
	    System.out.println("Your PIN must be 4 digits");
	}
    }
    //reset account number (checks for digits)
    public void setAccountNumber (int newAccountNumber){
	if (newAccountNumber > 99999999 && newAccountNumber < 1000000000){
	    accountNumber = newAccountNumber;
	}
	else {
	    accountNumber = 999999999;
	    System.out.println("Your account number must be 9 digits");
	}
    }


    //Deposit and withdraw returns the amount in the account after any transactions so the user can manage his money.
    //Depositing
    public double deposit (double depositAmount){
	accountBalance += depositAmount;
        return accountBalance;
    }

    //Withdrawing, fails if the balance is too low.
    public boolean withdraw (double withdrawAmount){
	if (accountBalance < withdrawAmount){
	    System.out.println("You do not have enough money");
	    return false;
	}
	else{
	    accountBalance -= withdrawAmount;
	    return true;
	}
    }

    //Checks to see if the PIN and account number match, returns true if it does
    public boolean authenticate(int acctnum, int pin){
	if(accountNumber != acctnum || PIN != pin){
	    return false;
	}
	else{
	    return true;
	}
    }
    
    //Displaying Account Information
    public void displayInfo(){
	System.out.println("Your account's owner is " + fullName);
	System.out.println("Your password is " + password);
	System.out.println("Your PIN is " + PIN);
	System.out.println("Your account number is " + accountNumber);
	System.out.println("Your current account balance is " + accountBalance);
    }

    public static void main(String[] args){
	BankAccount Jasmine = new BankAccount("Jasmine", "architecture", 0603, 229128429);
	Jasmine.setName("Jazmun");
	Jasmine.setPIN(12332);
	Jasmine.setAccountNumber(1232);
	Jasmine.setPassword("jfekgj");
	Jasmine.deposit(100);
	Jasmine.withdraw(20);
	Jasmine.withdraw(100);
	Jasmine.authenticate(999999999,9999);
	Jasmine.displayInfo();
	   
    }
}
