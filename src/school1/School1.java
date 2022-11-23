package school1;
/*
SCHOOL MANAGEMENT SYSTEM
GROUP MEMBERS
1.ABDU SEID
2.ABEBAW WALELGN
3.AYCHELUKEM MOGES
4.CHALTU ABDU
5.EDEN ATOMSA
6.TEMESGEN ZELALEM
*/
import java.util.Scanner;
abstract class school
{
    abstract void registrar();
    abstract void admin();
    abstract void Teacher();
    abstract void student();
}
public class School1 extends  school{
  String SchoolName=" PRIMARY SCHOOL" ;
    static Grade1 g[]=new Grade1[8];
    School1()
    { for(int i=0;i<8;i++)
            g[i]=new Grade1();    
    }
    void registrar()
    {
          Scanner sc=new Scanner(System.in);
         String fname,lname,gend;
         int age,choice;
         while(true)
         {
             System.out.println("\tEnter 1 to register a student\n\tEnter 2 to dispaly"
                     + "\n\tEnter 3 to search a student\n\tEnter 0 to exit");
             System.out.println("Enter your choice");
             choice=sc.nextInt();
             sc.nextLine();
             switch(choice)
             {
                 case 1:
                     System.out.println("Enter no of students to register");
                     int n=sc.nextInt();
                      sc.nextLine();
                      for(int i=0;i<n;i++){
                     System.out.println("Enter first name");
                     fname= sc.nextLine();
                     System.out.println("Enter last name");
                     lname= sc.nextLine();
                     System.out.println("Enter gender");
                     gend= sc.nextLine();
                     System.out.println("Enter age");
                     age=sc.nextInt();
                     sc.nextLine();
                     System.out.println("Enter grade level");
                     choice=sc.nextInt();
                     sc.nextLine();
                     g[choice-1].registration(fname, lname, gend, age);
                    //call sort from class grade
                     g[choice-1].sortStudent();
                     System.out.println("Student is successfully registered");
                      }
                 System.out.println("------------------\nPress enter to continue...");   
                     sc.nextLine();
                     break;
                 case 2:
                     System.out.println("Enter student grade");
                    choice=sc.nextInt();
                     sc.nextLine();
                     System.out.println("The students in grade "+choice+" are..");
                     ///call dispalystud from grade class
                     g[choice-1].displayStud();
                     System.out.println("------------------\nPress enter to continue...");   
                     sc.nextLine();
                     break;
                 case 3: 
                     System.out.println("which grade do you want to search..?");
                     choice=sc.nextInt();
                      sc.nextLine();
                    System.out.print("Enter name of Student:");
                    String snme = sc.nextLine();
                     //cassl searchstud from class grade
                      g[choice-1].searchStud(snme);
                     System.out.println("------------------\nPress enter to continue...");   
                     sc.nextLine();
                     break;
                 case 0:
                     return;
                     default:
                    System.out.println("incorrect choice!!!");
                    break;
             }
         }
    }
    void admin()
    {
        Scanner sc=new Scanner(System.in);
        int choice;
        while(true)
        {
            System.out.println("\tEnter 1 to Insert Subjects for each Grade\n\t\tEnter 2 to displaysubject\n"
                    + "\tEnter 3 to assign a teacher for the class\n\tEnter 4 to display a teacher\n\tEnter 0 to exit");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.println("Insert for grade ");
                    choice=sc.nextInt();
                    System.out.println("how many subjects do the grade learn");
                    int n=sc.nextInt();
                    sc.nextLine();
                    String s;     
                    for(int i=0;i<n;i++)
                    {
                        System.out.println("Enter the name of"+(i+1)+"subject");
                         s= sc.nextLine();
                        g[choice-1].insertSubj(s);
                    }
                     System.out.println("------------------\nPress enter to continue...");   
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("dispaly subjects for grade");
                    choice=sc.nextInt();
                    sc.nextLine();
                    System.out.println("the subject of grade"+choice+"is\n---->");
                    //call dispaly  subjects from class grade
                    g[choice-1].displaySub();
                    System.out.println("------------------\nPress enter to continue...");   
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("assign a teacher for grade---");
                    choice=sc.nextInt();
                      sc.nextLine();
                    System.out.println("how many teachers this grade want");
                    int t=sc.nextInt();
                      sc.nextLine();
                     for(int i=0;i<t;i++){
                         System.out.println("enter the name of the "+(i+1)+"teacher");
                         s=sc.nextLine();
                         System.out.println("enter the ID of the teacher");
                         String id=sc.nextLine();
                         System.out.println("which subject do the teacher teach");
                         //call dispaly  subjects from class grade
                          g[choice-1].displaySub();
                         System.out.println("enter your choice");
                         int sub=sc.nextInt();
                         sc.nextLine();
                         g[choice-1].techReg(s, id,g[choice-1].sub[sub-1].name);
                     }
                     System.out.println("------------------\nPress enter to continue...");   
                         sc.nextLine();
                     break;
                         case 4:
                         System.out.println("display teacher of grade ");
                             choice=sc.nextInt();
                             sc.nextLine();
                             System.out.println("Teachers of grade"+choice+"are");
                             //call display teacher from class grade
                             g[choice-1].dispTeacher();
                             System.out.println("------------------\nPress enter to continue...");   
                         sc.nextLine();
                             break;
                         case 0:
                            return;
                         default:
                             System.out.println("Incorrect option");
                             break;  }  
            }
        }       
    void Teacher()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter grade of the student");
        int grade=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your name");
        String name=sc.nextLine();
        System.out.println("Enter your id");
        String Id=sc.nextLine();
        //call search teacher from teacher class
        if(g[grade-1].searchTeach(name, Id))
        {
            while(true)
        {
            System.out.println("\tEnter 1 to enter mark\n\tEnter 2 to release mark of students\n"
                    + "\tEnter 3 prepare roster\n\tEnter 4 to enter mark of single student\n\tEnter 0 to exit ");
            System.out.println("Enter your choice");
         int choice=sc.nextInt();
         sc.nextLine();
         switch(choice)
         {
             case 0:
                 return;
             case 1:
                 g[choice-1].displayStud();
                 System.out.println("Enter number of subject");
                 int subnum=sc.nextInt();
                 sc.nextLine();
            //call enter mark subject from class grade
                 g[choice-1].insertMark(subnum-1);
                 break;
             case 2:
                System.out.println("Enter grade of student");
                  choice=sc.nextInt();
                  g[choice-1].displaySub();
                  System.out.println("Enter your choice");
                  subnum=sc.nextInt();                 
                  //call suject mark from class grade
                  g[choice-1].subMark(subnum-1);
                break;
             case 3:
                 System.out.println("Enter grade of the student");
                 choice=sc.nextInt();
                 //call roster from class grade
                 g[choice-1].studRoster();
                 break;
             case 4:
                 System.out.println("Enter grade");
                 choice=sc.nextInt();
                 System.out.println("Enter class number");
                 int no=sc.nextInt();
                 g[choice-1].st[no-1].stdisplay();
                 //call display sub from class grade
               g[choice-1].displaySub();
                 System.out.println("Enter your choice");
                 subnum=sc.nextInt();
                System.out.println("previos mark: "+g[choice-1].st[no-1].sb[subnum].mark);
                System.out.println("Enter new mark:");
                g[choice-1].st[no-1].sb[subnum].mark=sc.nextDouble();
                System.out.println("press enter to continue");
                sc.nextLine();
                 break;
             default:
                 System.out.println("Incorrect choice");
        }
        }  
    }
    }
    void student()
    {
        Scanner sc = new Scanner(System.in);
       int choice;
       while(true)
       {
           System.out.println("\tEnter 1 to view result\n\tEnter 0 to exit");
             System.out.println("Enter your choice");
             choice=sc.nextInt();
             sc.nextLine();
             switch(choice)
             {
                 case 1:
                     System.out.println("Enter your garde");
                     choice=sc.nextInt();
                     sc.nextLine();
                     System.out.println("Enter your number");
                     int cnum=sc.nextInt();
                     sc.nextLine();
                     System.out.println("\t\t"+SchoolName+"\n------------------\nSTUDENT DETAIL.........");
                     //call stud detail from class grade
                   g[choice-1].studDetail(cnum);
                     System.out.println("------------------\nPress enter to continue...");   
                    sc.nextLine();
                 case 0:
                     return;
             }
       }
    }
    public static void main(String[] args) {
      
        Scanner sc= new Scanner(System.in);
        School1 s=new School1();
        System.out.println("SCHOOL MANAGEMENT SYSTEM");
        while(true)
        { 
             String c;
          System.out.println("\t1->For registrar\n\t2->For Adminstrator\n\t3->For Teacher\n\t4->For Student\n\t0->To close the Program\n\n");
            System.out.print("Enter your Choice:");
            c = sc.next();
            switch (c) {
                case "1":
                    s.registrar();
                    break;
                case "2":
                    s.admin();
                    break;
                case "3":
                    s.Teacher();
                    break;
                case "4":
                    s.student();
                    break;
                case "0":
                    System.out.println("The program is terminated");
                    System.exit(1);
                default:
                System.out.println("invalid input!!!!");
            }
        }   
    }
}
