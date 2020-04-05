import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class School {
	// initialize Variables
	
	private String name;
	private int floor;
	private ArrayList<Room> listOfRoom;
	
	public School(String name,int floor){
		if(floor > 3) throw new IllegalArgumentException("The Maximum Floors is 3 ");
		this.name = name;
		this.floor = floor;
		listOfRoom =new ArrayList<Room>();
		
	}
	
	public void saveSchool() {
		try {
			PrintWriter pw = new PrintWriter(new File(".//M251_school.txt"));
			pw.write("School Name: " + getName() + "\n" +
					"Number Of Floors: " + getFloor() + "\n");
			pw.write(displayRooms());
			pw.close();
		}catch(FileNotFoundException e){
			System.out.println("Error in file");
		}
	}
	
	public String loadSchool(){
		String data = "";
		try {
			Scanner sc = new Scanner(new File(".//M251_school.txt"));
			while(sc.hasNext()) {
				data = data + sc.nextLine() + "\n";
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		return data;
	}
	
	public boolean checkRoom(Room checkRoom) {
		boolean isunique = true;
		for(Room r : listOfRoom) {
			if(r.getRoomNumber() == checkRoom.getRoomNumber())
				isunique = false;
		}
		return isunique;
	}
	
	public void addRoom(Room newRoom) {
		if(checkRoom(newRoom)) {
			listOfRoom.add(newRoom);
			System.out.println("Room added successfully ");
		}else {
			System.out.println("The Room Number Is Taken!");
		}
	}
	
	public String displayRooms(){
		String list = "**** Room list ****" + "\n";
		
		if(listOfRoom.isEmpty()) {
			list = "Empty list";
		}else
			for(Room r : listOfRoom) {
				list = list + "Room " + r.getRoomNumber() +
						" capacity: " + r.getCapacity() + 
						" assigned Class: " + r.getAssignedClass() + "\n";
			}
		return list;
	}

	public void assignclassToRightRoom(Class newClass) throws Exception {
		 Room satesFactory = null;
		 int minimum = 25;
		 int leftOver = 0;
		 for(Room r : listOfRoom) {
			 leftOver = r.getCapacity() - newClass.getSize();
			 if(r.getAssignedClass() == null && leftOver > 0) {
				 if(leftOver < minimum) {
					 minimum = leftOver;
					 satesFactory = r;
				 }
			 }
		 }
		 if(satesFactory != null) {
			 System.out.println(satesFactory.getRoomNumber());
			 satesFactory.setAssignedClass(newClass);
		 }else 
			 throw new Exception("No Sates Factory Room");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
			this.floor = floor;	
	}

	public ArrayList<Room> getListOfRoom() {
		return listOfRoom;
	}

	public void setListOfRoom(ArrayList<Room> listOfRoom) {
		this.listOfRoom = listOfRoom;
	}
	
	public String toString() {
	  return String.format("%s", displayRooms());
	}

}
