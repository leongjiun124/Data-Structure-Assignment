/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class PickUpOrder {
 private String orderId;
 private String itemName;
 private String date;
 private String time;
 private String quality;
 private String status;
 
// Getter and Setter methods
 public String getOrderId() {return orderId; }
 public void setOrderId(String orderId) {this.orderId = orderId;}
 public String getItemName() {return itemName;}
 public void setItemName(String itemName) {this.itemName = itemName;}
 public String getDate() {return date;}
 public void setDate(String date) {this.date = date;}
 
 public String getTime() {return time;}
 public void setTime(String time) {this.time = time;}
 public String getQuality() {return quality;}
 public void setQuality(String quality) {this.quality = quality;}
 public String getStatus() {return status;}
 public void setStatus(String status) {this.status = status;}
 
 // Default Constructor
 public PickUpOrder(){
 super();
 }
 // Parameterized Constructor
 public PickUpOrder(String orderId, String itemName, String date, String time, String quality, String status) {
 super();
 this.orderId = orderId;
 this.itemName = itemName;
 this.date = date;
 this.time = time;
 this.quality = quality;
 this.status = status;
 }
}
