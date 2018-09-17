//Team Build a Wall: Joelle Lum, Jake Zaia, Brandon Zhang
//credit to Team Z for code
//APCS1 pd5
//HW13 -- Outsourcing
//2016-10-05  

public class BankAccount {

    //declaring variables
    
    private String name;
    private String word;
    private int PIN;
    private int accountNum;
    private Double balance;

    //setting default values for each variable
    public BankAccount(String user, String pass, int fourDigit, int nineDigit,
		       Double initialDeposit) {
	setName(user);
	setWord(pass);
	setPIN(fourDigit);
	setAccountNum(nineDigit);
	setBalance(initialDeposit);
    }
    
    public void setName(String user) {
	name = user;
	// This will set the account owner's name
    }
    public void setWord(String pass) {
	word = pass;
	// This the password, which is just info and not security yet.
    }
    //setting PIN and making sure it's 4 digits
    public void setPIN(int fourDigit) {
	if (1000 <= fourDigit && fourDigit  <= 9998) {
	    PIN = fourDigit;
	}
	else {
	    PIN = 9999;
	    System.out.println("Error: PIN must be between 1000 and 9998, inclusive");
	}
    }
    //setting account number and making sure it's 9 digits
    public void setAccountNum(int nineDigit) {
	if (100000000 <= nineDigit && nineDigit <= 999999998) {
	    accountNum = nineDigit;
	}
	else {
	    accountNum = 999999999;
	    System.out.println("Error: The account number must be 9 digits and not 999999999");
	}
    }
    //setting balance
    public void setBalance(Double initialDeposit) {
	balance = initialDeposit;
	//Initial deposits are a thing, right?.
    }

    //adding money to balance
    public void deposit(Double money) {
	balance += money;
    }
    //withdrawing money only if the person has enough in his/her account to withdraw
    public boolean withdraw(Double money) {
	if (balance >= money) {
	    balance -= money;
	    return true;
	}
	else {
	    System.out.println("Error: not enough money in account");
	    return false;
	}
    }

    // to display the person's account information 
    public void printInfo() {
	System.out.println("Full name: " + name);
	//System.out.println("Password: " + word);
	System.out.println("PIN: " + PIN);
	System.out.println("Account number: " + accountNum);
	System.out.println("Balance: $" + balance);
	// The security here is terrible. Not super bad but....
    }

    //to make sure the account number and password match
public boolean authenticate(int neufDigits, String passmaybe){
	if (accountNum == neufDigits && word == passmaybe) {
	    return true;
	}
	else {
	    return false;
	}
}

    //testing with Mister Brown
public static void main(String[] args) {
	BankAccount brown = new BankAccount("Mister Brown", "no one can guess",
					    1234, 123456789, 4.13);
	brown.printInfo();
	brown.withdraw(2.00);
	brown.deposit(4.05);
	brown.printInfo();
	brown.setPIN(50);
	brown.setAccountNum(60);
	brown.printInfo();
	brown.setPIN(12345);
	brown.setAccountNum(1234567890);
	brown.withdraw(7.00);
	brown.printInfo();
	System.out.print(brown.authenticate(999999999, "no one can guess"));
	System.out.print(brown.authenticate(999999999, "poo"));
	System.out.print(brown.authenticate(123456789, "no one can guess"));
	System.out.println(brown.authenticate(12345, "yo!"));
}
}
