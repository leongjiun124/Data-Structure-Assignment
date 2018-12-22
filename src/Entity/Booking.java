/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author han wen
 */
public class Booking {
    private String bookingId;
    private String flowerName;
    private int quantity;
    private String time;
    private String date;
    private String address;
    private String custId;
    
    public Booking(String bookingId, String flowerName, int quantity, String time, String date, String address, String custId){
        this.bookingId = bookingId;
        this.flowerName = flowerName;
        this.quantity = quantity;
        this.time = time;
        this.date = date;
        this.address = address;
        this.custId = custId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    
     public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }
    
     public int getQuantity() {
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
    
    
    public static String generateID(int index) {
        char[] id = "B00000".toCharArray();
        int length = id.length;
        while (index != 0) {
            id[length - 1] = (char) (index % 10 + 48);
            length--;
            index /= 10;
        }
        return String.valueOf(id);
    }
}
