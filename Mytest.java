import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



class Mytest {

	@Test
	void test() {
		Piece tester = new Piece();
		//Testing positions and moves for player 1
		assertEquals(false, tester.CheckCurrentPosition(1, 1), "(1,1) is not a valid starting postion");
		assertEquals(false, tester.CheckCurrentPosition(5, 7), "(5,7) is not a valid starting postion");
		assertEquals(true, tester.CheckCurrentPosition(1, 2), "(1,2) is a valid starting postion");
		assertEquals(true, tester.CheckCurrentPosition(5, 2), "(5,2) is a valid starting postion");
		
		assertEquals(false, tester.CheckMovingPosition(0, 4, 1, 2), "(1,2) to (0,4) is not a valid move");
		assertEquals(false, tester.CheckMovingPosition(6, 3, 1, 2), "(1,2) to (6,3) is not a valid move");
		assertEquals(true, tester.CheckMovingPosition(0, 3, 1, 2), "(1,2) to (0,3) is a valid move");
		assertEquals(true, tester.CheckMovingPosition(6, 3, 5, 2), "(5,2) to (6,3) is a valid move");
		
		
		Piece.PL = 2; 
		
		//Testing positions and moves for player 2
		assertEquals(false, tester.CheckCurrentPosition(1, 1), "(1,1) is not a valid starting postion");
		assertEquals(false, tester.CheckCurrentPosition(5, 7), "(5,7) is not a valid starting postion");
		assertEquals(true, tester.CheckCurrentPosition(0, 5), "(0,5) is a valid starting postion");
		assertEquals(true, tester.CheckCurrentPosition(6, 5), "(6,5) is a valid starting postion");
				
		assertEquals(false, tester.CheckMovingPosition(5, 3, 6, 5), "(6,5) to (5,3) is not a valid move");
		assertEquals(false, tester.CheckMovingPosition(2, 4, 6, 5), "(6,5) to (2,4) is not a valid move");
		assertEquals(true, tester.CheckMovingPosition(7, 4, 6, 5), "(6,5) to (7,4) is a valid move");
		assertEquals(true, tester.CheckMovingPosition(1, 4, 0, 5), "(0,5) to (1,4) is a valid move");
	}

}
