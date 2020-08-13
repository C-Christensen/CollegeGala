package people;


public class ArrivalTime implements Comparable<ArrivalTime>{
	
	private final int hour;
	private final int minutes;
	private final String meridiem;
	
	
	public ArrivalTime() {
		this(0, 0, "PM");
	}
	
	
	public ArrivalTime(int hour, int minutes, String meridiem) {
		this.hour    	= hour;
		this.minutes 	= minutes;
		this.meridiem 	= meridiem;
	}
	
	
	public int compareTo(ArrivalTime other) {
		if(meridiem.compareTo(other.meridiem) != 0)  {
			return meridiem.compareTo(other.meridiem);
		}
		return 0;
	}
	
	public boolean equals(Object other) {
		if(other instanceof ArrivalTime) {
			return true;
		}
		return false;
	}
	
	public String toFile() {
		
		String _minutes = (minutes >= 0 && minutes <=9)? "0" + minutes : "" + minutes;
		return String.format("%d:%s %s", hour, _minutes, meridiem);
	}
	
	public String toString() {
		return String.format("%d:%s %s", hour, minutes, meridiem);
	}


	

}
