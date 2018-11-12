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
        switch (selection) {
            case 1:
                Login();
                break;
            case 2:
                Register();
                break;                  
            case 3:
                System.exit(0);
            default:
                break;
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
        System.out.println("5. Customized Floral Arrangement");
        System.out.printf("Please enter number 1 to 2 to select the option:  ");
        int selection;
        selection = sc.nextInt();
        sc.nextLine();
        
        switch(selection){
            case 1:Booking();break;
            case 2:menu(); break;
            case 5:CustomizedFlower();break;
        }
        /*if(selection == 1){
           Booking();
        }else if(selection == 2){
           menu();                 
      }*/
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
      
      public static void CustomizedFlower(){
        Scanner scan = new Scanner(System.in);
        char select;
        String[] flowerType = {"Elliptical flower arrangement", "Vertical flower arrangement", "The crescent flower arrangement"
        , "The 'S' shaped flower arrangement"};
        String[] flowerSize = {"Small", "Intermediate", "Big"};
        String[] flower = {"Lily", "Rose", "Sunflower", "White Rose"};
        String[] accessories = {"Double Artificial Holly Berry Stamens", "Bouquet Holder", "No need"};
        String decisionFlowerType = "";
        String decisionFlowerSize = "";
        String decisionFlower = "";
        String decisionAccessories = "";
        System.out.println("Type of flower arrangement style");
        do{
        //1. Choose the flower arrangement type
        for(int i = 0; i < flowerType.length; i++){
            System.out.println(i+1 + ") " + flowerType[i]);
        }
        System.out.print("Step 1: Choose the flower arrangement style from above: ");
        
        //Scan the arrangement style that the user choose
        int selection1 = scan.nextInt();
        
        //initialise the selection from user into the decisionFlowerType
        switch(selection1){
            case 1: decisionFlowerType = flowerType[0];break;
            case 2: decisionFlowerType = flowerType[1];break;
            case 3: decisionFlowerType = flowerType[2];break;
            case 4: decisionFlowerType = flowerType[3];break;  
            default: System.out.println("Error");System.exit(0);break;
        }
        
        //2. Choose the flower arrangement size
        for(int i = 0; i < flowerSize.length; i++){
            System.out.println(i+1 + ") " + flowerSize[i]);
        }
        System.out.print("Step 2: Please choose the arrangement size from above: ");
        int selection2 = scan.nextInt();
        switch(selection2){
            case 1: decisionFlowerSize = flowerSize[0];break;
            case 2: decisionFlowerSize = flowerSize[1];break;
            case 3: decisionFlowerSize = flowerSize[2];break;
            default: System.out.println("Error");System.exit(0);break;    
        }
        
        //3. Choose the Flower
        for(int i = 0; i < flower.length; i++){
            System.out.println(i+1 + ") " + flower[i]);
        }
        System.out.print("Step 3: Please choose the flower you want from above: ");
        int selection3 = scan.nextInt();
        switch(selection3){
            case 1: decisionFlower = flower[0];break;
            case 2: decisionFlower = flower[1];break;
            case 3: decisionFlower = flower[2];break;
            case 4: decisionFlower = flower[3];break;  
            default: System.out.println("Error");System.exit(0);break;
        }
        
        //4. Select Accessories
        for(int i = 0; i < accessories.length; i++){
            System.out.println(i+1 + ") " + accessories[i]);
        }
        System.out.print("Step 4: Please choose the accessories that you want to put from above: ");
        int selection4 = scan.nextInt();
        switch(selection4){
            case 1: decisionAccessories = accessories[0];break;
            case 2: decisionAccessories = accessories[1];break;
            case 3: decisionAccessories = accessories[2];break;
            default: System.out.println("Error");System.exit(0);break;
        }
        
        //Show the customized summary and comfirm with user
        System.out.printf("\nYour selection is: " + "\nFlower Arrangement Type: " + decisionFlowerType + "\nFlowerSize: " 
                + decisionFlowerSize + "\nFlower Type: " +
                decisionFlower + "\nAccessories: " + decisionAccessories + "\nAre you sure? (y/n): ");
        select = scan.next().charAt(0);
        }while(select != 'y');
    }
     
     
       
}
