package updatefinal;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Enrollment implements Serializable, Comparable<Enrollment> {
private	int studentID;
private	int CourseID;
private	int year;
private	int age;
private	String semester;
private	String Coursename;
private	String Sname;
private	String slastname;
private	String Room;
private	String day;
private int EnrollID;
private String Grades= null;

    public int getEnrollID() {
        return EnrollID;
    }

    public void setEnrollID(int EnrollID) {
        this.EnrollID = EnrollID;
    }

	
student stud = new student();;
courseInformation Crs= new courseInformation();
	
	public Enrollment() {
		
	}
        
        public Enrollment(int StudID, int CourseID) {
		this.studentID = StudID;
                this.CourseID= CourseID;
                
	}
        
        
        
                public Enrollment(int EnrollID,int StudID, int CourseID) {
		this.studentID = StudID;
                this.CourseID= CourseID;
                this.EnrollID = EnrollID;
                
	}
        
	public  Enrollment(student students, courseInformation courses) {
		this.studentID= students.get_studentID();
		this.CourseID= courses.get_courseID();
		this.year=courses.get_year();
		this.semester = courses.get_semester();
		this.Coursename = courses.get_coursename();
		this.Sname = students.get_name();
		this.slastname = students.get_lastname();
		this.age = students.get_age();
		this.stud = students;
		this.Crs = courses;
		this.Room = courses.get_roombld();
		this.day = courses.get_day();
		
		this.stud= students;
		this.Crs = courses;
		
	};
	
	public void SaveStudentedit(student stud) {
		Sname= stud.get_name();
		slastname = stud.get_lastname();
		age = stud.get_age();
		
		
		
	}
	
	
	public void SaveCourseEdit(courseInformation cour)
	{
		Coursename=cour.get_coursename();
		semester= cour.get_semester();
		year = cour.get_year();
		Room = cour.get_roombld();
		day= cour.get_day();
		
				
		
	}
	
	public int get_Sage() {
		return this.age;
	}
	
	
	public String get_Fullname() {
		String Fullname = this.Sname+ " "+ this.slastname;
		return Fullname;
		
	}
	
        public String get_GRADES(){
            return this.Grades;
        }
	public String get_sname() {
		return this.Sname;
	}
	
	public String get_slastname() {
		return this.slastname;
	}
	
	
	public int get_studentid() {
		return this.studentID;

	}
	
	public String get_room() {
		return this.Room;
	}
	
	public int get_CourseID() {
		return this.CourseID;
	}
	
	public int get_year() {
		return this.year;
	}
	
	public String get_semester() {
		return this.semester;
	}
	


	
	
	public String get_day(){
		return this.day;
	}
	public String get_coursename() {
		return this.Coursename;
	}
	
	public student get_Student() {
		return stud;
		
	}
	

	public void set_Grades(String Grade){
            this.Grades = Grade;
        }

	public courseInformation get_courseinformation() {
		return Crs;
	}

	
	public static void create_Enrollment() {
		boolean PassEnrollment = false;
		
		//ln("\n/***************************************/");
		System.out.println("\n*\t\tCreating Enrollment\t\t*");
		System.out.println("\n/***************************************/");
		
		student stud = student.check_student();   // Getting Student
		 
		System.out.println("\n-------- Available Courses----------\n");
		display.display_courses(); // Available Courses
		
		courseInformation course = courseInformation.check_course(); // Getting Course
		 
		 
		 
		 
		 PassEnrollment = openBinary.check_Enrollment(stud.get_studentID(), course.get_courseID());
		if(PassEnrollment==false) 
		{ 
			 
			Enrollment Ecomplete = Confirm_Enrollment(stud, course);
			saveBinary.save_enrollment(Ecomplete);
		}
		else
		{
			System.out.println("Student ID: "+stud.get_studentID()+ " | Student name:"+stud.get_name()+" "+stud.get_lastname() 
					+"\n Already Enrolled in  " + " class:" + course.get_coursename()+ " |Course ID:"+ course.get_courseID());
			System.out.println("\n\nPress enter to continue.");
			new Scanner(System.in).nextLine();
		}
		
	}

	
	//edit enrollmetn info
	public static ArrayList<Object> Edit_EnrollmentInfo() {   // RETURNS ARRAY LIST because Student is enroll in more than 1 class.
		
		int ValidId = 0;
		boolean ConfirmId = true;
		ArrayList<Object> Enrollmentconfirm = new ArrayList<Object>();
		try 
		{
			while(ConfirmId == true) {
				
				System.out.println("Enter student ID?");
				Scanner keyboard = new Scanner(System.in);
				ValidId= keyboard.nextInt();
				keyboard.nextLine();
				
				if (ValidId<0)
				{
					System.out.println("Error: Invalid number. Try again");
					 System.out.println("Press enter to continue.");
				        new Scanner(System.in).nextLine();
				}
				
				else
				{
					try {
						ArrayList<Object> stud = openBinary.get_studentinfo();
						for (int i =0; i < stud.size(); i++) {
							Enrollment studentcheck = (Enrollment)stud.get(i);
							
							if (ValidId == studentcheck.get_studentid())
							{
								System.out.println("Student Found. ");
								ConfirmId = false;
								Enrollmentconfirm.add(studentcheck);     // RETURNING STUDENT pos.
								System.out.println("Press enter to continue.");
								new Scanner(System.in).nextLine();
								
							}

						
						}
					}catch (Exception e) {
						e.getSuppressed();
					}// for
				}; // else
			
				
				if(ConfirmId==true) {
					System.out.println("Student ID not found. Try again");
				}
				
			}; // WHILE loop
		
			
			
			
		}// try catch
		catch (Exception e) {
			e.getSuppressed();
		
		}
		
		return Enrollmentconfirm;

		
	}



	/******************************************************************/
	/********************************** EDIT METHOD *******************/
	/******************************************************************/

	
	// VALID GRADE
public static boolean valid_grade(char checkgrade)    // checks if enter Grade is valid
	{
		boolean validgrade = false;
		
		
		if(!((checkgrade=='A')||(checkgrade=='B'||(checkgrade=='C')|| (checkgrade=='D')||(checkgrade=='F') )))
		{
				System.out.println("Invalid Grade. Try again");
				validgrade = true;
		}
		
		return validgrade;
		
		
	}
	
	
	

	// EDIT ENROLLMENT
	public static void edit_Enrollment() {
	// get student ID > open enrollment file >  ask for class to be deleted. (make exit possible) > loop and if student ID and Course ID match. don't save back to file.

		int editchoice;
		boolean validEdit=false;
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Object> editEnrollmentobj = new ArrayList<Object>();
		editEnrollmentobj = Enrollment.Edit_EnrollmentInfo();//Getting  Int
		Enrollment editEnrollment = new Enrollment(); 
		
		for (int i = 0; i < editEnrollmentobj.size(); i++) {
			editEnrollment = (Enrollment) editEnrollmentobj.get(i);
			
			System.out.println("["+(i+1)+"]" );
			System.out.println("\nCourse ID: "+ editEnrollment.get_CourseID() + "||\tCourse name:"+ editEnrollment.get_coursename());
			System.out.println("\nSemester: "+editEnrollment.get_semester() + " || Room: "+ editEnrollment.get_courseinformation().get_roombld());
			System.out.println("\nYear: "+editEnrollment.get_year()+"  ||\tDays: "+ editEnrollment.get_courseinformation().get_day());
			System.out.println("\n---------------------------------------------------------");
			
			}	
		
		boolean editcourse=false;
		int option;
		do {
			editcourse=false;
			Scanner key = new Scanner(System.in);
			
			System.out.println("\nEnter Option to Withdraw from Course");
			option = key.nextInt();
			key.nextLine();
			
			if((option<=0)|| (option>(editEnrollmentobj.size())))
			{
				System.out.println("Invalid Option.");
				editcourse=true;
			}
			
		} while (editcourse==true);
			
			
	editEnrollment = (Enrollment) editEnrollmentobj.get(option);

	System.out.println("\nCourse ID: "+ editEnrollment.get_CourseID() + "||\tCourse name:"+ editEnrollment.get_coursename());
	System.out.println("\nSemester: "+editEnrollment.get_semester() + " || Room: "+ editEnrollment.get_courseinformation().get_roombld());
	System.out.println("\nYear: "+editEnrollment.get_year()+"  ||\tDays: "+ editEnrollment.get_courseinformation().get_day());

		do {
			validEdit=false;
		System.out.println("\n\nWhat would you like to edit? \n [1]Course name  [2] Semester  [3]Year \n\t\t [4]Room [5]Days  ");
		editchoice = keyboard.nextInt();
		keyboard.nextLine();
		
		if((editchoice <=0)|| (editchoice>5)) {
			System.out.println("Invalid Choice. Try again");
			validEdit = true;
		}
		
		}while (validEdit == true);
		

		switch(editchoice)
		{
		case 1:{
			System.out.println("Enter new Course name");
			String name;
				name = keyboard.nextLine();
			courseInformation course = new courseInformation(editEnrollment.get_CourseID(), name, editEnrollment.get_courseinformation().get_roombld(), editEnrollment.get_courseinformation().get_day(), editEnrollment.get_semester(), editEnrollment.get_year());
			saveBinary.save_EditCourse(course);
				break;
		}
		case 2:{
			System.out.println("Enter New Semester");
			String name;
				name = keyboard.nextLine();
				courseInformation course = new courseInformation(editEnrollment.get_CourseID(), editEnrollment.get_coursename(), editEnrollment.get_courseinformation().get_roombld(), editEnrollment.get_courseinformation().get_day(), name, editEnrollment.get_year());
				saveBinary.save_EditCourse(course);
				break;
				
		}
		case 3:{
			System.out.println("Enter new Year");
			int year;
				year = keyboard.nextInt();  
				keyboard.nextLine();
				courseInformation course = new courseInformation(editEnrollment.get_CourseID(), editEnrollment.get_coursename(), editEnrollment.get_courseinformation().get_roombld(), editEnrollment.get_courseinformation().get_day(), editEnrollment.get_semester(), year);
				saveBinary.save_EditCourse(course);
				break;

		}
		case 4:{
			System.out.println("Enter new Room");
			String name;
			name = keyboard.nextLine();
			courseInformation course = new courseInformation(editEnrollment.get_CourseID(), editEnrollment.get_coursename(), name, editEnrollment.get_courseinformation().get_day(), editEnrollment.get_semester(), editEnrollment.get_year());
			saveBinary.save_EditCourse(course);
			break;
			
			
		}
		case 5: {
			System.out.println("Enter new Day");
			String name;
			name = keyboard.nextLine();
			courseInformation course = new courseInformation(editEnrollment.get_CourseID(), editEnrollment.get_coursename(), editEnrollment.get_courseinformation().get_roombld(), name, editEnrollment.get_semester(), editEnrollment.get_year());
			saveBinary.save_EditCourse(course);
			break;
		}
		
		
		}
		
		System.out.println("Course Updated ");
		System.out.println("\nPress enter to continue.");
		new Scanner(System.in).nextLine();
	}

	
	//MAKING SURE STUDENT WANT TO ENROLL IN CLASS
@SuppressWarnings("resource")
private static Enrollment Confirm_Enrollment(student students, courseInformation courses) {
		Enrollment Ecomplete = null;
		System.out.println("\n_____________________________________________________________________");
		System.out.println("\n_____________________________________________________________________");

		System.out.println("\n Student Information"+ "\n-----------------------------------------------\n");

		System.out.println("Name:" + students.get_name()+" "+students.get_lastname()+"\nStudent ID:"+ students.get_studentID());
				System.out.println("Age: "+ students.get_age());
				
		System.out.println("\n-----------------------------------------------\n");
		// DISPLAYING COURSE being added
		System.out.println("\n Course being Added"+ "\n-----------------------------------------------\n");
		System.out.println( "\nCourse Name: "+ courses.coursename +"\nCourse ID: "+ courses.CourseId + 
				"\nSemester:"+courses.get_semester() + "\nClass Meets: "+ courses.day+ "\nRoom: "+ courses.get_roombld() );
		
		
		
		String EnrollConfirm ;
		Scanner keyboard= new Scanner(System.in);
		boolean acceptenroll=true;
		String answer ;
		do {
			acceptenroll = true;
		System.out.println("\nWould you like to enroll to this course? (Y/N)");
		EnrollConfirm= keyboard.nextLine();
		EnrollConfirm.trim();
		 answer = EnrollConfirm.toUpperCase(); 
		
		
			if(!(answer.equals("Y")||answer.equals("YES") || answer.equals("N") || answer.equals("NO"))) {
				acceptenroll=false;
				System.out.println("Invalid Choice");
			}
			
			
		}while(acceptenroll==false);
			
			
		if(answer.equals("YES")|| answer.equals("Y"))
		{
			Ecomplete = new Enrollment(students, courses);
			System.out.println("\nClass has been added");
			 System.out.println("\nPress enter to continue.");
		        new Scanner(System.in).nextLine();
		}
		else if (answer.equals("NO") || answer.equals("N")) {
			System.out.println("\nClass was not added");
			 System.out.println("\nPress enter to continue.");
		        new Scanner(System.in).nextLine();
		}
		
		
		
		
		return Ecomplete;
	}

    @Override
    public int compareTo(Enrollment o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  static MyGenericList<Enrollment> Get_EnrollmentInfo(){
        
     MyGenericList<Enrollment> Enrollmentdata = new MyGenericList<>();
		
		try
		{
			FileInputStream FOS = new FileInputStream("Enrollmentinfo.dat");
			
			
			try {
				ObjectInputStream ReadFile = new ObjectInputStream(FOS);
				
			
				
				Enrollmentdata = (MyGenericList<Enrollment>)ReadFile.readObject();
				
				
				FOS.close();
				ReadFile.close();
				
				
				

					
			}catch (ClassNotFoundException c) {
				//c.getSuppressed();
				c.printStackTrace();
			
                                }
		}catch (IOException i) {
			//i.getSuppressed();
			i.printStackTrace();
		}
		
		
    return 	Enrollmentdata;
}
   
public static ArrayList<Enrollment> Get_StudentListDB(int CID){
    ArrayList<Enrollment> EList = new ArrayList();
    
     try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
                ResultSet rs = s.executeQuery("SELECT * From Enrollment\n"  +"Where CourseID= '"+CID+ "'");
          
           while(rs.next())
           {    int CID11 =rs.getInt("CourseID");
                int SID11 = rs.getInt("StudentID");
                String Grade = rs.getString("Grade");
                
                
               Enrollment Enroll = Enrollment.Get_EnrollmentDB(CID11, SID11);
               
                if(!(Grade==null))
                    {
                        Enroll.set_Grades(Grade);
                    }
                
                
               EList.add(Enroll);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
    
    
    return EList;
} 

public static ArrayList<courseInformation> Get_EnrollListDB(String Departmentname){
    ArrayList<courseInformation> EList = new ArrayList();
    
     try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
                ResultSet rs = s.executeQuery("SELECT * From Courses\n"  +"Where  Department='"+Departmentname+ "';");
          
           while(rs.next())
           {    int CID11 =rs.getInt("CourseID");
                
                String CourseName = rs.getString("Name");
                
                
               courseInformation Course = courseInformation.GetCourseDB(CID11);
               
        
                
                
               EList.add(Course);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
    
    
    return EList;
} 

public static ArrayList<Enrollment> Get_EditEnroll_STudentList(int SID){
    ArrayList<Enrollment> EList = new ArrayList();
    boolean pass = false;
    Connection conn = null;
              

    
     try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
                ResultSet rs = s.executeQuery("SELECT * From Enrollment\n"  +"Where StudentID= '"+SID+ "'");
          
           while(rs.next())
           {    int EID = rs.getInt("EnrollmentID");
               int CID11 =rs.getInt("CourseID");
                int SID11 = rs.getInt("StudentID");
                String Grade = rs.getString("Grade");
                
               
                System.out.println(EID+" ------"+ EID +"------"+EID);
               Enrollment Enroll = Enrollment.Get_EnrollmentDB(CID11, SID11);
               Enroll.setEnrollID(EID);
               
                if(!(Grade==null))
                    {
                        Enroll.set_Grades(Grade);
                        
                    }
                if(EList.isEmpty())
                {
                    EList.add(Enroll);
                    //ln("FIRST ! ");
                }
                else{
                     for(int x=0; x<EList.size() ; x++)
                      {
                            int EIDCheck= EList.get(x).getEnrollID();
                           
                            if(EIDCheck == EID)
                              {
                                   pass = true;
                                 
                              }
  
                        }
               
                     
                        if(pass==true)
                        {
                         //ln("Enroll already");
                         pass=false;
                        }
                        else
                        {
                            EList.add(Enroll);
                            pass = false;
                        }
                    }
               
              
           }
          
           
          
           
              conn.close();  
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            

     //ln("OUT OUT OUT");
    return EList;
} 
    
public static boolean New_Enrollment_Boolean(int CID, int SID){
    boolean NewEnroll = true;
    
    
      try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
          
                ResultSet rs = s.executeQuery("SELECT * FROM Enrollment\n"  +"Where CourseID="+CID +" AND StudentID="+SID);
          
                
               
                
           while(rs.next())
           {
               int CID1 = rs.getInt(2);
             int SID1 = rs.getInt(3);
              
                //ln("****ALMOST*****");
             
              if(courseInformation.GetCourseDB_Boolean(CID1) && student.GetStudentDB_Boolean(SID1))
              {
                  NewEnroll = false;
              }
            
             
           }
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    return NewEnroll;
}    
    
    
public static boolean Enrollment_Drop_Boolean(int SID){
    boolean NewEnroll = false;
    
    
      try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
          
                ResultSet rs = s.executeQuery("SELECT * FROM Enrollment\n"  +"Where "+" StudentID="+SID);
          
                
               
                
           while(rs.next())
           {
               int CID1 = rs.getInt(2);
             int SID1 = rs.getInt(3);
              
                //ln("****ALMOST*****");
             
              
                if(SID1==SID){
                    NewEnroll = true;
                }
             
           }
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
            NewEnroll = false;
            
        }
    return NewEnroll;
} 


public static boolean Check_StudID_Enrollment(int SID){
    boolean NewEnroll = false;
    
    
      try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
          
                ResultSet rs = s.executeQuery("SELECT * FROM Enrollment\n"  +"Where "+" StudentID="+SID);
          
                
               
                
           while(rs.next())
           {
               int CID1 = rs.getInt(2);
             int SID1 = rs.getInt(3);
              
                //ln("****ALMOST*****");
             
              
                if(SID1==SID){
                    NewEnroll = true;
                }
             
           }
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
            NewEnroll = false;
            
        }
    return NewEnroll;
} 

public static void Get_DropEnrollment(Enrollment Enroll){
    boolean NewEnroll = false;
    
    
      try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
          
                 PreparedStatement Pst = conn.prepareStatement("Delete From Enrollment\n"  +"Where "+" CourseID="+Enroll.get_CourseID()+" AND StudentID="+ Enroll.get_studentid());
                
                 Pst.execute();
                 //ln("DELETING+ ");
                
               
                
           
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
            NewEnroll = false;
            
        }

}   

public static ArrayList<Enrollment> Get_StudDrop_List(int SID){
    boolean NewEnroll = false;
    ArrayList Enrollist = new ArrayList();
    
      try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
          
                ResultSet rs = s.executeQuery("SELECT * FROM Enrollment\n"  +"Where "+" StudentID="+SID);
          
                
               
                
           while(rs.next())
           {
               int EnrollID = rs.getInt(0);
             int CourseID = rs.getInt(1);
             int StudentID= rs.getInt(2);
             
             Enrollment Enroll = new Enrollment(EnrollID,StudentID, CourseID);
             
             Enrollist.add(Enroll);
                     
              
               
             
              
             
           }
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
            NewEnroll = false;
            
        }
    return Enrollist;
}    


    public static void Save_EnrollmentDB(Enrollment Enroll){
   
        try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
           
           PreparedStatement Pst = conn.prepareStatement("INSERT INTO Enrollment(CourseID, StudentID)\n "+ " VALUES( '"+Enroll.get_courseinformation().get_courseID()+"',"+"'"+Enroll.get_Student().get_studentID() +"');");

           Pst.execute();
         
           //ln("SAVED");
             Pst.clearBatch();
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}
    
    
    
      public static void Save_Grade_EnrollmentDB(Enrollment Enroll){
   
        try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
           
           PreparedStatement Pst = conn.prepareStatement("UPDATE Enrollment\n "+ "SET Grade ='"+Enroll.get_GRADES()+"'" +" \n WHERE StudentID="+Enroll.get_Student().get_studentID() +" AND CourseID="+Enroll.get_courseinformation().get_courseID()+" ;" ) ;
           
           

           Pst.execute();
         
        
             Pst.clearBatch();
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}
    
 public static Enrollment Get_EnrollmentDB(int CID, int SID){
  
    Enrollment Enroll = null;
    
    
      try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
          
                ResultSet rs = s.executeQuery("SELECT * FROM Enrollment\n"  +"Where CourseID="+CID +" AND StudentID="+SID);
          
                
               
                
           while(rs.next())
           {
               int EID1 = rs.getInt(1);
               int CID1 = rs.getInt(2);
             int SID1 = rs.getInt(3);
             
               String Grade = rs.getString(4);
               
              
                //ln("****ALMOST*****");
             
              if(courseInformation.GetCourseDB_Boolean(CID1) && student.GetStudentDB_Boolean(SID1))
              {
                  Enroll = new Enrollment(student.GetStudentDB(SID),courseInformation.GetCourseDB(CID));
                  
                    if(!(Grade==null))
                    {
                        Enroll.set_Grades(Grade);
                    }
              }
            
             
           }
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    return Enroll;
}     
    
    
    
  public String toString(){
     String Str = "";
      
     return Str; 
  }  
    
}
