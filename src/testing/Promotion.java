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

import java.awt.AWTException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Promotion {
    
    public static void main(String[] args)throws AWTException, ParseException, CloneNotSupportedException {
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
    
    }
    

