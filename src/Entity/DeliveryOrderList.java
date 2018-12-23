/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author lee3010
 */

public class DeliveryOrderList{
    private String orderId;
    private String itemName;
    private int quantity;
    private String address;
    private String deliveryMan;
    private String efficientRoute;    
    private String pickupDate;
    private String pickupTime;
    private String pickupStatus;
    private Double paymentAmount;
    private String paymentStatus;
    private String bookingId;
   
 // Default Constructor
 public DeliveryOrderList(){
    super();
 }
 
// Getter and Setter methods
 public String getOrderId(){
     return orderId; 
 }
 public void setOrderId(String orderId){
     this.orderId = orderId;
 }
 public String getItemName(){
     return itemName;
 }
 
 public void setItemName(String itemName){
     this.itemName = itemName;
 }
 public int getQuantity(){
     return quantity;
 }
 public void setQuantity(int quantity){
     this.quantity = quantity;
 }
 
 public String getAddress(){
     return address;
 }
 
 public void setAddress(String address){
     this.address = address;
 }
 
 public String getDeliveryMan(){
     return deliveryMan;
 }
 
 public void setDeliveryMan(String deliveryMan){
     this.deliveryMan = deliveryMan;
 }
 
public String getEfficientRoute(){
     return efficientRoute;
 }
 
public void setEfficientRoute(String efficientRoute){
     this.efficientRoute = efficientRoute;
 }

public String getPickupDate(){
     return pickupDate;
 }
 
public void setPickupDate(String pickupDate){
     this.pickupDate = pickupDate;
 }

public String getPickupTime(){
    return pickupTime;
}

public void setPickupTime(String pickupTime){
    this.pickupTime = pickupTime;
}

public String getPickupStatus(){
    return pickupStatus;
}

public void setPickupStatus(String pickupStatus){
    this.pickupStatus = pickupStatus;   
}

public Double getPaymentAmount(){
    return paymentAmount;
}

public void setPaymentAmount(Double paymentAmount){
    this.paymentAmount = paymentAmount;
}

public String getPaymentStatus(){
    return paymentStatus;
}

public String getBookingId() {
    return bookingId;
}

public void setBookingId(String bookingId) {
    this.bookingId = bookingId;
}

    public static String generateID(int index) {
        char[] id = "D00000".toCharArray();
        int length = id.length;
        while (index != 0) {
            id[length - 1] = (char) (index % 10 + 48);
            length--;
            index /= 10;
        }
        return String.valueOf(id);
    }

 // Parameterized Constructor
 public DeliveryOrderList(String orderId, String itemName, int quantity, String address, String deliveryMan, String efficientRoute, String pickupDate, String pickupTime, String pickupStatus, Double paymentAmount, String paymentStatus){
    super();
    this.orderId = orderId;
    this.itemName = itemName;
    this.quantity = quantity;
    this.address = address;
    this.deliveryMan = deliveryMan;
    this.efficientRoute = efficientRoute;
    this.pickupDate = pickupDate;
    this.pickupTime = pickupTime;
    this.pickupStatus = pickupStatus;
    this.paymentAmount = paymentAmount;
    this.paymentStatus = paymentStatus;
 }
 
  public DeliveryOrderList(String orderId, String itemName, int quantity, String address, String deliveryMan, String efficientRoute, String pickupDate, String pickupTime, String pickupStatus, Double paymentAmount, String paymentStatus, String bookingId){
    super();
    this.orderId = orderId;
    this.itemName = itemName;
    this.quantity = quantity;
    this.address = address;
    this.deliveryMan = deliveryMan;
    this.efficientRoute = efficientRoute;
    this.pickupDate = pickupDate;
    this.pickupTime = pickupTime;
    this.pickupStatus = pickupStatus;
    this.paymentAmount = paymentAmount;
    this.paymentStatus = paymentStatus;
    this.bookingId = bookingId;
 }
  
  public DeliveryOrderList(double paymentAmount, String bookingId){
      this.paymentAmount = paymentAmount;
      this.bookingId = bookingId;
  }
}
