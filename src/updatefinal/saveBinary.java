package updatefinal;

/*
 * SAVING PROBLEMS. 
 * retriving all of the data being stored? maybe only a list of an array being package in one and then retriving all of them at once. 
 * 
 * maybe a random access file?
 * 
 * 
 * 
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class saveBinary {
	
	student savingdata;

/********************************************************************************************************************/	
//SAVE STUDENT
public static void save_student(student stud) {

	ArrayList<Object> studentdata = new ArrayList<Object>();
	
	try
	{	if(openBinary.check_studentfile()) {
		
			studentdata = openBinary.get_studentinfo();
		
		}
		FileOutputStream FOS = new FileOutputStream("Studentinfo.dat");
		
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					studentdata.add(stud);
				 
					
					

			SaveFile.writeObject(studentdata); 
			
			
			SaveFile.close();
			FOS.close();
		
		
		}catch (Exception e) {
			e.getSuppressed();
		};

		
		
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}
	
	
	
	
}
/********************************************************************************************************************/
// SAVE ENROLLMENT BY ENROLLMENT CLASS
public static void save_enrollment(Enrollment enroll) {

	ArrayList<Object> enrollmentdata = new ArrayList<Object>();
	
	try
	{	if(openBinary.check_Enrollmentfile()) {
		
			enrollmentdata = openBinary.get_Enrollmentinfo();
		
		}
		FileOutputStream FOS = new FileOutputStream("Enrollmentinfo.dat");
		
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					enrollmentdata.add(enroll);
				 
					
					

			SaveFile.writeObject(enrollmentdata); 
			
			
			SaveFile.close();
			FOS.close();
			System.out.println("");
		
		}catch (Exception e) {
			
		};
		

		
		
	//	SaveFile.close();

		
		
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}
	
	
	
	
}

// save enrollment by Stud class
public static void save_enrollment(student enroll) {

	ArrayList<Object> enrollmentdata = new ArrayList<Object>();
	Enrollment checkstud = new Enrollment();
	
	try
	{	if(openBinary.check_Enrollmentfile()) {
		
			enrollmentdata = openBinary.get_Enrollmentinfo();
			for (int i = 0; i < enrollmentdata.size(); i++) {
				checkstud = (Enrollment) enrollmentdata.get(i);
				
				if(checkstud.get_studentid() == enroll.get_studentID() )
				{
					
					checkstud.SaveStudentedit(enroll);
					enrollmentdata.remove(i);
				}
				
				
				
				
			}
		
		}
		FileOutputStream FOS = new FileOutputStream("Enrollmentinfo.dat");
		
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					enrollmentdata.add(checkstud);
				 
					
					

			SaveFile.writeObject(enrollmentdata); 
			
			
			SaveFile.close();
			FOS.close();
			System.out.println("");
		
		}catch (Exception e) {
			
		};
		

		
		
	//	SaveFile.close();

		
		
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}
	
	
	
	
}


// save enrollment BY COURSE class
public static void save_enrollment(courseInformation enroll) {

	ArrayList<Object> enrollmentdata = new ArrayList<Object>();
	Enrollment checkstud = new Enrollment();
	
	try
	{	if(openBinary.check_Enrollmentfile()) {
		
			enrollmentdata = openBinary.get_Enrollmentinfo();
			for (int i = 0; i < enrollmentdata.size(); i++) {
				checkstud = (Enrollment) enrollmentdata.get(i);
				
				if(checkstud.get_CourseID() == enroll.get_courseID() )
				{
					
					checkstud.SaveCourseEdit(enroll);
					enrollmentdata.remove(i);
				}
				
				
				
				
			}
		
		}
		FileOutputStream FOS = new FileOutputStream("Enrollmentinfo.dat");
		
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					enrollmentdata.add(checkstud);
				 
					
					

			SaveFile.writeObject(enrollmentdata); 
			
			
			SaveFile.close();
			FOS.close();
			System.out.println("");
		
		}catch (Exception e) {
			
		};
		

		
		
	//	SaveFile.close();

		
		
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}
	
	
	
	
}
/********************************************************************************************************************/



/********************************************************************************************************************/
//SAVE COURSE 
public static void save_course(courseInformation courses) {

	ArrayList<Object> coursesdata = new ArrayList<Object>();
	
	try
	{	if(openBinary.check_coursefile()==true) {
		
			coursesdata = openBinary.get_coursefile();
		
		}
		FileOutputStream FOS = new FileOutputStream("CoursesFile.dat");
		
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
			coursesdata.add(courses);
				 
					
					

			SaveFile.writeObject(coursesdata); 
			
			
			SaveFile.close();
			FOS.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		};
		

		
		

		
		
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}
	
}

/********************************************************************************************************************/

//Save grade
public static void save_Grade(Grade grade) {
ArrayList<Object> gradedata = new ArrayList<Object>();
			

try
	{	if(openBinary.check_coursefile()==true) {
		
			gradedata = openBinary.get_Gradeinfo();
		
		}
		FileOutputStream FOS = new FileOutputStream("Enrollmentinfo.dat");
		
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
			gradedata.add(grade);
				 
					
					

			SaveFile.writeObject(gradedata); 
			
			
			SaveFile.close();
			FOS.close();
		
			
		}catch (Exception e) {
			e.getSuppressed();
		};
			
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}

	
}

/********************************************************************************************************************/
//SAVE EDIT STUDENT

