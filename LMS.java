
import java.util.*;
public class LMS {
	private static int szs,szts,sztb,szb,c;
        private static int age,  year;
        private static boolean stb;
	private static  String idt,idb,name, sex, dept, id;
	   private static String bcodet,bcodeb,bname,bcode,bauthor;           
	static Scanner sc=new Scanner(System.in);  
        private static boolean tfs,tfb;
        //List<String> l=new ArrayList<String>();
        static List<StudentD> s = new LinkedList<StudentD>();
        static List<BookD> b = new LinkedList<BookD>();
        
        
	public static void main(String[] args) 
	{
             
         MyMenu m= new MyMenu();
         while(c!=11)
		{
	         switch(c)
			{
		     case 1:
		    	 m.menus();
                         String a=sc.nextLine();
	                c=Integer.parseInt(a);	
                         switch(c)
                         {
                             case 1:
                                shows(); 
                                 break;
                             case 2:
                                 showstb();
                                  
            // showstb()
          //showtb()
                                 break;
                         }
		        break;
		     case 2:
		       	m.menub();
                        a=sc.nextLine();
	                c=Integer.parseInt(a);	
                         switch(c){
                             case 1:
                             showbl();
                                 break;
                             case 2:
                                showtb();
                                 break;
                         }
		     break;
                     case 3:
                     m.menuA();
                      a=sc.nextLine();
	                c=Integer.parseInt(a);	 
                         switch(c)
                         {
                             case 1:
                                adds();
                                 break;
                             case 2:
                                addb();
                                 break;
                             case 3:
                               //  giveb1(id);
                                // giveB(bcode);
                                 giveb(id,bcode);
                                 break;
                             case 4:
  
                                 SearchB(bcode);
                                 break;
                             case 5:
                                  SearchS(id);
                                 break;
                             case 6:
                                  RemoveS(id);
                                 break;
                             case 7:
                                 RemoveB(bcode);
                                 break;
                             case 8:
                                 ReturnB();
                                 break;
                            case 9:
                                ShowTakenBookDetail();
                                break;
                            case 10:
                                GroupName();
                                break;
                         }
                     break;
		     default :
                         break;
		    }
			m.menu();
                        String a=sc.nextLine();
	                c=Integer.parseInt(a);	
		}
	}
	
	
	public static void  adds()
	{

	                System.out.println(" We are about to Enters new Student\n************************************************************");
	                System.out.println("Enters a Name");
			name=sc.nextLine();
			System.out.println("Enters ID");
			id=sc.nextLine();
			System.out.println("Entera age");
			//age=sc.nextLine();
                         String ag=sc.nextLine();
	                 age=Integer.parseInt(ag);	
                       // age=sc.nextInt();
			System.out.println("Enter sex");
			sex=sc.nextLine();
			System.out.println("Enter year");
                        String yr=sc.nextLine();
	                 year=Integer.parseInt(yr);
			//year=sc.nextInt();
	         	System.out.println("Enter deprtiment");
			dept=sc.nextLine();
			StudentD stud = new StudentD(name,id,age,sex,year,dept);
			s.add(stud);
			szs=s.size();
		 	
	}
	public static void shows()
	{
		tfs=s.isEmpty();
                if(tfs==true)
                        {
                            System.out.println("::::::::Is Empty list::::::::");
                    	 }
                else
                {
                    System.out.println("Name\tID\tage\tSex\tYear\tdepratement ");
                    for(StudentD s1:s)
			System.out.println(s1.getName()+"\t"+s1.getId()+"\t"+s1.getAge()+"\t"+s1.getSex()+"\t"+s1.getYear()+"\t"+s1.getDept());	
                       
                     System.out.println("Toatal Sudent = "+szs+"\n");
                }
	}
        public static void GroupName()
        {
            System.out.println(" Group Name   \t\tID");
            System.out.println("BAYISA CHAMADA.............RU0639/10");
            System.out.println("Ararso Olkeba..............RU0627/10");
            System.out.println("Alaka Beresa ..............RU0618/10");
            System.out.println("  Guluma Abera ............RU");
            System.out.println(" Biniyam  Alemayo............RU");
            
        }
		
  public static void SearchS(String id)
  {
      		System.out.println("Enters ID to Search");
                id=sc.nextLine();       
               for (StudentD s1:s)
               {
                       if (id.equals(s1.getId()))
        {
         System.out.println("Name\tID\tage\tSex\tYear\tdepratement ");   
        System.out.println(s1.getName()+"\t"+s1.getId()+"\t"+s1.getAge()+"\t"+s1.getSex()+"\t"+s1.getYear()+"\t"+s1.getDept());	
        }      
              else
            {
             System.out.println("\nNot have such Id...\n");   
            }
        
            }       
       
  }
  
          
  public static void SearchB(String bcode)
  {
                System.out.println("Enters Book Code");
                bcode=sc.nextLine();       
                //if(b.contains(bcode))
                
                for(BookD b1:b)
                      if (bcode.equals(b1.getbcode()))
                      {
                         System.out.println("Name\tAuthor\tCode");
	    		System.out.println(b1.getbname()+"\t"+b1.getbauthor()+"\t"+b1.getbcode()); 
                      }
                     
                
                     else
                      {
                          System.out.println("Not Have Such Kind of book Code....");
                      }                          
	    	  
  }
  
