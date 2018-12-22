/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FlowerInventory {
    List<Item> flowerInventory = new ArrayList<Item>();
    
    
    
    public FlowerInventory()
    {
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
    }
    
    public List<Item> getInventory(){
        return flowerInventory;
    }
}

    
//class promotionList
//{
//    int month;
//    int year;
//    String Title;
//    
//    public int getMonth() {
//        return month;
//    } 
//    public int getYear() {
//        return year;
//    } 
//     public String getTitle() {
//        return Title;
//    } 
//     
//     public void setMonth(int month) {
//        this.month = month;
//    }
//     
//     public void setYear(int year) {
//        this.year = year;
//    }
//     
//      public void setTitle(String Title) {
//        this.Title = Title;
//    }
//    
//}
