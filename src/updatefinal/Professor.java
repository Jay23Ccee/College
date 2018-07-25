/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatefinal;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Jay-Cee
 */
public class Professor {
    
    private String Firstname;
	private String lastname;
	private  int age;
        private String DOB;
	private int Prof_ID;
        private String Department;

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }
       
    
     public  Professor(String Fname, String Lname,String Dob, int ProfID ){
         Firstname = Fname;
         lastname = Lname;
         DOB = Dob;
         Prof_ID = ProfID;
     }
      public  Professor( ){
         Firstname =null;
         lastname = null;
         DOB = null;
         
     }
     
         public  Professor(String Fname, String Lname,String Dob){
         Firstname = Fname;
         lastname = Lname;
         DOB = Dob;
        
     }
     
      public  Professor(String Fname, String Lname,int ProfID ){
         Firstname = Fname;
         lastname = Lname;
      
         Prof_ID = ProfID;
     }

     public Professor (String Fname, String Lname)
     {
         Firstname = Fname;
         lastname = Lname;
     }
    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getDOB() {
        return DOB;
    }

    public int getProf_ID() {
        return Prof_ID;
    }
    
    public String get_Fullname(){
        String name = this.Firstname +" "+ this.lastname;
        return name;
        
    }
    
     
    
    public static void Save_Professordb(Professor prof){
    
     
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
           
           
           PreparedStatement Pst = conn.prepareStatement("INSERT INTO Professor(FirstName,LastName,DOB)"+ " VALUES '"+prof.getFirstname() +" ', " + " '"+ prof.getLastname() + "'"+ " '"+ prof.getDOB() + "'"+";");
          
           Pst.execute();
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}


public static void Save_Edit_Professordb(Professor prof)
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
           
           
           PreparedStatement Pst = conn.prepareStatement("Update Professor\n" +"Set FirstName = '"+prof.getFirstname()+"', LastName='"+prof.getLastname()+"'"+"DOB='"+prof.getDOB()+"'\n" + "Where Prof_ID = "+prof.getProf_ID()+";");
           
           
          
           Pst.execute();
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}  







public static Professor GetProfessorDB(int ID){
   Professor Prof = null;      
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Professor\n"  +"Where Prof_ID="+ID);
          
                
                
                
           while(rs.next())
           {
               String PID = rs.getString(1);
              String ProfFName = rs.getString(2);
              String ProfLname = rs.getString(3);
              String DOB = rs.getString(4);
              
              System.out.println(ProfFName);
            
              int Prof_ID = Integer.parseInt(PID);
              
              Prof = new Professor(ProfFName, ProfLname, DOB, Prof_ID);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            
            courseInformation cw = null;
    return Prof;
}

public static boolean GetProfessorDB_Boolean(int ID){
           
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Professor\n"  +"Where Prof_ID="+ID);
          
           while(rs.next())
           {
              String PID = rs.getString(1);
              
            
              int Prof_ID = Integer.parseInt(PID);
                System.out.println(PID +" "+ ID  + " "+Prof_ID);
              if(Prof_ID == ID){
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





public static String Get_PROFID_Created(){
           
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
           
           
                ResultSet rs = s.executeQuery("SELECT Max(Prof_ID)\n From Professor;\n"  );
          
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

public static ArrayList<String> Get_ProfList_DB(){
    ArrayList<String> EList = new ArrayList();
     String emp = " ";
     String Detail = "ID  | Name";
            
            EList.add(emp);
            EList.add(Detail);
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Professor;\n"  );
          
           while(rs.next())
           {    int CID1 =rs.getInt("Prof_ID");
                String CID11 = Integer.toString(CID1);
               String Fname = rs.getString("FirstName");
                String Lname = rs.getString("LastName");
                
                String Sendback = CID11 +" | Prof."+ Fname + " "+ Lname;
                
                Professor prof = Professor.GetProfessorDB(CID1);
                
               
               
               
                
                
               EList.add(Sendback);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
    
    
    return EList;
} 
 


public static ArrayList<Professor> Get_ProfList_4_Course_DB(String dept){
    ArrayList<Professor> EList = new ArrayList();
     String emp = " ";
     String Detail = "ID  | Name";
            
           
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Professor\n Where Department='"+dept +"';" );
          
           while(rs.next())
           {    int CID1 =rs.getInt("Prof_ID");
                String CID11 = Integer.toString(CID1);
               String Fname = rs.getString("FirstName");
                String Lname = rs.getString("LastName");
                
                String Sendback = CID11 +" | Prof."+ Fname + " "+ Lname;
                
                Professor prof = Professor.GetProfessorDB(CID1);
                
               
               
               
                
                
               EList.add(prof);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
    
    
    return EList;
} 
}
