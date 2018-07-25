package updatefinal;

import java.util.Scanner;
import java.io.*;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;






class MyGenericList <T extends Comparable<T> > implements Serializable
{
	private  class Node<T> implements Serializable
	 {
	 	T value;
	 	int ID;
                int ID2nd;
	 	Node<T>  next;
		
	 	

	 }	 
	
     private Node<T> first = null;
     int count=0;
     

     
    public void  add(  T element)
     {
      	 Node<T> newnode = new Node<T>();
      	 newnode.value = element;
      	 newnode.next = null;

    	if (first== null)
    	{
    		first = newnode;
    	}
    	else
    	{
    		Node<T> lastnode = gotolastnode(first);
    		lastnode.next = newnode;
    	}
     	 count++;
     }
    
    public void  add(  T element, int ID)
    {
     	 Node<T> newnode = new Node<T>();
     	 newnode.value = element;
     	 newnode.next = null;
     	 newnode.ID = ID;

   	if (first== null)
   	{
   		first = newnode;
   	}
   	else
   	{
   		Node<T> lastnode = gotolastnode(first);
   		lastnode.next = newnode;
   	}
    	 count++;
    }
    
      public void  add(  T element, int ID, int ID2nd)
    {
     	 Node<T> newnode = new Node<T>();
     	 newnode.value = element;
     	 newnode.next = null;
     	 newnode.ID = ID;
         newnode.ID2nd = ID2nd;

   	if (first== null)
   	{
   		first = newnode;
   	}
   	else
   	{
   		Node<T> lastnode = gotolastnode(first);
   		lastnode.next = newnode;
   	}
    	 count++;
    }
    
    
    
    public T get(int pos)
    {
    	Node<T> Nodeptr = first;
    	try {
    	 int hopcount=0;
    	 while (hopcount < count && hopcount<pos)
    	 {   if(Nodeptr!=null)
    	 	 {
    		    Nodeptr = Nodeptr.next;
    	 	 }
    		 hopcount++;
    	 }
    	return  Nodeptr.value;
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return Nodeptr.value;
    }

    
    //ADDING LAST
	private Node<T> gotolastnode(Node<T> nodepointer) 
	{
       if (nodepointer== null )
        {
    	  return nodepointer;
		} 
        else
        {
        	if (nodepointer.next == null)
               return nodepointer;
        	else
        		 return gotolastnode( nodepointer.next);
        	
        }

	}

        
        public void set_ID(int ID){
         
             Node<T> newnode = new Node<T>();
             newnode.ID = ID;
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
				c.addSuppressed(c);
			
	}
		}catch (IOException i) {
			//i.getSuppressed();
			i.addSuppressed(i);
		}
		
		
return 	studentdata;
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
        
        
	
