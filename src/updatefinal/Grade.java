package updatefinal;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Grade implements Serializable {
		int studentID;
		int CourseID;
		char grade;
		
		public Grade(char grade, int courseID , int studID) {
			this.grade = grade;
			studentID = studID;
			CourseID= courseID;
			
		}
		
		
	/*	public Grade(char grade, Enrollment enroll) {
			student Gstudent = new student(enroll.get_sname(),enroll.get_slastname(), enroll.get_Sage(), enroll.get_studentid());
			this.grade = grade;
			courseInformation Gcourse = new courseInformation(enroll.get_CourseID(), enroll.get_coursename());
				
		}
		*/
		
public Grade() {
			// TODO Auto-generated constructor stub
		}

// SET GRADE
public static void set_grade() {
			
			int Cid=0; // user input course ID
			int Sid; // STUDENT ID
			char Gradess; // student grade
			boolean in=false;
			boolean passgrade = false;
			Enrollment enroll = new Enrollment();
			ArrayList<Object> FoundEnroll = new ArrayList<Object>();
			courseInformation FoundCourse = new courseInformation();
			student FoundStudent = new student();
			
			
			ArrayList<Object> getenroll = openBinary.get_Enrollmentinfo();
			
			ArrayList<Object> GetCourse = openBinary.get_coursefile();
			
			ArrayList<Object> GetStudent = openBinary.get_studentinfo();
			
			
			boolean pass = false;
				//ln("\n________________________________________________");
				//ln("\n________________________________________________\n\n");

				//ln("\t\tAssign grades.");
			while(pass==false) {
				
				
				try {
					//ln("\nWhat is the course ID?");
					Scanner keyboard = new Scanner(System.in);
					
					Cid = keyboard.nextInt();
					keyboard.nextLine();

					
					// Looking for Course ID
							try {
								
								for (int i = 0; i < getenroll.size(); i++) {
									enroll =(Enrollment)getenroll.get(i);
									
									
									// Get Course Info   // in case it doesn't have any Enroll students
									if(Cid == enroll.get_CourseID()) 
									{
												for (int j = 0; j < GetCourse.size(); j++) {
												courseInformation	searchcourse = new courseInformation();
												searchcourse= (courseInformation) GetCourse.get(j);
														if(Cid == searchcourse.get_courseID())
														{
															FoundCourse= searchcourse;
														};
											}
										
										
										
										// Continue Enroll 
										pass = true;
										FoundEnroll.add(enroll);
											if(in==false)
											{
												in = true;
											//ln("\n______________________________________________________________");
											//ln("\n______________________________________________________________");

											//ln("Course name:"+enroll.get_coursename()+ "Course ID: "+ enroll.get_CourseID());
											//ln("\nSemester: "+ enroll.get_semester()+ " | Year:"+ enroll.get_year()+ "| Room:"+enroll.get_room()+ "| Day:"+ enroll.get_day());
											
											//ln("\n______________________________________________________________");
											//ln("\nStudent enroll on this class\n");
											
											}
										
											//ln("\nname: "+enroll.get_sname()+ " " + enroll.get_slastname());
											////ln("Student ID: " + enroll.studentID+ " | Age: "+ enroll.get_Sage()) ;
											//ln("\n------------------------");
									}
								}
								}catch (Exception e) {
									e.getSuppressed();
								}
							
					}catch (Exception e) {
						e.getSuppressed();
					
				} // try. what course

							
							if(in==true) {  // if Course was found do this. GO FOR STUDENT INFO
								
								try {
										boolean studentfound = false;
										Scanner keyboard = new Scanner(System.in);
									
									while(studentfound == false)
									{
									//ln("\n\nEnter Student ID to Grade:");
									Sid = keyboard.nextInt();
									keyboard.nextLine();
									
										for (int j = 0; j < FoundEnroll.size(); j++) {
											enroll= (Enrollment) FoundEnroll.get(j);
											
											if (Sid == enroll.get_studentid()) {
												studentfound=true;
												//ln("--------------------------------------------------------------------");
												//ln("--------------------------------------------------------------------");

												//ln("\n\n name: "+ enroll.get_sname()+" "+ enroll.get_slastname());
												//ln("Student ID:"+ enroll.get_studentid() + "| Age: "+ enroll.get_Sage());
												
												do {
													 passgrade = false;
													//ln("\n\nEnter student grade:");
													Gradess = keyboard.next(".").charAt(0);
													
													Gradess = Character.toUpperCase(Gradess);
													
													passgrade = Grade.valid_grade(Gradess); // Checking if Grade is valid
												}while (passgrade == true);
												
												
												
												Grade grade  = new Grade(Gradess, Cid, Sid );  // CREATING Grade Obj.
												
												boolean finalsave = Grade.check_before_grade(grade);   // Checking if class obj exist already.
												
												if (finalsave == false)
												{
													// save only if grade obj is new.
													saveBinary.save_Grade(grade);
													
													//ln("Grade has been posted");
												}
												else {
													//ln("\nStudent already has a grade. To change Grade go to Edit Menu.");
												}
												
												
												
											}// END IF student id.
											
										
										} 
										if(studentfound==false)
										{
											//ln("Error:Student not found. try again");
											}// end while loop	
											
										}// end of FOR loop
										
										
									}// end of TRY
								catch (Exception e) {
								
										
										e.getSuppressed();
									}
									
									
									
									//ln("\nPress enter to continue.");
									new Scanner(System.in).nextLine();
									
								}
								else
								{
									
									for (int j = 0; j < GetCourse.size(); j++) 
									{
										courseInformation	searchcourse = new courseInformation();
										searchcourse= (courseInformation) GetCourse.get(j);
												if(Cid == searchcourse.get_courseID())
												{
													FoundCourse= searchcourse;
												};
									}
										
									//ln("\n______________________________________________________________");
									//ln("\n\t\t** No Student enroll on this class**\n");

									//ln("Course name:"+FoundCourse.get_coursename()+ "Course ID: "+ FoundCourse.get_courseID());
									//ln("\nSemester: "+ FoundCourse.get_semester()+ " | Year:"+ FoundCourse.get_year()+ "| Room:"+FoundCourse.get_roombld()+ "| Day:"+ FoundCourse.get_day());
									
									//ln("\n______________________________________________________________");

									///ln("\nPress enter to continue.");
									new Scanner(System.in).nextLine();
											
								
								}
								
			}
								
						
						
	}// set_grade ends
			
				
					
public int get_studentID(){
		return studentID;
		
	}
	
public char get_grade() {
		return grade;
	}

public int get_CourseID() {
		return CourseID;
	}
	
public String toString() {
		String r =("Student Grade: " +grade);
				return r;
	}
	
	
public static void Edit_Grade() {
		
		int Cid=0; // user input course ID
		int Sid; // STUDENT ID
		char Gradess; // student grade
		boolean in=false;
		boolean passgrade = false;
		Enrollment enroll = new Enrollment();
		ArrayList<Object> FoundEnroll = new ArrayList<Object>();
		courseInformation FoundCourse = new courseInformation();
		Grade displaygrade = new Grade();
		
		
		
		boolean pass = false;
			//ln("\n________________________________________________");
			//ln("\n________________________________________________\n\n");

//			/ln("\t\tEditing Student grade.");
		while(pass==false) {
			try {
				///ln("\nEnter course ID?");
				Scanner keyboard = new Scanner(System.in);
				
				Cid = keyboard.nextInt();
				keyboard.nextLine();
				

				ArrayList<Object> getenroll = openBinary.get_Enrollmentinfo();
				
				ArrayList<Object> GetCourse = openBinary.get_coursefile();
				
				ArrayList<Object>  GradeObj = openBinary.get_Gradeinfo();

				
				

				
				// Looking for Course ID
						try {
							
							for (int i = 0; i < getenroll.size(); i++) {
								enroll =(Enrollment)getenroll.get(i);
								
								//(If Course ID enter equals Enrollment ID from file go in.
								if(Cid == enroll.get_CourseID()) {
											// Getting Course Information
											for (int j = 0; j < GetCourse.size(); j++)
											{
											courseInformation	searchcourse = new courseInformation();
											searchcourse= (courseInformation) GetCourse.get(j);
													if(Cid == searchcourse.get_courseID())
													{
														FoundCourse= searchcourse;
													};
											}
											
									
									
									
									
									// Continue Enroll 
									pass = true;
									FoundEnroll.add(enroll);
										if(in==false)
										{
											in = true;
											//ln("\n______________________________________________________________");
											//ln("\n______________________________________________________________");

											//ln("Course name:"+enroll.get_coursename()+ "| Course ID: "+ enroll.get_CourseID());
											//ln("\nSemester: "+ enroll.get_semester()+ " | Year:"+ enroll.get_year()+ "| Room:"+enroll.get_room()+ "| Day:"+ enroll.get_day());
											
											//ln("\n______________________________________________________________");
											//ln("\nStudent enroll on this class\n");
											
											for (int j = 0; j < GradeObj.size(); j++) {
												displaygrade = (Grade) GradeObj.get(j);
												
												if(displaygrade.get_studentID() == enroll.get_studentid() && displaygrade.get_CourseID() == enroll.get_CourseID()) {
													displaygrade =(Grade) GradeObj.get(j);
													
													//ln("\nname: "+enroll.get_sname()+ " " + enroll.get_slastname());
													//ln("Student ID: " + enroll.get_studentid()+ " | Age: "+ enroll.get_Sage()) ;
													//ln("Grade: "+ displaygrade.get_grade() );
													//ln("\n------------------------");
				
													
													}
												
													
												}
												
											}
											

								}
							}
							}catch (Exception e) {
								e.getSuppressed();
							}
						
				}catch (Exception e) {
					e.getSuppressed();
				
			} // try. what course

						
						if(in==true) {  // if Course was found do this. GO FOR STUDENT INFO
							
							try {
									boolean studentfound = false;
									Scanner keyboard = new Scanner(System.in);
								
								while(studentfound == false)
								{
								//ln("\n\nEnter Student ID to edit grade:");
								Sid = keyboard.nextInt();
								keyboard.nextLine();
								
									for (int j = 0; j < FoundEnroll.size(); j++) {
										enroll= (Enrollment) FoundEnroll.get(j);
										
										if (Sid == enroll.get_studentid()) 
										{
											studentfound=true;
											//ln("--------------------------------------------------------------------");
											//ln("--------------------------------------------------------------------");

											//ln("\n\n name: "+ enroll.get_sname()+" "+ enroll.get_slastname());
											//ln("Student ID:"+ enroll.get_studentid() + "| Age: "+ enroll.get_Sage());
											
											do {
												 passgrade = false;
												//ln("\n\nEnter student grade:");
												Gradess = keyboard.next(".").charAt(0);
												
												Gradess = Character.toUpperCase(Gradess);
												
												passgrade = Grade.valid_grade(Gradess); // Checking if Grade is valid
											}while (passgrade == true);
											
											
											
											Grade grade  = new Grade(Gradess, Cid, Sid );
											saveBinary.save_EditGrade(grade);
											
										
												//ln("Grade has been change");
											
											
											
											
										}// END IF student id.
										
									
									}   // end FOR loop statement
									
									if(studentfound==false)
									{
										//ln("Error:Student not found. try again");
										}// end while loop	
										
									}// end of FOR loop
									
									
								}// end of TRY
							catch (Exception e) {
							
									
									e.getSuppressed();
								}
								
								
								
								//ln("\nPress enter to continue.");
								new Scanner(System.in).nextLine();
								
							}  // IF in == true (END)
							else
							{
								//ln("\n course not found");
								//ln("\nPress enter to continue.");
								new Scanner(System.in).nextLine();
										
							
							}
								
							}	
					
					
					}// set_grade ends
			
	
public static boolean valid_grade(char checkgrade)    // checks if enter Grade is valid
	{
		boolean validgrade = false;
		
		
		if(!((checkgrade=='A')||(checkgrade=='B'||(checkgrade=='C')|| (checkgrade=='D')||(checkgrade=='F') )))
		{
				//ln("Invalid Grade. Try again");
				validgrade = true;
		}
		
		return validgrade;
		
		
	}
	
	
	
@SuppressWarnings({ "unused", "resource" })
public static boolean check_before_grade(Grade updatedGrade) {
	boolean Fileconfirm= false;
		try {
			FileInputStream FOS = new FileInputStream("GradeFile.dat");
			ObjectInputStream ReadFile = new ObjectInputStream(FOS);
			
			ArrayList<Object> gradedata = (ArrayList<Object>)ReadFile.readObject();
			for (int i = 0; i < gradedata.size() ; i++) {
				Grade courseID = (Grade) gradedata.get(i);   // creating a Student class object
				if((courseID.get_CourseID()== updatedGrade.get_CourseID()) && (courseID.get_studentID() == updatedGrade.get_studentID()))             // IF File ID equals User input ID. 
				{
					Fileconfirm = true;
					
				}
				
			}
			
			
			
		} catch (Exception e) {
			Fileconfirm = false;
		}
		
	return Fileconfirm;
}	
	
	
	}// class ends
		
		
		
		

