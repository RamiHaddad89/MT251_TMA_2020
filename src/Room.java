public class Room {
	//initialize Variables
	
	private String roomNumber;
	private int capacity; // number of seats in the room
	private Class assignedClass; // initianlly empty
	
	public Room(String roomNumber, int capacity) {
		
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.assignedClass = null;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Class getAssignedClass() {
		return assignedClass;
	}

	public void setAssignedClass(Class assignedClass) {
		this.assignedClass = assignedClass;
	}

}
