package updatefinal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import static updatefinal.MyGenericList.get_studentinfo;
// THIS IS A CLASS THAT CREATES COURSES.
public class courseInformation implements Serializable, Comparable<courseInformation> {
	public int CourseId;
	public int year;
	public String coursename;
	public String roombuilding;
	public String day;
	public String semester;
	private ArrayList<String> Days ;
        public char Grade;
        private String Grades;
        public String subject;
        private String ProfessorName;
        private String Department;

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getProfessorName() {
        return ProfessorName;
    }

    public void setProfessorName(String ProfessorName) {
        this.ProfessorName = ProfessorName;
    }
	

public  courseInformation(courseInformation course) {
		CourseId = course.get_courseID();
		coursename = course.get_coursename();
		roombuilding = course.get_roombld();
		this.day= course.get_day();
		this.semester = course.get_semester();
		this.year = course.get_year();
	};
public  courseInformation(int CID,String cname, String roombld, ArrayList<String> Day, String semester , int year) {
		CourseId = CID;
		coursename = cname;
		roombuilding = roombld;
		this.Days= Day;
		this.semester = semester;
		this.year = year;

	}
	
	public  courseInformation(int CID,String cname, String roombld, String day, String semester , int year) {
		CourseId = CID;
		coursename = cname;
		roombuilding = roombld;
		this.day= day;
		this.semester = semester;
		this.year = year;

	}
	
               public  courseInformation(int CID, String cname, String Subject,String Semester, int Year,  ArrayList<String> Day,String dept, String pro)
	{
		CourseId=CID;
		coursename = cname;
                this.subject = Subject;
                this.year = Year;
                this.semester = Semester;
                this.Days= Day;
                this.Department = dept;
                this.ProfessorName = pro;
	}
               
               	
               public  courseInformation(int CID, String cname, String Subject,String Semester, int Year)
	{
		CourseId=CID;
		coursename = cname;
                this.subject = Subject;
                this.year = Year;
                this.semester = Semester;
               
	}

	public  courseInformation(int CID, String cname)
	{
		CourseId=CID;
		coursename = cname;
	}
	

        
	public courseInformation() {
		// CONSTRUCTOR WITH NOTHING IN IT
	}
	
        public  courseInformation(int CID, String cname, String Subject)
	{
		CourseId=CID;
		coursename = cname;
                this.subject = Subject;
	}
	
	/***********************************************
	**** 		Getters: Day/semester 		****
	**** 	year/room/coursename			****
	***********************************************/
	public String get_Subject(){
            return this.subject;
        }
	public int get_courseID(){
		return CourseId;
	}
        
        public int get_ID(){
            return CourseId;
        }
	
	public String get_day() {
		return this.day;
	}
        
        public ArrayList<String> Get_Day_ArrayList(){
            ArrayList<String> List = new ArrayList();
/*            String[] Dayz = this.day.split(",");
            
         for(int x=0; x< this.day.length();x++)
         {
             List.add(Dayz[x]);
         }*/
            
           return List; 
        } 

	public String get_semester() {
		return this.semester;
	}
	
	public int get_year() {
		return this.year;
	}
	
	public String get_roombld() {
		return this.roombuilding;
	}

	public String get_coursename() {
		return this.coursename;
	}
        
        public char get_Grade(){
            return this.Grade;
        }
	
	public String get_Day() {
		
		String[] DOS = new String[this.Days.size()];
		
		for (int x =0 ; x<this.Days.size(); x++) {
			DOS[x] = this.Days.get(x); 
		}
		String WDay = String.join(",", DOS);
		
		
		
		return WDay;
		
	}

	/***********************************************
	**** 		SETTERS DAY/ROOM/COURSE 		****
	**** 										****
	***********************************************/
	public void set_Grades(String Grade)
        {
            this.Grades = Grade;
        }
        public void set_Subject(String Sub){
            this.subject = Sub;
        }
        
        public void set_daytime(String day) {
		this.day= day;
	}
        
        public void set_Grade(char Grad){
            this.Grade = Grad;
        }

	public void set_roombuilding(String roombld) {
		roombuilding = roombld;
	}

	public void set_coursename(String cname) {
		coursename = cname;
	}

	public String toString() {
		String Cinfo=(" "+CourseId +" "+ coursename +" "+roombuilding+" "+this.day);
		
		return Cinfo;
		
		
	}
	
	/***********************************************
	 **** 	Valid								****
	 **** 										****
	 ***********************************************/
	
