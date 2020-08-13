package people;


import people.Person;

public class Employee extends Person implements Comparable<Employee> {
	
	private final String office;
	private final double salary;
	private final int    years;
	
	
	public static class Builder{
		
		private String 	name;
		private int 	age;
		private String 	id;
		private boolean willAttend;
		private String	office;
		private double 	salary;
		private int    	years;
		
		
		public Builder() {
			office = "Unassigned";
			salary = 0.0;
			years = 0;
		}
		
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		
		public Builder setID(String id) {
			this.id = id;
			return this;
		}
		
		
		
		public Builder setOffice(String office) {
			 this.office = office;
			 return this;
			
		}
		
		public Builder setSalary(double salary) {
			this.salary = salary;
			return this;	
		}
		
		public Builder setWillAttend(boolean willAttend) {
			this.willAttend = willAttend;
			return this;
		}
		
		public Builder setYears(int years) {
			this.years = years;
			return this;
		}
		
		
		public Employee build() {
			return new Employee(this);
		}
	}
	
	public int compareSalary(Employee e1, Employee e2) {
		return 0;
	}
	
	public int compareTo(Employee other) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean equals(Object other) {
		return false;
	}
	
	public Employee(Builder builder) {
		super(builder.name, builder.age, builder.id, builder.willAttend);
		office = builder.office;
		salary = builder.salary;
		years  = builder.years;	
		
	}
	
	public Employee(Employee other) {
		super(other);
		this.office = other.office;
		this.salary = other.salary;
		this.years  = other.years;
	}
	
	public double getSalary() {
		return salary;
	}
	
	
	public int getYears() {
		return years;
	}
	
	public double payments() {
		return 0.0;
	}
	
	public int rankSalary() {
		return 0;
	}
	
	public int rankYears() {
		return 0;
	}
	
	public String toFile() {
		return null;
	}
	
	public String toString() {
		return office + ", " + salary + ", " + years;
	}



	

}
