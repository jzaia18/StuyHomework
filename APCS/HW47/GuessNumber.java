//Jake Zaia 
//APCS pd5
//HW #47: Keep Guessing
//2016-12-16

import cs1.Keyboard;

public class GuessNumber{
    private int _lb; //Lower bound for guess
    private int _ub; //Upper bound for guess
    private int _ctr; //Counter for number of guesses
    private int _target; //Number to guess to end game
    private int _lastGuess; //Most recent guess by user

    public GuessNumber(){
	_lb = 1;
	_ub = 100;
	_ctr = 0;
	_target = (int) (Math.random()*100 + 1); //Creates a random number from 1-100 inclusive
	_lastGuess = 0;
    }

    public void runGame(){
	while (_lastGuess != _target){
	    System.out.print("Guess a number from " + _lb + "-" + _ub + ": ");
	    _lastGuess = Keyboard.readInt();
	    if (_lastGuess > _ub || _lastGuess < _lb)
		System.out.println("Guess out of bounds, retry.");
	    else if (_lastGuess < _target){
		System.out.println("Guess too low, retry.");
		_lb = _lastGuess + 1;
	    }
	    else if (_lastGuess > _target){
		System.out.println("Guess too high, retry.");
		_ub = _lastGuess - 1;
	    }
	    else
		System.out.println("You guessed it! And in only " + _ctr + " tries too, good job!");
	    _ctr++;
	}
    }
    
    public static void main(String [] args){
	GuessNumber game = new GuessNumber(); //Creates a new game
	game.runGame();  //Runs the game
    }
    
}
