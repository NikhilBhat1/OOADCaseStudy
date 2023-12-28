package com.ilp.services;

import java.util.*;

import com.ilp.entity.*;

public class AccountServices {
	public static void createServices(ArrayList<Services> allServices)
	{   int flag=0;
		Services service=new Services();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the Service Code");
		String serviceCode=scanner.next();
		service.setServiceCode(serviceCode); 
		System.out.println("Enter the Service Name");
		service.setServiceName(scanner.next());
		System.out.println("Enter the Rate");
		service.setRate(scanner.nextDouble());
		for(Services ser:allServices) {			
			if(ser.getServiceCode().compareToIgnoreCase(serviceCode)==0)
			{				
				flag=1;
				break;
			}
			else {			
				flag=0;
			}
		}				
		if (flag==1)
		{
			System.out.println("Service already exists");
		}
		else {
		
			allServices.add(service);
			System.out.println("Service Created");
		}
		System.out.println(service);		
	}
	
	
	public static void createProduct(ArrayList<Services> allServices,ArrayList<Product> allProducts) {
		Scanner scanner=new Scanner(System.in);
		char addProductChoice;		
		char serviceChoice;
		do {			
			System.out.println("Enter the Product Code");
			String productCode=scanner.next();
			System.out.println("Enter the Product Name");
			String productName=scanner.next();
			int allServicesLength=allServices.size();		
			ArrayList<Services> productServices=new ArrayList<>();
			do {				
			System.out.println("Select the Service from below List");
			int index=1;
				for(Services service:allServices) {
					System.out.println(index+" "+service.getServiceName());	
					index++;
				}
				System.out.println("Select the Service");
				int serviceItemChoice=scanner.nextInt();
				productServices.add(allServices.get(serviceItemChoice-1));
				System.out.println("Do you want to add another service (y/n)");
				serviceChoice= scanner.next().charAt(0);
			}while(serviceChoice=='y');			
				switch(productName) {
				case "SavingsMaxAccount":
					SavingMaxAccount savingsMaxAccount=new SavingMaxAccount(productCode,productName,productServices,1000.0);
					allProducts.add(savingsMaxAccount);
					break;
				case "LoanAccount":
					LoanAccount loanAccount=new LoanAccount(productCode,productName,productServices,true);
					allProducts.add(loanAccount);					
					break;
				case "CurrentAccount":
					CurrentAccount currentAccount=new CurrentAccount(productCode,productName,productServices);
					allProducts.add(currentAccount);
					break;
				}
				for (Product product : allProducts) {
					System.out.println(product);
				}
			System.out.println("Do you want to add another product (y/n)");
			addProductChoice = scanner.next().charAt(0);
		}while(addProductChoice=='y');
		
	}
	
	
	public static Customer createCustomer(ArrayList<Product> allProducts)
	{			
			Scanner scanner = new Scanner(System.in);			
			System.out.println("Enter Customer Code :");
			String customerCode = scanner.nextLine();			
			System.out.println("Enter Customer Name :");
			String customerName = scanner.nextLine();			
			ArrayList<Account> accountList = new ArrayList<Account>();
			char multipleAccountChoice='y';
			do {
				Product product = null;
				System.out.println("Enter Account Number :");
				String accountNo = scanner.next();				
				System.out.println("Enter Account Type :");
				String accountType = scanner.next();				
				System.out.println("Enter Balance:");
				double balance = scanner.nextDouble();			
				for(Product productItem: allProducts) {
					System.out.println(productItem.getProductName());
				}
				System.out.println("Product Choice :");
				String selectedProduct = scanner.next();				
				for(Product productItem: allProducts) {
					if(selectedProduct.equalsIgnoreCase(productItem.getProductName())) {
						product = productItem;
					}
				}					
			    Account account = new Account(accountNo, accountType, balance, product);
			    accountList.add(account);				
				System.out.println("Do you want to create another account? (y/n)");
				multipleAccountChoice = scanner.next().charAt(0);
			}while(multipleAccountChoice == 'y');			
			Customer customer = new Customer(customerCode, customerName, accountList);		    
		    return customer;			
		}
	 

	 		
	public static void manageAccounts(Customer customer)
	{  
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer id ");
		String custId=scanner.next();
		if(custId.equals(customer.getCustomerCode()))
		{
			displayCustomerAccounts(customer);
			System.out.println("choose your account");
			String userAccountChoice=scanner.next();
			Account selectedAccount = null;
			for(Account account : customer.getAccounts()) {
				if(account.getAccountType().equals(userAccountChoice)) {
					selectedAccount = account;
				}
			}		
			System.out.println("choose the service \n1 withdraw \n2 deposit \n3 check balance");
			int userServiceChoice=scanner.nextInt();
			switch(userServiceChoice)
			{
			case 1:
				System.out.println("Enter the amount you want to withdraw");
				double withdraw=scanner.nextDouble();
				switch(userAccountChoice)
				{
				case "SavingsMaxAccount":
					if(selectedAccount.getAccountBalance()-withdraw >= 1000) {
						selectedAccount.setAccountBalance(selectedAccount.getAccountBalance()-withdraw);
					}
					else {
						System.out.println("Insufficient Balance !!!");
					}
					break;
				case "CurrentAccount":
					if(selectedAccount.getAccountBalance()-withdraw >= 0) {
						selectedAccount.setAccountBalance(selectedAccount.getAccountBalance()-withdraw);
					}
					else {
						System.out.println("Insufficient Balance !!!");
					}
					break;
				case "LoanAccount":
					if(selectedAccount.getAccountBalance()-withdraw >= 0) {
						selectedAccount.setAccountBalance(selectedAccount.getAccountBalance()-withdraw);
					}
					else {
						System.out.println("Insufficient Balance !!!");
					}
					break;
					default:
						System.out.println("invalid choice");
				}
				
				break;
			case 2:
				System.out.println("Enter the amount you want to deposit");
				double deposit=scanner.nextDouble();
				switch(userAccountChoice)
				{
				case "SavingsMaxAccount":
					
						selectedAccount.setAccountBalance(selectedAccount.getAccountBalance()+deposit);
					
					break;
				case "CurrentAccount":
					selectedAccount.setAccountBalance(selectedAccount.getAccountBalance()+deposit);
					break;
				case "LoanAccount":
					selectedAccount.setAccountBalance(selectedAccount.getAccountBalance()+deposit);
					
					break;
					default:
						System.out.println("invalid choice");
				}

				break;
			case 3:
				switch(userAccountChoice)
				{
				case "SavingsMaxAccount":
					System.out.println(selectedAccount.getAccountBalance());
					break;
				case "CurrentAccount":
					System.out.println(selectedAccount.getAccountBalance());
					break;
				case "LoanAccount":
					System.out.println(selectedAccount.getAccountBalance());
					break;
					default:
						System.out.println("invalid choice");
				}

				break;
				default:
					System.out.println("invalid choice");
			}	
		}
		else{
			System.out.println("Customer doesnt exist try creating a new customer");
		}
		
	}


	private static void displayCustomerAccounts(Customer customer) {		
		for(Account account:customer.getAccounts())
		{
			System.out.println(account.getAccountType());
			System.out.println(account.getAccountBalance());
			for(Services service:account.getProduct().getProductList())
			{
			System.out.println(service.getServiceName());
			}						
		}		
	}
	
		
	public static String displayCustomer()
	{	Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Customer  Code");
		String customerCode=scanner.next();
		return customerCode;
		
	}
	public static void displayCustomer(Customer customer)
	{
		
		String customerCode=displayCustomer();
		if(customerCode.equals(customer.getCustomerCode()))
				{
					System.out.println("Cusomer code : "+customer.getCustomerCode());
					System.out.println("Customer Name : "+customer.getCustomerName());
					System.out.println("Hi "+customer.getCustomerName()+" ,You have the following accounts");
					displayCustomerAccounts(customer);				
				}
		else
		{
			System.out.println("Customer doesnt exist . Try creating a new customer");
		}
		
	}
}


		
		