	public static boolean Valid_Year(int year) {
		boolean validyear = false;
		
		if(year <1900|| year >2075) {
		
			validyear= true;
			System.out.println("Invalid Year. Try Again");
			}
		return validyear;
	}

	@SuppressWarnings("unused")
	public static boolean Valid_semester(String semester) {
		boolean validsemester=false;
		String Check;
			Check = semester.toUpperCase();
			if(!(Check.equals("FALL")||Check.equals("WINTER")||Check.equals("SUMMER")||Check.equals("SPRING") ) )
			{
				validsemester=true;
				
				System.out.println("Invalid Semester. ");
			}
		
		
			return validsemester;
	}


	
	public static boolean Valid_Day(String day) {
		boolean validday=false;
		String checkday;
		
		checkday=day.toUpperCase();
		
		if(!(checkday.equals("MONDAY")||checkday.equals("MON")||checkday.equals("TUESDAY")||checkday.equals("TUES")||checkday.equals("WEDNESDAY")||checkday.equals("WED")||checkday.equals("THURSDAY")||checkday.equals("THURS")||checkday.equals("FRIDAY")||checkday.equals("FRI")||checkday.equals("SATURDAY")||checkday.equals("SAT")||checkday.equals("SUNDAY")||checkday.equals("SUN")))
		{
			validday=true;
			System.out.println("Invalid Day");
		}
		
		
		return validday;
	}
	
	
	
