package updatefinal;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.Properties;

public class student implements Serializable,Comparable<student> {
	private String name;
	private String lastname;
	private  int age;
        private String DOB;
	private int studentID;
        private int DOBday;
	
	//CONSTRUCTOR
	student(student stud){
		this.name = stud.get_name();
		this.lastname = stud.lastname;
		this.age = stud.age;
		this.studentID = stud.get_studentID();
		
	}
	
	// CONSTRUCTOR
	student (String  n,String LN, int ID, String DOB, int Day)
	{
		name=n;
		lastname = LN;
		this.age = age;
		this.studentID=ID;
                this.DOB = DOB;
                this.DOBday= Day;
	
	}
        
        	student (String  n,String LN, int age, int ID)
	{
		name=n;
		lastname = LN;
		this.age = age;
		this.studentID=ID;
               
	
	}
        
        	// CONSTRUCTOR
	student (String  n,String LN, String DOB, int ID)
	{
		name=n;
		lastname = LN;
		this.DOB = DOB;
		this.studentID=ID;
	
	}
	
	//Empty Constructor
	student(){};

	
	
	public  boolean Equals() {
		boolean pass= true;
		
		if(this.name.equals("")||this.lastname.equals("")) {
			pass = false;
		}
			
		
		
		
		return pass;
	}
	
	/***********************************************
	 **** 		Getters : ID/AGE/LASTNAME/NAME	****
	 **** 										****
	 ***********************************************/
	public int get_studentID() {
		return this.studentID;

	}
        
        public int get_ID(){
            return this.studentID;
        }
	public int get_age() {
		return this.age;
	}
	
        
        public String get_DOB(){
                return this.DOB;
            
        }
        
        public void set_DOB(String DayOB){
            this.DOB = DayOB;
        }

	public String get_lastname() {
		return lastname;
	}

	public String get_name() {
		
		return name;
	}
        
        public String get_Month(){
            
           
           
           String ReturnMonth;
                    
                   int x =0;
                   int Dub = x++;
                   int Triple = Dub + 2 ;
                   String PrevMonth;
                   PrevMonth = new StringBuilder().append(DOB.charAt(0)).append(DOB.charAt(1)).append(DOB.charAt(2)).toString();
                
           
           
           
           
            
            return PrevMonth;
        }
        
        public int get_IntMonth(){
            
            String ReturnMonth;
                    
                   int x =0;
                   int Dub = x++;
                   int Triple = Dub++;
                   String PrevMonth;
                   PrevMonth = new StringBuilder().append(DOB.charAt(0)).append(DOB.charAt(1)).append(DOB.charAt(2)).toString();
                
                  switch(PrevMonth){
                      
                      case "Jan": x=1; break;
                      case "Feb": x=2 ; break;
                      case "Mar": x=3 ; break;
                      case "Apr": x=4 ; break;
                      case "May": x= 5; break;
                      case "Jun": x= 6; break;
                      case "Jul": x= 7; break;
                      case "Aug": x= 8; break;
                      case "Sep": x= 9; break;
                      case "Oct": x= 10; break;
                      case "Nov": x= 11; break;
                      case "Dec": x= 12; break;
                      
                      
                  
                      
                      
                  }
           
           
           
            
            return x;
            
        }
	
        
        
        
	public String get_fullname() {
		String fullname = this.name + " "+this.lastname;
		
		return fullname;
		
		
	}

	/***********************************************
	 **** 		Setter	AGE/LASTNAME/name		****
	 **** 										****
	 ***********************************************/
	public void set_Age(int age) {
		this.age = age;
	}
        
        public void Set_Day(int day){
                this.DOBday = day;
        }

	public void set_Lastname(String LN) {
		lastname= LN;
	}
	
	public  String setname() {
		Scanner keyboard = new Scanner(System.in);
		String newname;
		System.out.println("Enter name");
		newname = keyboard.nextLine();
		
		name = newname;
		
		
		
		return newname;
		
		
	}
	
	
	/***********************************************
	 **** 		To String						****
	 **** 										****
	 ***********************************************/
	public String toString() {
		String send ;
		
		send = "\n "+name + " "+ lastname +" ";
		
		return send;
		
	}
	
	

	
	/***********************************************
	 **** 		Create Student					****
	 **** 										****
	 ***********************************************/
	
	
	
	
	/// CHECKING STUDENT ID (GUI)
	public static boolean checkStudentID(int StudentID, JTextField IDTEXT, JPanel panel)  {
		boolean NoError=true;
			try {
				
			
			
					boolean pass = false;
		
						//STUDENT ID NEEDS
					pass=openBinary.check_StudentID(StudentID);      // CHECKING if STUDENT ID can be used
					
					if (pass == true) 
						{
							IDTEXT.setText(" ");
							panel.add(IDTEXT);
							
							JPanel IDUsed = new JPanel();
							JFrame IdUSEDFrame = new JFrame();
							IdUSEDFrame.setVisible(true);
							IdUSEDFrame.setSize(200, 150);
							IdUSEDFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
							JTextField ERRORID = new JTextField("ID has been Used. Try again");
							JButton  Closebutton = new JButton("Close");
							
							
							ERRORID.setEditable(false);
							ERRORID.setSelectionColor(Color.RED);
							
							IDUsed.add(ERRORID);
							IDUsed.add(Closebutton);
							IdUSEDFrame.add(IDUsed);
							
							
							Closebutton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									IdUSEDFrame.dispose();
									
								}
							});
							
							
							
