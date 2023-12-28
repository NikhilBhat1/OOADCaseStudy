package com.ilp.utility;

import java.util.*;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.services.BankServices;

public class BankUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		char continueChoice;
		ArrayList<Services> allServices=new ArrayList<Services>();
		ArrayList<Product> allProducts=new ArrayList<Product>();
		ArrayList<Account> allAccounts=new ArrayList<Account>();
		
		Customer customer=null;
		
		do {
		int userChoice=mainMenu();
		boolean exit=false;
		switch(userChoice)
		{
		case 1:BankServices.createServices(allServices);
		
		break;
		case 2:BankServices.createProduct(allServices,allProducts);
		break;
		case 3:customer=BankServices.createCustomer(allProducts);
		break;
		case 4:BankServices.manageAccounts(customer);
		break;
		case 5:BankServices.displayCustomer(customer);
		break;
		case 6:
			exit=true;
			break;
		default:
			System.out.println("Invalid Choice");		
		}
		if(exit)
		{
			break;
		}
		System.out.println("Do you want to continue (y/n)");
		continueChoice=scanner.next().charAt(0);
		}while(continueChoice=='y');

}
	
	
	public static int mainMenu() {
		Scanner scanner=new Scanner(System.in);		
		int userChoice;	
		System.out.println("1 Create Services 2 Create Product 3 Create Customer 4 Manage Accounts 5 Display Customer 6 exit");
		userChoice=scanner.nextInt();		
		return userChoice;
		
	}

}
