package updatefinal;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class display {

/*********************************************************************/
/*********************************************************************/

//Display Course
public static void display_courses() {
		
		ArrayList<Object> retrievecourses = openBinary.get_coursefile();
		System.out.println("\nDisplaying Course Information");
		System.out.println("\n__________________________________________________");

		for (int i = 0; i < retrievecourses.size(); i++) {
			courseInformation  courses= (courseInformation) retrievecourses.get(i);
			System.out.println("\nCourse name: "+ courses.get_coursename()+" | Course ID: "+ courses.get_courseID() );
			System.out.println("\n Semester: "+ courses.get_semester() + "| Year: "+ courses.get_year());
			System.out.println("\nDay:"+ courses.get_day() + " | room: "+ courses.get_roombld());
			System.out.println("\n-------------------------------------------------");
		}
		
		 System.out.println("\nPress enter to continue.");
	        new Scanner(System.in).nextLine();
	     
			
	}

	//Display Enrollment
public static void display_Enrollment() {
		
		ArrayList<Object> retrieveEnrollment = openBinary.get_Enrollmentinfo();
		System.out.println("\nDisplaying Enrollment Information");
		System.out.println("\n--------------------------------------");
		
		
		for (int i = 0; i < retrieveEnrollment.size(); i++) {

			Enrollment Enrollment= (Enrollment) retrieveEnrollment.get(i);
			System.out.println("\nClass:"+ Enrollment.get_coursename() + "\nStudent: "+Enrollment.get_sname()+" "+Enrollment.get_slastname());
			System.out.println("\n|age: "+ Enrollment.get_Sage() + "| Student ID: "+ Enrollment.get_studentid());
			System.out.println("\n--------------------------------------");
		}

		/*
**************** TRYING TO ORGANIZE COURSE BY NAME THEN BY STUDENT NAME.
 * 
		int[] Enrollmentarray = new int[retrieveEnrollment.size()];
		for (int i = 0; i < retrieveEnrollment.size(); i++) {
			Enrollment Enrollment= (Enrollment) retrieveEnrollment.get(i);
			Enrollmentarray[i] = Enrollment.get_CourseID();
			}// closing FOR loop
		
		
		for (int i = 0; i < Enrollmentarray.length; i++) {
			int replacementCourseID;
			if(Enrollmentarray[i]>Enrollmentarray[i+1])
			{
				replacementCourseID =Enrollmentarray[i];
				Enrollmentarray[i] = Enrollmentarray[i+1];
				Enrollmentarray[i+1] = replacementCourseID;
			}
			
		}
		for (int i = 0; i < retrieveEnrollment.size(); i++) {
			Enrollment Enrollment= (Enrollment) retrieveEnrollment.get(i);
			for (int j = 0; j < Enrollmentarray.length; j++)
			{
				if(Enrollmentarray[j]==Enrollment.get_CourseID());
			}
			
		}
		
		*/
		
		
		
		 System.out.println("\nPress enter to continue.");
	        new Scanner(System.in).nextLine();
			
	}
		
// Display Student
public static void display_Student() {
		
		ArrayList<Object> retrievestudent = openBinary.get_studentinfo();
		
		System.out.println("\nDisplaying Students Information");
		System.out.println("\n--------------------------------------");
		
		
		for (int i = 0; i < retrievestudent.size(); i++) {
			student student= (student) retrievestudent.get(i);
			System.out.println("\nname:"+ student.get_name() + " "+student.get_lastname());
			System.out.println("\n|age: "+ student.get_age() + "| Student ID: "+ student.get_studentID());
			System.out.println("\n--------------------------------------");
		}
		
		System.out.println("\nPress enter to continue.");
		new Scanner(System.in).nextLine();
		
	}
	
	
// DISPLAYING GRADE
	@SuppressWarnings("unused")
public static void display_Grade() {
		
		Grade displaygrade = new Grade();
		student displaystudent = new student();
		Enrollment displaycourse = new Enrollment();
		boolean viewgrade = false;
		// NEED TO GET STUDENT ID
		
	int StudID = 1;//NEEDS TO BE DELETED*********************************************************************************
	
	student Stud = new student();   // display this Student	
	ArrayList<Object>  GradeObj = openBinary.get_Gradeinfo();
	ArrayList<Object> retrieveEnrollment = openBinary.get_Enrollmentinfo();
	
		
		
		for (int i = 0; i < retrieveEnrollment.size(); i++) {
			
			displaycourse =(Enrollment) retrieveEnrollment.get(i);
			
			/*
			 * WE EXTRACT Enrollment > we get student id. 
			 */
			
			if(StudID ==displaycourse.get_studentid())  // FOUND STUDENT ID >> GOING TO FIND COURSE
			{
			
				for (int j = 0; j < GradeObj.size(); j++) {
					displaygrade = (Grade) GradeObj.get(j);
					
					
					
					if(StudID==displaygrade.get_studentID())
					{
						viewgrade = true;
						Stud = openBinary.return_StudentbyID(StudID);
						
						System.out.println("\n_________________________________________________________________________");
						System.out.println("\n_________________________________________________________________________");
						System.out.println("\n\t\tDisplaying Grade");

						System.out.println("\nName:"+ Stud.get_name()+" " + Stud.get_lastname() ) ;
						System.out.println("Student ID: " + Stud.get_studentID());
						System.out.println("\n--------------------------------------------------");

						System.out.println("\n Course:"+ displaycourse.get_courseinformation().get_coursename()+ " | Course ID:"+ displaycourse.get_courseinformation().get_courseID());
						System.out.println("\nSemester: "+ displaycourse.get_courseinformation().get_semester()+"\t | Year:" + displaycourse.get_courseinformation().get_year()+" | Grade:"+ displaygrade.get_grade());

						System.out.println("\n_________________________________________________________________________");
						System.out.println("\n_________________________________________________________________________");

					}
					
				}
				
				
				
				
			}
		}
		
		if(viewgrade == false)
		{
			System.out.println("\nStudent not enrolled in any class");

		}
		
		System.out.println("\nPress enter to continue.");
		new Scanner(System.in).nextLine();
		
	}
	
	
	
	
}
