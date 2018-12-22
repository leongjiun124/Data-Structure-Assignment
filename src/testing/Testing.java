/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import Entity.PickUpOrder;
import Control.FlowerCustomizedControl;
import Entity.Item;
import Entity.PromotionList;
import Entity.FlowerCustomized;
import Entity.DeliveryOrderList;
import Entity.Customer;
import Entity.CompanyDetail;
import Entity.Booking;
import Entity.DomainCatalogMaintain;
import Entity.Staff;
import da.FlowerCustomizedDA;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author han wen
 */
public class Testing {
    
    //generate Linked Array of each classes
    public static ArrayInterface<Customer> custList = new Array<>();
    public static ArrayInterface<Booking> bookList = new Array<>();
    public static QueueInterface<String> flowerList = new Queue<>();
    public static QueueInterface<String> arrangementList = new Queue<>();
    public static QueueInterface<String> sizeList = new Queue<>();
    public static QueueInterface<String> accessoryList = new Queue<>();
    public static QueueInterface<String> priorityList = new Queue<>();
    public static QueueInterface<Staff> staffList = new Queue<>();
    public static Scanner sc = new Scanner(System.in);
    public static Scanner input = new Scanner(System.in);
    public static Customer currentUser;
    public static Staff currentStaff;
    public int date2;
    public int discount1;
    public int month1;
    
     public static void main(String[] args) throws AWTException, ParseException, CloneNotSupportedException {
         custList.add( new Customer("Mia Khalifa","12345","Mia Khalifa","981126-06-5000","012-6969696","12, Jalan Pudu, 55100 Kuala Lumpur."));
         staffList.enqueue(new Staff("S1", "Staff 1", "abc123", "abc123"));
         flowerList.enqueue("Rose");
         flowerList.enqueue("White Rose");
         flowerList.enqueue("Sunflower");
         flowerList.enqueue("Lily");
         arrangementList.enqueue("Elliptical flower arrangement");
         arrangementList.enqueue("Vertical flower arrangement");
         arrangementList.enqueue("The crescent flower arrangement");
         arrangementList.enqueue("The 'S' shaped flower arrangement");
         sizeList.enqueue("Small");
         sizeList.enqueue("Intermediate");
         sizeList.enqueue("Big");
         accessoryList.enqueue("Double Artificial Holly Berry Stamens");
         accessoryList.enqueue("Bouquet Holder");
         accessoryList.enqueue("No need");
         menu();
     }  
     
