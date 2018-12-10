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
public class PaymentDetails {
 
 private String orderId;
 private String itemName;
 private String pickDate;
 private String pickTime;
 private String quantity;
 double paymentAmount;
 private String paymentStatus;
 
// Getter and Setter methods
 public String getOrderId() {return orderId; }
 public void setOrderId(String orderId) {this.orderId = orderId;}
 public String getItemName() {return itemName;}
 public void setItemName(String itemName) {this.itemName = itemName;}
 public String getPickDate() {return pickDate;}
 public void setPickDate(String pickDate) {this.pickDate = pickDate;}
 public String getPickTime() {return pickTime;}
 public void setPickTime(String pickTime) {this.pickTime = pickTime;}
 public String getQuantity() {return quantity;}
 public void setQuntity(String quantity) {this.quantity = quantity;}
 
 public double getPaymentAmount() {return paymentAmount;}
 public void setPaymentAmount(double paymentAmount) {this.paymentAmount = paymentAmount;}
 public String getPaymentStatus() {return paymentStatus;}
 public void setPaymentStatus(String paymentStatus) {this.paymentStatus = paymentStatus;}
 
 // Default Constructor
 public PaymentDetails(){
 super();
 }
 // Parameterized Constructor
 public PaymentDetails(String orderId, String itemName, String pickDate, String pickTime, String quantity, double paymentAmount, String paymentStatus) {
 super();
 this.orderId = orderId;
 this.itemName = itemName;
 this.pickDate = pickDate;
 this.pickTime = pickTime;
 this.quantity= quantity;
 this.paymentAmount = paymentAmount;
 this.paymentStatus = paymentStatus;
 }
}

    

