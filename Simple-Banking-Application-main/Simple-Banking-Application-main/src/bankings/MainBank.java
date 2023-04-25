package bankings;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainBank {
	
	private static ArrayList <User> user1 = new ArrayList<User>();
	
	
	public void tryagainCreate()
	{
		  Scanner sc1 = new Scanner(System.in);
		  System.out.println("Enter 1 to try again");
		  System.out.println("Enter 2 to Menu");
		  int userinput = sc1.nextInt();
		  if(userinput==1)
		  {
			  CreateAcc();
		  }
		  else if (userinput==2)
		  {
			  Menu();
		  }
		  else {
			  System.out.println("Invalid Option");
			  tryagainCreate();
		  }
   }
	
	 public void CreateAcc() {
			
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter the User Name:");
			String name=sc1.next();
			
			System.out.println("Enter the Phone Number:");
			String phonenum=sc1.next();
			System.out.println("Enter the Pin:");
			String pin = sc1.next();
		    Pattern patternphn = Pattern.compile("^\\d{10}$");
		    Pattern patternpin = Pattern.compile("^\\d{4}$");
		    Matcher matcherphn = patternphn.matcher(phonenum); 
		    Matcher matcherpin = patternpin.matcher(pin);
		      
		      if(matcherphn.matches())
		      {
		    	  if(matcherpin.matches())
	       	      {
		    	    Random rand = new Random();
					int accountnum = rand.nextInt(100);
					long balance = 1000;
					User user = new User(accountnum,name,phonenum,pin, balance);
					user1.add(user);
					System.out.println("Your Account Number is :"+user.getActno());
		          }
		    	  else {
		    		   System.out.println("Pin Number Should contain only 4 digits");
		    		   tryagainCreate();
		    	       }
		      }
		    	  else  {
		    		  System.out.println("Phone Number Should contain only 10 digits");
		    		  tryagainCreate();
		    	  }
		      }
		
	 public void tryagainWithdraw()
	 {
		 Scanner sc1 = new Scanner(System.in);
		  System.out.println("Enter 1 to try again");
		  System.out.println("Enter 2 to Menu");
		  int userinput = sc1.nextInt();
		  if(userinput==1)
		  {
			  withdraw();
		  }
		  else if (userinput==2)
		  {
			  Menu();
		  }
		  else {
			  System.out.println("Invalid Option");
			  tryagainWithdraw();
		  }
	 }
	 

	 public void withdraw()
	 {
	 	Scanner sc = new Scanner(System.in);
	 	
	 	System.out.println("Enter the Pin:");
	 	String Pin = sc.nextLine();
	 	System.out.println("Enter the Amount to Withdraw:");
	 	long withdraw = sc.nextLong();
	 		
	 	for(int i =0;i<user1.size();i++) {
	 		if(user1.get(i).getPin().equals(Pin))
	 		{
	 			if(withdraw<user1.get(i).balance)
	 			{
	 				user1.get(i).balance = withdraw - user1.get(i).balance;
	 				System.out.println("Your Balance is:"+Math.abs(user1.get(i).balance));
	 			}
	 			else if (withdraw > user1.get(i).balance )
	 			{
	 				System.out.println("Your Bank Balance is less than the amount");
	 				tryagainWithdraw();
	 				
	 			}
	 			else if (withdraw - user1.get(i).balance == 0)
	 			{
	 				user1.get(i).balance = withdraw - user1.get(i).balance;
	 				System.out.println("Your Balance is:" +Math.abs(user1.get(i).balance));
	 			}
	 			else if(withdraw==0) {
	 				System.out.println("Amount cannot be deposit");
	 				tryagainWithdraw();
	 			}
	 	    }
	 		else{
	 			  System.out.println("Incorrect Pin");
	 			  tryagainWithdraw();
	 		    }
	 	}
	 }
	 
	 
	 
	 
	 public void tryagainDisplay()
	 {   Scanner sc1 = new Scanner(System.in);
		 System.out.println("Enter 1 to try again");
		     System.out.println("Enter 2 to Menu");
		     int userinput = sc1.nextInt();
		     if(userinput==1)
		     {
			  Display();
		     }
		     else if(userinput == 2)
		     {
			  Menu();
		     }
		     else
		     {
		    	 System.out.println("Invalid option");
		    	 tryagainDisplay();
		     }
	  }
	 
	 
	 
	 
	 public void Display() {
	 Scanner sc1 = new Scanner(System.in);
	 System.out.println("Enter the Account Number:");
	 int Actnum = sc1.nextInt();
	 System.out.println("Enter the Pin");
	 String Pin = sc1.next();
	 for(int i = 0;i<user1.size();i++)
	 {
		 if(user1.get(i).getActno()==Actnum)
		 {
			 if(user1.get(i).getPin().equals(Pin))
			 {
			 System.out.println("Your Account Number:"+user1.get(i).accountnum);
			 System.out.println("Your Name:"+user1.get(i).getName());
			 System.out.println("Your Phone Number:"+user1.get(i).getPhonenum());
			 System.out.println("Balance:"+Math.abs(user1.get(i).balance));
			 
			 }
		    else
		    {
		    	 System.out.println("Enter the valid Pin:");
		    	 tryagainDisplay();
		    }
     }
	 else 
	    {
		 System.out.println("Enter the valid Account Number:");
		 tryagainDisplay();
     	}
	 }
}

	 
	 
		 
		 public void tryagainDeposit() {
			     Scanner sc1 = new Scanner(System.in);
			     System.out.println("Enter 1 to try again");
			     System.out.println("Enter 2 to Menu");
			     int userinput = sc1.nextInt();
			     if(userinput==1)
			     {
				  Deposit();
			     }
			     else if(userinput == 2)
			     {
				  Menu();
			     }
			     else
			     {
			    	 System.out.println("Invalid option");
			    	 tryagainDeposit();
			     }
		 }
	 
	 
		 
		 
	 public void Deposit() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Account Number:");
		 int AccountNum = sc.nextInt();
		 System.out.println("Enter the Pin");
		 String Pin = sc.next();
		 System.out.println("Enter the amount to deposit:");	 
         long amount = sc.nextLong();	
		 
		 for(int i = 0;i<user1.size();i++) {
			 if(user1.get(i).getActno() == AccountNum)
			 {
				  if(user1.get(i).getPin().equals(Pin)) 
				  {
					 if(amount > 5000)
					    {
						 System.out.println("You cannot deposit more than 5000");
						 tryagainDeposit();
					    } 
					 else if (amount==0)
					 {
						 System.out.println("Deposit value cannot be 0 or less number");
						 tryagainDeposit(); 
					 }
					 else 
					 {
						 user1.get(i).balance = user1.get(i).balance + amount;
						 System.out.println("Amount is deposit Successfully ");
						 System.out.println("Your balance is:"+user1.get(i).balance);
					 }
					 
				 }
				    else
				    {
				    	 System.out.println("Enter the valid Pin Number");
						 tryagainDeposit(); 
				    }
			 }
			else 
			{
			System.out.println("Enter the valid Account Number:");
			tryagainDeposit();
		    }
		 } 
		}
	 
	 
	
	 
	 
	  
	 public void balance()
	 { 
		 Scanner sc1 = new Scanner(System.in);
		 System.out.println("Enter the Act no: ");
		 int actNum = sc1.nextInt();
		 System.out.println("Enter the Pin: ");
		 String Pin = sc1.next();
		 
		 int index = -1;
		 for(int i = 0;i<user1.size();i++) {
		     if(user1.get(i).getActno()==actNum) {
		    	 index = i;
		     }
		 }
		 
		 if (index != -1) {
			 if(user1.get(index).getPin().equals(Pin)) {
	    		 System.out.println("Your balance is:"+Math.abs(user1.get(index).balance));
	    	 } else {
	    		 System.out.println("Incorrect pin");
	    		 tryAgainForBalance();
	    	 }
		 } else {
			 System.out.println("Act not available");
			 tryAgainForBalance();
		 }
		 
	 }
	 
	 public void tryAgainForBalance() {
    	 System.out.println("Enter 1 to Try again to view balance");
		 System.out.println("Enter 2 to Menu");
		 Scanner sc = new Scanner(System.in);
    	 int op= sc.nextInt();
    	 if (op == 1) {
    		 balance(); 
    	 } else if (op == 2) {
    		 Menu();
    	 } else {
    		 System.out.println("Invalid option");
    		 tryAgainForBalance();
    	 }
	 }
	  
	 
	 public void MainPage() {

		    int useroption = 0;
			Scanner sc = new Scanner(System.in);
			while(useroption > -1) 
			{
				if(useroption >= 0)
				{
					System.out.println("***** BANKING APPLICATION *****");	
					System.out.println("Enter 1 Create Account");
					System.out.println("Enter 2 login");
					useroption = sc.nextInt();
					
					switch(useroption)
					{
					case 1: 
						System.out.println("Create Account:");
						MainBank bank = new MainBank();
						bank.CreateAcc();
						System.out.println("Account is Created Successfull!!");
						break;
						
					case 2:
						System.out.println("Login");
						MainBank bank1 = new MainBank(); 
						bank1.Login();
						//System.out.println("")
					}
							
				}
				
			}	 
	 }
	 
	 public void Login() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("***** Login PAGE *****");
		 System.out.println("Enter the Account Number ");
		 int actno=sc.nextInt();
		 System.out.println("Enter the Pin Number ");
		 String pinno=sc.next();
		 for(int i=0;i<=user1.size();i++)
		 {
		 if(actno == user1.get(i).getActno() && user1.get(i).getPin().equals(pinno))
		 {
			 System.out.println("Login Successfully");
			 Menu();
		 }
		 else
		 {
			 System.out.println("Login failed");
			 System.out.println("1 - To Try Again");
			 System.out.println("2 - Create Account");
		     int useroption = sc.nextInt();
	     		switch(useroption)
					{
					case 1: 
						Login();
						break;
						
					case 2:
		                 CreateAcc();
						 break;
		             }
		 }
		 }
	 }
	 
	 
	 
	 public void Menu()
	 {
		    int useroption = 0;
			Scanner sc = new Scanner(System.in);
			while(useroption > -1) 
			{
			if(useroption >= 0)
			{
				System.out.println("***** HOME PAGE *****");	
				System.out.println("Enter 1 View Balance");
				System.out.println("Enter 2 Deposit");
				System.out.println("Enter 3 Withdraw");
				System.out.println("Enter 4 View Details");
				System.out.println("Enter 5 Logout");
				System.out.println("Enter the option to proceed");
				
				useroption = sc.nextInt();
	     		switch(useroption)
					{
						
					case 1:
						 System.out.println("View Balance");
						 balance();
						 break;
			
					case 2:
						System.out.println("Deposit");
						Deposit();
						break;
						
					case 3:
						System.out.println("Withdraw");
						withdraw();
						break;
						
					case 4:
						 System.out.println("View Details");
						 Display();		
						 break; 
						 
					case 5:
						 System.out.println("Logout");
						 Logout();		
						 break; 
						 
			        } 
	     		
			}
		}
				
	} 
	 
	 
	public void Logout() {
		
		 MainPage();
	}

	public static void main(String[] args) 
	{
     MainBank bank = new MainBank();	
     bank.MainPage();
}
}
