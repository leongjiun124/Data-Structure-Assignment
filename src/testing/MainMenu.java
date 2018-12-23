package testing;

import adt.FlowerInventoryLinkedList;
import adt.PromotionLinkedStack;
import Entity.FlowerInventory;
import Entity.PromotionDomain;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author User
 */
public class MainMenu {
    
    public static FlowerInventoryLinkedList<FlowerInventory> flowerStack = new FlowerInventoryLinkedList<>();
    public static PromotionLinkedStack<PromotionDomain> promotionItem =new PromotionLinkedStack<>();
    
    public static void initFlower() {
        FlowerInventory flowerInventory = new FlowerInventory(100001, "Rose", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100002, "White Rose", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100003, "Sunflower", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);
        flowerInventory = new FlowerInventory(100003, "Lily", "Happy Flower make you very 7 happy", "Alstromeria", 100, 50, "21-12-2018");
        flowerStack.add(flowerInventory);  
        //System.out.print("Insertion done\n");
        //System.out.print("Total number = "+ flowerStack.getNumberOfEntries()+"\n");
        
        PromotionDomain p = new PromotionDomain(1001,"MegeSales",12,12,12,1000001);
        promotionItem.push(p);
        
        
        

    }
    
}