    public static void showtb()
     {//stb
         if(bcodet==null)
         {
                     System.out.println("We Haven't Issued any Book!!! ");        
         }
         else
         {
      for(BookD b1:b)
             if( bcodet==b1.getbcode())
             {
                System.out.println("Name\tAuthor\tCode");
   		System.out.println(b1.getbname()+"\t"+b1.getbauthor()+"\t"+b1.getbcode());
                
                System.out.println("Total Taken Book...... "+sztb);
             }
             
         }
           
     }
     
  public static void giveb(String id,String bcode)
  {
     
             System.out.println("Enters ID to Give Book");
                id=sc.nextLine();       
                
                  for (StudentD s1:s)
                      
                       if (id.equals(s1.getId()))
                       {
                                          idt=s1.getId();
                                          szts++;
                                          idb=s1.getId();
                  System.out.println("Enters Book Code .....");
                  bcode=sc.nextLine();       
                  for(BookD b1:b)
                      if (bcode.equals(b1.getbcode()))
                      {
                          bcodet=b1.getbcode();
                           sztb++;
                           szb--;
                           System.out.println("Book is Successfully Issued...");
                      }
                     
                       }
                        
                       else
                       {
                                System.out.println("Not have such Id");
      
                       }
                           
      
      
  }
  
  public static void ReturnB()
  {

                System.out.println("Enters Student ID ");
                id=sc.nextLine();      
                if(idb==id)
                {
                    szts--;
                    System.out.println("Enter Book Code... ");
                    bcode=sc.nextLine();
                    if(bcodeb==bcode)
                    szb++;    
                }
                else
                {
                    System.out.println("Invalid Opretion.......");
          
                }
                    
  }
  
  
    public static void showstb() //show 
    {
            
            if(idt==null)
            {
                 System.out.println("No Student Had Taken Book !!! ");  
            }
            else
            {
               for(StudentD s1:s)
               {
             if(idt==s1.getId())
             {
                  System.out.println("\t\tlist of Student Took Book");
            System.out.println("\t\t******************************");
                System.out.println("Name\tID\tage\tSex\tYear\tdepratement ");   
                System.out.println(s1.getName()+"\t"+s1.getId()+"\t"+s1.getAge()+"\t"+s1.getSex()+"\t"+s1.getYear()+"\t"+s1.getDept());	
                System.out.println("Tolat Student Taken Book....."+szts);
             }
                  
             }  
            }
       
    }
	public static void  addb()
    {
          	System.out.println(" We are about to Enters new BOOK.......");
                System.out.println("\t\t******************************");
		System.out.println("Enters  BooK Name");
                bname=sc.nextLine();
                System.out.println("Enters  BooK code");
                bcode=sc.nextLine();
        	System.out.println("Enters  BooK Author");
                bauthor=sc.nextLine();
                BookD bo=new BookD(bname,bcode,bauthor);
                b.add(bo);
                szb=b.size();
                
    }
 
  public static void RemoveS(String id)
  {
      
       	System.out.println("Enters Student ID to delete...");
                id=sc.nextLine();      
              for (StudentD s1:s)
              { 
               if (id.equals(s1.getId()))
               {
                s.remove(s1);
                szs--;
                System.out.println("Student Information is deleted !! ");
               }
                else
               {
                   System.out.println("Not Have such kind of ID... ");
               }
              }   
                
                 
  }
  public static void ShowTakenBookDetail()
  {
      
      System.out.println("\t\tList Of Student Taken Book   ");
      System.out.println("\t\t******************************");
         for(StudentD s1:s)
             if(idt==s1.getId())
             {
                System.out.print("Name\tID\tage\tSex\tYear\tdepratement "); 
                System.out.println("\tName\tAuthor\tCode");
                System.out.print(s1.getName()+"\t"+s1.getId()+"\t"+s1.getAge()+"\t"+s1.getSex()+"\t"+s1.getYear()+"\t"+s1.getDept());	
               
             }
             
             
             for(BookD b1:b)
             if( bcodet==b1.getbcode())
             {
             
   		System.out.print("\t\t"+b1.getbname()+"\t"+b1.getbauthor()+"\t"+b1.getbcode()+"\n");
                System.out.println("Toatl Taken Book        = "+sztb);
                System.out.println("Tolat Student TAke Book = "+szts);
                 
             }
            /*
               else
             {
             System.out.println("Not Have Such ID Numbers ");     
            
             }
             
      */
      
      
      
  }
  public static void RemoveB(String bcode)
  {
                      System.out.println("Enters Book Code to delete");
                bcode=sc.nextLine();       
          
                for(BookD b1:b)
                {   
                    if (bcode.equals(b1.getbcode()))
                    {
                          b.remove(b1); 
                          szb--;
                          System.out.println("Book are deleted...");
                    }
                    
                     else
                    {
                    System.out.println("Not have such Kind of Book code.....") ; 
                    
                    }
                   }
                
                    
  }
  
	public static void showbl()
	{
	    System.out.println("\n\t\tList Book \n ************************************");
            tfb=b.isEmpty();
            if(tfb==true)
            
                System.out.println("::::No Book Yet...");
            
            else
            
                System.out.println("Name\tAuthor\tCode");
	    	
	    		for(BookD b1:b)
	    		System.out.println(b1.getbname()+"\t"+b1.getbauthor()+"\t"+b1.getbcode());	
	    	 System.out.println("\nToatal Book = "+szb+"\n");
              
	    	
	}
       
       
}
           