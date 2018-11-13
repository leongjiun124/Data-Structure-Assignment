/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author han wen
 */
public class Booking {
    private String flowerName;
    private int quantity;
    private String time;
    private String date;
    private String address;
    
    Booking(String flowerName, int quantity, String time, String date, String address){
        this.flowerName = flowerName;
        this.quantity = quantity;
        this.time = time;
        this.date = date;
        this.address = address;
    }
    
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Booking)super.clone();
    }
    
     public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }
    
     public int Quantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
     public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
     public String getAddress() {
        return address;
    }

    public void setAddress(String address ) {
        this.address = address;
    }  
}
