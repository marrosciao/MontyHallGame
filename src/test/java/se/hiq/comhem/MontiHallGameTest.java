package se.hiq.comhem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MontiHallGameTest {
	String[] correctArgs;
	String[] emptyArgs;
	String[] nonNumberArgs;

	@Before
	public void setUp() throws Exception {
		correctArgs = new String[] {"1000"};
		emptyArgs = new String[] {};
		nonNumberArgs = new String[] {"testing"};
	}

	@Test
	public void testCorrectParseArgsToNumber() {
		// When
		int number = MontiHallGame.parseArgsToNumber(correctArgs);
		
		// Then
		assertTrue(number == 1000);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEmptyParseArgsToNumber(){
		// When and Then
		MontiHallGame.parseArgsToNumber(emptyArgs);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testNonNumberParseArgsToNumber(){
		// When and Then
		MontiHallGame.parseArgsToNumber(nonNumberArgs);
	}
	
	@Test
	public void testCountWinningIfStayingDoor_ManyTries(){
		// When
		int noOfWinning = MontiHallGame.countWinningIfStayingDoor(1000);
		System.out.println("Number of winning if staying door: " + noOfWinning);
		
		// Then
		assertTrue(noOfWinning >= 0 && noOfWinning <= 1000);
	}
	
	@Test
	public void testCountWinningIfSwichingDoor_ManyTries(){
		// When
		int noOfWinning = MontiHallGame.countWinningIfSwichingDoor(1000);
		System.out.println("Number of winning if switching door: " + noOfWinning);
		
		// Then
		assertTrue(noOfWinning >= 0 && noOfWinning <= 1000);
	}
	
	@Test
	public void testCountWinningIfStayingDoor_FewTries(){
		// When
		int noOfWinning = MontiHallGame.countWinningIfStayingDoor(10);
		System.out.println("Number of winning if staying door: " + noOfWinning);
		
		// Then
		assertTrue(noOfWinning >= 0 && noOfWinning <= 10);
	}
	
	@Test
	public void testCountWinningIfSwichingDoor_FewTries(){
		// When
		int noOfWinning = MontiHallGame.countWinningIfSwichingDoor(10);
		System.out.println("Number of winning if switching door: " + noOfWinning);
		
		// Then
		assertTrue(noOfWinning >= 0 && noOfWinning <= 10);
	}
	
	@Test
	public void testCountWinningIfStayingDoor_VeryFewTries(){
		// When
		int noOfWinning = MontiHallGame.countWinningIfStayingDoor(3);
		System.out.println("Number of winning if staying door: " + noOfWinning);
		
		// Then
		assertTrue(noOfWinning >= 0 && noOfWinning <= 3);
	}
	
	@Test
	public void testCountWinningIfSwichingDoor_VeryFewTries(){
		// When
		int noOfWinning = MontiHallGame.countWinningIfSwichingDoor(3);
		System.out.println("Number of winning if switching door: " + noOfWinning);
		
		// Then
		assertTrue(noOfWinning >= 0 && noOfWinning <= 3);
	}
	
	@Test
	public void testCountWinningIfStayingDoor_NegativeTries(){
		// When
		int noOfWinning = MontiHallGame.countWinningIfStayingDoor(-10);
		System.out.println("Number of winning if staying door: " + noOfWinning);
		
		// Then
		assertTrue(noOfWinning  >= 0);
	}
	
	@Test
	public void testCountWinningIfSwichingDoor_NegativeTries(){
		// When
		int noOfWinning = MontiHallGame.countWinningIfSwichingDoor(-10);
		System.out.println("Number of winning if switching door: " + noOfWinning);
		
		// Then
		assertTrue(noOfWinning >= 0);
	}

}