							NoError = false;
						}
						else if(StudentID < 0)
						{
							pass=true; 
							System.out.println("Invalid ID number");
							NoError = false;
						}
					}catch (Exception e) {
						e.getStackTrace();
					}
			
			
			return NoError;
			
	}
	
		
	
	// CHECKING STUDENT AGE (GUI)
	public static boolean  checkStudentAge(int age, JTextField AGETEXT, JPanel panel){
		boolean NoError= true;
		if(age<0)
		{
			AGETEXT.setText("Invalid Age");
			panel.add(AGETEXT);
			NoError=false;
			System.out.println("\nInvalid Age. Try again");
	
			
		}
		
		return NoError;
	}
	
        
        public static boolean checkStudentname(String name){
            
            if(name.isEmpty())
            {
                System.out.println("Error IN NAME");
                return true;
            }
            else {
                return false;
            }
    
        };
        
        public static boolean checkStudentDOB(String month){
            String mon  = month.toUpperCase();
            System.out.println(mon + " | MONTH");
            if(mon.compareTo("MONTH") == 0){
                System.out.println("Error in DOB");
                return true;
            }
            else{
                return false;
            }
            
        };
	
	public static void createStudent(int StudentID )  {
		
		String name, lastname;
		int age;
		student Nstudent;
		
		
		
			try {
				
			
			Scanner keyboard1 = new Scanner(System.in);
			boolean pass = false;
			//System.out.println("\n/***************************************/");
			//System.out.println("\n*\t\tCreating Student\t*");
			//System.out.println("\n/***************************************/"); 
			
			
			



	System.out.println("Enter First name");
	name= keyboard1.nextLine();


	System.out.println("Enter last name");
	lastname = keyboard1.nextLine();


	boolean passage = true;
	do {
		passage = true;
		System.out.println("Enter age");
		age = keyboard1.nextInt();
		keyboard1.nextLine();
		
		if(age<0)
		{
			passage = false;
			System.out.println("\nInvalid Age. Try again");

			
		}
			
	}while(passage == false);



	Nstudent= new student(name,lastname,age, StudentID );
	saveBinary.save_student(Nstudent);          

	System.out.println("\nStudent was created");

	System.out.println("\nPress enter to continue.");
	new Scanner(System.in).nextLine();


	} catch (Exception e) {
		e.getSuppressed();
	}










	}


	
	
	/***********************************************
	 **** 		return Student. Check for ID	****
	 **** 									****
	 ***********************************************/	

        
public static boolean check_StudentID_boolean(int ID2check) {
	boolean IDconfirm= false;
        	ArrayList<Object> studentdata;
	try {
		FileInputStream FOS = new FileInputStream("Studentinfo.dat");
		
		try {
				final ObjectInputStream ReadFile = new ObjectInputStream(FOS);
	
			
				studentdata = (ArrayList<Object>)ReadFile.readObject();
			
					for (int i = 0; i < studentdata.size() ; i++) {
						
						student studentID = (student) studentdata.get(i);   // creating a Student class object
						
						if(studentID.get_studentID()== ID2check)             // IF File ID equals User input ID. 
						{
							IDconfirm= true;
						}
				
				
					}
				
			} // closing Try
		catch (Exception e) {
			e.printStackTrace();
			}
	
	
	}catch (Exception e) {
                e.printStackTrace();
	}
	
	
	return IDconfirm;

}
        
        
        public static student check_student() {	
		int ValidId = 0;
		boolean ConfirmId = true;
		student studentconfirm = null;
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
							student studentcheck = (student)stud.get(i);
							
							if (ValidId == studentcheck.get_studentID())
							{
								System.out.println("Student is Found ! ");
								ConfirmId = false;
								studentconfirm = studentcheck;     // RETURNING STUDENT pos.
								System.out.println("Press enter to continue.");
								new Scanner(System.in).nextLine();
								System.out.println("_____________________________________________");
								System.out.println("Student ID:"+ studentcheck.get_studentID() + "\nStudent Name:"+ studentcheck.get_name()+" "+ studentcheck.get_lastname());
								
								break;
							}

						
						}
					}catch (Exception e) {
						e.getSuppressed();
					}// for
				}; // else
			
				
				if(ConfirmId==true) {
					System.out.println("Student ID not found. Try again");
				}
				
			};
		
			
			
			
		}
		catch (Exception e) {
			e.getSuppressed();
		
		}
		
		return studentconfirm;
	}


        
        
        
 public int get_Day(){
     
        return DOBday;
     
 }  ;     
       


