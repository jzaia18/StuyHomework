//Team Build a Wall: Joelle Lum, Jake Zaia, Brandon Zhang
//credit to Team Z for code
//APCS1 pd5
//HW13 -- Outsourcing
//2016-10-05

public class Teller{
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
