package bankings;


import java.util.Random;
import java.util.Scanner;

public class User {
	 int accountnum;
	 String name;
	 String phonenum;
	 String pin;
	 long balance;
	
	public User(int accountnum ,String name,String phonenum,String pin, long balance)
	{
		this.accountnum = accountnum;
		this.name = name;
		this.phonenum = phonenum;
		this.pin = pin;
		this.balance = balance;
		
	}
	
public User() {
		super();
	}



public int getActno()
   {
	   return  accountnum ;
   }
   
   public void setActno(int accountnum )
   {
	   this.accountnum = accountnum ;
   }
   
   
   public String getName()
   {
	   return name;
   }
   
   public void setName(String name)
   {
	   this.name = name;
   }
   
   
   
   public String getPhonenum()
   {
	   return phonenum;
   }
   
   public void setPhonenum(String phonenum)
   {
	   this.phonenum = phonenum;
   }
   
   
   
   
   
   public String getPin()
   {
	   return pin;
   }
   
   public void setPin(String pin)
   {
	   this.pin = pin;
   }
   
   
   public long getBalance()
   {
	   return balance;
   }
   
   public void setBalance(int balance)
   {
	   this.balance = balance;
   }

   
   
}
	