public String get_Year(){
    
   String[] Yearstring =  DOB.split(",");
  
    
   
    return Yearstring[1];
}
 
/***********************************************
 **** 		get EDIT STUDENT 					****
 **** 										****
 ***********************************************/	

        
public static  student get_EditStudent() {	
	int ValidId = 0;
	boolean ConfirmId = true;
	student studentconfirm = null;
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
						student studentcheck = (student)stud.get(i);
						
						if (ValidId == studentcheck.get_studentID())
						{
							System.out.println("STUDENT FOUND ! ");
							ConfirmId = false;
							studentconfirm = studentcheck;     // RETURNING STUDENT pos.
							System.out.println("Press enter to continue.");
							new Scanner(System.in).nextLine();
							break;
						}

					
					}
				}catch (Exception e) {
					e.getSuppressed();
				}// for
			}; // else
		
			
			if(ConfirmId==true) {
				System.out.println("Student ID not found. Try again");
			}
			
		};
	
		
		
		
	}
	catch (Exception e) {
		e.getSuppressed();
	
	}
	
	return studentconfirm;
}

public static  student get_EditStudent(int IDstud ) {	
	int ValidId = IDstud;

	student studentconfirm = null;

				try {
					ArrayList<Object> stud = openBinary.get_studentinfo();
					for (int i =0; i < stud.size(); i++) {
						student studentcheck = (student)stud.get(i);
						
						if (ValidId == studentcheck.get_studentID())
						{
	
							studentconfirm = studentcheck;     // RETURNING STUDENT pos.
							
							break;
						}

					
					}
				}
				catch (Exception e)
				{
					e.getSuppressed();
				}// for
			
			
			
			return studentconfirm;
		};

		
		
		
public static  student get_EditStudent(int IDstud,JTextField IDtextfield , JPanel panel,boolean found  ) {	
			int ValidId = IDstud;
			found = false;
			student studentconfirm = null;

						try {
							ArrayList<Object> stud = openBinary.get_studentinfo();
							for (int i =0; i < stud.size(); i++) {
								student studentcheck = (student)stud.get(i);
								
								if (ValidId == studentcheck.get_studentID())
								{
			
									studentconfirm = studentcheck;     // RETURNING STUDENT pos.
									found =true;
									break;
								}

							
							}
						}
						catch (Exception e)
						{
							e.getSuppressed();
						}// for
					
					
				
					return studentconfirm;
				};		





public static int get_Last_StudentID(){
    int position=0 ; 
    int ID = 0;
     
    try {
		ArrayList<Object> stud = openBinary.get_studentinfo();
                
                position = stud.size() - 1;
                
                for(int x=0 ; x < stud.size(); x++)
                {
                    student lastStudentsaved = (student) stud.get(x);
                      System.out.println(lastStudentsaved.get_studentID());
                    if(ID < lastStudentsaved.get_studentID() ){
                        ID = lastStudentsaved.get_studentID();
                        
                    }
                    
                }
                
                
                
                
              
                
                
	}
	catch (Exception e)
        {
            e.getSuppressed();
        }// for
    
        ID++;
    return ID;
}




		
/***********************************************
**** 		EDIT STUDENT 					****
**** 										****
***********************************************/
@SuppressWarnings("unused")
public static void edit_Student() {
			int editchoice;
			boolean validEdit=false;
			Scanner keyboard = new Scanner(System.in);
		// Get student ID to edit.  > SEARCH> Open Student & Enroll file. > make changes. > save back > Loop (IF STUD ID > add new info) cont saving the rest.
			student editstud = new student();
			editstud = student.get_EditStudent();//Getting Student ID retruning Student Obj
			
			System.out.println("\n-------------------------------------------------------");
			System.out.println("\nName: "+ editstud.get_name()+" "+editstud.get_lastname() );
			System.out.println("Student ID:" + editstud.get_studentID());
			System.out.println("Age: " + editstud.get_age());
			
			do {
				validEdit=false;
			System.out.println("\n\nWhat would you like to edit? \n [1] First name  [2] Lastname [3] Age");
			System.out.println("\nEnter Option: ");
			editchoice = keyboard.nextInt();
			keyboard.nextLine();
			
			if((editchoice <=0)|| (editchoice>3)) {
				System.out.println("Invalid Choice. Try again");
				validEdit = true;
			}
			
			}while (validEdit == true);
			

			switch(editchoice)
			{
			case 1:{
				System.out.println("Enter new First name");
				String name;
					name = keyboard.nextLine();
				student stud = new student(name, editstud.get_lastname(), editstud.get_age(), editstud.get_studentID());
				saveBinary.save_enrollment(stud);

				saveBinary.save_EditStudent(stud);
					break;
			}
			case 2:{
				System.out.println("Enter new Last name");
				String name;
					name = keyboard.nextLine();
				student stud = new student(editstud.get_name(), name, editstud.get_age(), editstud.get_studentID());
				saveBinary.save_enrollment(stud);

				saveBinary.save_EditStudent(stud);
					break;
					
			}
			case 3:{
				System.out.println("Enter new age");
				int age;
					age = keyboard.nextInt();  
					keyboard.nextLine();
					
					
					
					
				student stud = new student(editstud.get_name(), editstud.get_lastname(), age, editstud.get_studentID());
				
				saveBinary.save_enrollment(stud);
				
				saveBinary.save_EditStudent(stud);
					
					
					break;
			}
			
			
			}
			
			System.out.println("Student Updated ");
			System.out.println("\nPress enter to continue.");
			new Scanner(System.in).nextLine();

		}



