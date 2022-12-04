
public class StudentD {
	private String name;
	private String id; //RU
	private int age;
	private String sex;
	private String dept;
	private int year;
	StudentD(){
	}
	public  StudentD(String n,String id,int age, String sex,int yr,String dept)
	{
		name=n;
		this.id=id;
		this.age=age;
		this.sex=sex;
		this.dept=dept;
		year=yr;
	}

    StudentD(String id) {

    }

   
	public void setName(String name)
	{
            
		this.name=name;
	}
	public void setID(String id)
	{
		this.id=id;
	}
	
	public void setSex(String sex)
	{
           	this.sex=sex;
	}
	
	public void setdept(String dept)
	{
		this.dept=dept;
	}
	
	public void setAge(int age)
	{
            age=((age>0 && age<100)?age:0);
		this.age=age;
	}
	
	public void setYear(int yr)
	{
		year=yr;
	}
	public String getName()
	{
		return name;
	}
	public String getId()
	{
		return id;
	}

	public int getAge()
	{
		return age;
	}
	public String getSex()
	{
		return sex;
	}
	public int getYear()
	{
		return year;
	}
        public String getDept()
	{
		return dept;
	}
	
}
