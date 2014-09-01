package se.hiq.comhem;

public class MontiHallGame {
	private static final int NUMBER_OF_DOORS = 3;

	public static void main(String[] args) {
		int noOfTries = parseArgsToNumber(args);
		
		System.out.println("Total number of tries in the game: " + noOfTries);
		
		System.out.println("Number of doors: " + NUMBER_OF_DOORS);
		
		// Get number of winning out of number of try if players changed their mind
		int noOfWinningIfSwitch = countWinningIfSwichingDoor(noOfTries);
		
		// Get number of winning out of number of try if players stayed their choice
		int noOfWinningIfStay = countWinningIfStayingDoor(noOfTries);
		
		getComparisionResult(noOfWinningIfSwitch, noOfWinningIfStay);
	}
	
	/**
	 * Get the comparision of the results Switch or Stay
	 * @param noOfWinningIfSwitch
	 * @param noOfWinningIfStay
	 */
	public static void getComparisionResult(int noOfWinningIfSwitch, int noOfWinningIfStay){
		System.out.println("Number of winning if switching door: " + noOfWinningIfSwitch);
		System.out.println("Number of winning if staying door: " + noOfWinningIfStay);
		
		if (noOfWinningIfSwitch == noOfWinningIfStay) {
			System.out.println("RESULT: The possibility is the same no matter which player switched or played");
		}
		
		if (noOfWinningIfSwitch > noOfWinningIfStay) {
			System.out.println("RESULT: Switch the selected door is better then Stay");
		}
		
		if (noOfWinningIfSwitch < noOfWinningIfStay) {
			System.out.println("RESULT: Stay the selected door is better then Switch");
		}
	}

	/**
	 * Parse the argument to Number of tries in the game
	 * @param args
	 * @return
	 */
	public static int parseArgsToNumber(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException("You must pass the number of tries in the game as argument");
		}
		
		try {
			return Integer.parseInt(args[0]);
		}catch (NumberFormatException ex){
			throw new NumberFormatException("Argument is supposed to be a number");
		}
	}
	
	/**
	 * Count the number of winning if player switched the selected door all the time
	 * @param noOfTries
	 * @return
	 */
	public static int countWinningIfSwichingDoor(int noOfTries){
		int noOfWinning = 0;
		
		// Play noOfTries times
		for (int play = 0; play < noOfTries; play++){
			Doors doors = new Doors(NUMBER_OF_DOORS);
			doors.shuffleDoors(NUMBER_OF_DOORS);
			
			// Select a random door (door number)
			int selectedDoorNo = doors.getRandomInteger(NUMBER_OF_DOORS);
			
			// Open an empty door randomly other then selected door
			int openedDoorNo = doors.getRandomNumberWithExcludingAndEmptyDoor(NUMBER_OF_DOORS, new int[] {selectedDoorNo});
			
			// Get the final selected door if switching door
			int lastSelectedDoorNo = doors.getRandomNumberWithExcluding(NUMBER_OF_DOORS, new int[] {selectedDoorNo,openedDoorNo});
			
			Door lastSelectedDoor = doors.getDoorsArray()[lastSelectedDoorNo];
			if (lastSelectedDoor.isMoney()) {
				noOfWinning++;
			}
		}
		
		return noOfWinning;
	}
	
	/**
	 * Count the number of winning if player stayed the selected door all the time
	 * @param noOfTries
	 * @return
	 */
	public static int countWinningIfStayingDoor(int noOfTries) {
		int noOfWinning = 0;
		
		// Play noOfTries times
		for (int play = 0; play < noOfTries; play++){
			Doors doors = new Doors(NUMBER_OF_DOORS);
			doors.shuffleDoors(NUMBER_OF_DOORS);
			
			// Open a random door (door number)
			int selectedDoorNo = doors.getRandomInteger(NUMBER_OF_DOORS);
			
			// Stay selected door
			Door selectedDoor = doors.getDoorsArray()[selectedDoorNo];
			
			// Check whether the door has money or not then increase the number of winning
			if (selectedDoor.isMoney()) {
				noOfWinning++;
			}
		}
		
		return noOfWinning;
	}
}
