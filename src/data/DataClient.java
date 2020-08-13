package data;

import java.io.File;
import java.io.FileNotFoundException;

public class DataClient {

	public static void main(String[] args) throws FileNotFoundException{
		
		String location =   File.separator + "NO NAME"	+
						    //File.separator + "Documents"	+
						    //File.separator + "CSC143"		+
						    //File.separator + "W20"			+
						    File.separator + "People.txt";
		
//		String location1 =  File.separator + "Users"		+
//			    			File.separator + "Documents"	+
//			    			File.separator + "W20"			+
//			    			File.separator + "CSC143";
		
		
		
		Filter filter = new Filter();
		filter.read(location);
		
		//filter.filterVisitorAge(location1);
		

	}

}