	/***********************************************
	**** 		CREATE COURSE					****
	**** 										****
	***********************************************/
public static void create_course() {
int Cid;
String coursename;
String roombld;
courseInformation courses;
String day;
String semester;

int year;
boolean validsemester=false;
boolean pass= false;
boolean validyear=false;
boolean validday=false;

try {
	

Scanner keyboard = new Scanner(System.in);

System.out.println("\n/***************************************/");
System.out.println("\n*\t\tCreating Course\t\t*");
System.out.println("\n/***************************************/");

do {
	System.out.println("\nWhat is the Course ID");
	Cid= keyboard.nextInt();
	keyboard.nextLine();
	
	pass=openBinary.check_CourseID(Cid);      // CHECKING if STUDENT ID can be used
		if (pass == true) {
			System.out.println(Cid+" ID has been used. Use a different ID");
		}
}while (pass==true);


System.out.println("Enter Course Name");
coursename= keyboard.nextLine();

do {
	validsemester=false;
System.out.println("\nEnter Semeter: (Fall,Spring,Winter,Summer)");
semester=keyboard.nextLine();
validsemester=courseInformation.Valid_semester(semester);
}while (validsemester==true);

do {
	validyear=false;
System.out.println("\nEnter Year");
year = keyboard.nextInt();
keyboard.nextLine();
validyear= courseInformation.Valid_Year(year);
}while(validyear==true);

System.out.println("\nEnter Room building:");
roombld = keyboard.nextLine();

do {

validday=false;
System.out.println("\nEnter Days class meets: (Mon,Tues,Wed,Thurs,Fri,Sat,Sun)");
day = keyboard.nextLine();
validday=courseInformation.Valid_Day(day);


}while(validday==true);

courses = new courseInformation(Cid, coursename, roombld, day, semester, year);

saveBinary.save_course(courses);

System.out.println("\nCourse was created");
System.out.println("\nPress enter to continue.");
new Scanner(System.in).nextLine();



} catch (Exception e) {
	
}

}


/***********************************************
**** 		EDIT 	COURSE					****
**** 										****
***********************************************/


public static courseInformation get_Edit_Course(int validcourse) {
	//loca variables
	
	boolean courseConfirm= true;
	courseInformation foundcourse= null;
	
	try {

			
				// IF WE GOT A PROBLEM
				if (validcourse < 0)
				{
					System.out.println("Invalid course ID");
					 System.out.println("Press enter to continue.");
				        new Scanner(System.in).nextLine();
					
				}
				else  // IF ALL IS GOOD
				{

					try {
						ArrayList<Object> cour = openBinary.get_coursefile();
							for (int i = 0; i < cour.size(); i++) 
							{
								courseInformation courseinf = (courseInformation) cour.get(i);
								
								if (validcourse == courseinf.get_courseID()) 
								{
									foundcourse = courseinf;
									courseConfirm = false;
									System.out.println("\nCourse found");
								
									
									break;
									
									
								}
							
							}
						}
						catch (Exception e) {
						e.getSuppressed();
						}
				
					}
				
			 
			
		
		
		
	} catch (Exception e) {
		e.getSuppressed();
	}
	
	return foundcourse;
}
//EDIT COURSE




public static courseInformation get_Edit_Course(String[] Classes) {
	//loca variables
	int validcourse = 0;
	boolean courseConfirm= true;
	courseInformation foundcourse= null;
	


					try {
						ArrayList<Object> cour = openBinary.get_coursefile();
						Classes = new String[cour.size()];
							for (int i = 0; i < cour.size(); i++) 
							{
								courseInformation courseinf = (courseInformation) cour.get(i);
								
								Classes[i]= Integer.toString(courseinf.get_year())+" "+ courseinf.get_coursename();
									break;
									
									
								}
							
							}catch (Exception e) {
								e.getSuppressed();
						}
						
					return foundcourse;
						}//EDIT COURSE



public String get_Grades(){
    return this.Grades;
}

public static void edit_Course() {
	
	int editchoice;
	boolean validEdit=false;
	Scanner keyboard = new Scanner(System.in);
//Get student ID to edit.  > SEARCH> Open Student & Enroll file. > make changes. > save back > Loop (IF STUD ID > add new info) cont saving the rest.
	
	System.out.println("\n______________________________________________________________\n\t\tEdit Course\n\n\n");
	display.display_courses();
	courseInformation editcourse = new courseInformation();
	//editcourse = courseInformation.get_Edit_Course();//Getting Student ID retruning Student Obj
	
System.out.println("\n_________________________________________________________________________________________");	
System.out.println("\n_________________________________________________________________________________________");	
System.out.println("\t\tCourse Being Edited\n");
System.out.println("\n| Course ID: "+ editcourse.CourseId + "\t || Course name:"+ editcourse.get_coursename());
System.out.println("\n| Semester: "+editcourse.get_semester() + " || Room: "+ editcourse.get_roombld());
System.out.println("\n| Year: "+editcourse.get_year()+"\t || Days: "+ editcourse.get_day());
System.out.println("\n----------------------------------------------------------------");

	do {
		validEdit=false;
	System.out.println("\n\nWhat would you like to edit? \n [1]Course name  [2] Semester  [3]Year \n [4]Room   \t [5]Days  ");
	System.out.println("\nEnter choice: ");
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
		courseInformation course = new courseInformation(editcourse.get_courseID(), name, editcourse.get_roombld(), editcourse.get_day(), editcourse.get_semester(), editcourse.get_year());
		saveBinary.save_enrollment(course);
		saveBinary.save_EditCourse(course);
			break;
	}
	case 2:{
		boolean validsemester = false;
		String name;
		
			do {
				validsemester=false;
				System.out.println("Enter New Semester (Fall,Spring,Summer,Winter)");
					name = keyboard.nextLine();
					validsemester=courseInformation.Valid_semester(name);
			}while(validsemester==true);	
		
			
			courseInformation course = new courseInformation(editcourse.get_courseID(), editcourse.get_coursename(), editcourse.get_roombld(), editcourse.get_day(), name, editcourse.get_year());
			saveBinary.save_enrollment(course);
			
			saveBinary.save_EditCourse(course);
			break;
			
	}
	case 3:{
		boolean valid=false;
		int year;
			do {
				valid=false;
				System.out.println("Enter new Year");
				year = keyboard.nextInt();  
				keyboard.nextLine();
				valid= courseInformation.Valid_Year(year);
			}while(valid==true);
		
			courseInformation course = new courseInformation(editcourse.get_courseID(), editcourse.get_coursename(), editcourse.get_roombld(), editcourse.get_day(), editcourse.get_semester(), year);
			saveBinary.save_enrollment(course);

			saveBinary.save_EditCourse(course);
			break;

	}
	case 4:{
		System.out.println("Enter new Room");
		String name;
		name = keyboard.nextLine();
		courseInformation course = new courseInformation(editcourse.get_courseID(), editcourse.get_coursename(), name, editcourse.get_day(), editcourse.get_semester(), editcourse.get_year());
		saveBinary.save_enrollment(course);

		saveBinary.save_EditCourse(course);
		break;
		
		
	}
	case 5: {
		boolean validday = false;
		String name;
		do {
			System.out.println("Enter new Day (Mon,Tues,Wed,Thurs,Fri,Sat,Sun)");
			name = keyboard.nextLine();
			validday= courseInformation.Valid_Day(name);
		
		}while(validday==true);
		
		courseInformation course = new courseInformation(editcourse.get_courseID(), editcourse.get_coursename(), editcourse.get_roombld(), name, editcourse.get_semester(), editcourse.get_year());
		saveBinary.save_enrollment(course);

		saveBinary.save_EditCourse(course);
		break;
	}
	
	
	}
	
