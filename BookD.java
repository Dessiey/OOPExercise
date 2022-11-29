
public class BookD extends Object{
    private String bname;
    private String  bcode;
    private String bauthor;

public BookD()
{
bname=" ";
bcode=" ";
bauthor=" ";
}
public  BookD(String bname,String  bcode,String bauthor)
{
	this.bname=bname;
	this.bcode=bcode;
	this.bauthor=bauthor;
}
public void  setbname(String bname)
{
	this.bname=bname;
}
public void setbcode(String  bcode)
{
	this.bcode=bcode;
}
public void setauthor(String bauthor)
{
	this.bauthor=bauthor;
}

public String getbname()
{
	return bname;
}
public String  getbcode()
{
	return bcode;
}
public String getbauthor()
{
	return bauthor;
}

}
