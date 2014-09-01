package se.hiq.comhem;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DoorsTest {
	private static int NUMBER_OF_DOORS = 3;
	private static int[] EXCLUDED_VALUES = new int[] {0,2};
	
	Doors doors;

	@Before
	public void setUp() throws Exception {
		doors = new Doors(NUMBER_OF_DOORS);
	}

	@Test
	public void testGetRandomInteger() {
		// When
		int randomNumber = doors.getRandomInteger(NUMBER_OF_DOORS);
		
		// Then
		System.out.println("Random number: " + randomNumber);
		assertTrue((randomNumber >= 0 && randomNumber < NUMBER_OF_DOORS));
	}
	
	@Test
	public void testGetRandomNumberExcluding(){
		// When
		int randomNumber = doors.getRandomNumberWithExcluding(NUMBER_OF_DOORS, EXCLUDED_VALUES);
		
		// Then
		System.out.println("Random number excluding {0,2}: " + randomNumber);
		assertTrue(randomNumber != 0 && randomNumber != 2);
	}
	
	@Test
	public void testGetRandomNumberWithExcludingAndEmptyDoor(){
		// Given
		int[] selectedDoor = new int[] {0};
		
		// When
		doors.shuffleDoors(NUMBER_OF_DOORS);
		Door[] doorsArray = doors.getDoorsArray();
		int randomNumber = doors.getRandomNumberWithExcludingAndEmptyDoor(NUMBER_OF_DOORS, selectedDoor);
		
		// Then
		System.out.println("---------");
		System.out.println("testGetRandomNumberWithExcludingAndEmptyDoor:");
		System.out.println("Door 0: " + doorsArray[0].isMoney());
		System.out.println("Door 1: " + doorsArray[1].isMoney());
		System.out.println("Door 2: " + doorsArray[2].isMoney());
		System.out.println("Random number excluding {0} and empty door: " + randomNumber);
		System.out.println("---------");
		assertTrue(!doorsArray[randomNumber].isMoney() && randomNumber != 0);
	}
	
	@Test
	public void testShuffleDoors(){
		// Given
		int numberOfMoneyDoors = 0;
		int numberOfEmptyDoors = 0;
		
		// When
		doors.shuffleDoors(NUMBER_OF_DOORS);
		Door[] doorsAray = doors.getDoorsArray();
		
		for (int i = 0; i < NUMBER_OF_DOORS; i++) {
			Door door = doorsAray[i];
			
			if (door.isMoney()) numberOfMoneyDoors++;
			else numberOfEmptyDoors++;
		}
		
		// Then
		assertTrue((numberOfMoneyDoors == 1));
		assertTrue((numberOfEmptyDoors == (NUMBER_OF_DOORS - 1)));
	}

}