	System.out.println("Course Updated ");
	System.out.println("\nPress enter to continue.");
	new Scanner(System.in).nextLine();
	
}

/***********************************************
**** 		Check Course					****
**** 										****
***********************************************/
public static courseInformation check_course() {
	//loca variables
	int validcourse = 0;
	boolean courseConfirm= true;
	courseInformation foundcourse= null;
	
	try {
		while(courseConfirm==true)
		{
			System.out.println("\nEnter Course ID");
			Scanner keyboard = new Scanner(System.in);
			validcourse = keyboard.nextInt();
			keyboard.nextLine();
				if (validcourse < 0)
				{
					System.out.println("Invalid course ID");
					 System.out.println("Press enter to continue.");
				        new Scanner(System.in).nextLine();
					
				}
				else 
				{

					try {
						ArrayList<Object> cour = openBinary.get_coursefile();
							for (int i = 0; i < cour.size(); i++) 
							{
								courseInformation courseinf = (courseInformation) cour.get(i);
								
								if (validcourse == courseinf.get_courseID()) 
								{
									foundcourse = courseinf;
									courseConfirm = false;
									System.out.println("\nCourse found");
									System.out.println("\nPress enter to continue.");
									new Scanner(System.in).nextLine();
									break;
									
									
								}
							
							}
						}
						catch (Exception e) {
						e.getSuppressed();
						}
				
					}
				
				if(courseConfirm==true)
				{
					System.out.println("\nCourse ID not found. Try again");
				}
				
			} 
			
		
		
		
	} catch (Exception e) {
		e.getSuppressed();
	}
	
	return foundcourse;
}










public static void save_course(courseInformation course) {

	MyGenericList<courseInformation>    coursedata = new MyGenericList<courseInformation>();
	
	try
	{	
		//get course info.	
                                if(get_courseinfo() != null){
					coursedata = get_courseinfo();
					
				}
				
				
			
				
		
		
		FileOutputStream FOS = new FileOutputStream("courseinfo.dat");
		
		



	
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					coursedata.add(course, course.get_ID());
				 
					
					
			
			SaveFile.writeObject(coursedata); 
			
			
			SaveFile.close();
			FOS.close();
		
		
		}catch (Exception e) {
			//e.getSuppressed();
			e.printStackTrace();
		};

		
		
	}
	catch (Exception e) {
		//e.getSuppressed();
		e.printStackTrace();
	}
	
	
	
	
}


public static void save_course(MyGenericList<courseInformation> course) {

	MyGenericList<courseInformation>    coursedata = new MyGenericList<courseInformation>();
	
	try
	{	
		//get course info.	
                                
				
				
			
				
		
		
		FileOutputStream FOS = new FileOutputStream("courseinfo.dat");
		
		



	
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					//coursedata.add(course, course.get_ID());
				 
				
					
			
			SaveFile.writeObject(course); 
			
			
			SaveFile.close();
			FOS.close();
		
		
		}catch (Exception e) {
			//e.getSuppressed();
			e.printStackTrace();
		};

		
		
	}
	catch (Exception e) {
		//e.getSuppressed();
		e.printStackTrace();
	}
	
	
	
	
}



	@SuppressWarnings("unchecked")
	public static MyGenericList<courseInformation> get_courseinfo() {

		MyGenericList<courseInformation> coursedata = new MyGenericList<>();
			
			try
			{
                            
                            
				FileInputStream FOS = new FileInputStream("courseinfo.dat");
				
				
				try {
					ObjectInputStream ReadFile = new ObjectInputStream(FOS);
					
				
					
					coursedata = (MyGenericList<courseInformation>)ReadFile.readObject();
					
				
					
					FOS.close();
					ReadFile.close();
					
					
					

						
				}catch (ClassNotFoundException c) {
					c.getSuppressed();
					
				
		}
			}catch (IOException i) {
				i.getSuppressed();
				
			}
			
			
	return 	coursedata;
	} 



    public courseInformation(int CourseId, int year, String coursename, String roombuilding, String day, String semester, ArrayList<String> Days, char Grade, String subject) {
        this.CourseId = CourseId;
        this.year = year;
        this.coursename = coursename;
        this.roombuilding = roombuilding;
        this.day = day;
        this.semester = semester;
        this.Days = Days;
        this.Grade = Grade;
        this.subject = subject;
    }


