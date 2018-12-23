/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import static testing.MainMenu.flowerStack;
import static testing.MainMenu.initFlower;
import static testing.MaintainCatalog.MaintainCatalogMenu;
import static testing.MaintainCatalog.sc;
import static testing.MainMenu.promotionItem;
import Entity.PromotionDomain;
import Control.BookingControl;
import Control.CustomerControl;
import Control.DeliveryOrderListControl;
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
import Entity.FlowerInventory;
import Entity.Staff;
import da.BookingDA;
import da.CustomerDA;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author han wen
 */
public class Testing {
    
    //generate Linked Array of each classes
    public static ArrayInterface<Customer> custList = new Array<>();
    public static ArrayInterface<Booking> bookList = new Array<>();
    public static QueueFlowerCustomizedInterface<String> flowerList = new QueueFlowerCustomized<>();
    public static QueueFlowerCustomizedInterface<String> arrangementList = new QueueFlowerCustomized<>();
    public static QueueFlowerCustomizedInterface<String> sizeList = new QueueFlowerCustomized<>();
    public static QueueFlowerCustomizedInterface<String> accessoryList = new QueueFlowerCustomized<>();
    public static QueueFlowerCustomizedInterface<String> priorityList = new QueueFlowerCustomized<>();
    public static QueueFlowerCustomizedInterface<Staff> staffList = new QueueFlowerCustomized<>();
    public static FlowerInventoryLinkedList<FlowerInventory> flowerStack = new FlowerInventoryLinkedList<>();
    public static QueueInterface<String> efficientRoute = new ArrayQueue<>();
    public static Scanner sc = new Scanner(System.in);
    public static Scanner input = new Scanner(System.in);
    public static Booking currentBooking;
    public static Customer currentUser;
    public static Staff currentStaff;
    public int date2;
    public int discount1;
    public int month1;
    
