//Jake Zaia
//APCS1 pd5
//HW11 -- Iterative Improvement
//2016-09-28
//Team Build a Wall -Brandon Zhang, Joelle Lum

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
	PIN = setPIN;
	accountNumber = setAccountNumber;
	accountBalance = 0;
	//accountBalance is set to 0 because there is no money in the account when you create one
    }

    //methods

    //In case you need to reset things

    //resets name
    public void setName (String newName){
	fullName = newName;
    }
    public void setPassword (String newPassword){
	password = newPassword;
    }
    //reset PIN
     public void setPIN (int newPIN){
	PIN  = newPIN;
    }
    //reset account number
     public void setAccountNumber (int newAccountNumber){
	accountNumber = newAccountNumber;
    }


    //Deposit and withdraw returns the amount in the account after any transactions so the user can manage his money.
    //Depositing
    public void deposit (double depositAmount){
	accountBalance += depositAmount;
	System.out.println("Your current balance is " + accountBalance);
    }

    //Withdrawing
    public void withdraw (double withdrawAmount){
	accountBalance -= withdrawAmount;
	System.out.println("Your current balance is " + accountBalance);
    }
    
    //Displaying Account Information
    public void displayInfo (){
	System.out.print("Your name is ");
	System.out.println(fullName);
	System.out.print("Your password is ");
	System.out.println(password);
	System.out.print("Your PIN is ");
	System.out.println(PIN);
	System.out.print("Your account number is ");
	System.out.println(accountNumber);
	System.out.print("Your account balance is ");
	System.out.println(accountBalance);
    }
}
