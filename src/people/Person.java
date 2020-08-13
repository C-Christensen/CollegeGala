package people;


public class Person {
	
	protected String  name;
	protected String  firstName;
	protected String  lastName;
	protected int     age;
	protected String  id;
	protected boolean willAttend;
	
	
	
	public static int compareName(Person p1, Person p2) {
		if(p1.getLastName().compareTo(p2.getLastName()) != 0) {
			return p1.getLastName().compareTo(p2.getLastName());
		}else if(p1.getFirstName().compareTo(p2.getFirstName()) !=0) {
			return p1.getFirstName().compareTo(p2.getFirstName());
		}
		return p1.getAge() - p2.getAge();
		
	}
	
	public boolean equals(Object other) {
		if(other instanceof Person) {
			return true;
		}
		return false;
	}
	
	public Person(Person other) {
		this(other.name, other.age, other.id, other.willAttend);
	}
	
	public Person(String name, int age, String id, boolean willAttend) {
		this.name 		= name;
		this.age		= age;
		this.id 		= id;
		this.willAttend = willAttend;
	}

	public int getAge() {
		return age;
	}
	
	public String getFirstName() {
		String [] splitFirstName = name.split(" ");
		return splitFirstName[0];
	}


	public String getLastName() {
		String [] splitLastName = name.split(" ");
		return splitLastName[1];
	}


	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public boolean isWillAttend() {
		return willAttend;
	}
	
	public String toFile() {
		String result = name + ", " + age + ", " + id + ", ";
		return result + willAttend;
	}
	
	public String toString() {
		return "Name: \t"	+	"\t" 	+ name 		+ "\n"
			+	"Age: \t"	+	"\t"	+ age		+ "\n"
			+	"ID:  \t"	+	"\t"	+id			+"\n"
			+	"Gala: \t"	+	"\t" 	+willAttend +"\n";
		
	}

	
	
	
	
	
	
	

}