     public static void main(String[] args) throws AWTException, ParseException, CloneNotSupportedException {
         custList.add(new Customer("C00001","Mia Khalifa","12345","Mia Khalifa","981126-06-5000","012-6969696","12, Jalan Pudu, 55100 Kuala Lumpur.","Corporate"));
         custList.add(new Customer("C00002","abc123","12345","abc123","981126-06-5000","012-6969696","12, Jalan Pudu, 55100 Kuala Lumpur.","Consumer"));
         staffList.enqueue(new Staff("S1", "Staff 1", "abc123", "abc123"));
//         flowerList.enqueue("Rose");
//         flowerList.enqueue("White Rose");
//         flowerList.enqueue("Sunflower");
//         flowerList.enqueue("Lily");
        FlowerInventory flowerInventory = new FlowerInventory(100001, "Rose", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100002, "White Rose", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100003, "Sunflower", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100003, "Lily", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);  
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
            int flag = 1;
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "lee", "123");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from CUSTOMER");
            while(rs.next()){
                if(rs.getString(2).equals(loginCust) && rs.getString(3).equals(loginPassword))
                {
                    flag = 0;                   
                    break;
                }               
            }
            if(flag==0){    
                loginAccess = true;
            }else{
                System.out.println("Invalid Username and Password! Plese try again!");
            }
        }catch (SQLException ex){
            System.out.println("Invalid Username and Password! Plese try again!");
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
        CustomerControl customerControl = new CustomerControl();
            
        System.out.printf("Username        : ");
         custUsername = sc.nextLine();
        
        do{
            if(custUsername.isEmpty()){
               System.out.println("Please enter your Username !");
               System.out.printf("Username        : ");
               custUsername = sc.nextLine();              
            }
        }while((custUsername.isEmpty()));
           
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
                 int index = 1;
        String custId;
        String id;
        do {
            id = Customer.generateID(index);
            index++;
        } while (customerControl.getRecord(id) != null);
         custId = id;
         custList.add(new Customer(custId, custUsername,custPassword,custName,ic,phone,address));
         customerControl.addCustomer(custList.getAndRemoveData(2));
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
        System.out.println("4. Order Pickup/Delivery and Consumer Payment Management");
        System.out.println("=======================================================");
        
        System.out.printf("Please enter number to select the option:  ");
        selection = scan.nextInt();
        switch(selection){
            case 1:CustMaintenence();break;
            case 2:MaintainCatalog.MaintainCatalogMenu();break;
            case 3: Promotion();break;
            case 4:OrderPickup();break;          
        }
     }
     
     public static void Promotion() throws AWTException, CloneNotSupportedException{
                 initFlower();
        int totalItem=0;
        int id=0;
        id=promotionItem.pop().getPromotionID();
        totalItem=flowerStack.getNumberOfEntries();
        
        LocalDateTime now = LocalDateTime.now();
        int currentYear=now.getYear();
        int currentMonth=now.getMonthValue();
        int currentDay=now.getDayOfMonth();
        String CombineAll= currentDay + ("-") + currentMonth + ("-") + currentYear;
        
        
        //System.out.print(CombineAll);
        
        String line = new String(new char[90]).replace('\0', '-');
         String line2 = new String(new char[90]).replace('\0', '=');
        Scanner scan=new Scanner(System.in);
        boolean existingPromotion=false;
        
        
        int promotionID=0;// testing
        promotionID=id+1;
        //Start
        System.out.println("Creating Promotion");
        //Title
                System.out.println("Please enter year of the product promotion");
                int dateYear;
                do
                {
                    dateYear=scan.nextInt();
                    if(currentYear>dateYear)
                    {
                        System.out.println("Input Year must greater then current year");
                    }  
                }while(currentYear>dateYear);
                System.out.println("Please enter month of the product promotion(1-12)");
                int dateMonth ;
                do
                {
                    dateMonth=scan.nextInt();
                    if(currentYear==dateYear && currentMonth>dateMonth || dateMonth>13)
                    {
                        System.out.println("Please enter valid month");
                    }
                }while(currentYear==dateYear && currentMonth>dateMonth || dateMonth>13);
                
                System.out.println("Please enter the promotion title");
                String title=scan.next();
                
                
        int count=0;
        for(int a=1;a<=totalItem;a++)
        {count++;
            System.out.println( count +" "+ flowerStack.getEntry(a).getProductID() + " " + flowerStack.getEntry(a).getProductName() +" " + flowerStack.getEntry(a).getProductCategory() + " " +
            flowerStack.getEntry(a).getProductQuantity() + " " + flowerStack.getEntry(a).getProductWarningLvl() + " " + flowerStack.getEntry(a).getCombineAll());
        }       

            System.out.println("Please select item(index number) for promotion");
            int select=0;
            do
        {
            select= scan.nextInt();
            if(select>count)
            {
                System.out.println("Please Re-enter");
            }
        }while(select>count);
            System.out.println("Please Enter Discount %");
            int discount = scan.nextInt();
            
            System.out.println("To confirm please press 99 or 00 to cancel : ");
                System.out.println("");
                int confirm=scan.nextInt();
                if(confirm ==99)
                {
                    PromotionDomain p=new PromotionDomain(promotionID,title,dateMonth,dateYear,discount,flowerStack.getEntry(select).getProductID());
                    promotionItem.push(p);
                    System.out.println("\n\n\n");
                    System.out.println("Pomotion ID = " + promotionItem.pop().getPromotionID());
                    System.out.println("Pomotion Name = " + title );
                    System.out.println("Pomotion Year = " + dateYear);
                    System.out.println("Pomotion Month = " + dateMonth);
                    System.out.println("Pomotion Discount = " + discount);
                    System.out.println("Product ID = " + flowerStack.getEntry(select).getProductID());
                 System.out.println("Item sucessfully added to month promotion list");
                }
                if(confirm == 00)
                {
                 System.out.println("The selected item is canceled");
                }
 
    }
     
     
     public static void OrderPickup() throws AWTException, CloneNotSupportedException{
        int selection;
        String cont;
        Scanner myScanner = new Scanner(System.in);
        do{
            System.out.println("Welcome to Fiore Flowershop");
            System.out.println("---------------------------------");
            System.out.println("Selection of process");
            System.out.println("1. View Delivery Order List");
            System.out.println("2. Select Efficient Route");
            System.out.println("3. View Pickup Order List");
            System.out.println("4. Update Pickup Status");
            System.out.println("5. Check Payment Status");
            System.out.println("6. Update Payment Status");
            System.out.println("7. Exit");
            System.out.print("Selection : ");
        	selection = myScanner.nextInt();
        	if(selection < 1 || selection > 6){
        		System.out.println("Wrong Selection. Please select again.");
        	}
        switch(selection){
        	case 1: ViewDeliveryOrderList();break;
        	case 2: SelectEfficientRoute();break;
        	case 3: ViewPickupOrderList();break;
        	case 4: UpdatePickupStatus();break;
        	case 5: CheckPaymentStatus();break;
                case 6: UpdatePaymentStatus();break;
        	default: break;
        }
        System.out.print("Would you want to retry the selction of process? (YES to continue) :");
        cont = myScanner.next();
		}while(cont.toUpperCase().equals("YES"));
        System.exit(0);
     }
     
         public static void ViewDeliveryOrderList(){
        Connection myconObj = null;
        Statement mystatObj = null;
        ResultSet myresObj = null;
        String query = "Select * from Delivery" ;
    try{
        myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","lee", "123");
        mystatObj = myconObj.createStatement();
        myresObj = mystatObj.executeQuery(query);
        System.out.println("=============================================================================================================================================");
        System.out.printf("%1s %15s %13s %20s %35s %24s", "ORDER ID", "ITEM NAME", "QUANTITY", "ADDRESS", "DELIVERY MAN IN CHARGE", "EFFICIENT ROUTE");
        System.out.println();
        System.out.println("=============================================================================================================================================");
        if(!myresObj.next()){
            System.out.println("No record found!");
        }else{
        
        while(myresObj.next()){
            String id = myresObj.getString("OrderId");
            String itemName = myresObj.getString("ItemName");
            int quantity = myresObj.getInt("Quantity");
            String address = myresObj.getString("Address");
            String deliveryMan = myresObj.getString("DeliveryMan");  
            String efficientRoute = myresObj.getString("EfficientRoute");
            System.out.println(id+"\t\t"+ itemName +"\t"+ quantity +"\t" + address +"\t\t"+ deliveryMan +"\t\t" + efficientRoute);
        }
        }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
            //int count = myresObj.getInt(query);
            //System.out.println("MyTable has " + count + " row(s).");
            System.out.println("Press 0 to exit, 1 to continue: ");     
    }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
         
         public static void UpdatePaymentStatus(){
            Scanner scan = new Scanner(System.in);
            DeliveryOrderListControl deliveryControl = new DeliveryOrderListControl();
            int chooseStatus;
            int status;
            int choice;
            int back;
            String choosenStatus = null;
            DeliveryOrderList delivery = new DeliveryOrderList();
            QueueInterface<DeliveryOrderList> viewAll = deliveryControl.getAllDeliveryOrderList();
            for(int i = 0; i < viewAll.totalLength(); i++){
                if(viewAll.getItem(i).getPaymentStatus() == null || viewAll.getItem(i).getPaymentStatus().equals("Not Yet")){          
                  System.out.println(i+1 + ") " + viewAll.getItem(i).getOrderId() + "\n");
                }
            }
                System.out.print("Please choose the payment status you want to update the status: ");
                chooseStatus = scan.nextInt();
                delivery = viewAll.getItem(chooseStatus - 1);
                System.out.println("1. Already");
                System.out.println("2. Not Yet");
                System.out.print("What type of pickup status you want to update for " + delivery.getOrderId() + ": ");
                status = scan.nextInt();
                    switch (status) {
                        case 1:
                            choosenStatus = "Already";
                            break;
                        case 2:
                            choosenStatus = "Not Yet";
                            break;
                            default:
                            System.out.println("Error");
                            //StaffSelection();
                            break;
                    }
                        System.out.print("Are you sure? (1 to continue, 0 to return to menu): ");
                        choice = scan.nextInt();
                        if(choice == 1){
                            deliveryControl.updatePaymentStatus(new DeliveryOrderList(delivery.getOrderId(), delivery.getItemName(), delivery.getQuantity(), delivery.getAddress(), delivery.getDeliveryMan(), delivery.getEfficientRoute(), delivery.getPickupDate(), delivery.getPickupTime(), delivery.getPickupStatus(), delivery.getPaymentAmount(), choosenStatus));
                        }
         }
    public static void ViewPickupOrderList(){
    	Scanner scan = new Scanner(System.in);
        Connection myconObj = null;
        Statement mystatObj = null;
        ResultSet myresObj = null;
        String query = "Select * from lee.Delivery" ;
    try{
        myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","lee", "123");
        mystatObj = myconObj.createStatement();
        myresObj = mystatObj.executeQuery(query);
        System.out.println("====================================================================================================================");
        System.out.printf("%1s %15s %19s %21s %17s %20s", "ORDER ID", "ITEM NAME", "PICKUP DATE", "PICKUP TIME", "QUANTITY", "PICKUP STATUS");
        System.out.println();
        System.out.println("====================================================================================================================");
        while(myresObj.next()){
            String id = myresObj.getString("OrderId");
            String itemName = myresObj.getString("ItemName");
            Date date = myresObj.getDate("PickupDate");
            Date time = myresObj.getTime("PickupTime");
            int quantity = myresObj.getInt("Quantity");
            String pickupStatus = myresObj.getString("PickupStatus");     
            System.out.println(id+"\t\t"+ itemName +"\t "+ date +"\t\t" + time +"\t\t"+ quantity +"\t\t" +pickupStatus);
        }
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println("The Total Number of Order have been Pickup: 1");   
                    
            System.out.println("Press 0 to exit, 1 to continue: ");     
    }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void CheckPaymentStatus(){
    	Scanner scan = new Scanner(System.in);
        Connection myconObj = null;
        Statement mystatObj = null;
        ResultSet myresObj = null;
        String query = "Select * from Delivery" ;
    try{
        myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","lee", "123");
        mystatObj = myconObj.createStatement();
        myresObj = mystatObj.executeQuery(query);
        System.out.println("===================================================================================================");
        System.out.printf("%1s %15s %19s %23s %22s", "ORDER ID", "ITEM NAME", "QUANTITY", "PAYMENT AMOUNT", "PAYMENT STATUS");
        System.out.println();
        System.out.println("===================================================================================================");
        while(myresObj.next()){
            String id = myresObj.getString("OrderId");
            String itemName = myresObj.getString("ItemName");
            int quantity = myresObj.getInt("Quantity");
            Double paymentAmount = myresObj.getDouble("PaymentAmount");
            String paymentStatus = myresObj.getString("PaymentStatus");     
            System.out.println(id+"\t\t"+ itemName +"\t\t"+ quantity +"\t\t" + "RM" + String.format("%.2f", paymentAmount) +"\t\t\t"+ paymentStatus);
        }
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("The totol order haven't been paid: 2"); 
           
            System.out.println("Press 0 to exit, 1 to continue: ");     
    }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
        
        public static void SelectEfficientRoute() throws AWTException, CloneNotSupportedException{
          efficientRoute.enqueue("Ampang Road     (2km)");
          efficientRoute.enqueue("Bangsar Road    (7km)");
          efficientRoute.enqueue("Chow Kit Road   (10km)");
          efficientRoute.enqueue("Campbell Road   (12km)");
          efficientRoute.enqueue("Batu Road       (15km)");
          efficientRoute.enqueue("Yap Ah Loy Road (18km)");
          DeliveryOrderList delivery = null;
          DeliveryOrderListControl deliveryControl = new DeliveryOrderListControl();
          QueueInterface<DeliveryOrderList> viewData = deliveryControl.getAllDeliveryOrderList();
          char select;
          Scanner scan = new Scanner(System.in);
          do{
            for(int i = 0; i < viewData.totalLength(); i++){
                if(viewData.getItem(i).getDeliveryMan() == null){           
                    System.out.println(i+1 + ") " + viewData.getItem(i).getAddress() + "\n");
              }
          }
          System.out.print("Please choose the efficient route you want to choose: ");
          int route = scan.nextInt();
          if(route > viewData.totalLength()){
              System.out.println("Error");
//              menu();
          }
          delivery = viewData.getItem(route - 1);

          efficientRoute.displayItem();
          System.out.print("Please select your efficient route: ");
          int selection = scan.nextInt();
          System.out.print("Your selection: " + efficientRoute.getItem(selection - 1));

          System.out.print(delivery + "\nYou may take the " + efficientRoute.getItem(selection - 1) + " to deliver.\nAre you sure(y/n): ");
          select = scan.next().charAt(0);
          if(select == 'y'){
              deliveryControl.updateDeliveryOrderList(new DeliveryOrderList(delivery.getOrderId(),delivery.getItemName(),delivery.getQuantity(),delivery.getAddress(),delivery.getDeliveryMan(),efficientRoute.getItem(selection - 1),delivery.getPickupDate(),delivery.getPickupTime(),delivery.getPickupStatus(),delivery.getPaymentAmount(),delivery.getPaymentStatus()));
          }
          }while (select != 'y');
        System.out.print("Press 0 to exit, 1 to continue: ");
        int last = scan.nextInt();
        switch (last) {
            case 0:
                System.exit(0);
            case 1:
                //Selection();
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
        }          
      }
        
        public static void UpdatePickupStatus() throws AWTException, CloneNotSupportedException{
            Scanner scan = new Scanner(System.in);
            DeliveryOrderListControl deliveryControl = new DeliveryOrderListControl();
            int chooseStatus;
            int status;
            int choice;
            int back;
            String choosenStatus = null;
            DeliveryOrderList delivery = new DeliveryOrderList();
            QueueInterface<DeliveryOrderList> viewAll = deliveryControl.getAllDeliveryOrderList();
            for(int i = 0; i < viewAll.totalLength(); i++){
                if(viewAll.getItem(i).getPickupStatus() == null){          
                  System.out.println(i+1 + ") " + viewAll.getItem(i).getOrderId() + "\n");
                }
            }
                System.out.print("Please choose the pickup status you want to update the status: ");
                chooseStatus = scan.nextInt();
                delivery = viewAll.getItem(chooseStatus - 1);
                System.out.println("1. Already");
                System.out.println("2. Not Yet");
                System.out.print("What type of pickup status you want to update for " + delivery.getOrderId() + ": ");
                status = scan.nextInt();
                    switch (status) {
                        case 1:
                            choosenStatus = "Already";
                            break;
                        case 2:
                            choosenStatus = "Not Yet";
                            break;
                            default:
                            System.out.println("Error");
                            //StaffSelection();
                            break;
                    }
                        System.out.print("Are you sure? (1 to continue, 0 to return to menu): ");
                        choice = scan.nextInt();
                        if(choice == 1){
                            deliveryControl.updatePickupOrderList(new DeliveryOrderList(delivery.getOrderId(), delivery.getItemName(), delivery.getQuantity(), delivery.getAddress(), delivery.getDeliveryMan(), delivery.getEfficientRoute(), delivery.getPickupDate(), delivery.getPickupTime(), choosenStatus, delivery.getPaymentAmount(), delivery.getPaymentStatus()));
                        }
                      /*      System.out.print("1 to return to staff menu, 0 to exit: ");
                            back = scan.nextInt();
                        switch(back){
                            case 0: System.exit(0);break;
                            case 1: StaffSelection();break;
                            default: System.out.println("Error");System.exit(0);break;
                        }*/
        }     
     public static void CustMaintenence() throws AWTException, CloneNotSupportedException{
        Scanner scan = new Scanner(System.in);
        int selection;
        System.out.println("================================================");
        System.out.println("------------------Selection---------------------");  
        System.out.println("================================================");
        System.out.println("1. Set Customer Status");
        System.out.println("2. Set Credit Limit");
        System.out.println("3. Generate Monthly Invoice");
        System.out.println("================================================");
        
        System.out.printf("Please enter number to select the option:  ");
        selection = scan.nextInt();
        switch(selection){
            case 1: SetCustStatus();break;
            case 2: SetCreditLimit();break;
            case 3: MonthlyInvoice();break;
            default: Selection();break;
        }
     }
     
     public static void SetCustStatus() throws AWTException, CloneNotSupportedException{
         Scanner scan = new Scanner(System.in);
         CustomerControl custControl = new CustomerControl();
         int chooseStatus;
         int status;
         int choice;
         int back;
         int limit = 0;
         String choosenStatus = null;
         Customer customer = new Customer();
         CustomerMaintainInterface<Customer> viewAll = custControl.getAllCustomer();
         for(int i = 0; i < viewAll.getLength(); i++){
              if(viewAll.getItem(i).getStatus() == null || viewAll.getItem(i).getStatus().equals("null")){
                  
                  System.out.print(i+1 + ") " + viewAll.getItem(i).getCustName() + "\n");
              }
                
//                System.out.print(i+1 + ") " + viewAll.pop().getCustId() + "\n");
          }
         System.out.print("Please choose the customer you want to update the status: ");
         chooseStatus = scan.nextInt();
         customer = viewAll.getItem(chooseStatus - 1);
         System.out.println("1. Corporate Customer");
         System.out.println("2. Consumer");
         System.out.print("What type of customer you want to update for " + customer.getCustName() + ": ");
         status = scan.nextInt();
        switch (status) {
            case 1:
                choosenStatus = "Corporate";
                limit = 5000;
                break;
            case 2:
                choosenStatus = "Consumer";
                break;
            default:
                System.out.println("Error");
                StaffSelection();
                break;
        }
         System.out.print("Are you sure? (1 to continue, 0 to return to menu): ");
         choice = scan.nextInt();
         if(choice == 1){
             custControl.updateStatus(new Customer(customer.getCustId(), customer.getCustUsername(), customer.getCustPassword(), customer.getCustName(), customer.getIc(), customer.getPhone(), customer.getAddress(), choosenStatus, limit));
         }
         System.out.print("1 to return to staff menu, 0 to exit: ");
         back = scan.nextInt();
         switch(back){
             case 0: System.exit(0);break;
             case 1: StaffSelection();break;
             default: System.out.println("Error");System.exit(0);break;
         }
     }
     
     public static void SetCreditLimit() throws AWTException, CloneNotSupportedException{
         Scanner scan = new Scanner(System.in);
         CustomerControl custControl = new CustomerControl();
         Customer customer = new Customer();
         int chooseStatus;
         int limit;
         int choice;
         int back;
         CustomerMaintainInterface<Customer> viewAll = custControl.getAllCustomer();
         for(int i = 0; i < viewAll.getLength(); i++){
              if(viewAll.getItem(i).getCreditLimit() < 5000 && viewAll.getItem(i).getStatus().equals("Corporate")){
                  
                  System.out.println(i+1 + ") " + viewAll.getItem(i).getCustName() + "\n");
              }
          }
         System.out.print("Please choose the customer you want to update the credit limit: ");
         chooseStatus = scan.nextInt();
         customer = viewAll.getItem(chooseStatus - 1);
//         System.out.print("Please enter the credit limit of the corporate customer: ");
//         limit = scan.nextInt();
         limit = 5000;
         System.out.print("Are you sure? (1 for yes, 0 for no): ");
         choice = scan.nextInt();
         if(choice == 1){
             custControl.updateCreditLimit(new Customer(customer.getCustId(), customer.getCustUsername(), customer.getCustPassword(), customer.getCustName(), customer.getIc(), customer.getPhone(), customer.getAddress(), customer.getStatus(), limit));
         }
         System.out.print("1 to return to staff menu, 0 to exit: ");
         back = scan.nextInt();
         switch(back){
             case 0: System.exit(0);break;
             case 1: StaffSelection();break;
             default: System.out.println("Error");System.exit(0);break;
         }
     }
     
     public static void MonthlyInvoice() throws AWTException, CloneNotSupportedException{
         Scanner scan = new Scanner(System.in);
         int back;
         CustomerControl custControl = new CustomerControl();         
         CustomerMaintainInterface<Customer> viewAll = custControl.getAllCustomer();
         for(int i = 0; i < viewAll.getLength(); i++){
              if(viewAll.getItem(i).getStatus().equals("Corporate")){
                  System.out.println(i+1 + ") " + viewAll.getItem(i).getCustName() + " -------> Credit Left: " + viewAll.getItem(i).getCreditLimit() +"\n");
              }else if(viewAll.getItem(i).getStatus() == null){
                  
              }
          }
         System.out.print("1 to return to staff menu, 0 to exit: ");
         back = scan.nextInt();
         switch(back){
             case 0: System.exit(0);break;
             case 1: StaffSelection();break;
             default: System.out.println("Error");System.exit(0);break;
         }
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
        switch(selection){
            case 1: Booking();break;
            case 2: if(currentUser.getStatus().equals("Consumer")){
                CustomizedFlowerMenu();
                break;
            }else{
                System.out.println("Can only access by consumer. Please try again");
                Selection();
                break;
            }
        }
        //sc.nextLine();
        
//        switch(selection){
//            case 1:Booking();break;
//            case 2: TrackProductStock();break;
//            case 3: Report();break;
//            case 4: DeliveryList(); break;
//            case 5:CustomizedFlowerMenu();break;
//            case 6:SetCreditLimit();break;
//            case 7: PickUpOrder();break;
//            case 8:Corporate(); break;
//            case 9:MonthlyPromotion();break;
//            case 11:ItemizedBill();break;
//            case 12: PaymentList();break;
//            case 13: ResetCreditLimit(); break;
//            case 14: MaintainCatalog();break;
//            case 15: menu();break;
//        }
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
        System.out.println("3. Itemized Bill");
        System.out.printf("Please enter number to select the option:  ");
        int select = scan.nextInt();
        switch(select){
            case 1: CustomizedFlower();break;
            case 2: PickUpPriority();break;
            case 3: ItemizedBill();break;
        }
     }
        
    public static void Booking()throws AWTException, CloneNotSupportedException{    
          Scanner scan = new Scanner(System.in);
          Calendar cal = Calendar.getInstance();
          ArrayInterface<Booking> booking = new Array<>();
          ArrayInterface<Customer> customer = new Array<>();
          BookingControl bookingControl = new  BookingControl();
          char back = 'n';
          int index = 1;
          String id;
          int month = cal.get(Calendar.MONTH)+1;          
          int amount = 0;
          int total = 0;
          int Lily;
          int sunFlower;
          int Rose;
          int whiteRose;
          int price = 0;
          String flower ="";
          int selection = 0;
          do{
          do {
            id = Booking.generateID(index);
            index++;
        } while (bookingControl.getRecord(id) != null);
         CustomerControl customerControl = new CustomerControl();
         CustomerMaintainInterface<Customer> viewAll = customerControl.getAllCustomer();
         for(int i = 0; i < viewAll.getLength(); i++){
             System.out.println("================================================");
             System.out.println("ID         Name             IC       Phone Number      Address               Status      Credit Limit ");
             System.out.println( viewAll.getItem(i).getCustId() + "  " +  viewAll.getItem(i).getCustName() + "  " +  viewAll.getItem(i).getIc() + "  " +  viewAll.getItem(i).getPhone() + "  " +  viewAll.getItem(i).getAddress() + "  " +
                      viewAll.getItem(i).getStatus() + "  " +  viewAll.getItem(i).getCreditLimit());
             System.out.println("================================================");
          }
          System.out.printf("Please enter the customer'ID: ");
          while(scan.hasNextLine()){
          String loginCust= scan.nextLine();
          boolean loginAccess = false;        
        try{
            int flag = 1;
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "lee", "123");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from CUSTOMER");
            while(rs.next()){
                if(rs.getString(1).equals(loginCust))
                {
                    flag = 0;                   
                    break;
                }               
            }
            if(flag==0){    
                loginAccess = true;
            }else{
                System.out.println("Invalid customer ID! Plese try again!");
            }
        }catch (SQLException ex){
        }
        
        if(loginAccess == true){
            System.out.println("Verify Successfull!");
            System.out.println("=============================");    
            for(int a=1;a<=flowerStack.getNumberOfEntries();a++)
        {
            System.out.println(a +") " + flowerStack.getEntry(a).getProductName());
        }  
            System.out.println("=============================");
            System.out.print("Please enter number 1 to 4 to select the flower: ");    
           try{
                sc = new Scanner(System.in);
                selection = sc.nextInt();
                sc.nextLine();
                System.out.println("\n\n\n\n");              
                if(selection== 1){
                   flower = "Rose";
                   System.out.println("Each Rose costs RM 2");
                   System.out.println("Enter the quantity that you want to purchase : ");
                   total = input.nextInt();
                   input.nextLine(); 
                   price = total * 2; 
                   if(total > 100){
        do{
            if(total > 100){
               System.out.println("Purchase amount cannot more than 100 !");
               System.out.println("Enter the quantity that you want to purchase : ");
                total = input.nextInt();
                input.nextLine(); ;              
            }
        }while((total > 100));
         }
                }else if(selection == 2){
                   flower = "White Rose";
                   System.out.println("Each Rose costs RM 3");
                   System.out.println("Enter the quantity that you want to purchase : ");
                   total = input.nextInt();
                   input.nextLine();
                   price = total * 3;
                   if(total > 100){
        do{
            if(total > 100){
               System.out.println("Purchase amount cannot more than 100 !");
               System.out.println("Enter the quantity that you want to purchase : ");
                total = input.nextInt();
                input.nextLine(); ;              
            }
        }while((total > 100));
         }
                }else if(selection == 3){
                   flower = "Sunflower";
                   System.out.println("Each Rose costs RM 2");
                   System.out.println("Enter the quantity that you want to purchase : ");
                   total = input.nextInt();                   
                   input.nextLine();
                   price = total * 2; 
                   if(total > 100){
        do{
            if(total > 100){
               System.out.println("Purchase amount cannot more than 100 !");
               System.out.println("Enter the quantity that you want to purchase : ");
                total = input.nextInt();
                input.nextLine();              
            }
        }while((total > 100));
         }
                }else if(selection == 4){
                   flower = "Lily";
                   System.out.println("Each Lily costs RM 1");
                   System.out.println("Enter the quantity that you want to purchase : ");
                   total = input.nextInt();
                   input.nextLine(); 
                   price = total * 1;
                   if(total > 100){
        do{
            if(total > 100){
               System.out.println("Purchase amount cannot more than 100 !");
               System.out.println("Enter the quantity that you want to purchase : ");
                total = input.nextInt();
                input.nextLine(); ;              
            }
        }while((total > 100));
         }                   
                }else{
                    System.out.println("Invalid input! Please enter number 1 to 4 only! \n");
                } 
            }catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter number 1 to 4 only! \n");
            }
              
            
      
            System.out.println("================================================");
            System.out.println("-----------------Sales Order--------------------"); 
            System.out.println("1.Flower that you pucrhase : " + flower);
            System.out.println("Total flower: " + total);
            System.out.println("Total Price: " + "RM " + price);
            System.out.println("Customer'ID : " + viewAll.getItem(0).getCustId());
            System.out.println("Customer'Name : " + viewAll.getItem(0).getCustName());
            System.out.println("Phone Number : " + viewAll.getItem(0).getPhone());
            System.out.println("Address : " + viewAll.getItem(0).getAddress());
            System.out.println("Status : " + viewAll.getItem(0).getStatus());
            System.out.println("Credit Limit : " + viewAll.getItem(0).getCreditLimit());
            System.out.println("Date : "+ cal.get(Calendar.DAY_OF_MONTH)+ "/" + month + "/" +cal.get(Calendar.YEAR));
            System.out.println("Time : " + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
            System.out.println("================================================");
            System.out.println("Are you sure to booking? (y/n)");
            int select = scan.next().charAt(0);           
        if(select == 'y'){
            if(viewAll.getItem(0).getStatus().equals("Corporate")){
                amount = viewAll.getItem(0).getCreditLimit() - price;
            }
                customerControl.updateCreditLimit(new Customer(viewAll.getItem(0).getCustId(),viewAll.getItem(0).getCustUsername(),viewAll.getItem(0).getCustPassword(),viewAll.getItem(0).getCustName(), viewAll.getItem(0).getIc(), viewAll.getItem(0).getPhone(), viewAll.getItem(0).getAddress(),viewAll.getItem(0).getStatus(), amount));
                booking.add(new Booking(id, flower, total, new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()), cal.get(Calendar.DAY_OF_MONTH)+ "/" + month + "/" +cal.get(Calendar.YEAR),viewAll.getItem(0).getAddress(),viewAll.getItem(0).getCustId()));
                bookingControl.addBooking(booking.getAndRemoveData(0));
                System.out.println("Booking Suceess!");
                System.out.println("Generate Sales Order Success!");
                System.out.println("Do you want to continue booking?: ");
                back = scan.next().charAt(0);
                
        }else{
            System.out.println("Booking Fail!");
            StaffSelection();
        }
        
        
        }else{
            System.out.println("Verify Fail!");
            System.out.println("Invalid Customer'ID, Please try again!");
            Booking();
        }  
        
    }
          }while(back != 'n');
                      System.out.print("Press 0 to exit, Press 1 to continue: ");
            int choose = scan.nextInt();
            switch (choose) {
            case 0:
                StaffSelection();
                break;
            case 1:
                Booking();
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
        String priority = null;
        String productId;
        String id;
        String bookingId;
        Booking item = null;
        boolean check = true;
        DeliveryOrderListControl deliveryControl = new DeliveryOrderListControl();
        QueueInterface<DeliveryOrderList> viewDelivery = deliveryControl.getAllDeliveryOrderList();
        char back = 'n';
        QueueFlowerCustomizedInterface<FlowerCustomized> flowerCust = new QueueFlowerCustomized<>();
        FlowerCustomizedControl flowerControl = new FlowerCustomizedControl();
        QueueFlowerCustomizedInterface<FlowerCustomized> viewData = flowerControl.getAllProduct();
        do{
        do {
            id = FlowerCustomized.generateID(index);
            index++;
        } while (flowerCustomizedDA.getRecord(id) != null);
        productId = id;
        BookingControl bookCont = new BookingControl();
        Booking book = null;
        ArrayInterface<Booking> viewAll = bookCont.getAllProduct();
         for(int i = 0; i < viewAll.length(); i++){
              if(viewAll.getData(i).getCustId().equals(currentUser.getCustId())){
                  for(int j = 0; j < viewData.size(); j++){
                      if(viewData.getItem(j).getBookingId().equals(viewAll.getData(i).getBookingId())){
                          check = false;
                            break;
                      }
//                        System.out.println(i+1 + ") " + viewAll.getData(i).getBookingId() + "\n");
                  }
                  if(check == true){
                      System.out.println(i+1 + ") " + viewAll.getData(i).getBookingId() + "\n");
                  }
//                          item = viewAll.getData(i);
              }
          }
         System.out.println("Please Choose the order you wanted to customized: ");
         int orderChoose = scan.nextInt();
         book = viewAll.getData(orderChoose - 1);
        System.out.println("Type of flower arrangement style");
        //1. Choose the flower arrangement type
        arrangementList.displayItem();
        System.out.print("Step 1: Choose the flower arrangement style from above: ");
        
        //Scan the arrangement style that the user choose
        int selection1 = scan.nextInt();
        
        //initialise the selection from user into the decisionFlowerType

        //2. Choose the flower arrangement size
        sizeList.displayItem();

        System.out.print("Step 2: Please choose the arrangement size from above: ");
        int selection2 = scan.nextInt();

        for(int a=1;a<=flowerStack.getNumberOfEntries();a++)
        {
            System.out.println(a +") " + flowerStack.getEntry(a).getProductName());
        }  
        System.out.print("Step 3: Please choose the flower you want from above: ");
        int selection3 = scan.nextInt();
        accessoryList.displayItem();
        System.out.print("Step 4: Please choose the accessories that you want to put from above: ");
        int selection4 = scan.nextInt();
        
        //Show the customized summary and comfirm with user
        System.out.printf("\nYour selection is: " + "\nFlower Arrangement Type: " + arrangementList.getItem(selection1 - 1) + "\nFlowerSize: " 
                + sizeList.getItem(selection2 - 1) + "\nFlower Type: " +
                flowerList.getItem(selection3 - 1) + "\nAccessories: " + accessoryList.getItem(selection4 - 1) + "\nAre you sure? (y/n): ");
        select = scan.next().charAt(0);
        if(select == 'y'){
            flowerCust.enqueue(new FlowerCustomized(productId,arrangementList.getItem(selection1 - 1),sizeList.getItem(selection2 - 1),flowerList.getItem(selection3 - 1),accessoryList.getItem(selection4 - 1),priority, book.getBookingId()));
            flowerCustomizedDA.addFlower(flowerCust.dequeue());
            do {
                 bookingId = DeliveryOrderList.generateID(index);
            index++;
        } while (deliveryControl.getDeliveryOrderList(bookingId) != null);
            deliveryControl.addDeliveryOrderList(new DeliveryOrderList(bookingId, flowerList.getItem(selection3 - 1), book.getQuantity(), book.getAddress(), "Daniel Lee", null, book.getDate(), book.getTime(), null, 0.00, null, book.getBookingId()));
        }
        System.out.print("Do you want to customize another order?: ");
        back = scan.next().charAt(0);
        }while(back == 'y');
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
      
     
      
      public static void PickUpPriority() throws AWTException, CloneNotSupportedException{
//          String[] priority = {"Express (Highest)", "Normal", "Flexi (Lowest)"};
          priorityList.enqueue("Express (Highest)");
          priorityList.enqueue("Normal");
          priorityList.enqueue("Flexi (Lowest)");
          FlowerCustomized flower = null;
          FlowerCustomizedControl flowerControl = new FlowerCustomizedControl();
          QueueFlowerCustomizedInterface<FlowerCustomized> viewData = flowerControl.getAllProduct();
          
          char select;
          Scanner scan = new Scanner(System.in);
          do{
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
          priorityList.displayItem();
          System.out.print("Please select your pick up priority: ");
          int selection = scan.nextInt();
          System.out.print("Your selection: " + priorityList.getItem(selection - 1));
          System.out.print(flower + "\nThey will be in " + priorityList.getItem(selection - 1) + " priority.\nAre you sure(y/n): ");
          select = scan.next().charAt(0);
          if(select == 'y'){
              flowerControl.updateProduct(new FlowerCustomized(flower.getFlowerId(),flower.getFlowerName(),flower.getFlowerSize(),flower.getFlowerType(),flower.getFlowerAccessory(),priorityList.getItem(selection - 1),flower.getBookingId()));
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
          QueueFlowerCustomizedInterface<FlowerCustomized> viewData = flowerControl.getAllProduct();    
          BookingControl bookingCont = new BookingControl();
          String bookingId;
          ArrayInterface<Booking> viewBooking = bookingCont.getAllProduct();
          DeliveryOrderListControl deliveryControl = new DeliveryOrderListControl();
        QueueInterface<DeliveryOrderList> viewDelivery = deliveryControl.getAllDeliveryOrderList();
          Scanner scan = new Scanner(System.in);
          double flowerArrangePrice = 0;
          double sizePrice = 0;
          double flowerPrice = 0;
          double accessoriesPrice = 0;
          double pickUpPrice = 0;
          double totalPrice = 0;
          int index = 1;
          boolean add = true;
          Booking bookItem = null;
          
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
          for(int i = 0; i < viewBooking.length(); i++){
              if(viewBooking.getData(i).getBookingId().equals(flower.getBookingId())){
                  bookItem = viewBooking.getAndRemoveData(i);
              }
          }
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

          deliveryControl.updatePaymentAmount(new DeliveryOrderList(totalPrice, flower.getBookingId()));

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
      

      
      }
      


