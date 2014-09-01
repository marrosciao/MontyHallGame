package se.hiq.comhem;

import java.util.Arrays;
import java.util.Random;

public class Doors {
	private int numberOfDoors;
	private Door[] doorsArray;
	
	public Doors(int _numberOfDoors){
		this.numberOfDoors = _numberOfDoors;
	}
	
	/**
	 * Shuffle the set of doors based on number of doors
	 * @param numberOfDoors
	 */
	public void shuffleDoors(int numberOfDoors){
		doorsArray = new Door[numberOfDoors];
		
		int randomDoorNumber = getRandomInteger(numberOfDoors);
		
		for (int i=0; i < numberOfDoors; i++) {
			Door door = new Door(i);
			
			// Set money for the random door
			if (i != randomDoorNumber) {
				door.setMoney(false);
			}else {
				door.setMoney(true);
			}
			
			doorsArray[i] = door;
		}
	}
	
	/**
	 * Get a random integer from 0 to numberOfDoors
	 * @param numberOfDoors
	 * @return
	 */
	public int getRandomInteger(int numberOfDoors){
		Random random = new Random();
        int randomNumber = random.nextInt(numberOfDoors);
        
        return randomNumber;
	}
	
	/**
	 * Get a random number with excluding and to open the door that doesn't have money
	 * @param numberOfDoors
	 * @param excludedValues
	 * @return
	 */
	public int getRandomNumberWithExcludingAndEmptyDoor(int numberOfDoors, int[] excludedValues){
		Arrays.sort(excludedValues);
		int randomNumber = 0;
		Door door;
		
		// Loop until getting random number not in the excluded values and that door is empty
		do {
			Random random = new Random();
	        randomNumber = random.nextInt(numberOfDoors);
	        door = doorsArray[randomNumber];
		}while (Arrays.binarySearch(excludedValues, randomNumber) >= 0 || door.isMoney());
		
		return randomNumber;
	}
	
	/**
	 * Get a random number from 0 to numberOfDoors and not in specific values
	 * @param numberOfDoors
	 * @param excludedValues
	 * @return
	 */
	public int getRandomNumberWithExcluding(int numberOfDoors, int[] excludedValues){
		Arrays.sort(excludedValues);
		int randomNumber = 0;
		
		// Loop until getting random number not in the excluded values
		do {
			Random random = new Random();
	        randomNumber = random.nextInt(numberOfDoors);
		}while (Arrays.binarySearch(excludedValues, randomNumber) >= 0);
		
		return randomNumber;
	}
	
	public Door[] getDoorsArray(){
		return doorsArray;
	}
}
