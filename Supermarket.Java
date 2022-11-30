package supermarketmanagementsystem;
import java.util.Scanner;
 import java.util.*;
import javax.swing.JOptionPane;

public class SuperMarketManagementSystem {
    public interface Actions {
	void Admin_Menu();
	void Store_Product();
	void Modify_Product();
	void Display_All_Products();
	void Search_A_Specific_Product();
	void User_Menu();
	void Create_Reciept();
	
	final double VAT=0.15;
}
public static class Product implements Actions{
	String Product_Id;
	String Product_Name;
	double Price;
	int Amount;
	int Shelf_Number;
	int Row_Number;
	int Min_Stock_Level;
	
	//keyboard input object
	Scanner Accept=new Scanner(System.in);
	
	//ArrayList that stores objects.
	ArrayList <Product> Record= new ArrayList <Product>();
	Product p;
	
	//Constructors
	public Product() {		
	}
	public Product(String i,String n,double p,int a,int sn,int rn,int mst) {
		Product_Id=i;
		Product_Name=n;
		Price=p;
		Amount=a;
		Shelf_Number=sn;
		Row_Number=rn;
		Min_Stock_Level=mst;
	}

	//Administrative Privilege Methods
	public void Admin_Menu() {
            System.out.println("\t SUPER MARKET MANAGEMENT SYSTEM PROJECT");
           
		System.out.println("\n\t        Admin Menu choose 1");
		System.out.println("\t ------------------------");
		System.out.println("\t| 1) Store Product       |");
		System.out.println("\t| 2) Modify Product      |");
		System.out.println("\t| 3) Display All Product |");
		System.out.println("\t| 4) Search A Product    |");
		System.out.println("\t| 5) Change Password     |");
		System.out.println("\t| 6) LogOut              |");
		System.out.println("\t ------------------------");
		System.out.print("\t   What Is Your Choice:");
	}
	
	public void Store_Product() {
		String P_Id;
		String P_Name;
		double P;
		int A;
		int S_N;
		int R_N;
		int M_S_T;

                
			System.out.println("\n\t         Store Product");
			System.out.println("\t   ----------------------------");
			System.out.print("\t | Enter Product Id: ");
			P_Id=Accept.next();
			for (int i = 0; i < Record.size(); i++) {
				p=Record.get(i);
				if (P_Id.equals(p.Product_Id)) {
			System.out.println("\nError... Other Products Are Found By The Id "+P_Id);
					System.out.print("\n\t | Enter Product Id Again: ");
					P_Id=Accept.next();
				}
			}
			System.out.print("\t | Enter Product Name:");
			P_Name=Accept.next();			
			System.out.print("\t | Enter Unit Price:");
			P=Accept.nextDouble();
			System.out.print("\t | Enter Amounte Stored:");
			A=Accept.nextInt();
			System.out.print("\t | Enter Shelf Number:");
			S_N=Accept.nextInt();
			System.out.print("\t | Enter Row Number:");
			R_N=Accept.nextInt();
			System.out.print("\t | Set Minimum Stock Level:");
			M_S_T=Accept.nextInt();
			if (A<=M_S_T) {
	JOptionPane.showMessageDialog(null, "Minimum Stock Level Cannot Be Greater Than\n Or Equal To Amount Stored!");
		     System.out.print("\t | Set Minimum Stock Level Again:");
			M_S_T=Accept.nextInt();
			}
			System.out.println("\t |");
			System.out.println("\t | Product Successfully Created!");
			System.out.println("\t   ----------------------------");
			Record.add(new Product(P_Id,P_Name,P,A,S_N,R_N,M_S_T));
			System.out.print("\n Want More?(y/n): ");
			String yn=Accept.next();
            switch (yn) {
                case "y":
                case "Y":
                    Store_Product();
                    break;
                case "n":
                case "N":
                    System.out.println("\nExiting!...");
                    break;
                default:
                    System.out.println("\nError... Incorrect Input!");
                    break;
            }
	}
	