	@SuppressWarnings("unchecked")
	public static MyGenericList<student> get_studentinfo() {

		MyGenericList<student> studentdata = new MyGenericList<student>();
			
			try
			{
				FileInputStream FOS = new FileInputStream("Studentinfo.dat");
				
				
				try {
					ObjectInputStream ReadFile = new ObjectInputStream(FOS);
					
				
					
					studentdata = (MyGenericList<student>)ReadFile.readObject();
					
				
					
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
	public static MyGenericList<Enrollment> get_enrollinfo() {

		MyGenericList<Enrollment> Enrolldata = new MyGenericList<Enrollment>();
			
			try
			{
				FileInputStream FOS = new FileInputStream("Enrollinfo.dat");
				
				
				try {
					ObjectInputStream ReadFile = new ObjectInputStream(FOS);
					
				
					
					Enrolldata = (MyGenericList<Enrollment>)ReadFile.readObject();
					
				
					
					FOS.close();
					ReadFile.close();
					
					
					

						
				}catch (ClassNotFoundException c) {
					c.getSuppressed();
					
				
		}
			}catch (IOException i) {
				i.getSuppressed();
				
			}
			
			
	return 	Enrolldata;
	} 	      

public static void save_student(student stud) {

	MyGenericList<student> studentdata = new MyGenericList<student>();
	
	try
	{	
				if(get_studentinfo() != null){
					studentdata = get_studentinfo();
					
				}
				
				
			
				
		
		
		FileOutputStream FOS = new FileOutputStream("Studentinfo.dat");
		
		



	
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					studentdata.add(stud, stud.get_ID());
				 
					
					
			
			SaveFile.writeObject(studentdata); 
			
			
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

public static void save_student(MyGenericList<student> list)  {

	
	
	try
	{	
				
				
				
			
				
		
		
		FileOutputStream FOS = new FileOutputStream("Studentinfo.dat");
		
		



	
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					
				 
					
					
			
			SaveFile.writeObject(list); 
			
			
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


public static void save_Enrollment(Enrollment enroll) {

	MyGenericList<Enrollment> enrolldata = new MyGenericList<>();
	
	try
	{	
				if(get_enrollinfo() != null){
					enrolldata = get_enrollinfo();
					
				}
				
				
			
				
		
		
		FileOutputStream FOS = new FileOutputStream("Enrollinfo.dat");
		
		



	
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					enrolldata.add(enroll,enroll.get_studentid(), enroll.get_CourseID());
                                        
				 
					
					
			
			SaveFile.writeObject(enrolldata); 
			
			
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

public static void save_Enrollment(MyGenericList<Enrollment> enroll) {

	MyGenericList<Enrollment> enrolldata = new MyGenericList<>();
	
	try
	{	
				if(get_enrollinfo() != null){
					enrolldata = get_enrollinfo();
					
				}
				
				
			
				
		
		
		FileOutputStream FOS = new FileOutputStream("Enrollinfo.dat");
		
		



	
		
		
		try { 
			ObjectOutputStream SaveFile = new ObjectOutputStream(FOS);
			
					
                                        
				 
					
					
			
			SaveFile.writeObject(enroll); 
			
			
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


public void displaystudent(){
		
		Node<T> theLink = first;
		student  stud= new student();
		// Start at the reference stored in firstLink and
		// keep getting the references stored in next for
		// every Link until next returns null
		
		while(theLink != null){
			
			
			stud = (student) theLink.value;
			System.out.println("Next Link: " + theLink.ID + "||Name "+ stud.get_name() );
			
			theLink = theLink.next;
			
			System.out.println("\n TEST\n");
			
		}
		
	}
	

public void display(){
	try{	
		Node<T> theLink = first;
		courseInformation  course= new courseInformation();
		// Start at the reference stored in firstLink and
		// keep getting the references stored in next for
		// every Link until next returns null
		
		while(theLink != null){
			
			
			course = (courseInformation) theLink.value;
			System.out.println("Next Link: " + theLink.ID + "||Name "+ course.get_Subject() );
			
			theLink = theLink.next;
			
			System.out.println("\n TEST\n");
			
		}
        }catch(Exception e){
            e.printStackTrace();
        }	
	}

public Node<T> removeLink(int ID){
		
		Node<T> currentLink = first;
		Node<T> previousLink = first;
		
		// Keep searching as long as a match isn't made
		
		while(currentLink.ID != ID){
			
			// Check if at the last Link in the LinkedList
			
			if(currentLink.next == null){
				
				// ID  not found so leave the method
				
				return null; 
				
			} else {
				
				// We checked here so let's look in the
				// next Link on the list
				
				previousLink = currentLink; 
				
				currentLink = currentLink.next;
				
			}
			
		}
		
		if(currentLink == first){
			
			// If you are here that means there was a match
			// in the reference stored in firstLink in the
			// LinkedList so just assign next to firstLink
			System.out.println("Delete");
			first = first.next;
			
		} else {
			
			// If you are here there was a match in a Link other 
			// than the firstLink. Assign the value of next for
			// the Link you want to delete to the Link that's 
			// next previously pointed to the reference to remove
			System.out.println("Delete");

			
			previousLink.next = currentLink.next;
			
		}
		
		return currentLink;
		
	}

// REPLACE 
public T ReplaceLink(int ID, T e1){
	
	Node<T> updatenode = new Node<T>();
	updatenode.value = e1;
	updatenode.ID = ID;
	Node<T> currentLink = first;
	Node<T> previousLink = first;
	
	// Keep searching as long as a match isn't made
	
	while(currentLink.ID != ID){
		
		// Check if at the last Link in the LinkedList
		
		if(currentLink.next == null){
			
			// ID  not found so leave the method
			
			return null; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
	
	if(currentLink == first){
		
		// If you are here that means there was a match
		// in the reference stored in firstLink in the
		// LinkedList so just assign next to firstLink
		System.out.println("replace");
		first = updatenode;
		first.next = currentLink.next;
		
		
		
	} else {
		
		// If you are here there was a match in a Link other 
		// than the firstLink. Assign the value of next for
		// the Link you want to delete to the Link that's 
		// next previously pointed to the reference to remove
		System.out.println("Replace");

		updatenode.next = currentLink.next;
		previousLink.next = updatenode;
		currentLink = previousLink.next;
	
		
	}
	
	return currentLink.value;
	
}

public boolean Get_SearchEditID(int ID){
	
       
       boolean sendback = false;
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
	
	// Keep searching as long as a match isn't made
	
	while(currentLink.ID != ID){
		
		// Check if at the last Link in the LinkedList
		
		if(currentLink.next == null){
			
			// ID  not found so leave the method
			
			return sendback; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
	
	if(currentLink == first){
		
		// If you are here that means there was a match
		// in the reference stored in firstLink in the
		// LinkedList so just assign next to firstLink
		
                sendback = true;
		return sendback;
		
		
	} else {
                sendback = true;
		return sendback;
		// If you are here there was a match in a Link other 
		// than the firstLink. Assign the value of next for
		// the Link you want to delete to the Link that's 
		// next previously pointed to the reference to remove
		

		
	
		
	}

}

public student GetEditID(int ID){
	
       
       T sendback = null;
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
	
	// Keep searching as long as a match isn't made
	
	while(currentLink.ID != ID){
		
		// Check if at the last Link in the LinkedList
		
		if(currentLink.next == null){
			
			// ID  not found so leave the method
			
			return null; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
	
	if(currentLink == first){
		
		// If you are here that means there was a match
		// in the reference stored in firstLink in the
		// LinkedList so just assign next to firstLink
		
                
		return (student) currentLink.value;
		
		
	} else {
		return (student) currentLink.value;
		// If you are here there was a match in a Link other 
		// than the firstLink. Assign the value of next for
		// the Link you want to delete to the Link that's 
		// next previously pointed to the reference to remove
		

		
	
		
	}
        
}


public Enrollment Get_EnrollmentSID(int ID){
	
       
       T sendback = null;
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
	
	// Keep searching as long as a match isn't made
	
	while(currentLink.ID != ID){
		
		// Check if at the last Link in the LinkedList
		
		if(currentLink.next == null){
			
			// ID  not found so leave the method
			
			return null; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
	
	if(currentLink == first){
		
		// If you are here that means there was a match
		// in the reference stored in firstLink in the
		// LinkedList so just assign next to firstLink
		
                
		return (Enrollment) currentLink.value;
		
		
	} else {
		return (Enrollment) currentLink.value;
		// If you are here there was a match in a Link other 
		// than the firstLink. Assign the value of next for
		// the Link you want to delete to the Link that's 
		// next previously pointed to the reference to remove
		

		
	
		
	}
        
}

public courseInformation Get_CourseEditID(int ID){
	
       
       T sendback = null;
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
	
	// Keep searching as long as a match isn't made
	
	while(currentLink.ID != ID){
		
		// Check if at the last Link in the LinkedList
		
		if(currentLink.next == null){
			
			// ID  not found so leave the method
			
			return null; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
	
	if(currentLink == first){
		
		// If you are here that means there was a match
		// in the reference stored in firstLink in the
		// LinkedList so just assign next to firstLink
		
                
		return (courseInformation) currentLink.value;
		
		
	} else {
		return (courseInformation) currentLink.value;
		// If you are here there was a match in a Link other 
		// than the firstLink. Assign the value of next for
		// the Link you want to delete to the Link that's 
		// next previously pointed to the reference to remove
		

		
	
		
	}
        
}


public boolean Get_CourseEditID_boolean(int ID){
	
       boolean valid = false;
       T sendback = null;
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
	
	// Keep searching as long as a match isn't made
	
	while(currentLink.ID != ID){
		
		// Check if at the last Link in the LinkedList
		
		if(currentLink.next == null){
			
			// ID  not found so leave the method
			
			return false; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
	
	if(currentLink == first){
		
		// If you are here that means there was a match
		// in the reference stored in firstLink in the
		// LinkedList so just assign next to firstLink
		
                
		return true;
		
		
	} else {
		return true;
		// If you are here there was a match in a Link other 
		// than the firstLink. Assign the value of next for
		// the Link you want to delete to the Link that's 
		// next previously pointed to the reference to remove
		

		
	
		
	}
        
}


public int Getnew_StudID(){
	
       int ID;
       T sendback = null;
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
         ID = currentLink.ID;
	
	// Keep searching as long as a match isn't made
	
	while(!(currentLink.ID > ID)){
		
		// Check if at the last Link in the LinkedList
		
		if(currentLink.next == null){
			
			// ID  not found so leave the method
                            ID++;
			return ID; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
	
	if(currentLink == first){
		
		// If you are here that means there was a match
		// in the reference stored in firstLink in the
		// LinkedList so just assign next to firstLink
		
                ID = currentLink.ID + 1;
		return ID;
		
		
	} else {
            
		ID = currentLink.ID +1;
		return ID;
		// If you are here there was a match in a Link other 
		// than the firstLink. Assign the value of next for
		// the Link you want to delete to the Link that's 
		// next previously pointed to the reference to remove
				
	}
}


public ArrayList<String> Fill_EnrollBox(){
           T sendback = null;
           ArrayList<String> SubjectList  = new ArrayList<>();
                   
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
         
	
	// Keep searching as long as a match isn't made
       /*
        if(currentLink == null){
            ID++;
            String SID = Integer.toString(ID);
			return SID; 
            
            
        }*/
        
	while(currentLink != null){
		
		// Check if at the last Link in the LinkedList
		
                  
                     courseInformation SubjCourse = new courseInformation();
                     SubjCourse =(courseInformation) currentLink.value;
                  
                            SubjectList.add(SubjCourse.get_Subject());
                        
                            for(int x = 0 ; x<SubjectList.size(); x++)
                            {
                                SubjectList.get(x);
                            }
                       
                  
                
		if(currentLink.next == null){
			
			
			return SubjectList; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
    return SubjectList;
}


public courseInformation Enroll_CourseID(String Subclass){
           T sendback = null;
           ArrayList<String> SubjectList  = new ArrayList<>();
           courseInformation Courseback= null;       
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
         
	
	// Keep searching as long as a match isn't made
       /*
        if(currentLink == null){
            ID++;
            String SID = Integer.toString(ID);
			return SID; 
            
            
        }*/
        
	while(currentLink != null){
		
		// Check if at the last Link in the LinkedList
		
                  
                     courseInformation SubjCourse ;
                     SubjCourse =(courseInformation) currentLink.value;
                  
                         if( Subclass.compareTo(SubjCourse.get_coursename())==0){
                                return SubjCourse;
                               
                             
                         } 
                        
                           
                       
                  
              
                
		if(currentLink.next == null){
			
			
			return Courseback; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
    return Courseback;
}


public ArrayList<String> Fill_EnrollClassnameBox(String Subclass){
           T sendback = null;
           ArrayList<String> SubjectList  = new ArrayList<>();
                   
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
         
	
	// Keep searching as long as a match isn't made
       /*
        if(currentLink == null){
            ID++;
            String SID = Integer.toString(ID);
			return SID; 
            
            
        }*/
        
	while(currentLink != null){
		
		// Check if at the last Link in the LinkedList
		
                  
                     courseInformation SubjCourse ;
                     SubjCourse =(courseInformation) currentLink.value;
                  
                         if( Subclass.compareTo(SubjCourse.get_Subject())==0){
                                SubjectList.add(SubjCourse.coursename);
                               
                             
                         } 
                        
                           
                       
                  
              
                
		if(currentLink.next == null){
			
			
			return SubjectList; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
    return SubjectList;
}


public String Getnew_CourseID(int ID){
	
       //int ID;
       T sendback = null;
	
	Node<T> currentLink = first;
	Node<T> previousLink = first;
         
	
	// Keep searching as long as a match isn't made
       /*
        if(currentLink == null){
            ID++;
            String SID = Integer.toString(ID);
			return SID; 
            
            
        }*/
        
	while(currentLink != null){
		
		// Check if at the last Link in the LinkedList
		
                        
                     if(currentLink.ID > ID && currentLink.ID < (ID+999))
                     {
                              ID = currentLink.ID ;
                             
                              
            
                      }
                
		if(currentLink.next == null){
			ID++ ;
                              String SID = Integer.toString(ID);
			
			return SID; 
			
		} else {
			
			// We checked here so let's look in the
			// next Link on the list
			
			previousLink = currentLink; 
			
			currentLink = currentLink.next;
			
		}
		
	}
	

        
	if(currentLink == first){
		
		// If you are here that means there was a match
		// in the reference stored in firstLink in the
		// LinkedList so just assign next to firstLink
		
                
		
	} else {
            
		
		// If you are here there was a match in a Link other 
		// than the firstLink. Assign the value of next for
		// the Link you want to delete to the Link that's 
		// next previously pointed to the reference to remove
				
	}
        
          ID++;
         String SID = Integer.toString(ID);
        return SID;
}


public Node<T> find(int ID){
	
	Node<T> theLink = first;
	int count = 0;
	
	if(!isEmpty()){
	
		while(theLink.ID != ID){
		
			// Checks if at the end of the LinkedList
		
			if(theLink.next == null){
			
				// Got to the end of the Links in LinkedList
				// without finding a match
			
				return null;
			
			} else {
			
				// Found a matching Link in the LinkedList
			
				theLink = theLink.next;
			
			}
		
			
			
		}
		
	} else {
		
		System.out.println("Empty LinkedList");
		
	}
	
	return theLink;
	
}

public boolean isEmpty(){
	
	return(first == null);
	
}
}