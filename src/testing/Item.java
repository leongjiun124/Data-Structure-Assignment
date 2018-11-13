/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author Admin
 */
public class Item {
    String itemName="| %1$-20s | ";
    int quantity;
    int warningLevel;
    String date1;
    
    public String getItemName() {
        return itemName;
    }    
    public int getQuantity() {
        return quantity;
    } 
    public int getWarningLevel() {
        return warningLevel;
    } 
    public String getDate1l() {
        return date1;
    } 
    
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setWarningLevel(int warningLevel) {
        this.warningLevel = warningLevel;
    }
    public void setDate1(String date1) {
        this.date1 = date1;
    }
}