	public void Modify_Product(){
		String p_id;
		boolean found=false;
		System.out.print("\n Enter Product Id To Modify: ");
		p_id=Accept.next();
		for (int i = 0; i < Record.size(); i++) {
			p=Record.get(i);
			if (p_id.equals(p.Product_Id)) {
				found=true;
				System.out.println("\n\t         Product Modification");
				System.out.println("\t -------------------------------");
				System.out.print("\t| Enter New Product Id: ");
				String nw_p_id=Accept.next();	
				for (int j = 0; j < Record.size(); j++) {
					p=Record.get(j);
				if (p_id.equals(p.Product_Id)) {
				System.out.println("\nError... Other Products Are Found By The Id '"+nw_p_id+"'");
				System.out.print("\n\t| Enter Product Id Again: ");
					nw_p_id=Accept.next();
					}
				}
				p.Product_Id=nw_p_id;
				System.out.print("\t| Enter New Product Name: ");
				p.Product_Name=Accept.next();
				System.out.print("\t| Enter New Price: ");
				p.Price=Accept.nextDouble();
				System.out.print("\t| Enter New Product Amount: ");
				p.Amount=Accept.nextInt();
				System.out.print("\t| Enter New Shelf Number: ");
				p.Shelf_Number=Accept.nextInt();
				System.out.print("\t| Enter New Row Number: ");
				p.Row_Number=Accept.nextInt();
				System.out.print("\t| Enter New Stock Level: ");
				p.Min_Stock_Level=Accept.nextInt();
				if (p.Amount<=p.Min_Stock_Level) {
	JOptionPane.showMessageDialog(null, "Minimum Stock Level Cannot Be Greater Than\n Or Equal To Amount Stored!");
					System.out.print("\t| Set Minimum Stock Level Again:");
					p.Min_Stock_Level=Accept.nextInt();
				}
				System.out.println("\t|");
				System.out.println("\t| Product Successfully Updated!");
				System.out.println("\t -------------------------------");
			}
		}
		if (found==false) {
			System.out.println("\nError... Product Cannot Be Found!");
		}		
	}
	
        @Override
	public void Display_All_Products(){
		System.out.println("\n\t\t       Product Table");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Product Id"+"	"+"Product Name"+"	"+"Price"+"	"+"Amount"+"	"+"Shelf Number"+"	"+"Row Number");
		System.out.println("---------------------------------------------------------------------------------");
		for (int i = 0; i < Record.size() ; i++) {
			p=Record.get(i);
			System.out.println(p.Product_Id+"		"+p.Product_Name+"		"+p.Price+"	  "+p.Amount+"	    "+p.Shelf_Number+"	    	   "+p.Row_Number);
		}
	}
	
        @Override
	public void Search_A_Specific_Product(){
		String pr_id;
		boolean found=false;
		System.out.print("\nEnter Product Id To Search: ");
		pr_id=Accept.next();
		for (int i = 0; i < Record.size(); i++) {
			p=Record.get(i);
			if (pr_id.equals(p.Product_Id)) {
				found=true;
				System.out.println("\n\t         Search Result");
				System.out.println("\t -------------------------------");
				System.out.println("\t  Product Id: "+p.Product_Id);
				System.out.println("\t  Product Name: "+p.Product_Name);
				System.out.println("\t  Price: "+p.Price);
				System.out.println("\t  Amount In The Store: "+p.Amount);
				System.out.println("\t  Shelf Number: "+p.Shelf_Number);
				System.out.println("\t  Row Number: "+p.Row_Number);				
				System.out.println("\t -------------------------------");
			}
		}
		if (found==false) {
			System.out.println("\nError... Product Cannot Be Found!");
		}
	}	
	//User Privilege Methods
	public void User_Menu(){
		System.out.println("\n\t          User Menu");
		System.out.println("\t -------------------------------");
		System.out.println("\t| 1) Create Receipt             |");
		System.out.println("\t| 2) Display Product Table      |");
		System.out.println("\t| 3) Display A Specific Product |");
		System.out.println("\t| 4) LogOut                     |");
		System.out.println("\t -------------------------------");
		System.out.print("\t   What Is Your Choice:");
	}
	
	public void Create_Reciept(){
		
		String Sold_Product_Id;
		int Sold_Quantity;
                int Sold_Item;
		double total=0;
		boolean found=false;
		
		System.out.println("\n\t         Create Recept");
		System.out.println("\t -------------------------------");
		System.out.print("\t| Enter Number Of Items Sold: ");
		Sold_Item=Accept.nextInt();
		if (Sold_Item>Record.size()) {
	System.out.println("\nError... Sold Products Cannot Be Greater Than Items On Shelves!");
	System.out.print("\t| Enter Number Of Items Sold Again: ");
			Sold_Item=Accept.nextInt();
		}
		String []Name_Array=new String[Sold_Item];
		int []Quantity_Array=new int[Sold_Item];
		double  []Price_Array=new double[Sold_Item];
		
		while (Sold_Item>0) {
			System.out.print("\t| Enter Product Id: ");
			Sold_Product_Id=Accept.next();
			for (int j = 0; j < Record.size(); j++) {
				p=Record.get(j);
				if (Sold_Product_Id.equals(p.Product_Id)) {
					found=true;
					System.out.print("\t| Quantity: ");
					Sold_Quantity=Accept.nextInt();
					p.Amount=p.Amount-Sold_Quantity;
					total=total+(Sold_Quantity*p.Price);
					
					Name_Array[j]=p.Product_Name;
					Quantity_Array[j]=Sold_Quantity;
					Price_Array[j]=p.Price;
					
					//Depending On The Company's policy Minimum Stock Level Is Maintained
					if(p.Amount<=p.Min_Stock_Level){
                              JOptionPane.showMessageDialog(null, "Product Name: "+p.Product_Name+"\nProduct Id: "+p.Product_Id+"\nAmount: "+p.Amount+"\n\tReached Minimum Stock Level! ");
					}
				}//End of if
			}//End of for
			if (found==false) {
				System.out.println("\nError... Product Cannot Be Found!");
				System.out.println("\t -------------------------------");
			}
			else {
				Sold_Item--;
			} 
		}//End of while
		total=(total+(total*VAT));
		System.out.println("\n\t       INVOICE");
		System.out.println("---------------------------------------------");
		System.out.println("Product Name"+"	"+"Quantity"+"	"+"Unit Price");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < Name_Array.length; i++) {
			System.out.println(Name_Array[i]+"		"+Quantity_Array[i]+"		"+Price_Array[i]);
		}
		System.out.println("--------------------------");
		System.out.println("Total With VAT = "+total);
		System.out.println("--------------------------");
	}//End of Create_Reciept()
	
}//End of Product
        