/************************************************
 * **********************************************
 * *****       SAVE EDIT STUDENT ****************
 * **********************************************
 ************************************************/

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

public static MyGenericList<student> get_Studentinfo() {
		

		MyGenericList<student> studentdata = new MyGenericList<>();
		
		try
		{
			FileInputStream FOS = new FileInputStream("Studentinfo.dat");
			
			
			try {
				ObjectInputStream ReadFile = new ObjectInputStream(FOS);
				
			
				
				studentdata = (MyGenericList<student>)ReadFile.readObject();
				
				
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
		
		
return 	studentdata;
} 

public static student GetStudentDB(int ID){
            
    student stud  = null;
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Students\n"  +"Where Student_ID="+ID);
          
           while(rs.next())
           {
              String SID = rs.getString(1);
              String FirstName = rs.getString(2);
              String LastName = rs.getString(3);
              String DOB = rs.getString(4);
            
              int STUDIDdb = Integer.parseInt(SID);
                System.out.println(SID +" "+ ID  + " "+STUDIDdb);
              if(STUDIDdb == ID){
                                   
                  stud = new student(FirstName, LastName, DOB, STUDIDdb);
                  System.out.println("PASS");

              }
              else
              {
                  
                  System.out.println("DID NOT PASS");
              }
              
               System.out.println();
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
           
    return stud ;
    
}

public static boolean GetStudentDB_Boolean(int ID){
            
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Students\n"  +"Where Student_ID="+ID);
          
           while(rs.next())
           {
              String SID = rs.getString(1);
              String FirstName = rs.getString(2);
              String LastName = rs.getString(3);
            
              int STUDIDdb = Integer.parseInt(SID);
                System.out.println(SID +" "+ ID  + " "+STUDIDdb);
              if(STUDIDdb == ID){
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
public static void SaveStudentdb(student Student){
    
     
        try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
         // Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
           PreparedStatement Pst = conn.prepareStatement("INSERT INTO Students(Student_FirstName,Student_LastName,Student_DOB)"+ " Values( '"+Student.get_name() +" ', " + " '"+ Student.get_lastname() + "',"+
                                                "'"+ Student.get_DOB()+ "'" + ");");
          
           Pst.execute();
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}


public static void Save_Edit_Studentdb(student stud)
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
           
           
           PreparedStatement Pst = conn.prepareStatement("Update Students\n SET Student_FirstName= '"+ stud.get_name()+"' , Student_LastName= '"+stud.get_lastname()+ "',Student_DOB=' "+stud.get_DOB()+"'"+"\n WHERE Student_ID ="+ stud.get_studentID()+ ";");
           
          
           Pst.execute();
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}



  
public static String Get_StudentID_Created(){
           
    String List = null;
   
    
    try(FileReader reader = new FileReader("app.Config")){
	Properties properties = new Properties();
	properties.load(reader);

	//Some String(Remember case sensitive)
	String ClassName = properties.getProperty("ClassName");
	String path = properties.getProperty("path");
	String URL = properties.getProperty("URL")+ path;
       
                
          //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
          System.out.println(ClassName);
            Class.forName(ClassName);
          // path ="C:\\Users\\Jay-Cee\\Documents\\NetBeansProjects\\UpdateFinal\\FinalProject.accdb";
         // String URL =  "jdbc:ucanaccess://"+path;
          
          Connection conn = DriverManager.getConnection(URL);
          
          
           Statement s = conn.createStatement();
        
           //ResultSet rs = s.executeQuery( );
           
           
                ResultSet rs = s.executeQuery("SELECT Max(Student_ID)\n From Students;\n"  );
          
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
    public int compareTo(student o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }













}
