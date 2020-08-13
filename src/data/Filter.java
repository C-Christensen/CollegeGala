package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import modules.DModule;

import people.ArrivalTime;
import people.Employee;
import people.Person;
import people.Visitor;


public class Filter {
	
	List<Person>	data;
	List<Employee> 	employeeData;
	List<Visitor> 	visitorsData;
	
	public Filter() {
		data 			= new ArrayList<Person>();
		employeeData 	= new ArrayList<Employee>();
		visitorsData 	= new ArrayList<Visitor>();
	}
	
	public void filterVisitorAge(String directory) throws FileNotFoundException {
		String loc_1 = directory + File.separator + "VisitorUnder21.txt";
		String loc_2 = directory + File.separator + "VisitorUnder21CS.txt";
		String loc_3 = directory + File.separator + "VisitorOver21.txt";
		String loc_4 = directory + File.separator + "VisitorOver21CS.txt";
		
		File file_1 = new File(loc_1);
		File file_2 = new File(loc_2);
		File file_3 = new File(loc_3);
		File file_4 = new File(loc_4);
		
		PrintStream out_1 = new PrintStream(file_1);
		PrintStream out_2 = new PrintStream(file_2);
		PrintStream out_3 = new PrintStream(file_3);
		PrintStream out_4 = new PrintStream(file_4);
		
		DModule.bubbleSort(visitorsData);
		
		if(file_1.exists() && file_2.exists() & file_3.exists() && file_4.exists()) {
			for(Visitor visitor : visitorsData) {
				if(visitor.getAge() < 21) {
					out_1.println(visitor);
					out_2.println(visitor.toFile());
					
				}else {
					out_3.println(visitor);
					out_4.println(visitor.toFile());
					
				}
			}
		}
		
		out_1.close();
		out_2.close();
		out_3.close();
		out_4.close();	
	
	}
	
	public ArrivalTime makeArrivalTime(String str) {
		String[] info 		= str.split(":");
		String[] sub 		= info[1].split(" ");
		int      hour 		= Integer.parseInt(info[0]);
		int      minutes 	= Integer.parseInt(sub[0]);
		String 	 meridiem 	= sub[1];
		
		return new ArrivalTime(hour, minutes, meridiem);
	}
	
	public Person parse(String line) {
		String[] 	info  		= line.split(", ");
		String   	name  		= info[0];
		int		 	age   		= Integer.parseInt(info[1]);
		String   	id    		= info[2];
		boolean  	willAttend  = info[3].equalsIgnoreCase("Yes");
		
		if(id.charAt(0) == 'E') {
			String 	office 		= info[4];
			double 	salary 		= Double.parseDouble(info[5]);
			int    	years  		= Integer.parseInt(info[6]);
			
			
			return new Employee.Builder()
							   .setName(name)
							   .setAge(age)
							   .setID(id)
							   .setWillAttend(willAttend)
							   .setOffice(office)
							   .setSalary(salary)
							   .setYears(years)
							   .build();
		}else {
			ArrivalTime time = makeArrivalTime(info[4]);
			return new Visitor(name, age, id, willAttend, time);
		}
	}
	
	public void read(String location) throws FileNotFoundException {
		File 	file 	= new File(location);
		Scanner input	= new Scanner(file);
		
		Person 		person;
		Employee 	employee;
		Visitor 	visitor;
		
		while(input.hasNextLine() && file.exists()) {
			
			person = parse(input.nextLine());
			
			if(person instanceof Employee) {
				employee = (Employee) person;
				if(employeeData.contains(employee)) {
					employeeData.add(employee);		
				}	
			}else if(person instanceof Visitor) {
				visitor = (Visitor) person;
				if(visitorsData.contains(visitor)) {
					visitorsData.add(visitor);
				}
			}
		}
		
		input.close();
	}
	
}
