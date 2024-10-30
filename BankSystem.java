package BankSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {

	 public static void main(String[] args) {
	        // TODO code application logic here
	        Map <String,user>users=new HashMap<>();
	        users.put("Saiteja",new user("Saiteja", "754892645", 1000, "Saving"));
	        users.put("varun",new user("varun", "123456789", 1200, "Saving"));
	        users.put("sathwik",new user("sathwik", "1235468791", 6000, "Saving"));
	        users.put("Tharun",new user("Tharun", "tharun123", 20000, "Saving"));
	        Scanner scanner=new Scanner(System.in);
	        
	        while(true){
	            System.out.print("Welcome Sir\nplease Enter ur Username: ");
	            String username= scanner.nextLine();
	            System.out.print("please Enter ur Password: ");
	            String password= scanner.nextLine();
	            if(users.containsKey(username)){
	                boolean check=users.get(username).checkPassword(username, password);
	                if(check){
	                    int flag=0;
	                    while(true){
	                        user now=users.get(username);
	                        System.out.println("please Select operation \n 1-> Deposit\n 2->Withdraw\n 3-> View balance\n Otherwise for Exit ");
	                        int x=Integer.parseInt(scanner.nextLine());
	                        switch(x){
	                            case 1:
	                                System.out.println("please Enter the amout u want to desposit");
	                                double amount=Double.parseDouble(scanner.nextLine());
	                                boolean despositCheck=now.deposit(amount);
	                                if(!despositCheck){
	                                    System.out.println("Sorry wrong amount to deposit");
	                                }else{
	                                    System.out.println("Succesfull Operation");
	                                }
	                                break;
	                            case 2:
	                                System.out.println("please Enter the amout u want to withdraw");
	                                double cash=Double.parseDouble(scanner.nextLine());
	                                boolean withdrawCheck=now.withdraw(cash);
	                                if(!withdrawCheck){
	                                    System.out.println("Sorry wrong amount to withdraw");
	                                }else{
	                                    System.out.println("Succesfull Operation");
	                                }
	                                break;
	                            case 3:
	                                System.out.println("your balance is:"+now.getBalance());
	                                break;
	                            default:
	                                flag=1;
	                                System.out.println("Thank you");
	                                break;
	                        }
	                        if(flag==1){
	                            break;
	                        }
	                    }
	                }
	                else{
	                    System.out.println("Wrong Password please try Again");
	                }
	                

	            }
	            else{
	                return;
	            }
	        }
	    
	    }
	    
	}
	class user{
	    String username;
	    String password;
	    double balance;
	    String type;
	    public user(String username, String password, double balance, String type) {
	        this.username = username;
	        this.password = password;
	        this.balance = balance;
	        this.type = type;
	    }
	    public user() {
	        this.username = "";
	        this.password = "";
	        this.balance = 0.0;
	        this.type = "";
	    }
	    boolean checkPassword(String userna,String password){
	        if(userna.equals(this.username) && password.equals(this.password)){
	            return true;
	        }
	        else return false;
	    }
	    boolean deposit (double amount){
	        this.balance=this.balance+amount;
	        return true;
	    } 
	    boolean withdraw(double amount){
	        if(this.balance>=amount){
	            this.balance=this.balance-amount;
	            return true;
	        }else{
	            return false;
	        }
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getPassword() {
	        return password;
	    }
	    
	    
	}