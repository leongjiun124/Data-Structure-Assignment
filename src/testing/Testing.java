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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
            System.out.println("LOGIN SUCCESSFUL!!!");
            Testing.Selection();
        }else{
            System.out.println("LOGIN UNSUCCESSFUL,PLEASE TRY AGAIN!!!");
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
        System.out.println("2. Track Product Stock"); 
        System.out.println("3. Generate Monthly Invoice");
        System.out.println("4. Delivery Order List");
        System.out.println("5. Customized Floral Arrangement");
        System.out.println("6. Return to the main menu");       
        
        System.out.printf("Please enter number to select the option:  ");
        int selection;
        selection = sc.nextInt();
        sc.nextLine();
        
        switch(selection){
            case 1:Booking();break;
            case 2: TrackProductStock();break;
            case 3: Report();break;
            case 4: DeliveryList(); break;
            case 5:CustomizedFlowerMenu();break;
            case 6:menu(); break;
        }
        /*if(selection == 1){
           Booking();
        }else if(selection == 2){
           menu();                 
      }*/
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
      
      public static void PickUpPriority() throws AWTException, CloneNotSupportedException{
          String[] priority = {"Express (Highest)", "Normal", "Flexi (Lowest)"};
          FlowerCustomized[] flowerCustomed = new FlowerCustomized[2];
          flowerCustomed[0] = new FlowerCustomized("Vertical flower arrangement", "Small", "Lily", "Double Artificial Holly Berry Stamens");
          flowerCustomed[1] = new FlowerCustomized("Elliptical flower arrangement", "Big", "Rose", "No Need");
          
          /*String flowerType = type;
          String flowerSize = size;
          String flowerName = flower;
          String flowerAccessories = accessories;*/
          char select;
          Scanner scan = new Scanner(System.in);
          do{
          for(int i = 0; i<flowerCustomed.length; i++){
              System.out.println(i+1 + ") " + flowerCustomed[i].toString());
          }
          System.out.print("Please choose the order you want to choose: ");
          int order = scan.nextInt();
          System.out.println("1. " + priority[0]);
          System.out.println("2. " + priority[1]);
          System.out.println("3. " + priority[2]);
          System.out.print("Please select your pick up priority: ");
          int selection = scan.nextInt();
          System.out.print("Your selection: ");
          switch(selection){
              case 1: System.out.println(priority[0]);break;
              case 2: System.out.println(priority[1]);break;
              case 3: System.out.println(priority[2]);break;
          }
          /*System.out.printf("\nYour Flower Arrangement Type: " + flowerType + "\nFlowerSize: " 
                + flowerSize + "\nFlower Type: " +
                flowerName + "\nAccessories: " + flowerAccessories + "\nThey will be in " + priority[selection - 1] + " priority.\nAre you sure(y/n): ");*/
          System.out.print(flowerCustomed[order - 1].toString() + "\nThey will be in " + priority[selection - 1] + " priority.\nAre you sure(y/n): ");
          select = scan.next().charAt(0);
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
       
}
