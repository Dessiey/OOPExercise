package school1;
public class Student1 {
    
    double avg;
    int rank;
      int cntsub;
      String fname,lname,gender;
      int age;
      Subject1 sb[]=new Subject1[10];
      void setSubject(String sname)
      {
         sb[cntsub]=new Subject1();
         sb[cntsub].name=sname;
         cntsub++;
      }
      void stdisplay()
      {
          System.out.println(fname+"\t"+lname+"\t\t"+gender+"\t"+age);
      }
}
