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
public class Departments {
    int DepartmentID;
    String DepartmentName;
    Professor Prof;
    
   public  Departments(int ID, String name){
       DepartmentID = ID;
       DepartmentName = name;
   }
   
      public Departments(int ID, String name, Professor professor){
       DepartmentID = ID;
       DepartmentName = name;
       Prof = professor;
   }
           
   public void setProfessor(Professor prof){
       this.Prof = prof;
   }
   
   public Professor getProfessor(){
       return Prof;
   }
   public int getDeptID(){
       return DepartmentID;
   }
   

   public String getDeptName(){
       return DepartmentName;
   }
   
   
 public static void Save_Departmentdb(Departments Dept){
    
     
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
           
           
           PreparedStatement Pst = conn.prepareStatement("INSERT INTO Departments(Name,Department_ID,ChairName, Chair_ID)"+ " VALUES("+" '"+Dept.getDeptName() +" ', " + " '"+ Dept.getDeptID() + "',"+
                                                "'"+Dept.getDeptName() +" ', "+"'"+ Dept.getProfessor().getProf_ID()+ "'" + ");");
                                                        
          
           Pst.execute();
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}


public static void Save_Edit_Departmentdb(Departments Dept)
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
           
           
           PreparedStatement Pst = conn.prepareStatement("Update Departments\n" +
                                                        "Set Name='"+Dept.getDeptName()+"'," +"ChairName='"+Dept.getProfessor().get_Fullname()+"',"+ "Chair_ID="+Dept.getProfessor().getProf_ID()+
                                                        "\nWHERE Department_ID="+Dept.getDeptID()+";");
           
          
           Pst.execute();
         
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
}  
   
   
   public static Departments GetDepartmentsDB(int ID){
    Departments DeptDB = null;      
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Departments\n"  +"Where Department_ID="+ID);
          
                
                
                
           while(rs.next())
           {
              int DID = rs.getInt(1);
              String DeptName = rs.getString(2);
              int chair = rs.getInt(4);
              
              int Chair_ID =chair;
              int Dept_ID = DID;
              
           
              
              Professor prof = Professor.GetProfessorDB(Chair_ID);
                // //ln();
              DeptDB = new Departments(Dept_ID, DeptName, prof);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            
            
    return DeptDB;
}

public static boolean GetDepartmentsDB_Boolean(int ID){
           
    boolean Pass = true;
    int DeptIDdb = -1;
    int Chair_ID= -1;
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Departments\n"  +"Where Department_ID="+ID);
                                             

                
           while(rs.next())
           {
              int DID = rs.getInt(1);
              String DepartName = rs.getString(2);
             int Chair = rs.getInt(4);
              
            
              DeptIDdb = DID;
              Chair_ID = Chair;
              
              
              
       

              
           }
          
           // cHECKING ID 
                ;
              if(DeptIDdb == ID){
                                   // PASS

              }
 
              else
              {
                  Pass = false;
                 
              }           
            conn.close();
           
        }catch(Exception e)
        {
            Pass = false;
            e.printStackTrace();
            
        }
            
           
    return Pass ;
}

   
     
public static ArrayList<Departments> Get_DepartmentListDB_LOG(){
    ArrayList<Departments> EList = new ArrayList();
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Departments\n"  );
          
           while(rs.next())
           {    int CID11 =rs.getInt("Department_ID");
                
                String DepartmentName = rs.getString("Name");
                
                Departments dept = Departments.GetDepartmentsDB(CID11);
                
              
               
               
                
                
               EList.add(dept);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
    

     
    return EList;
}  
    
   
   
public static ArrayList<String> Get_DepartmentListDB(){
    ArrayList<String> EList = new ArrayList();
    
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
           
           
                ResultSet rs = s.executeQuery("SELECT * From Departments\n"  );
          
           while(rs.next())
           {    int CID11 =rs.getInt("Department_ID");
                
                String DepartmentName = rs.getString("Name");
                
                Departments dept = new Departments(CID11,DepartmentName);
                
              
               
               
                
                
               EList.add(DepartmentName);
              
           }
          
            conn.close();
           
        }catch(Exception e)
        {
            
            e.printStackTrace();
            
        }
            
    

     
    return EList;
}  
   
   
   
public static String Get_DEPTID_Created(){
           
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
           
           
                ResultSet rs = s.executeQuery("SELECT Max(Department_ID)\n From Departments;\n"  );
          
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

   
    
    
}