public static void SaveCoursedb(courseInformation course)
{
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
           
           
           PreparedStatement Pst = conn.prepareStatement("INSERT INTO Courses(CourseName,Department,Semester,Year,Days,Professor)"+ 
                                                        " Values '"+course.get_coursename()+"',\n"
                                                                         + ""+"'"+ course.get_Subject()+"',"     
                                                                          +"'"+ course.get_semester()+"'," 
                                                                          +"'"+ course.get_year()+"'," 
                                                                          +"'"+ course.Days+"'," 
                                                                          +"'"+ course.getProfessorName()+"'"   +";");
           
           
         
           
           
          
           Pst.execute();
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}
public static void Save_EditCoursedb(courseInformation course)
{
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
           
           
           PreparedStatement Pst = conn.prepareStatement("Update Courses\n SET CourseName= '"+ course.get_coursename()+"' ,"+
                                                                                " Department= '"+course.get_Subject()+"',"+
                                                                                "Semester = '"+course.get_semester()+"',"+
                                                                                 "Professor = '"+course.getProfessorName()+"',"+
                                                                                "Year= "+course.get_year()+""+
                   
                                                                                " \n WHERE CourseID ="+ course.get_courseID()+ ";");
     
          
           Pst.execute();
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}





/**
 * 
 * 
 * get course from DATABASE
 */
public static courseInformation GetCourseDB(int ID){
    courseInformation courseDB = null;      
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Courses\n"  +"Where CourseID="+ID);
          
                
                
                
           while(rs.next())
           {
               String CID = rs.getString(1);
              String CourseName = rs.getString("CourseName");
              String Department = rs.getString("Department");
             // String Days= rs.getString("Days");
              String Semester = rs.getString("Semester");
              
             
              int Year = Integer.parseInt(rs.getString("Year"));

             /* 
              Days.replaceAll("["," ");
              Days.replaceAll("]", " ");
              
              String[] Day= Days.split(",");
              
              ArrayList<String> List = new ArrayList();
              
              for(int x=0; x<Days.length(); x++)
              {
                  List.add(Day[x]);
                   System.out.println(Days+" "+ Day[x]);
              }
              
              */
             
             
              int CourseIDdb = Integer.parseInt(CID);
              
              courseDB = new courseInformation(CourseIDdb, CourseName, Department, Semester, Year);
             
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            
            courseInformation cw = null;
    return courseDB;
}

public static boolean GetCourseDB_Boolean(int ID){
           
    boolean Pass = false;
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Courses\n"  +"Where CourseID="+ID);
          
           while(rs.next())
           {
              String CID = rs.getString(1);
              String CourseName = rs.getString(2);
              String Department = rs.getString(3);
            
              int CourseIDdb = Integer.parseInt(CID);
                System.out.println(CID +" "+ ID  + " "+CourseIDdb);
              if(CourseIDdb == ID){
                                    System.out.println("PASS");
                                    Pass = true;
              }
              else
              {
                  Pass = false;
                  System.out.println("DID NOT PASS");
              }
              
               System.out.println();
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            Pass = false;
            e.printStackTrace();
            
        }
            
           
    return Pass ;
}




/*

    GETTING COURSE JTABLE base on SUBJECT/Department

*/

public static ArrayList<courseInformation> Professor_CourseListDB(String Prof){
           
    ArrayList<courseInformation> List = new ArrayList();
   
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Courses\n"  +"Where Professor= '"+Prof+ "'");
          
           while(rs.next())
           {
               courseInformation CourseIn = new courseInformation(rs.getInt("CourseID"), rs.getString("CourseName"), rs.getString("Department"));
               List.add(CourseIn);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
           
    return List ;
}




public static ArrayList<courseInformation> CoursesTableList(String Department){
           
    ArrayList<courseInformation> List = new ArrayList();
   
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Courses\n"  +"Where Department= '"+Department+ "'");
          
           while(rs.next())
           {
               courseInformation CourseIn = new courseInformation(rs.getInt("CourseID"), rs.getString("CourseName"), rs.getString("Department"));
               List.add(CourseIn);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
           
    return List ;
}


public static ArrayList<courseInformation> GET_CoursesTableList(){
           
    ArrayList<courseInformation> List = new ArrayList();
   
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Courses\n ORDER BY CourseName ASC " );
          
           while(rs.next())
           {
               courseInformation CourseIn = new courseInformation(rs.getInt("CourseID"), rs.getString("CourseName"), rs.getString("Department"));
               List.add(CourseIn);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
           
    return List ;
}

public static String Get_CourseID_Created(){
           
    String List = null;
   
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT Max(CourseID)\n From Courses;\n"  );
          
           while(rs.next())
           {
               
               int NEWID = rs.getInt(1) + 1;
               
               List = Integer.toString(NEWID);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
           
    return List ;
}



    @Override
    public int compareTo(courseInformation o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
