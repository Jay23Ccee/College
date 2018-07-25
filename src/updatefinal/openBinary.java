package updatefinal;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class openBinary {

	@SuppressWarnings("unchecked")
public static ArrayList<Object> get_studentinfo() {

		ArrayList<Object> studentdata = new ArrayList<Object>();
		
		try
		{
			FileInputStream FOS = new FileInputStream("Studentinfo.dat");
			
			
			try {
				ObjectInputStream ReadFile = new ObjectInputStream(FOS);
				
			
				
				studentdata = (ArrayList<Object>)ReadFile.readObject();
				
				
				FOS.close();
				ReadFile.close();
				
				
				

					
			}catch (ClassNotFoundException c) {
				c.getSuppressed();
			
	}
		}catch (IOException i) {
			i.getSuppressed();
		}
		
		
return 	studentdata;
} 
		
@SuppressWarnings("unchecked")
public static ArrayList<Object> get_Enrollmentinfo() {

		ArrayList<Object> enrollmentdata = new ArrayList<Object>();
		
		try
		{
			FileInputStream FOS = new FileInputStream("Enrollmentinfo.dat");
			
			
			try {
				ObjectInputStream ReadFile = new ObjectInputStream(FOS);
				
			
				
				enrollmentdata = (ArrayList<Object>)ReadFile.readObject();
				
				
				FOS.close();
				ReadFile.close();
				
				
				
					
			}catch (ClassNotFoundException c) {
				c.getSuppressed();
			
				}
		}catch (IOException i) {
			
			}
		
		
return 	enrollmentdata;
} 
	
@SuppressWarnings({ "unchecked", "unused" })
public static ArrayList<Object> get_Gradeinfo() {

	ArrayList<Object> gradedata = new ArrayList<Object>();
	
	try
	{
		FileInputStream FOS = new FileInputStream("Enrollmentinfo.dat");
		
		
		try {
			ObjectInputStream ReadFile = new ObjectInputStream(FOS);
			
		
			
			gradedata = (ArrayList<Object>)ReadFile.readObject();
			
			
			FOS.close();
			ReadFile.close();
			
			
			
			for (int i = 0; i < gradedata.size(); i++) {
				Grade retrievegrade = (Grade)gradedata.get(i);

				break;
				
			}
				
		}catch (ClassNotFoundException c) {
			c.getSuppressed();
		
			}
	}catch (IOException i) {
		
		}
	
	
return 	gradedata;
} 
	

public static ArrayList<Object> get_coursefile() {

	ArrayList<Object> coursestdata = new ArrayList<Object>();
		
		try
		{
			FileInputStream FOS = new FileInputStream("CoursesFile.dat");
						
				try {
					ObjectInputStream ReadFile = new ObjectInputStream(FOS);
				
					
					
					coursestdata = (ArrayList<Object>)ReadFile.readObject();
					
					
									
					FOS.close();
					ReadFile.close();			
								

				}catch (ClassNotFoundException c) {
					c.getSuppressed();
				}
			
	
		}catch (IOException i) {
			i.getSuppressed();
		}
		
		
return 	coursestdata;
} 	
	
@SuppressWarnings({ "unused", "resource" })
public static boolean check_Enrollmentfile() {
	boolean Fileconfirm= false;
		try {
			FileInputStream FOS = new FileInputStream("Studentinfo.dat");
			Fileconfirm = true;
			
			
		} catch (Exception e) {
			Fileconfirm = false;
		}
	
	return Fileconfirm;
}

@SuppressWarnings({ "unused", "resource" })
public static boolean check_coursefile() {
	boolean Fileconfirm= false;
		try {
			FileInputStream FOS = new FileInputStream("CoursesFile.dat");
			Fileconfirm = true;
			
			
		} catch (Exception e) {
			Fileconfirm = false;
		}
		
	return Fileconfirm;
}

@SuppressWarnings({ "resource", "unchecked" })
public static boolean check_StudentID(int ID2check) {
	boolean IDconfirm= false;
	try {
		FileInputStream FOS = new FileInputStream("Studentinfo.dat");
		
		try {
				ObjectInputStream ReadFile = new ObjectInputStream(FOS);
	
			
				ArrayList<Object> studentdata = (ArrayList<Object>)ReadFile.readObject();
			
					for (int i = 0; i < studentdata.size() ; i++) {
						
						student studentID = (student) studentdata.get(i);   // creating a Student class object
						
						if(studentID.get_studentID()== ID2check)             // IF File ID equals User input ID. 
						{
							IDconfirm= true;
						}
				
				
					}
				
			} // closing Try
		catch (Exception e) {
					
			}
	
	
	}catch (Exception e) {
	// TODO: handle exception
	}
	
	
	return IDconfirm;

}



@SuppressWarnings({ "resource", "unchecked" })
public static boolean check_Enrollment(int ID2check, int CourseID2Check) {
	boolean IDconfirm= false;
	try {
		FileInputStream FOS = new FileInputStream("Enrollmentinfo.dat");
		
		try {
			ObjectInputStream ReadFile = new ObjectInputStream(FOS);

		
			ArrayList<Object> studentdata = (ArrayList<Object>)ReadFile.readObject();
			for (int i = 0; i < studentdata.size() ; i++) {
				Enrollment studentID = (Enrollment) studentdata.get(i);   // creating a Student class object
				
				/**IF Student ID and Course ID are match. student can't be enrolled for the same class*/
				if((studentID.get_Student().get_studentID()== ID2check)&& (CourseID2Check == studentID.get_courseinformation().get_courseID()    ))        // IF File ID equals User input ID. 
				{
					IDconfirm= true;
				}
				
				
			}
				
			} // closing Try
		catch (Exception e) {
					
			}
	
	
	}catch (Exception e) {
	// TODO: handle exception
	}
	
	return IDconfirm;

}


@SuppressWarnings({ "resource", "unchecked" })
public static student return_StudentbyID(int ID2check) {
	boolean IDconfirm= false;
	student returnstud = new student();
	try {
		FileInputStream FOS = new FileInputStream("Studentinfo.dat");
		
		try {
			ObjectInputStream ReadFile = new ObjectInputStream(FOS);

		
			ArrayList<Object> studentdata = (ArrayList<Object>)ReadFile.readObject();
			for (int i = 0; i < studentdata.size() ; i++) {
				student studentID = (student) studentdata.get(i);   // creating a Student class object
				if(studentID.get_studentID()== ID2check)             // IF File ID equals User input ID. 
				{
					IDconfirm= true;
					returnstud = studentID;
					
				}
				
				
			}
				
			} // closing Try
		catch (Exception e) {
					
			}
	
	
	}catch (Exception e) {
	// TODO: handle exception
	}
	
	return returnstud;

}





// Search Course ID
@SuppressWarnings({ "resource", "unchecked" })
public static boolean check_CourseID(int ID2check) {
	boolean IDconfirm= false;
	try {
		FileInputStream FOS = new FileInputStream("CoursesFile.dat");
		
		try {
			ObjectInputStream ReadFile = new ObjectInputStream(FOS);

		
			ArrayList<Object> coursedata = (ArrayList<Object>)ReadFile.readObject();
			for (int i = 0; i < coursedata.size() ; i++) {
				courseInformation courseID = (courseInformation) coursedata.get(i);   // creating a Student class object
				if(courseID.get_courseID()== ID2check)             // IF File ID equals User input ID. 
				{
					IDconfirm= true;
				}
				
				
			}
				
			} // closing Try
		catch(IOException e) {
		
		}
		catch (Exception e) {
				
			}
	
	
	}catch (Exception e) {
	// TODO: handle exception
	}
	
	return IDconfirm;

}

@SuppressWarnings({ "unused", "resource" })
public static boolean check_gradefile() {
	boolean Fileconfirm= false;
		try {
			FileInputStream FOS = new FileInputStream("Enrollmentinfo.dat");
			Fileconfirm = true;
			
			
		} catch (Exception e) {
			Fileconfirm = false;
		}
		
	return Fileconfirm;
}



	
	

public static boolean check_studentfile() {
	boolean Fileconfirm= false;
		try {
			FileInputStream FOS = new FileInputStream("Studentinfo.dat");
			Fileconfirm = true;
			
			
		} catch (Exception e) {
			Fileconfirm = false;
		}
	
	return Fileconfirm;
}


}