public static void save_EditStudent(student stud) {

	ArrayList<Object> studentdata = new ArrayList<Object>();
	
	try
	{	if(openBinary.check_studentfile()) {
		
			studentdata = openBinary.get_studentinfo();
		
		}
		FileOutputStream FOS = new FileOutputStream("Studentinfo.dat");
		
		
		
		try { 
				if(openBinary.check_studentfile()) {
				
				studentdata = openBinary.get_studentinfo();
				student checkid= new student();
				
				for (int i = 0; i < studentdata.size(); i++) {
					checkid=(student) studentdata.get(i);
					
					if (stud.get_studentID() == checkid.get_studentID())
					{
						studentdata.remove(i);
					}
					
				}
				}
			
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					studentdata.add(stud);
				 
					
					

			SaveFile.writeObject(studentdata); 
			
			
			SaveFile.close();
			FOS.close();
		
		
		}catch (Exception e) {
			e.getSuppressed();
		};

		
		
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}
	
	
	
	
}



/***************************************************************************************************/
// SAVE EDIT COURSE
public static void save_EditCourse(courseInformation cour) {

	ArrayList<Object> Coursedata = new ArrayList<Object>();
	
	try
	{	if(openBinary.check_Enrollmentfile()) {
		
			Coursedata = openBinary.get_coursefile();
		
		}
		FileOutputStream FOS = new FileOutputStream("CoursesFile.dat");
		
		
		
		try { 
				if(openBinary.check_Enrollmentfile()) {
				
				Coursedata = openBinary.get_coursefile();
				courseInformation checkid= new courseInformation();
				
				for (int i = 0; i < Coursedata.size(); i++) {
					checkid=(courseInformation) Coursedata.get(i);
					
					if (cour.get_courseID() == checkid.get_courseID())
					{
						Coursedata.remove(i);
					}
					
				}
				}
			
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					Coursedata.add(cour);
				 
					
					

			SaveFile.writeObject(Coursedata); 
			
			
			SaveFile.close();
			FOS.close();
		
		
		}catch (Exception e) {
			e.getSuppressed();
		};

		
		
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}
	
	
	
	
}

	
/***************************************************************************************************/
//SAVE EDIT COURSE
@SuppressWarnings("unchecked")
public static void save_EditEnrollment(Enrollment Enro) {

	ArrayList<Object> Enrollmentdata = new ArrayList<Object>();
	ArrayList<Object> gradedata = new ArrayList<Object>();
	
	try
	{	if(openBinary.check_Enrollmentfile()) {
		
			Enrollmentdata = openBinary.get_Enrollmentinfo();
		
		}
	
		try { 
				if(openBinary.check_Enrollmentfile()) {
				
				Enrollmentdata = openBinary.get_Enrollmentinfo();
				Enrollment checkid= new Enrollment(); // gets ENROLLMENT 
				
				for (int i = 0; i < Enrollmentdata.size(); i++) {
					checkid=(Enrollment) Enrollmentdata.get(i);
					
					if ((Enro.get_studentid() == checkid.get_studentid())&& (Enro.get_CourseID() == checkid.get_CourseID()))
					{
						try {
							FileInputStream FOS1 = new FileInputStream("Enrollmentinfo.dat");

							ObjectInputStream ReadFile1 = new ObjectInputStream(FOS1);
								
							
						
									Enrollmentdata.remove(i);
									
									
									FOS1.close();
									ReadFile1.close();
									
								
						}catch (Exception e) {
							e.getSuppressed();
						}

							
						}
						
					}
					
				}
				}catch (Exception e) {
					e.getSuppressed();
				}
			

			
		try {
			FileOutputStream FOS = new FileOutputStream("Enrollmentinfo.dat");

			
			
			
			try { 
				ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
				
				Enrollmentdata.add(Enro);
					
						
						

				SaveFile.writeObject(Enrollmentdata); 
				
				
				SaveFile.close();
				FOS.close();
			
				
			}catch (Exception e) {
				e.getSuppressed();
			}; 

		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}catch (Exception e) {
		// TODO: handle exception
	}

		
		
	}
	
/*****************************************************************************************************/
// SAVE Edit Grade
public static void save_EditGrade(Grade grade) {

ArrayList<Object> gradedata = new ArrayList<Object>();
	
	try
	{	if(openBinary.check_gradefile()==true) 
		{
		
			gradedata = openBinary.get_Gradeinfo();
			
			for (int i = 0; i < gradedata.size(); i++) {
				Grade Editgrade = (Grade) gradedata.get(i);
				
				if((grade.get_studentID()== Editgrade.get_studentID()))
				{
					
					
					//&& (grade.get_CourseID() == Editgrade.get_CourseID())   // THIS NEEDS TO GO UP. NEED 
					gradedata.remove(i);
					
					break;
				}
		
			}
		}
	} catch (Exception e) {
		e.getSuppressed();
	}
			
	try {
		FileOutputStream FOS = new FileOutputStream("Enrollmentinfo.dat");

		
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
			gradedata.add(grade);
				
					
					

			SaveFile.writeObject(gradedata); 
			
			
			SaveFile.close();
			FOS.close();
		
			
		}catch (Exception e) {
			e.getSuppressed();
		};
			
		
	} // Try Fileoutput ending
	catch (Exception e) {
		
	}
	
	}

/****************************************************************************************************/
	

	
}








	
	