package school1;
import java.util.Scanner;
public class Grade1 {
    int numOfSub;
    int numOfStud;
    int numOfTeach;
    Teacher1[] t=new Teacher1[20];
    Subject1[] sub=new Subject1[10];
    Student1[] st=new Student1[50];
    void sortteacher(){
    for (int i = 0; i < numOfTeach; i++) {
            for (int j = 0; j < numOfTeach - 1; j++) {
                if (t[j].name.compareToIgnoreCase(t[j + 1].name) > 0) {
                    Teacher1 temp = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = temp;
                }
            }
        }
    }
    void sortsubject() {
        for (int i = 0; i < numOfSub; i++) {
            for (int j = 0; j < numOfSub - 1; j++) {
                if (sub[j].name.compareToIgnoreCase(sub[j + 1].name) > 0) {
                    Subject1 temp = sub[j];
                    sub[j] = sub[j + 1];
                    sub[j + 1] = temp;
                }
            }
        }
    }
    void sortStudent() {
        for (int i = 0; i < numOfStud; i++) {
            for (int j = 0; j < numOfStud - 1; j++) {
                if (st[j].fname.compareToIgnoreCase(st[j + 1].fname) > 0) {
                    Student1 temp = st[j];
                    st[j] = st[j + 1];
                    st[j + 1] = temp;
                } else if (st[j].fname.compareToIgnoreCase(st[j + 1].fname) ==0) {
                    if (st[j].lname.compareToIgnoreCase(st[j + 1].lname) > 0) {
                        Student1 temp = st[j];
                        st[j] = st[j + 1];
                        st[j + 1] = temp;
                    }
                }
            }
        }
    }
    void studDetail(int rn)
    {
        double total=0.0;
        for(int i=0;i<numOfStud;i++)
        {
            if(i==rn-1)
            System.out.println("\tFName \tLname\t Gender\tAge");
            System.out.println(st[i].fname+"\t"+st[i].lname+"\t"+st[i].gender+"\t"+st[i].age);
            System.out.println("---------------------------------------------------------");
            System.out.println("\tSubject\t\tMark");
            for (int j = 0; j < numOfSub; j++) {
                    System.out.print(j + 1 + ". ");
                    total += st[i].sb[j].mark;
                    st[i].sb[j].display();}               
                System.out.println("\t\tTotal => " + total);
                System.out.println("\nAverage=> " + st[i].avg);
                System.out.println("RANK=> "+st[i].rank);
        }  
    }
    boolean searchTeach(String n,String i)
    {
      for(int j=0;j<numOfTeach;j++)
      {
          if(t[j].name.compareToIgnoreCase(n)==0&&t[j].id.compareToIgnoreCase(i)==0)
          {
              return true;
          }  
      }
          return false;
    }
    void dispTeacher()
    {
     System.out.println("The teachers name-->");
        for(int i=0;i<numOfTeach;i++)
        {
            t[i].display();
        }
    }
    void techReg(String tname,String ID,String sub)
    {
        t[numOfTeach]=new Teacher1();
        t[numOfTeach].name=tname;
        t[numOfTeach].id=ID;
        t[numOfTeach].subject=sub;
        numOfTeach++;
        sortteacher();    
    }
    void displaySub()
    {
        System.out.println("The subjects are-->");
        for(int i=0;i<numOfSub;i++)
            System.out.println(i+1+ "->"+sub[i].name);
        //sub[i].display
    }
    void insertSubj(String subj)
    {
        sub[numOfSub]=new Subject1();
        sub[numOfSub].name=subj;
        numOfSub++;
        //assign subjects to the grade using loop
        for (int i = 0; i <numOfStud; i++) {
            st[i].setSubject(subj); 
    }
    }
    void searchStud(String name)
    {
     for(int i=0;i<numOfStud;i++)
     {
        if(st[i].fname.compareToIgnoreCase(name)==0) 
        {
           st[i].stdisplay();
        }
     }
    }
    void registration(String fn,String ln,String g,int ag)
    {
        st[numOfStud]=new Student1();
        st[numOfStud].fname=fn;
        st[numOfStud].lname=ln;
        st[numOfStud].gender=g;
        st[numOfStud].age=ag;
        //assign subject to the students
          for (int i = 0; i < numOfSub; i++) {
            st[numOfStud].setSubject((sub[i].name));  
    }
          numOfStud++; 
    }
    void displayStud()
    {
        System.out.println("----------------------------");
       System.out.println("The students are-->");
        for(int i=0;i<numOfStud;i++)
        {
            System.out.println(i+1+" ");
            //+sub[i].name);
            st[i].stdisplay();
        } 
        System.out.println("----------------------------");
    }
    void rank()
    {
        double[] temp=new double[numOfStud];
        for(int i=0;i<numOfStud;i++)
        {
          temp[i]=st[i].avg;
        }
        for(int i=0;i<numOfStud;i++)
        {
            for(int j=0;j<numOfStud;j++)
            {
                if(temp[j]<temp[j+1])
                {double temp1=temp[j];
                temp[j]=temp[j+1];
                temp[j+1]=temp1;
                }
            }
        }
        for(int i=0;i<numOfStud;i++)
        {
            for(int j=0;j<numOfStud;j++)
            {
                if(temp[i]==st[j].avg&&st[j].rank==0)
                {
                    st[i].rank=i+1;
                }
            }
        }
    }  
    void studRoster()
    {
        double total;
        for(int i=0;i<numOfStud;i++)
        {
             total=0;
             for (int j = 0; j < numOfSub; j++) {
                 total += st[i].sb[j].mark;
             }
              st[i].avg=total/numOfSub;
         }
        //call rank
        rank();
        System.out.println(" ----------------------------------------------------------\n");
        System.out.print("Name   \t Fathername\tAge\t");
        for (int j = 0; j < numOfSub; j++) {
            System.out.print(sub[j].name + "\t");
        }
        System.out.println("Total\tAver\t Rank");
        for (int i = 0; i < numOfStud; i++) {
             total = 0;
            System.out.print((i + 1) + ". " + st[i].fname + "\t" + st[i].lname + "\t" + st[i].age + "\t");
            for (int j = 0; j < numOfSub; j++) {
                System.out.print(st[i].sb[j].mark + "\t");
                total += st[i].sb[j].mark;
            }
           
            System.out.println(total + "\t" + st[i].avg+"\t"+st[i].rank);//rank()
        }
    }
    void subMark(int n)
    {
        //mark of a single subject but for all students
        System.out.println("\n\tName\t\tfname\t\tgender\t\tage"
                + sub[n].name);
        for(int i=0;i<numOfStud;i++)
        {
            System.out.println(i+1+"."+st[i].fname+"\t\t"+st[i].lname
                    +"\t\t"+st[i].gender+"\t\t"+st[i].age+"\t\t"+st[i].sb[n].mark);  
        }
    }
    void insertMark( int m)
    {
     Scanner sc=new Scanner(System.in);
        System.out.println("Enserting mark of students...."
                + "\n\tSubject name"+st[0].sb[m].name);
        for(int i=0;i<numOfSub;i++)
        {
            System.out.print("Enter mark of  "+st[i].fname+" : ");
          st[i].sb[m].mark=sc.nextDouble();
        }
    }   
}
