package controller;
import java.io.*;
import java.sql.*;
import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;
public class Main 
{

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice,option;
		
		Login login=new Login();
		LoginDAO logindao=new LoginDAO();
		Product product=new Product();
		ProductDAO productdao=new ProductDAO();
		
		
		do
		{
			System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("________________");
			choice = Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1: System.out.println("________________");
			System.out.println("Enter the username");
			String username=br.readLine();
			System.out.println("Enter the password:");
			String  passsword=br.readLine();
			login.setUsername(username);
			login.setPassword(passsword);
			if(logindao.validate(login))
			{
				System.out.println("_________________");
				System.out.println("Login Successful");
				 
				do
				{
					System.out.println("________________");
					System.out.println("1.Add Product");
					System.out.println("2.Display Inverntory Details");
					System.out.println("3.Login");
					System.out.println("_________________");
					option=Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1: System.out.println("Enter the product id: ");
					int productId = Integer.parseInt(br.readLine());
					System.out.println("Enter the product name: ");
					String productname = br.readLine();
					System.out.println("Enter the min selling quantity: ");
					int minsell= Integer.parseInt(br.readLine());
					System.out.println("Enter the product price");
					int price= Integer.parseInt(br.readLine());
					System.out.println("Enter the product quantity");
					int quantity= Integer.parseInt(br.readLine());
					product.setProductName(productname);
					product.setProductId(productId);
					product.setMinSellQuantity(minsell);
					product.setPrice(price);
					product.setQuantity(quantity);
					
					productdao.addProduct(product);
					break;
					
					case 2:productdao.display();
					break;
					
					case 3: break;
					}
				}while(option!=3);
			}
			else
			{
				System.out.println("________________");
				System.out.println("Check your Username & Password");
			}
			break;
			
			case 2:System.out.println("_______________");
			System.out.println("Enter the username: ");
			String name=br.readLine();
			System.out.println("Enter the password: ");
			String pass=br.readLine();
			login.setUsername(name);
			login.setPassword(pass);
			if(logindao.validate(login))
			{
				System.out.println("_________________");
				System.out.println("Login Successful");
				
				do
				{
					System.out.println("________________");
					System.out.println("1.Show Inventory");
					System.out.println("2.Logout");
					System.out.println("_________________");
					option=Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1:productdao.display();
					break;
					
					case 2:break;
					}
				}while(option!=2);
			}
			}
		}while(choice!=3);
	}
}