     public static void attachShutDownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            System.out.println("exit");
        }
    });

}
      
        public static void menu() throws AWTException, CloneNotSupportedException{
        System.out.println("================================================");
        System.out.println("----------------Fiore Flowershop----------------");       
//        System.out.println("-----------------Welcome Staff------------------"); 
        System.out.println("------------------------------------------------"); 
        System.out.println("1. Staff Login");
        System.out.println("2. Customer Login");
        System.out.println("3. Customer Register");
        System.out.println("4. Exit");
        System.out.println("================================================");
        System.out.printf("Please enter number 1 to 3 to select the option:  "); 
        int selection;
        selection = sc.nextInt(); 
        switch (selection) {
            case 1:
                StaffLogin();
                break;
            case 2:
                Login();
                break;
            case 3:
                Register();
                break;                  
            case 4:
                attachShutDownHook();break;
            default:
                break;
        }
    } 
        
    public static void StaffLogin() throws AWTException, CloneNotSupportedException{
//      clearScreen();
      System.out.println("======================================================");
      System.out.println("--------------------Staff Login-----------------------"); 
      System.out.println("======================================================");
      System.out.printf("Username: ");
      while(input.hasNextLine()){
      String loginCust= input.nextLine();
      if(loginCust.isEmpty()){
        do{
            if(loginCust.isEmpty()){
               System.out.println("Please enter your Username !");
               System.out.printf("Username: ");
               loginCust = sc.nextLine();              
            }
        }while((loginCust.isEmpty()));
         }
      System.out.printf("Password: ");
      String loginPassword = input.nextLine();
      if(loginPassword.isEmpty()){
        do{
            if(loginPassword.isEmpty()){
               System.out.println("Please enter your Password !");
               System.out.printf("Password: ");
               loginPassword = sc.nextLine();              
            }
        }while((loginPassword.isEmpty()));
         }
      boolean loginAccess = false;
      
               try{
            for(int i = 0; i < staffList.size(); i++){
                if(staffList.getItem(i) != null){
                    if((loginCust.equals(staffList.getItem(i).getUserName()) && (loginPassword.equals(staffList.getItem(i).getPassword())))){
                        currentStaff = staffList.getItem(i);
                        loginAccess = true;
                        break;                       
                    }
                }
            }
        }catch(Exception e){    
            
        }
               
        if(loginAccess == true){
            System.out.println("Login Successfull!");
            Testing.StaffSelection();
        }else{
            System.out.println("Login Fail!");
            System.out.println("Invalid Username or Password, Please try again!");
            Login();
        }
      }
    }
        
    public static void Login()throws AWTException, CloneNotSupportedException{
      clearScreen();
      System.out.println("=========================================================");
      System.out.println("--------------------Customer Login-----------------------"); 
      System.out.println("=========================================================");
      System.out.printf("Username: ");
      while(input.hasNextLine()){
      String loginCust= input.nextLine();
      if(loginCust.isEmpty()){
        do{
            if(loginCust.isEmpty()){
               System.out.println("Please enter your Username !");
               System.out.printf("Username: ");
               loginCust = sc.nextLine();              
            }
        }while((loginCust.isEmpty()));
         }
      System.out.printf("Password: ");
      String loginPassword = input.nextLine();
      if(loginPassword.isEmpty()){
        do{
            if(loginPassword.isEmpty()){
               System.out.println("Please enter your Password !");
               System.out.printf("Password: ");
               loginPassword = sc.nextLine();              
            }
        }while((loginPassword.isEmpty()));
         }
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
            System.out.println("Login Successfull!");
            Testing.Selection();
        }else{
            System.out.println("Login Fail!");
            System.out.println("Invalid Username or Password, Please try again!");
            Login();
        }
      }
          
      }
    

     public static void Register()throws AWTException, CloneNotSupportedException{
        clearScreen();
        System.out.println("================================================");
        System.out.println("------------------Register----------------------");  
        
        String custUsername ="";
        String custPassword="";
        String custName="";
        String ic="";
        String phone="";
        String address ="";
            
        System.out.printf("Username        : ");
         custUsername = sc.nextLine();
        
         if(custUsername.isEmpty()){
        do{
            if(custUsername.isEmpty()){
               System.out.println("Please enter your Username !");
               System.out.printf("Username        : ");
               custUsername = sc.nextLine();              
            }
        }while((custUsername.isEmpty()));
         }
           
         System.out.printf("Password        : ");
         custPassword = sc.nextLine();
         
        if((custPassword.isEmpty()) || (custPassword.length() < 5) ){         
        do{
            if(custPassword.isEmpty()){
               System.out.println("Please enter your password !");
               System.out.printf("Password        : ");
               custPassword = sc.nextLine();
            }else if(custPassword.length() < 5){
                System.out.println("Your password cannot be less than 5 words, please enter again ! ");
                System.out.printf("Password        : ");
                custPassword = sc.nextLine();
            }
        }while((custPassword.isEmpty()) || (custPassword.length() < 5));
        }
        
        System.out.printf("Name            : ");
        custName = sc.nextLine();
        
         do{
            if((custName.isEmpty())){
                System.out.println("Please enter your Name ! ");
                System.out.printf("Name            : ");
                custName = sc.nextLine();
            }
        }while(custName.isEmpty());      
        
        System.out.println("Example of IC Number : 987664-69-6968 ");
        System.out.printf("IC Number       : ");
        ic = sc.nextLine();
        
        if((ic.isEmpty()) || (ic.length() < 14) ){
           do{
            if((ic.isEmpty())){
                System.out.println("Please enter your IC Number ! ");
                System.out.printf("IC Number       : ");
                ic = sc.nextLine();
            }else if(ic.length() < 14){
                 System.out.println("Your IC Number cannot be less than 14 words, please enter again ! ");
                 System.out.printf("IC Number       : ");
                 ic = sc.nextLine();
            }
        }while((ic.isEmpty()) || (ic.length() < 14));       
        }
        
        System.out.println("Example of Phone Number : 010-123-6968 or 03-91011069");
        System.out.printf("Phone Number    : ");
        phone = sc.nextLine();
        
        if((phone.isEmpty()) || (phone.length() < 11) ){
        do{
            if((phone.isEmpty())){
                System.out.println("Please enter your Phone Number ! ");
                System.out.printf("Phone Number    : ");
                phone = sc.nextLine();
            }else if(phone.length() < 11){
                System.out.println("Your Phone Number cannot be less than 11 words, please enter again ! ");
                System.out.printf("Phone Number    : ");
                phone = sc.nextLine();
            }
        }while((phone.isEmpty()) || (phone.length() < 11));
        }
        
        System.out.printf("Address         : ");
        address = sc.nextLine();
        
         do{
            if((address.isEmpty())){
                System.out.println("Please enter your address ! ");
                System.out.printf("Address         : ");
                address = sc.nextLine();
            }
        }while(address.isEmpty());
         custList.add(new Customer(custUsername,custPassword,custName,ic,phone,address));
         System.out.println("Register Successful!");
         menu();                      
     }
     
     public static void StaffSelection() throws AWTException, CloneNotSupportedException{
         Scanner scan = new Scanner(System.in);
         int selection;
        System.out.println("======================================================");
        System.out.println("------------------Staff Selection---------------------");  
        System.out.println("======================================================");
        System.out.println("1. Customer/Corporate Consumer Maintenence");
        System.out.println("2. Maintain Product Information");
        System.out.println("3. Maintain Promotion");
        System.out.println("4. Order Pickup");
        System.out.println("=======================================================");
        
        System.out.printf("Please enter number to select the option:  ");
        selection = scan.nextInt();
        switch(selection){
            case 1:CustMaintenence();break;
            
        }
     }
     
     public static void CustMaintenence() throws AWTException, CloneNotSupportedException{
        Scanner scan = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println("------------------Selection---------------------");  
        System.out.println("================================================");
        System.out.println("1. Set Customer Status");
        System.out.println("2. Set Credit Limit");
        System.out.println("3. Generate Monthly Invoice");
        System.out.println("4. Invoice Payment");
        System.out.println("=======================================================");
        
     }
     
     public static void Selection()throws AWTException, CloneNotSupportedException{  
        System.out.println("================================================");
        System.out.println("------------------Selection---------------------");      
//        System.out.println("1. Booking flowers");
//        System.out.println("2. Track Product Stock"); 
//        System.out.println("3. Generate Monthly Invoice");
//        System.out.println("4. Delivery Order List");
//        System.out.println("5. Customized Floral Arrangement");
//        System.out.println("6. Set Credit Limit");
//        System.out.println("7. Pick Up Order");
//        System.out.println("8. Update Customer as Corporate Customer");
//        System.out.println("9. Monthly Promotion");
//        System.out.println("10. Generate Sales Order");
//        System.out.println("11. Itemized Bill");
//        System.out.println("12. Payment List");
//        System.out.println("13. Reset Credit Limit");
//        System.out.println("14. Maintain Catalog");
//        System.out.println("15. Return to the main menu");
          System.out.println("1. Booking Item");
          System.out.println("2. Customized Floral Arrangement");
        System.out.println("================================================");
        
        System.out.printf("Please enter number to select the option:  ");
        int selection;
        while(sc.hasNextInt()){
        selection = sc.nextInt();
        //sc.nextLine();
        
        switch(selection){
            case 1:Booking();break;
            case 2: TrackProductStock();break;
            case 3: Report();break;
            case 4: DeliveryList(); break;
            case 5:CustomizedFlowerMenu();break;
            case 6:SetCreditLimit();break;
            case 7: PickUpOrder();break;
            case 8:Corporate(); break;
            case 9:MonthlyPromotion();break;
            case 10:SalesOrder(); break;
            case 11:ItemizedBill();break;
            case 12: PaymentList();break;
            case 13: ResetCreditLimit(); break;
            case 14: MaintainCatalog();break;
            case 15: menu();break;
        }
        /*if(selection == 1){
           Booking();
        }else if(selection == 2){
           menu();                 
      }*/
        }
     }
     
     public static void CustomizedFlowerMenu()throws AWTException, CloneNotSupportedException{
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Customized Flower Order");
        System.out.println("2. Select Pick Up Priority"); 
        System.out.printf("Please enter number to select the option:  ");
        int select = scan.nextInt();
        switch(select){
            case 1: CustomizedFlower();break;
            case 2: PickUpPriority();break;
        }
     }
        
    public static void Booking()throws AWTException, CloneNotSupportedException{      
       char select;
       Scanner scan = new Scanner(System.in);
       String[] flowerName = {"Lily", "Rose", "Sunflower", "White Rose"};
       int quantity;
       String time ="";
       String date="";
       String address ="";
       String decisionFlowerName = "";
       System.out.println("Booking"); 
       System.out.println("Please choose the flowers that want to purchase");
        do{
        for(int i = 0; i < flowerName.length; i++){
            System.out.println(i+1 + ") " + flowerName[i]);
        }
        System.out.print("Step 1: Choose the flower from above: ");

        int selection1 = scan.nextInt();
   
        switch(selection1){
            case 1: decisionFlowerName = flowerName[0];break;
            case 2: decisionFlowerName = flowerName[1];break;
            case 3: decisionFlowerName = flowerName[2];break;
            case 4: decisionFlowerName = flowerName[3];break;  
            default: System.out.println("Error");System.exit(0);break;
        }
       
        System.out.printf("Enter the quantity:   ");
        quantity = input.nextInt();
        input.nextLine();
        
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
        
          System.out.printf("\nYour flower is: " + "\nFlower Arrangement Type: " + decisionFlowerName + "\nQuantity: " 
                + quantity + "\nTime: " +
                time + "\nDate: " + date + "\nAddress: " + address+ "\nAre you sure? (y/n): ");
        select = scan.next().charAt(0);
        }while(select != 'y');  
        System.out.println("Press 0 to exit, 1 to continue: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                System.exit(0);
            case 1:
                Selection();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }   
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
      
      public static void CustomizedFlower() throws AWTException, CloneNotSupportedException{
        Scanner scan = new Scanner(System.in);
        char select;
        FlowerCustomizedDA flowerCustomizedDA = new FlowerCustomizedDA();
        int index = 1;
        String productId;
        String id;
        do {
            id = FlowerCustomized.generateID(index);
            index++;
        } while (flowerCustomizedDA.getRecord(id) != null);
        productId = id;
//        String[] flowerType = {"Elliptical flower arrangement", "Vertical flower arrangement", "The crescent flower arrangement"
//        , "The 'S' shaped flower arrangement"};
//        String[] flowerSize = {"Small", "Intermediate", "Big"};
        //String[] flower = {"Lily", "Rose", "Sunflower", "White Rose"};
//        String[] accessories = {"Double Artificial Holly Berry Stamens", "Bouquet Holder", "No need"};
//        String decisionFlowerType = "";
//        String decisionFlowerSize = "";
//        String decisionFlower = "";
//        String decisionAccessories = "";
        System.out.println("Type of flower arrangement style");
        do{
        //1. Choose the flower arrangement type
        arrangementList.displayItem();
        System.out.print("Step 1: Choose the flower arrangement style from above: ");
        
        //Scan the arrangement style that the user choose
        int selection1 = scan.nextInt();
        
        //initialise the selection from user into the decisionFlowerType
//        switch(selection1){
//            case 1: decisionFlowerType = flowerType[0];break;
//            case 2: decisionFlowerType = flowerType[1];break;
//            case 3: decisionFlowerType = flowerType[2];break;
//            case 4: decisionFlowerType = flowerType[3];break;  
//            default: System.out.println("Error");System.exit(0);break;
//        }
//        
        //2. Choose the flower arrangement size
        sizeList.displayItem();
//        for(int i = 0; i < flowerSize.length; i++){
//            System.out.println(i+1 + ") " + flowerSize[i]);
//        }
        System.out.print("Step 2: Please choose the arrangement size from above: ");
        int selection2 = scan.nextInt();
//        switch(selection2){
//            case 1: decisionFlowerSize = flowerSize[0];break;
//            case 2: decisionFlowerSize = flowerSize[1];break;
//            case 3: decisionFlowerSize = flowerSize[2];break;
//            default: System.out.println("Error");System.exit(0);break;    
//        }
        
        //3. Choose the Flower
//        for(int i = 0; i < flower.length; i++){
//            System.out.println(i+1 + ") " + flower[i]);
//        }
        flowerList.displayItem();
        System.out.print("Step 3: Please choose the flower you want from above: ");
        int selection3 = scan.nextInt();
//        switch(selection3){
//            case 1: decisionFlower = flowerList.getItem(0);break;
//            case 2: decisionFlower = flowerList.getItem(1);break;
//            case 3: decisionFlower = flowerList.getItem(2);break;
//            case 4: decisionFlower = flowerList.getItem(3);break;  
//            default: System.out.println("Error");System.exit(0);break;
//        }
        
        //4. Select Accessories
        accessoryList.displayItem();
//        for(int i = 0; i < accessories.length; i++){
//            System.out.println(i+1 + ") " + accessories[i]);
//        }
        System.out.print("Step 4: Please choose the accessories that you want to put from above: ");
        int selection4 = scan.nextInt();
//        switch(selection4){
//            case 1: decisionAccessories = accessories[0];break;
//            case 2: decisionAccessories = accessories[1];break;
//            case 3: decisionAccessories = accessories[2];break;
//            default: System.out.println("Error");System.exit(0);break;
//        }
        
        //Show the customized summary and comfirm with user
        System.out.printf("\nYour selection is: " + "\nFlower Arrangement Type: " + arrangementList.getItem(selection1 - 1) + "\nFlowerSize: " 
                + sizeList.getItem(selection2 - 1) + "\nFlower Type: " +
                flowerList.getItem(selection3 - 1) + "\nAccessories: " + accessoryList.getItem(selection4 - 1) + "\nAre you sure? (y/n): ");
        select = scan.next().charAt(0);
        if(select == 'y'){
            flowerCustomizedDA.addFlower(new FlowerCustomized(productId,arrangementList.getItem(selection1 - 1),sizeList.getItem(selection2 - 1),flowerList.getItem(selection3 - 1),accessoryList.getItem(selection4 - 1)));
        }
        }while(select != 'y');
        System.out.println("Press 0 to exit, 1 to continue to choose priority: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                System.exit(0);
            case 1:
                PickUpPriority();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }
        
    }
      
      public static void SetCreditLimit()throws AWTException, CloneNotSupportedException{
          Scanner scan = new Scanner(System.in);
        
        String [] coporateDetails = {"1. Company SellYou", "2. Company BuyYou", "3. Company CIaoYou", "4. Company DiaoYou"};
        for(int i = 0; i < coporateDetails.length; i++){
            System.out.println(coporateDetails[i]);
        }
        
        int choice;
        int creditLimit;
        
        System.out.print("Enter Your Choice (in number): ");
        choice = scan.nextInt();
        if(choice > coporateDetails.length){
            System.out.println("Error");
            System.exit(0);
        }
        
        System.out.println("You have Selected : " + coporateDetails[choice -1]);
        
        System.out.print("Enter Your Credit Limit For Selected Company: ");
        creditLimit = scan.nextInt();
        
        System.out.println("You Have Set The Credit Limit to (RM): " + creditLimit);
        System.out.println("Press 0 to exit, 1 to continue: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                System.exit(0);
            case 1:
                CustomizedFlowerMenu();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }
      }
      
      public static void PickUpOrder()throws AWTException, CloneNotSupportedException{
          Scanner scan = new Scanner(System.in);
          List<PickUpOrder> pick = new ArrayList<PickUpOrder>();
    pick.add(new PickUpOrder("OR001", "Flower 1", "12/07/2018", "13:00", "34", ""));
    pick.add(new PickUpOrder("OR002", "Flower 2", "13/07/2018", "15:00", "13", "Already"));
    pick.add(new PickUpOrder("OR003", "Flower 3", "14/07/2018", "17:00", "50", ""));
 
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.printf("%10s %20s %20s %20s %15s %10s", "ORDER ID", "ITEM NAME", "PICKUP DATE", "PICKUP TIME", "QUALITY", "STATUS");
    System.out.println();
    System.out.println("---------------------------------------------------------------------------------------------------------");
    for(PickUpOrder picks: pick){
        System.out.format("%10s %20s %20s %16s %15s %15s",
                picks.getOrderId(), picks.getItemName(), picks.getDate(), picks.getTime(), picks.getQuality(), picks.getStatus());
        System.out.println();
    }
    System.out.println("---------------------------------------------------------------------------------------------------------");
    
    System.out.println("The totol number of order has been picked up: 1");
            System.out.println("Press 0 to exit, 1 to continue: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                System.exit(0);
            case 1:
                Selection();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }
      }
      
      public static void PickUpPriority() throws AWTException, CloneNotSupportedException{
//          String[] priority = {"Express (Highest)", "Normal", "Flexi (Lowest)"};
          priorityList.enqueue("Express (Highest)");
          priorityList.enqueue("Normal");
          priorityList.enqueue("Flexi (Lowest)");
          FlowerCustomized flower = null;
          FlowerCustomizedControl flowerControl = new FlowerCustomizedControl();
          QueueInterface<FlowerCustomized> viewData = flowerControl.getAllProduct();
          
          /*String flowerType = type;
          String flowerSize = size;
          String flowerName = flower;
          String flowerAccessories = accessories;*/
          char select;
          Scanner scan = new Scanner(System.in);
          do{
//          for(int i = 0; i<flowerCustomized.length; i++){
//              System.out.println(i+1 + ") " + flowerCustomed[i].toString());
//          }
//          flowerCustomized.getFlowerAccessory();
          for(int i = 0; i < viewData.size(); i++){
              if(viewData.getItem(i).getPickUpPriority() == null){
                  
                  System.out.println(i+1 + ") " + viewData.getItem(i) + "\n");
              }
          }
          System.out.print("Please choose the order you want to choose: ");
          int order = scan.nextInt();
          if(order > viewData.size()){
              System.out.println("Error");
              menu();
          }
          flower = viewData.getItem(order - 1);
//          if(order > flowerCustomed.length){
//              System.out.println("Error");
//              System.exit(0);
//          }
//          System.out.println("1. " + priority[0]);
//          System.out.println("2. " + priority[1]);
//          System.out.println("3. " + priority[2]);
          priorityList.displayItem();
          System.out.print("Please select your pick up priority: ");
          int selection = scan.nextInt();
          System.out.print("Your selection: " + priorityList.getItem(selection - 1));
//          switch(selection){
//              case 1: System.out.println(priority[0]);break;
//              case 2: System.out.println(priority[1]);break;
//              case 3: System.out.println(priority[2]);break;
//              default:System.out.println("Error");System.exit(0);
//          }
          /*System.out.printf("\nYour Flower Arrangement Type: " + flowerType + "\nFlowerSize: " 
                + flowerSize + "\nFlower Type: " +
                flowerName + "\nAccessories: " + flowerAccessories + "\nThey will be in " + priority[selection - 1] + " priority.\nAre you sure(y/n): ");*/
          System.out.print(flower + "\nThey will be in " + priorityList.getItem(selection - 1) + " priority.\nAre you sure(y/n): ");
          select = scan.next().charAt(0);
          if(select == 'y'){
              flowerControl.updateProduct(new FlowerCustomized(flower.getFlowerId(),flower.getFlowerName(),flower.getFlowerSize(),flower.getFlowerType(),flower.getFlowerAccessory(),priorityList.getItem(selection - 1)));
          }
          }while (select != 'y');
        System.out.print("Press 0 to exit, 1 to continue: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                System.exit(0);
            case 1:
                Selection();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }          
      }
     
      public static void TrackProductStock() throws AWTException, CloneNotSupportedException{
        List<Item> flowerInventory = new ArrayList<Item>();
        String line = new String(new char[90]).replace('\0', '-');
        Scanner scan=new Scanner(System.in);
        
        Item item = new Item();
        item.setItemName("Flower 1");
        item.setQuantity(200);
        item.setWarningLevel(20);
        item.setDate1("12/11/2018");
        flowerInventory.add(item);
        
        item = new Item();
        item.setItemName("Flower 2");
        item.setQuantity(100);
        item.setWarningLevel(20);
        item.setDate1("12/11/2018");
        flowerInventory.add(item);
        
        item = new Item();
        item.setItemName("Flower 3");
        item.setQuantity(10);
        item.setWarningLevel(20);
        item.setDate1("12/11/2018");
        flowerInventory.add(item);
        System.out.println(line);
        
       
        
        System.out.print("       ");
        System.out.print("Item Name");
        System.out.print("       ");
        System.out.print("Last Update");
        System.out.print("       ");
        System.out.print("Quantity");
        System.out.print("       ");
        System.out.print("Warning Level");
        System.out.println("");
        System.out.println(line);
        for(int i =0; i<flowerInventory.size();i++)
        {
            System.out.print(i+1);
            System.out.print("       ");
            System.out.print(flowerInventory.get(i).getItemName());
            System.out.print("       ");
            System.out.print(flowerInventory.get(i).getDate1l());
            System.out.print("       ");
            System.out.print(flowerInventory.get(i).getQuantity());
            System.out.print("                 ");
            System.out.print(flowerInventory.get(i).getWarningLevel());
            if(flowerInventory.get(i).getWarningLevel()>=flowerInventory.get(i).getQuantity())
            {
                System.out.print("       ");
                System.out.println("Warning");
            }
            System.out.println("");
        }
        System.out.println(line);
        System.out.print("Press 0 to exit, 1 to go to main menu: ");
        int select = scan.nextInt();
        switch (select) {
            case 0:
                attachShutDownHook();break;
            case 1:
                //Selection();
                break;
            default:
                System.out.println("Error");
                attachShutDownHook();
                break;
        }
      }
     
      public static void Report() throws AWTException, CloneNotSupportedException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Monthly Report of November");
        
        String [] CustReport = {"C001       James       FlowerA       200.00", "C002       Lim       FlowerB       600.00","C003       Daniel       FlowerC      500.00","C004       Ali       FlowerA       250.00"};
        System.out.println("InvoiceID  CustName    Flower Tpye    Price");
        System.out.println("============================================");
        for(int i = 0; i < CustReport.length; i++){
            System.out.println(CustReport[i]);
        }
        System.out.print("Press 0 to exit, 1 to go to main menu: ");
        int select = scan.nextInt();
        switch (select) {
            case 0:
                attachShutDownHook();
            case 1:
                //Selection();
                break;
            default:
                System.out.println("Error");
                attachShutDownHook();
                break;
        }
      }
      
      public static void DeliveryList() throws AWTException, CloneNotSupportedException{
            Scanner scan = new Scanner(System.in);
            DeliveryOrderList[] d = new DeliveryOrderList[6];
            d[0] = new DeliveryOrderList("D0L0001", "445 Mount Eden Road, Mount Eden, Malaysia", 107.80, "Allium roseum", "Daniel Lee");
            d[1] = new DeliveryOrderList("D0L0002", "21 Greens Road RD 2 Ruawai 0592", 70.65, "Daffodil", "Cheng Jiun");
            d[2] = new DeliveryOrderList("D0L0003", "Main Highway Otaki; 32 Wilson Street", 120.40, "Delphinium", "Yen Khai");
            d[3] = new DeliveryOrderList("D0L0004", "PO Box 39100, Howick", 50.30, "Delphinium", "Jasmine Lee");
            d[4] = new DeliveryOrderList("D0L0005", "CMB C5, Huntly", 200.50, "Delphinium", "Tuck Wai");
            d[5] = new DeliveryOrderList("D0L0006", "Lot 12 Via Cola Rie", 150.30, "Delphinium", "Han Wen");

            for(int i=0; i < d.length; i++){
                System.out.println(d[i].toString());
            }
            System.out.println("\nTotal Number of Delivery Order List:" + DeliveryOrderList.totalList);
            
            System.out.print("Press 0 to exit, Press 1 to continue: ");
            int select = scan.nextInt();
            switch (select) {
            case 0:
                attachShutDownHook();break;
            case 1:
                //Selection();
                break;
            default:
                System.out.println("Error");
                attachShutDownHook();
                break;
        }
      }
      
      public static void Corporate() throws AWTException, CloneNotSupportedException{
          Scanner scan = new Scanner(System.in);
          System.out.println("Enter the customer'name that want to update as corporate customer");
          while(scan.hasNextLine()){
          String loginCust= scan.nextLine();
          boolean login = false;
        
        try{
            for(int i = 0; i < custList.length(); i++){
                if(custList.getData(i) != null){
                    if((loginCust.equals(custList.getData(i).getCustName()))){
                        currentUser = custList.getData(i);
                        login = true;
                        break;                        
                    }
                }
            }
        }catch(Exception e){         
        }
      
      if(login == true){
            System.out.println("Verify Success");
            System.out.println("Are you sure want to update " +  custList.getData(0).getCustName() + " as a corporate customer");
            System.out.print("Press 1 to yes, 0 to cancel: ");
        int select = scan.nextInt();
        switch (select) {
            case 1:
                System.out.println("Update " + custList.getData(0).getCustName() +"as corporate customer successful");
                System.out.print("Press 1 to update more corporate customer, 0 to go back main menu: ");
                int choose = scan.nextInt();
            switch (choose) {
            case 0:
                attachShutDownHook();break;
            case 1:
                Corporate();
                break;
            default:
                System.out.println("Error");
                attachShutDownHook();;
                break;
                        }
            case 0:
                System.out.println("Update fail!");
                Selection();
            default:
                System.out.println("Error");
                attachShutDownHook();
                break;
        }}else{
            System.out.println("Verify Unsuccessful");
            System.out.println("Please try again!");
            Corporate();
        }
       }   
       
}
      
      public static void MonthlyPromotion() throws AWTException, CloneNotSupportedException{
          LocalDateTime now = LocalDateTime.now();
        int currentYear=now.getYear();
        int currentMonth=now.getMonthValue();
        
        List<Item> flowerInventory = new ArrayList<Item>();
        List<PromotionList> Promotion = new ArrayList<PromotionList>();
        String line = new String(new char[90]).replace('\0', '-');
         String line2 = new String(new char[90]).replace('\0', '=');
        Scanner scan=new Scanner(System.in);
        boolean existingPromotion=false;
        Item item = new Item();
        item.setItemName("Flower 1");
        item.setQuantity(200);
        item.setWarningLevel(20);
        item.setDate1("12/11/2018");
        flowerInventory.add(item);
        
        item = new Item();
        item.setItemName("Flower 2");
        item.setQuantity(100);
        item.setWarningLevel(20);
        item.setDate1("12/11/2018");
        flowerInventory.add(item);
        
        item = new Item();
        item.setItemName("Flower 3");
        item.setQuantity(10);
        item.setWarningLevel(20);
        item.setDate1("12/11/2018");
        flowerInventory.add(item);
        
        //Start
        System.out.println("Creating Promotion");
        //Title
                System.out.println("Please enter year of the product promotion");
                int dateYear;
                do
                {
                    dateYear=scan.nextInt();
                    System.out.println("Input Year must greater then current year");
                }while(currentYear>dateYear);
                
                System.out.println("Please enter month of the product promotion(1-12)");
                int dateMonth ;
                do
                {
                    dateMonth=scan.nextInt();
                    System.out.println("Please enter valid month");
                    
                }while(currentYear==dateYear && currentMonth>dateMonth || dateMonth>13);
                
                    for(int j=0;j<Promotion.size();j++)
                    {
                        if(Promotion.get(j).getMonth()==dateMonth && Promotion.get(j).getYear()==dateYear)
                        {
                            existingPromotion=true;
                        }
                    }
                    
                    if(existingPromotion==true)
                    {
                        System.out.println("The promotion date are existing. You can go to add the promotion date in promotion menu");
                        String exitToMenu= scan.next();
                        System.exit(0);
                    }
                    System.out.println("Please enter the promotion title");
                    String title=scan.next();
                
        //Promotion();
        
        System.out.println(line);
        
       
        
        System.out.print("       ");
        System.out.print("Item Name");
        System.out.print("       ");
        System.out.print("Last Update");
        System.out.print("       ");
        System.out.print("Quantity");
        System.out.print("       ");
        System.out.print("Warning Level");
        System.out.println("");
        System.out.println(line);
        for(int i =0; i<flowerInventory.size();i++)
        {
            System.out.print(i+1);
            System.out.print("       ");
            System.out.print(flowerInventory.get(i).getItemName());
            System.out.print("       ");
            System.out.print(flowerInventory.get(i).getDate1l());
            System.out.print("       ");
            System.out.print(flowerInventory.get(i).getQuantity());
            System.out.print("                 ");
            System.out.print(flowerInventory.get(i).getWarningLevel());
            if(flowerInventory.get(i).getWarningLevel()>=flowerInventory.get(i).getQuantity())
            {
                System.out.print("       ");
                System.out.println("Warning");
            }
            System.out.println("");
        }
        System.out.println(line);
        System.out.println("Please select item(index number) for promotion");
        System.out.println("Press 0 to exit");
        System.out.print("Index = ");
        
        boolean indexNumber=false;
        int select ;
        
        do
        {
            select= scan.nextInt();
        
        
        
        for(int j=0; j<flowerInventory.size();j++)
        {
            if(select==(j+1))
            {
                System.out.println("");
                System.out.println(line);
                System.out.println("Item Selected");
                System.out.println(line);
                System.out.println(flowerInventory.get(j).getItemName());
                System.out.println(line2);
                System.out.println("");
                System.out.println("Please enter quantity for promotion ( The quantity will be reserve for promotion )");
                int quantity;
                do
                {
                  quantity = scan.nextInt();
                }while(flowerInventory.get(j).quantity<quantity || quantity==-1);
                if(quantity==-1)
                {
                    System.exit(0);
                }

                System.out.println("Please Enter Discount %");
                int discount = scan.nextInt();
               
                
                System.out.println(line2);
                System.out.print("Promotion Title         : ");
                System.out.println(title);
                System.out.print("Item Name               : ");
                System.out.println(flowerInventory.get(j).getItemName());
                System.out.print("Discount (%)          : ");
                System.out.println(discount);
                System.out.print("Quantity                : ");
                System.out.println(quantity);
                System.out.print("Month                   : ");
                System.out.println(dateMonth);
                System.out.print("Year                    :");
                System.out.println(dateYear);
            
                System.out.println(line2);
                
                System.out.println("");
                System.out.println("To confirm please press 99 or 00 to cancel : ");
                System.out.println("");
                int confirm=scan.nextInt();
                if(confirm ==99)
                {
                   
                 System.out.println("Item sucessfully added to month promotion list");
                  System.out.print("Press 0 to exit, 1 to continue: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                System.exit(0);
            case 1:
                Selection();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }   
                 
                }
                if(confirm == 00)
                {
                 System.out.println("The selected item is canceled");
                         System.out.print("Press 0 to exit, 1 to continue: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                System.exit(0);
            case 1:
                Selection();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }   
                }
                indexNumber=true;
                
                
                
            }
            else
            {
                
            }
            
        }
        
        System.out.println("Please select index according to the index number");
                
        }while(indexNumber==false);
        //here

        
        
    }
      
      public static void SalesOrder() throws AWTException, CloneNotSupportedException{
          Scanner scan = new Scanner(System.in);
          Calendar cal = Calendar.getInstance();
          int month = cal.get(Calendar.MONTH)+1;
          int Lily;
          int Rose;
          int whiteRose;
          int sunFlower;
          System.out.println("Please enter the customer'name : ");
          while(scan.hasNextLine()){
          String loginCust= scan.nextLine();
          boolean loginAccess = false;
        
        try{
            for(int i = 0; i < custList.length(); i++){
                if(custList.getData(i) != null){
                    if((loginCust.equals(custList.getData(i).getCustName()))){
                        currentUser = custList.getData(i);
                        loginAccess = true;
                        break;                        
                    }
                }
            }
        }catch(Exception e){         
        }
        
        if(loginAccess == true){
            System.out.println("Verify Successfull!");
            System.out.println("Please enter the quantity of Lily: ");
            Lily = input.nextInt();
            input.nextLine();
            System.out.println("Please enter the quantity of Rose: ");
            Rose = input.nextInt();
            input.nextLine();
            System.out.println("Please enter the quantity of White Rose: ");
            whiteRose = input.nextInt();
            input.nextLine();
            System.out.println("Please enter the quantity of Sunflower: ");
            sunFlower = input.nextInt();
            input.nextLine();   
            System.out.println("================================================");
            System.out.println("-----------------Sales Order--------------------"); 
            System.out.println("1.Lily : " + Lily);
            System.out.println("2.Rose : " + Rose);
            System.out.println("3.White Rose : " + whiteRose);
            System.out.println("4.Sunflower : " + sunFlower);
            System.out.println("Customer'name : " + loginCust);
            System.out.println("Address : " +custList.getData(0).getAddress());
            System.out.println("Phone Number : " + custList.getData(0).getPhone());
            System.out.println("Date : "+ cal.get(Calendar.DAY_OF_MONTH)+ "/" + month + "/" +cal.get(Calendar.YEAR));
            System.out.println("Time : " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
            System.out.println("================================================");
            System.out.print("Press 0 to exit, Press 1 to continue: ");
            int select = scan.nextInt();
            switch (select) {
            case 0:
                System.exit(0);break;
            case 1:
                SalesOrder();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }
        }else{
            System.out.println("Verify Fail!");
            System.out.println("Invalid Customer'name, Please try again!");
            SalesOrder();
        }
         }
        
      }
      
      public static void PaymentList() throws AWTException, CloneNotSupportedException{
          Scanner scan = new Scanner(System.in);
        Connection myconObj = null;
        Statement mystatObj = null;
        ResultSet myresObj = null;
        String query = "Select * from lee.MyTable" ;
    try{
        myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","lee", "123");
        mystatObj = myconObj.createStatement();
        myresObj = mystatObj.executeQuery(query);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%1s %15s %19s %18s %13s %21s %22s", "ORDER ID", "ITEM NAME", "PICKUP DATE", "PICKUP TIME", "QUANTITY", "Payment Amount", "Payment Status");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        while(myresObj.next()){
            String id = myresObj.getString("OrderId");
            String itemName = myresObj.getString("ItemName");
            Date pickupDate = myresObj.getDate("PickupDate");
            String pickupTime = myresObj.getString("PickupTime");
            int quantity = myresObj.getInt("Quantity");
            double paymentAmount = myresObj.getDouble("PaymentAmount");
            String paymentStatus = myresObj.getString("PaymentStatus");     
            System.out.println(id+"\t\t"+ itemName +"\t "+ pickupDate +"\t\t" + pickupTime +"\t\t"+ quantity +"\t\t"+ "RM"+ String.format("%.2f", paymentAmount) +"\t\t\t"+ paymentStatus);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("The totol order has been paid on 12/07/2018: 3");     
        System.out.println("The totol order haven't been paid on 12/07/2018: 2");
         System.out.println("Press 0 to exit, 1 to continue: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                attachShutDownHook();break;
            case 1:
                Selection();
                break;
            default:
                System.out.println("Error");
                attachShutDownHook();
                break;
        }   
    }
    catch(SQLException e){
        e.printStackTrace();
    }
 /*
        List<PaymentDetails> payDetails = new ArrayList<PaymentDetails>();
        payDetails.add(new PaymentDetails("OR001", "Flower 1", "12/07/2018", "13:00", "34",34.00, "Paid"));
        payDetails.add(new PaymentDetails("OR002", "Flower 2", "12/07/2018", "15:00", "13",34.00, "Paid"));
        payDetails.add(new PaymentDetails("OR003", "Flower 3", "12/07/2018", "17:00", "50",34.00, "\tNot Yet"));
        payDetails.add(new PaymentDetails("OR004", "Flower 2", "12/07/2018", "19:00", "22",34.00, "\tNot Yet"));
        payDetails.add(new PaymentDetails("OR005", "Flower 1", "12/07/2018", "21:00", "41",34.00, "Paid"));
 
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %18s %19s %18s %16s %22s %20s", "ORDER ID", "ITEM NAME", "PICKUP DATE", "PICKUP TIME", "QUANTITY", "Payment Amont", "Payment STATUS");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        for(PaymentDetails pay: payDetails){
            System.out.format("%8s %20s %19s %15s %16s %18s %20s",
                pay.getOrderId(), pay.getItemName(), pay.getPickDate(), pay.getPickTime(), pay.getQuantity(), pay.getPaymentAmount(), pay.getPaymentStatus());
            System.out.println();
        }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
    
            System.out.println("The totol order has been paid on 12/07/2018: 3");     
            System.out.println("The totol order haven't been paid on 12/07/2018: 2"); */
    } 
      
      public static void ResetCreditLimit() throws AWTException, CloneNotSupportedException{
          Scanner scan = new Scanner(System.in);
        CompanyDetail[] companyDetail = new CompanyDetail[5];
        companyDetail[0] = new CompanyDetail("Company A", 5000.00, "Not Cleared");
        companyDetail[1] = new CompanyDetail("Company B", 5000.00, "Not Cleared");
        companyDetail[2] = new CompanyDetail("Company C", 5000.00, "Not Cleared");
        companyDetail[3] = new CompanyDetail("Company D", 5000.00, "Not Cleared");  
        char cont = 'n';
        //String [] custCreditList = {"1. CompanyA 5000 Payment Not Cleared", "2. CompanyB 5000 Payment Not Cleared", "3. CompanyC 5000 Payment Not Cleared", "4. CompanyD 5000 Payment Not Cleared"};        
        System.out.println("Monthly Payment Status");
        System.out.println("========================");
        do{
        for(int i = 0; i<companyDetail.length; i++){
            if(companyDetail[i] != null){
                System.out.println(i+1 + "." + companyDetail[i].toString());
            }
        }
        System.out.print("Please choose the company: ");
        int chose = scan.nextInt();
        
        System.out.print("Did the company have settle the credit limit before 7th? (y for yes, n for no): ");
        char confirm = scan.next().charAt(0);
        if(confirm == 'y'){
            switch(chose){
                case 1: companyDetail[0].setCreditLimit(10000.00);companyDetail[0].setPaymentStatus("Cleared");break;
                case 2: companyDetail[1].setCreditLimit(10000.00);companyDetail[1].setPaymentStatus("Cleared");break;
                case 3: companyDetail[2].setCreditLimit(10000.00);companyDetail[2].setPaymentStatus("Cleared");break;
                case 4: companyDetail[3].setCreditLimit(10000.00);companyDetail[3].setPaymentStatus("Cleared");break;
                default:System.out.println("Error");
            }
        }
        
                for(int i = 0; i<companyDetail.length; i++){
            if(companyDetail[i] != null){
                System.out.println(i+1 + "." + companyDetail[i].toString());
            }
        }
         System.out.print("Do you want to continue?(y/n): ");
         while(scan.hasNext()){
         cont = scan.next().charAt(0);
         }
        }while(cont == 'y');
         System.out.println("Press 0 to exit, 1 to continue: ");
         while(scan.hasNextInt()){
        int last = scan.nextInt();
        switch (last) {
            case 0:
                attachShutDownHook();break;
            case 1:
                Selection();
                break;
            default:
                System.out.println("Error");
                attachShutDownHook();
                break;
        }   
         }
    }
      
      
      public static void ItemizedBill() throws AWTException, CloneNotSupportedException{
//          FlowerCustomized[] flowerBill = new FlowerCustomized[10];
          /*        String[] flowerType = {"Elliptical flower arrangement", "Vertical flower arrangement", "The crescent flower arrangement"
        , "The 'S' shaped flower arrangement"};
        String[] flowerSize = {"Small", "Intermediate", "Big"};
        String[] flower = {"Lily", "Rose", "Sunflower", "White Rose"};
        String[] accessories = {"Double Artificial Holly Berry Stamens", "Bouquet Holder", "No need"};
          String[] priority = {"Express (Highest)", "Normal", "Flexi (Lowest)"};*/
//          flowerBill[0] = new FlowerCustomized("Elliptical flower arrangement", "Small", "Rose", "Double Artificial Holly Berry Stamens","Normal");
//          flowerBill[1] = new FlowerCustomized("Vertical flower arrangement", "Big", "White Rose", "Bouquet Holder","Express (Highest)");
          FlowerCustomized flower = null;
          FlowerCustomizedControl flowerControl = new FlowerCustomizedControl();
          QueueInterface<FlowerCustomized> viewData = flowerControl.getAllProduct();          
          Scanner scan = new Scanner(System.in);
          double flowerArrangePrice = 0;
          double sizePrice = 0;
          double flowerPrice = 0;
          double accessoriesPrice = 0;
          double pickUpPrice = 0;
          double totalPrice = 0;
          
          for(int i = 0; i < viewData.size(); i++){
              if(viewData.getItem(i).getPickUpPriority() != null){
                  System.out.println(i+1 + ") " + viewData.getItem(i) + "\n");
              }
          }
          System.out.print("Please choose the order you want to choose: ");
          int order = scan.nextInt();
          if(order > viewData.size()){
              System.out.println("Error");
              menu();
          }
          flower = viewData.getItem(order - 1);
          //calculate flower arrangement type price
          if(flower.getFlowerType().equals("Elliptical flower arrangement")){
              flowerArrangePrice = 25.00;
          }else if(flower.getFlowerType().equals("Vertical flower arrangement")){
              flowerArrangePrice = 30.00;
          }else if(flower.getFlowerType().equals("The crescent flower arrangement")){
              flowerArrangePrice = 28.00;
          }else if(flower.getFlowerType().equals("The 'S' shaped flower arrangement")){
              
          }
                  
          //calculate flower size price
          if(flower.getFlowerSize().equals("Small")){
              sizePrice = 2.00;
          }else if(flower.getFlowerSize().equals("Intermediate")){
              sizePrice = 5.00;
          }else if(flower.getFlowerSize().equals("Big")){
              sizePrice = 10.00;
          }
          
          //calculate flower type price
          if(flower.getFlowerName().equals("Rose")){
              flowerPrice = 10.00;
          }else if(flower.getFlowerName().equals("White Rose")){
              flowerPrice = 12.00;
          }else if(flower.getFlowerName().equals("Sunflower")){
              
          }else if(flower.getFlowerName().equals("Lily")){
              
          }
          
          //calculate accessories
          if(flower.getFlowerAccessory().equals("Double Artificial Holly Berry Stamens")){
              accessoriesPrice = 2.00;
          }else if(flower.getFlowerAccessory().equals("Bouquet Holder")){
              accessoriesPrice = 3.00;
          }else if(flower.getFlowerAccessory().equals("No need")){
              accessoriesPrice = 0;
          }
          
          //calculate priority price
          if(flower.getPickUpPriority().equals("Express (Highest)")){
              pickUpPrice = 5.00;
          }else if(flower.getPickUpPriority().equals("Normal")){
              pickUpPrice = 2.00;
          }else if(flower.getPickUpPriority().equals("Flexi (Lowest)")){
              pickUpPrice = 0.50;          }
          totalPrice = pickUpPrice + accessoriesPrice + flowerPrice + flowerArrangePrice + sizePrice;
          System.out.println("==================================================================================");          
          System.out.println("\t\t\t\tItemized Bill");
          System.out.println("==================================================================================");
          System.out.println("\t\t\t\t\t\t\t\t\tPrice");
          System.out.println("\t\t\t\t\t\t\t\t\t------");
          System.out.println("Flower Arrangement Type: " + flower.getFlowerType() + " ---> RM " + String.format("%.2f", flowerArrangePrice));
          System.out.println("Flower Size: " + flower.getFlowerSize() + " ---> RM " + String.format("%.2f", sizePrice));
          System.out.println("Flower Type: " + flower.getFlowerName() + " ---> RM " + String.format("%.2f", flowerPrice));
          System.out.println("Flower Accessories: " + flower.getFlowerAccessory() + " ---> RM " + String.format("%.2f", accessoriesPrice));
          System.out.println("Pick Up Priority: " + flower.getPickUpPriority() + " ---> RM " + String.format("%.2f", pickUpPrice));
          System.out.println("==================================================================================");
          System.out.println("\t\t\t\t\t\t\t   Total Price: RM"+ String.format("%.2f", totalPrice));
          System.out.print("Press 0 to exit, Press 1 to continue: ");
            int select = scan.nextInt();
            switch (select) {
            case 0:
                attachShutDownHook();break;
            case 1:
                Selection();
                break;
            default:
                System.out.println("Error");
                attachShutDownHook();
                break;
        }
          
      }
      
      private static void MaintainCatalog() throws AWTException, CloneNotSupportedException{
          //MaintainCatalogUI mainui = new MaintainCatalogUI();
          MaintainCatalogUI.MaintainCatalogMenu();
          
      }
      
      }
      