public static void main(String[] args){
		String Password;
		String Password_For_Admin="admin";
		String Password_For_User="casher";
		int test=0;
		int ch;
		int ch2;
		
                      //Object For Input
                Scanner Input = new Scanner(System.in); {
                         
                 Product O=new Product(); //Object Of Product Class
                         
                         while(test==0){
                 System.out.println("\n\t User Authentication");
                System.out.print("Login: ");
                        //User Input
                             Password=Input.next();
                             
                             if(Password.equals(Password_For_Admin)){
                                 test=1;//Admin LoggedIn
                                 System.out.println("\nWelcome!\nLogIn = ADMIN");
                                 while(test==1){
                                     O.Admin_Menu();
                                     ch=Input.nextInt();
                                     switch(ch){
                                         case 1:
                                             O.Store_Product();
                                             break;
                                         case 2:
                                             O.Modify_Product();
                                             break;
                                         case 3:
                                             O.Display_All_Products();
                                             break;
                                         case 4:
                                             O.Search_A_Specific_Product();
                                             break;
                                         case 5:
                                             int choice;
                                             System.out.println("\n\t         Account Modification");
                                             System.out.println("\t -------------------------------");
                                             System.out.println("\t| 1) Admin ");
                                             System.out.println("\t| 2) User ");
                                             System.out.print("\t| Whice Account Do You Want To Modify: ");
                                             choice=Input.nextInt();
                                             System.out.println("\t -------------------------------");
                                     switch (choice) {
                                         case 1:
                                             {
                                                 System.out.print("\n Enter Old Password: ");
                                                 String PrPassword=Input.next();
                                                 if(PrPassword.equals(Password_For_Admin)){
                                                     System.out.print("\n Enter New Password: ");
                                                     Password_For_Admin=Input.next();
                                                     System.out.println("\n Password Successfully Changed!");
                                                 }
                                                 else{
                                                     System.out.print("\n Error...Incorrect Password\nExiting!... ");
                                                 }
                                                 break;
                                             }
                                         case 2:
                                             {
                                                 System.out.print("\n Enter Old Password: ");
                                                 String PrPassword=Input.next();
                                                 if(PrPassword.equals(Password_For_User)){
                                                     System.out.print("\n Enter New Password: ");
                                                     Password_For_User=Input.next();
                                                     System.out.println("\n Password Successfully Changed!");
                                                 }
                                                 else{
                                                     System.out.print("\n Error...Incorrect Password\nExiting!... ");
                                                 }
                                                 break;
                                             }
                                         default:
                                             System.out.println("\nError... Incorrect Choice!\nExiting... ");
                                             break;
                                     }
                                             break;
                                         case 6:
                                             test=0;
                                             break;
                                         default:
                                             System.out.println("\nError... Incorrect Choice!");
                                             break;
                                     }//End of switch
                                 }//End of while
                                 System.out.println("\nThanks You Have Successfully LoggedOut!");
                             }//End of if
                             else if(Password.equals(Password_For_User)){
                                 test=1;//User LogedIn
                                 System.out.println("\nWelcome!		LogIn Status = USER");
                                 while(test==1){
                                     O.User_Menu();
                                     ch2=Input.nextInt();
                                     switch(ch2){
                                         case 1:
                                             O.Create_Reciept();
                                             break;
                                         case 2:
                                             O.Display_All_Products();
                                             break;
                                         case 3:
                                             O.Search_A_Specific_Product();;
                                             break;
                                         case 4:
                                             test=0;
                                             break;
                                         default:
                                             System.out.println("\nError... Incorrect Choice!");
                                             break;
                                     }//End of switch
                                 }//End of while
                                 System.out.println("\nThanks You Have Successfully LoggedOut!");
                             }//End of else if
                             else{
                                 System.out.println("\nError... Incorrect Password!");
                             }
                         }//End of while
                     } //Object Of Product Class
	}//End of main()
}//End of MainClass

    


