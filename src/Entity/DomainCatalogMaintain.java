/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.time.LocalDateTime;
import java.util.Date;
/**
 *
 * @author Chong Tuck Wai
 */
public class DomainCatalogMaintain {
    
    private String productID;
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
    
    public DomainCatalogMaintain(String productID, String productName, String productDesc, String productCategory, int productQuantity, int productWarningLvl, String lastUpdate) {
        this.productID = productID;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        this.productWarningLvl = productWarningLvl;
        this.lastUpdate = lastUpdate;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
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
        //Check
        lastUpdate=CombineAll;
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
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
