public class Class {
	//initialize Variables
	
	private int size;// number of students
	private String level;// 
	private String teacherName;
	
	public Class(int size, String level, String teacherName) {
		if(size > 25) throw new IllegalArgumentException("Maximum Number Of Student is 25 ");
		
		this.size = size;
		this.level = level;
		this.teacherName = teacherName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getTeacher() {
		return teacherName;
	}

	public void setTeacher(String teacher) {
		this.teacherName = teacher;
	}
	
	@Override
	public String toString() {	
		return String.format("{The Size: %d The Level: %s The Teacher Name: %s}",getSize(),getLevel(),getTeacher());
	}

}
