/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author han wen
 */
public class Testing {
    
    //generate Linked Array of each classes
    public static ArrayInterface<Customer> custList = new Array<>();
    public static ArrayInterface<Booking> bookList = new Array<>();
    public static Scanner sc = new Scanner(System.in);
    public static Scanner input = new Scanner(System.in);
    public static Customer currentUser;
    
     public static void main(String[] args) throws AWTException, ParseException, CloneNotSupportedException {
         custList.add( new Customer("Mia Khalifa","12345","Mia Khalifa","981126-06-5000","012-6969696","12, Jalan Pudu, 55100 Kuala Lumpur."));
         menu();
     }    
      
        public static void menu() throws AWTException, CloneNotSupportedException{
        System.out.println("Welcome!!!");             
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");   
        System.out.printf("Please enter number 1 to 3 to select the option:  ");
        int selection;
        selection = sc.nextInt();
        sc.nextLine();  
        if(selection == 1){
          Login();
        }else if(selection == 2){
           Register();
         }else if(selection == 3){            
            System.exit(0);
        }                  
    } 
        
    public static void Login()throws AWTException, CloneNotSupportedException{
      clearScreen();
      System.out.println("Login"); 
      System.out.printf("Username: ");
      String loginCust= input.nextLine();
      System.out.printf("Password: ");
      String loginPassword = input.nextLine();
      boolean loginAccess = false;
        
        try{
            for(int i = 0; i < custList.length(); i++){
                if(custList.getData(i) != null){
                    if((loginCust.equals(custList.getData(i).getCustUsername()) && (loginPassword.equals(custList.getData(i).getCustPassword())))){
                        currentUser = custList.getData(i);
                        loginAccess = true;
                        break;                        
                    }
                }
            }
        }catch(Exception e){
            
        }
        
        if(loginAccess == true){
            System.out.print("LOGIN SUCCESSFUL!!!");
            Testing.Selection();
        }else{
            System.out.print("LOGIN UNSUCCESSFUL,PLEASE TRY AGAIN!!!");
            Login();
        }
      }
    

     public static void Register()throws AWTException, CloneNotSupportedException{
        clearScreen();
        System.out.println("Register");     
        
        String custUsername ="";
        String custPassword="";
        String custName="";
        String ic="";
        String phone="";
        String address ="";
        
            
        System.out.printf("Username             : ");
         custUsername = sc.nextLine();
        
         if(custUsername.isEmpty()){
        do{
            if(custUsername.isEmpty()){
               System.out.println("Please enter your username !");
               System.out.println("");
               System.out.println("Username             : ");
               custUsername = sc.nextLine();              
            }
        }while((custUsername.isEmpty()));
         }
         
         System.out.printf("Password            : ");
         custPassword = sc.nextLine();
         
        if((custPassword.isEmpty()) || (custPassword.length() < 5) ){
            
        do{
            if(custPassword.isEmpty()){
               System.out.println("Please enter your password !");
               System.out.println("");
               System.out.println("Password             : ");
               custPassword = sc.nextLine();
            }else if(custPassword.length() < 5){
                System.out.println("Your password cannot be less than 5 words, please enter again ! ");
                System.out.println("");
               System.out.println("Password             : ");
               custPassword = sc.nextLine();
            }
       
        }while((custPassword.isEmpty()) || (custPassword.length() < 5));
        }
        
        System.out.printf("Name            : ");
        custName = sc.nextLine();
        
         do{
            if((custName.isEmpty())){
                System.out.println("Please enter your Name ! ");
                custName = sc.nextLine();
            }
        }while(custName.isEmpty());      
         
         
        System.out.printf("IC Number            : ");
        ic = sc.nextLine();
        
         do{
            if((ic.isEmpty())){
                System.out.println("Please enter your IC number ! ");
                ic = sc.nextLine();
            }
        }while(ic.isEmpty());      
         
        System.out.printf("Phone Number            : ");
        phone = sc.nextLine();
        
        do{
            if((phone.isEmpty())){
                System.out.println("Please enter your phone number ! ");
                phone = sc.nextLine();
            }
        }while(phone.isEmpty());
        
        System.out.printf("Address            : ");
        address = sc.nextLine();
        
         do{
            if((address.isEmpty())){
                System.out.println("Please enter your address ! ");
                address = sc.nextLine();
            }
        }while(address.isEmpty());
         custList.add(new Customer(custUsername,custPassword,custName,ic,phone,address));     
         System.out.println("Register Successful!!!");    
         menu();                      
     }
     
     public static void Selection()throws AWTException, CloneNotSupportedException{       
        System.out.println("1. Booking flowers");
        System.out.println("2. Return to the main menu\n");       
        System.out.printf("Please enter number 1 to 2 to select the option:  ");
        int selection;
        selection = sc.nextInt();
        sc.nextLine();
       
        if(selection == 1){
           Booking();
        }else if(selection == 2){
           menu();                 
      }
     }
        
    public static void Booking()throws AWTException, CloneNotSupportedException{      
       clearScreen();
       System.out.println("Booking"); 
       String flowerName ="";
       int quantity;
       String time ="";
       String date="";
       String address ="";
       
        System.out.printf("Alstroemeria");
        flowerName = sc.nextLine();
        System.out.printf("Enter the quantity:   ");
        quantity = input.nextInt();
        input.nextLine();
        //System.out.printf("Anemone");
        //System.out.printf("Enter the quantity:   ");
        // quantity = input.nextInt();
        //input.nextLine();
         //System.out.printf("Asters");
        //System.out.printf("Enter the quantity:   ");
        //uantity = input.nextInt();
        //input.nextLine();
        
        System.out.printf("Time           : ");
        time = sc.nextLine();
        
        do{
            if((time.isEmpty())){
                System.out.println("Please enter your phone number ! ");
                time = sc.nextLine();
            }
        }while(time.isEmpty());
        
        System.out.printf("Date           : ");
        date = sc.nextLine();
        
        do{
            if((date.isEmpty())){
                System.out.println("Please enter your phone number ! ");
                date = sc.nextLine();
            }
        }while(date.isEmpty());
        
        System.out.printf("Address            : ");
        address = sc.nextLine();
        
         do{
            if((address.isEmpty())){
                System.out.println("Please enter your address ! ");
                address = sc.nextLine();
            }
        }while(address.isEmpty());
        bookList.add(new Booking(flowerName,quantity,time,date,address));     
         System.out.println("Booking Successful!!!");    
         Selection();           
        
      }
      
      public static void clearScreen() throws AWTException{
        
        //get width of Screen size /3*2
        int width = (Toolkit.getDefaultToolkit().getScreenSize().width)/3*2;
        //get height of Screen size /5*4
        int height = (Toolkit.getDefaultToolkit().getScreenSize().height)/5*4; 
       
        Robot r = new Robot();
        r.mouseMove(width,height); //move the mouse 
        r.mousePress(InputEvent.BUTTON1_MASK); // left click
        r.mouseRelease(InputEvent.BUTTON1_MASK); // release left click
        r.keyPress(KeyEvent.VK_CONTROL); // Holds CTRL key.         
        r.keyPress(KeyEvent.VK_L); // Holds L key.          
        r.keyRelease(KeyEvent.VK_CONTROL); // Releases CTRL key.
        r.keyRelease(KeyEvent.VK_L); // Releases L key.         
    }   
     
     
       
}
