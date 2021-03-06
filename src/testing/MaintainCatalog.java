/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import static testing.MainMenu.flowerStack;
import java.awt.AWTException;
import java.text.ParseException;
import java.util.Scanner;
import Entity.FlowerInventory;
import adt.FlowerInventoryLinkedList;
import static testing.MainMenu.initFlower;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MaintainCatalog {
    
    public static Scanner sc = new Scanner(System.in);
        public static FlowerInventoryLinkedList<FlowerInventory> flowerStack = new FlowerInventoryLinkedList<>();
        
        
    public static void main(String[] args)throws AWTException, ParseException, CloneNotSupportedException {
        initFlower();
        //System.out.printf("Total =  " + flowerStack.getNumberOfEntries() + "\n");
        //System.out.printf("Total =  " + flowerStack.peek().getProductID() + "\n");
        
       MaintainCatalogMenu();
      
    }
    
    public static void Test() throws AWTException, CloneNotSupportedException{
        FlowerInventory flowerInventory = new FlowerInventory(100001, "Rose", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100002, "White Rose", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100003, "Sunflower", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100004, "Lily", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);  
        MaintainCatalogMenu();
    }
    
    public static void MaintainCatalogMenu()throws AWTException, CloneNotSupportedException
    {

        System.out.printf("Total =  " + flowerStack.getNumberOfEntries() + "\n");
        
         System.out.println("================================================");
        System.out.println("----------------Fiore Flowershop----------------");       
        System.out.println("----------------Maintain Catalog----------------");  
        System.out.println("1. Add Product"); 
        System.out.println("2. View Product");
        System.out.println("3. Update Product");
        System.out.println("4. Remove Product");
        System.out.println("================================================");
        System.out.printf("Please enter number 1 to 4 to select the option: ");
        
        int selection;
        
        //sc.nextLine();  
        do{
            selection = sc.nextInt();
            switch (selection) {
            case 1:
                
                AddProduct();
                break;
            case 2:
                displayAll();
                break;                  
            case 3:
                
                UpdateProduct();
                break;
            case 4:
                RemoveProduct();
               
                break;
            default:System.exit(0);
                break;
        }
            
            if(selection!=0 && selection!=1 && selection!=2 && selection!=3 && selection!=4)
            {
                System.out.printf("Invalid number, press enter again");
            }
            
        }while(selection!=0 && selection!=1 && selection!=2 && selection!=3 && selection!=4);
        
    }
    public static void displayAll()throws AWTException, CloneNotSupportedException
    {
        int totalItem=0;
        totalItem=flowerStack.getNumberOfEntries();
        for(int a=1;a<=totalItem;a++)
        {
            System.out.println(flowerStack.getEntry(a).getProductID() + " " + flowerStack.getEntry(a).getProductName() +" " + flowerStack.getEntry(a).getProductCategory() + " " +
            flowerStack.getEntry(a).getProductQuantity() + " " + flowerStack.getEntry(a).getProductWarningLvl() + " " + flowerStack.getEntry(a).getCombineAll());
        }       
        System.out.printf("Please enter number any key to back menu or 0 to exit system");
        int backMene = sc.nextInt();
        switch (backMene) {
            case 0:
                System.exit(0);;
                break;
            default:
                MaintainCatalogMenu();
                break;
        }
        
        
        
    }
   
     public static void AddProduct()throws AWTException, CloneNotSupportedException{
        LocalDateTime now = LocalDateTime.now();
        int currentYear=now.getYear();
        int currentMonth=now.getMonthValue();
        int currentDay=now.getDayOfMonth();
        String lastUpdate= currentDay + ("-") + currentMonth + ("-") + currentYear;
        
        int productID;
        String productName="";
        String productDesc;
        String productCategory="";
        int productQuantity;
        int productWarningLvl;
        boolean validCatogry=false;
        int id=0;
          id=  flowerStack.lastIndex().getProductID();
        productID=++id;
        
        
        System.out.println("================================================");
        System.out.println("----------------Fiore Flowershop----------------");       
        System.out.println("-------------------Add Product------------------");
        System.out.println("Product Name : "); 
        sc.nextLine();
        productName = sc.nextLine();
        
        
        System.out.println("Product Description"); 
        productDesc = sc.nextLine();
        
        System.out.println("Product Catogory"); 
        System.out.println("1. Alstromeria"); 
        System.out.println("2. Bouquets"); 
        System.out.println("3. Asters"); 
        System.out.println("4. Carnations"); 
        System.out.println("5. Chrysanthemum");
        System.out.println("6. Exotic Blooms"); 
        System.out.println("7. Gladiolas"); 
        System.out.println("Please Select one of the catogry :"); 
        int catogorySelection;
        do{
        catogorySelection = sc.nextInt();
        switch(catogorySelection)
        {
            case 1: productCategory = "Alstromeria"; validCatogry=true; break;
            case 2: productCategory = "Bouquets"; validCatogry=true; break;
            case 3: productCategory = "Asters"; validCatogry=true; break;
            case 4: productCategory = "Carnations"; validCatogry=true; break;
            case 5: productCategory = "Chrysanthemum"; validCatogry=true; break;
            case 6: productCategory = "Exotic Blooms"; validCatogry=true; break;
            case 7: productCategory = "Gladiolas";validCatogry=true; break;
            default: System.out.println("Please select the correct index number");break;
        }
        }while(validCatogry==false);
        
        System.out.println("Quantity of product : "); 
        productQuantity = sc.nextInt();
        System.out.println("Please set the minimun level of this product in order to let the system alert user when the drop to minimun level");
        productWarningLvl = sc.nextInt();
        
        System.out.println("Product generated ID: " + productID);
        //
        System.out.println("Product name : " + productName);
        System.out.println("Product description: " + productDesc); 
        System.out.println("Product category : " + productCategory); 
        System.out.println("Product quantity : " + productQuantity);
        System.out.println("Product mininmun level : " + productWarningLvl);
        //
        System.out.println("Today : " + lastUpdate);
        
        System.out.println("Press 1 to save or press 0 to cancel :"); 
        int saveProduct;
        
        do{
        saveProduct = sc.nextInt();
        switch(saveProduct){
            case 1: 
                FlowerInventory d=new FlowerInventory(productID,productName,productDesc,productCategory,productQuantity,productWarningLvl,lastUpdate);
                flowerStack.add(d);
                
                break;
            case 2:
                System.out.println("Add product canceled, back to menu");
                System.out.println("");
                System.out.println("");
                MaintainCatalogMenu();
                break;
            default: 
                break;
        }
        
        if(saveProduct!=0 && saveProduct!=1)
            {
                System.out.printf("Invalid number, press enter again");
            }
            
        }while(saveProduct!=0 && saveProduct!=1);
 
        //Testing Item
        System.out.println("Successfully added product"); 
        System.out.println("Press any key to back menu");
        sc.nextLine();
        String back = sc.nextLine();
        switch(back)
        {
            default:
                MaintainCatalogMenu();;
                break;
        }
        
        
    }
   
     public static void UpdateProduct()throws AWTException, CloneNotSupportedException
    {
        int totalItem=0;
        totalItem=flowerStack.getNumberOfEntries();
        LocalDateTime now = LocalDateTime.now();
        int currentYear=now.getYear();
        int currentMonth=now.getMonthValue();
        int currentDay=now.getDayOfMonth();
        String lastUpdate= currentDay + ("-") + currentMonth + ("-") + currentYear;
        
        //ControlCatalogMaintain controlCatalog;
        //controlCatalog=new ControlCatalogMaintain();
        //ArrayList<DomainCatalogMaintain> viewAll = controlCatalog.getAllProduct();
        int count=0;
        System.out.println("================================================");
        System.out.println("----------------Fiore Flowershop----------------");       
        System.out.println("-----------------Update Product-----------------");
        for(int i=1;i<=totalItem;i++)
        {
            if("Alstromeria".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("1.Alstromeria  " + "(" + count + ")");
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Bouquets".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("2.Bouquets  " + "(" + count+")");
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Asters".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("3.Asters  " + "(" + count+")");
        
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Carnations".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("4.Carnations  " + "(" + count+")");
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Chrysanthemum".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("5.Chrysanthemum  " + "(" + count+")");
        
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Exotic Blooms".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("6.Exotic Blooms  " + "(" + count+")");
        
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Gladiolas".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("7.Gladiolas  " + "(" + count+")");
        
        
        System.out.println("Please select one of the option");
        int selection=0;
        String category="";
        boolean valid=false;
        do
        {
            selection=sc.nextInt();
            switch(selection){
                case 1: category="Alstromeria";
                valid=true;
                break;
                case 2:
                    category="Bouquets";
                valid=true;
                    break;
                    case 3:
                        category="Asters";
                valid=true;
                    break;
                    case 4:
                        category="Carnations";
                valid=true;
                    break;
                    case 5:
                        category="Chrysanthemum";
                valid=true;
                    break;
                    case 6:
                        category="Exotic Blooms";
                valid=true;
                    break;
                    case 7:
                        category="Gladiolas";
                valid=true;
                    break;
                    
            }
            
        }while(valid==false);
        int number=0;
        System.out.println("===================================================================");
        System.out.println("No        Flower        Description     Quantity      Warning Level");
        System.out.println("===================================================================");
        for(int j=1;j<=totalItem;j++)
        {
            if(category.equals(flowerStack.getEntry(j).getProductCategory()))
            {
                number++;
                System.out.println(" " + number + "       " + flowerStack.getEntry(j).getProductName() + "        " + flowerStack.getEntry(j).getProductDesc() + "         " + flowerStack.getEntry(j).getProductQuantity() + "         " + flowerStack.getEntry(j).getProductWarningLvl());
            }
        }
        System.out.println("Please select one if the index : ");
       
        
        if(number==0)
        {
            System.out.println("The category that you selected is empty or haven created. ");
            System.out.println("\n\n");
            System.out.println("Returning to menu");
            MaintainCatalogMenu();
            
        }
        int modify;
        boolean indexvalid=false;
        do{
            modify = sc.nextInt();
            if(modify<=number)
            {
                indexvalid = true;
            }
            if(modify>number)
            {
                System.out.println("Please Re-enter : ");
            }
            
        }while(indexvalid==false);
        
        int checkIndex=0;
        int StoreProductID=0;
        String StoreProductName="";
        String StoreProductDesc="";
        int StoreQuantity=0;
        int StoreWarningLvl=0;
        int storePosition=0;
        String StoreCategory="";
        for(int a=1;a<=totalItem;a++)
        {
            if(category.equals(flowerStack.getEntry(a).getProductCategory()))
            {
                checkIndex++;
                if(checkIndex==modify)
                {
                    storePosition=a;
                    StoreProductID=flowerStack.getEntry(a).getProductID();
                    StoreProductName=flowerStack.getEntry(a).getProductName();
                    StoreProductDesc=flowerStack.getEntry(a).getProductDesc();
                    StoreQuantity=flowerStack.getEntry(a).getProductQuantity();
                    StoreWarningLvl=flowerStack.getEntry(a).getProductWarningLvl();
                    StoreCategory=flowerStack.getEntry(a).getProductCategory();
                    
                    System.out.println("1. ProductName : " + flowerStack.getEntry(a).getProductName() );
                    System.out.println("2. Product Descripton : " + flowerStack.getEntry(a).getProductDesc() );
                    System.out.println("3. Product Category : "+ flowerStack.getEntry(a).getProductCategory());
                    System.out.println("4. Product Quantity : " + flowerStack.getEntry(a).getProductQuantity() );
                    System.out.println("5. Product Minimun Level : " +flowerStack.getEntry(a).getProductWarningLvl());
                    System.out.println("0.Exit" );
                }
            }
        }
        System.out.println("Please select product index to Update : " );
        int subModify=0;
        String updateAnswer="";
        int updateNumber=0;
        boolean validsubModify =false;
        
        do{
            subModify = sc.nextInt();
            if(subModify==0)
            {
                System.exit(0);
            }
            if(subModify>6)
            {
                System.out.println("Invalid index, please enter again" );
            }
        }while(subModify>5 || subModify<0);
        
        if(subModify==1 || subModify==2 || subModify==3)
        {
            
            System.out.printf("Update or change the contain = \n" );
            updateAnswer = sc.next();
        }
        if(subModify==4 || subModify == 5)
        {
            System.out.println("Update or change the contain = " );
            updateNumber = sc.nextInt();
        }
        
        if(subModify==1)
        {
            StoreProductName=updateAnswer;
        }
        if(subModify==2)
        {
            StoreProductDesc=updateAnswer;
        }
        if(subModify==3)
        {
            StoreCategory=updateAnswer;
        }
        if(subModify==4)
        {
            StoreQuantity=updateNumber;
        }
        if(subModify==5)
        {
            StoreWarningLvl=updateNumber;
        }
        

        System.out.println("Press 1 to save or press 0 to cancel :"); 
        int saveProduct;
        do
        {
            saveProduct = sc.nextInt();
            switch(saveProduct){
            case 1:    
                FlowerInventory f= new FlowerInventory(StoreProductID,StoreProductName,StoreProductDesc,StoreCategory,StoreQuantity,StoreWarningLvl,lastUpdate);
                flowerStack.replace(storePosition, f);
                break;
            case 2:
                System.exit(0);
                break;
            default: 
                break;
            }
            if(saveProduct!=0 && saveProduct!=1)
            {
                System.out.println("Please re-enter again : "); 
            }
            
        }while(saveProduct!=0 && saveProduct!=1);
        System.out.println("Successfully update"); 
        sc.next();
            System.out.println("Press any key to back menu");
            String back = sc.nextLine();
            switch(back)
            {
                default:
                    MaintainCatalogMenu();
                    break;
            }
        
        
        
    }
     
     
      public static void RemoveProduct()throws AWTException, CloneNotSupportedException{
          int storePosition=0;
        int totalItem=0;
        totalItem=flowerStack.getNumberOfEntries();
        LocalDateTime now = LocalDateTime.now();
        int currentYear=now.getYear();
        int currentMonth=now.getMonthValue();
        int currentDay=now.getDayOfMonth();
        String lastUpdate= currentDay + ("-") + currentMonth + ("-") + currentYear;
        
        int count=0;
        System.out.println("================================================");
        System.out.println("----------------Fiore Flowershop----------------");       
        System.out.println("-----------------Delete Product-----------------");
        for(int i=1;i<=totalItem;i++)
        {
            if("Alstromeria".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("1.Alstromeria  " + "(" + count+")");
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Bouquets".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("2.Bouquets  " + "(" + count+")");
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Asters".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("3.Asters  " + "(" + count+")");
        
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Carnations".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("4.Carnations  " + "(" + count+")");
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Chrysanthemum".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("5.Chrysanthemum  " + "(" + count+")");
        
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Exotic Blooms".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("6.Exotic Blooms  " + "(" + count+")");
        
        count=0;
         for(int i=1;i<=totalItem;i++)
        {
            if("Gladiolas".equals(flowerStack.getEntry(i).getProductCategory()))
            {
                count++;
            }
        }
        System.out.println("7.Gladiolas  " + "(" + count+")");
        
        
        System.out.println("Please select one of the option");
        int selection=0;
        String category="";
        boolean valid=false;
        do
        {
            selection=sc.nextInt();
            switch(selection){
                case 1: category="Alstromeria";
                valid=true;
                break;
                case 2:
                    category="Bouquets";
                valid=true;
                    break;
                    case 3:
                        category="Asters";
                valid=true;
                    break;
                    case 4:
                        category="Carnations";
                valid=true;
                    break;
                    case 5:
                        category="Chrysanthemum";
                valid=true;
                    break;
                    case 6:
                        category="Exotic Blooms";
                valid=true;
                    break;
                    case 7:
                        category="Gladiolas";
                valid=true;
                    break;
                    
            }
            
        }while(valid==false);
        int number=0;
        System.out.println("===================================================================");
        System.out.println("No        Flower        Description     Quantity      Warning Level");
        System.out.println("===================================================================");
        for(int j=1;j<=totalItem;j++)
        {
            if(category.equals(flowerStack.getEntry(j).getProductCategory()))
            {
                number++;
                System.out.println("" + number + "     " + flowerStack.getEntry(j).getProductName() + "      " +flowerStack.getEntry(j).getProductDesc() + "      " + flowerStack.getEntry(j).getProductQuantity() + "     " + flowerStack.getEntry(j).getProductWarningLvl());
            }
        }
        System.out.println("Please select one if the index : ");
       
        
        if(number==0)
        {
            //back to menu
            
        }
        int modify;
        boolean indexvalid=false;
        do{
            modify = sc.nextInt();
            if(modify<=number)
            {
                indexvalid = true;
            }
            if(modify>number)
            {
                System.out.println("Please Re-enter : ");
            }
            
        }while(indexvalid==false);
        
        int checkIndex=0;
        int StoreProductID=0;
        for(int a=1;a<=totalItem;a++)
        {
            if(category.equals(flowerStack.getEntry(a).getProductCategory()))
            {
                checkIndex++;
                if(checkIndex==modify)
                {
                    storePosition=a;
                    StoreProductID=flowerStack.getEntry(a).getProductID();
                    
                    
                    System.out.println("ProductName : " + flowerStack.getEntry(a).getProductName() );
                    System.out.println("Product Descripton : " + flowerStack.getEntry(a).getProductDesc() );
                    System.out.println("Product Category : "+ flowerStack.getEntry(a).getProductCategory());
                    System.out.println(" Product Quantity : " + flowerStack.getEntry(a).getProductQuantity() );
                    System.out.println("Product Minimun Level : " + flowerStack.getEntry(a).getProductWarningLvl());
                    System.out.println("Exit" );
                }
               
            }
        }
        System.out.println("Do you want to remove the following product? Press 1 to confirm or press 0 to cancel : " );
        int decisonIndex=0;
        do
        {
            decisonIndex = sc.nextInt();
            switch(decisonIndex){
            case 1:    
                
                flowerStack.remove(storePosition);
                break;
            case 2:
                System.exit(0);
                break;
            default: 
                break;
            }
            if(decisonIndex!=0 && decisonIndex!=1)
            {
                System.out.println("Please re-enter again : "); 
            }
            
        }while(decisonIndex!=0 && decisonIndex!=1);
        System.out.println("Successfully Delete ");
        
        System.out.println("Press any key to back menu");
        String back = sc.next();
        switch(back)
        {
            default:
                MaintainCatalogMenu();;
                break;
        }
        
        
        
        
        
        
        
        
        
    }
     
      
      
      
}
