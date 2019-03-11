import java.util.InputMismatchException;
import java.util.Scanner;

class Board {
	
	//Board generated
	static int[][] bd = {
		{0, 1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 0, 1},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{2, 0, 2, 0, 2, 0, 2, 0},
		{0, 2, 0, 2, 0, 2, 0, 2},
		{2, 0, 2, 0, 2, 0, 2, 0}
		};
	
	//Printing the board
	void bdprint() {
		for (int i = 0; i < bd.length; i++) {
		    for (int j = 0; j < bd[i].length; j++) {
		        System.out.print(bd[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	//Update the board with the new position
	void Update(int A, int B, int X, int Y) {
		bd[Y][X] = 0;
		bd[B][A] = Piece.PL;
		
	}
	
}

//Piece class for moving pieces
class Piece extends Board {
	
	//Variable for number of pieces (not relevant in this version)
	static int NP1 = 12;
	static int NP2 = 12;
	//Variable for the players: 1 or 2
	static int PL = 1;
	//Error messages
	static String POSERROR = "";
	static String MOVERROR = "";
	
	//Checking if the starting position for a piece is valid
	boolean CheckCurrentPosition(int X, int Y) {
		
		//true when position is valid
		if (X < 0 || X > 7 || Y < 0 || Y > 7 || Board.bd[Y][X] != PL) {
			POSERROR = "Entered position not valid for piece";
			return false;
		}
		
		//false when position is not valid
		else {
			POSERROR = "";
			return true;
		}
	}
	
	//Checking if the moving position for the chosen piece is valid
	boolean CheckMovingPosition(int A, int B, int X, int Y) {
		
		//valid moves for player 1
		if (PL == 1) {
			
			//return false when the moving position is not valid
			if (A < 0 || A > 7 || B < 0 || B > 7 || Board.bd[B][A] != 0 || ((A != X + 1 || B != Y + 1) && (A != X - 1 || B != Y + 1))){
				MOVERROR = "Entered position not valid for move";
				return false;
			}
			
			//true when the moving position valid
			else {
				MOVERROR = "";
				return true;
			}

		}
		
		//Valid moves for player 2
		else if (PL == 2) {
			
			//return false when the moving position is not valid
			if (A < 0 || A > 7 || B < 0 || B > 7 || Board.bd[B][A] != 0 || ((A != X + 1 || B != Y - 1) && (A != X - 1 || B != Y - 1))){
				MOVERROR = "Entered position not valid for move";
				return false;
			}
			
			//true when the moving position valid
			else {
				MOVERROR = "";
				return true;
			}
		}
		
		return false;
	}
	
	//Switches between variables 1 and 2, representing the players
	void PlayerSwitch() {
		if (PL == 1) {
			PL = 2;
		}
		else if (PL == 2) {
			PL = 1;
		}
	}
	
	
	
}



public class Checkers {

	public static void main(String[] args) {
		
		
		//Scanner for user input
		Scanner s = new Scanner(System.in);
		
		
		//new board at the start of the game
		Board b = new Board();
		
		//new piece at the start of the game
		Piece p = new Piece();
		
		//Variables for current position user input
		int PX = 0;
		int PY = 0;
		
		//Variables for moving position user input
		int MX = 0;
		int MY = 0;
		
		
		
		//While loop until either team runs out of pieces
		while (Piece.NP1 > 0 && Piece.NP2 > 0) {
			//Print board
			b.bdprint();
			
			//Choosing Piece to Move
			do {
			System.out.println(Piece.POSERROR);
				
			System.out.println("Player " + Piece.PL + "'s" + " Turn");
			
			//Getting user input
			
			//X coordinate
			System.out.print("Enter X coordinate for the piece you want to move: ");
			
			
			try {
				PX = s.nextInt();
			}
			
			//Exception if input is not an integer
            catch(InputMismatchException e) {
                System.out.println("Please insert a valid number");
                s.next();
            }
			
			//Y coordinate
			System.out.print("Enter Y coordinate for the piece you want to move: ");
			
			try {
				PY = s.nextInt();	
			}
			
			//Exception if input is not an integer
			catch(InputMismatchException e) {
				System.out.println("Please insert a valid number");
				s.next();
			}
			
			//if the current position is not valid the while loop runs, if valid the program continues
			} while (p.CheckCurrentPosition(PX, PY) == false);
			
			System.out.println("Position Confirmed");
			
			
			
			//Choosing Position to move to
			do {
			System.out.println(Piece.MOVERROR);
				
			System.out.println("Player " + Piece.PL + "'s" + " Turn");
			
			//Getting user input
			
			//X coordinate
			
			System.out.print("Enter X coordinate for the position you want to move to: ");
			
			try {
				MX = s.nextInt();	
			}
			
			//Exception if input is not an integer
			catch(InputMismatchException e) {
				System.out.println("Please insert a valid number");
				s.next();
			}
			
			//Y coordinate
			
			System.out.print("Enter Y coordinate for the position you want to move to: ");
			
			try {
				MY = s.nextInt();	
			}
			
			//Exception if input is not an integer
			catch(InputMismatchException e) {
				System.out.println("Please insert a valid number");
				s.next();
			}
			
			//if the moving  position is not valid the while loop runs, if valid the program continues
			} while (p.CheckMovingPosition(MX, MY, PX, PY) == false);
			
			System.out.println("Move Confirmed");
			
			//Updates the board after a valid move
			b.Update(MX, MY, PX, PY);
			
			//Switching turns
			p.PlayerSwitch();
		}
			
			s.close();
	}
}
