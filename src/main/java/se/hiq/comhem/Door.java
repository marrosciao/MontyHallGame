package se.hiq.comhem;

public class Door {
	private int doorNumber;
	
	public Door(int _doorNumber) {
		this.setDoorNumber(_doorNumber);
	}
	
	private boolean isMoney;

	public boolean isMoney() {
		return isMoney;
	}

	public void setMoney(boolean isMoney) {
		this.isMoney = isMoney;
	}

	public int getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}
}
