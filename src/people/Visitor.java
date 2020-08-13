package people;

import people.ArrivalTime;
import people.Person;


public class Visitor extends Person implements Comparable<Visitor>{

	private ArrivalTime time;
	
	
	public Visitor(Visitor other) {
		super(other);
		this.time = other.time;
		
	}
	
	public Visitor(String name, int age, String id, boolean willAttend, ArrivalTime time) {
		super(name, age, id, willAttend);
		this.time = time;
		
	}

	@Override
	public int compareTo(Visitor other) {
		return 0;
	}
	
	public boolean equals(Object object) {
		if(object instanceof Visitor) {
			Visitor other = (Visitor) object;
			return getName().equals(other.getName()) &&
				   age == other.age 		   		 &&
				   time.equals(other.time);
		}
		return false;
		}

}
