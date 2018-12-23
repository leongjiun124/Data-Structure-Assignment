/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class FlowerInventory {
    private int productID;
    private String productName;
    private String productDesc;
    private String productCategory;
    private int productQuantity;
    private int productWarningLvl;
    private String lastUpdate;
    
     LocalDateTime now = LocalDateTime.now();
    int currentYear=now.getYear();
    int currentMonth=now.getMonthValue();
    int currentDay=now.getDayOfMonth();
    String CombineAll= currentDay + ("-") + currentMonth + ("-") + currentYear;

    public FlowerInventory(int productID, String productName, String productDesc, String productCategory, int productQuantity, int productWarningLvl, String lastUpdate) {
        this.productID = productID;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        this.productWarningLvl = productWarningLvl;
        this.lastUpdate = lastUpdate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductWarningLvl() {
        return productWarningLvl;
    }

    public void setProductWarningLvl(int productWarningLvl) {
        this.productWarningLvl = productWarningLvl;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public String getCombineAll() {
        return CombineAll;
    }

    public void setCombineAll(String CombineAll) {
        this.CombineAll = CombineAll;
    }
    
    public static String generateID(int index) {
        char[] id = "P00000".toCharArray();
        int length = id.length;
        while (index != 0) {
            id[length - 1] = (char) (index % 10 + 48);
            length--;
            index /= 10;
        }
        return String.valueOf(id);
    }
    
}
