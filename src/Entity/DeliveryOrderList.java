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
public class DeliveryOrderList {
        private String orderId;
    private String address;
    private double price;
    private String description;
    private String deliveryMan;
    public static int totalList;
    /**
     * @param args the command line arguments
     */
    
    public DeliveryOrderList(){
       
    }
    
    public DeliveryOrderList(String orderId, String address, double price, String description, String deliveryMan){
        this.orderId = orderId;
        this.address = address;
        this.price = price;
        this.description = description;
        this.deliveryMan = deliveryMan;
        totalList++;
    }
    
    public String getOrderId(){
        return orderId;
    }
    
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDeliveryMan(){
        return deliveryMan;
    }    
    
    public void setDeliveryMan(String deliveryMan){
        this.deliveryMan = deliveryMan;
    }
    
    public String toString(){ 
        return  "******************Delivery Order List******************" +"\t\t" +"\nOrder Id:" + orderId + "\nAddress:" + address + "\nPrice: RM" + price + "\nDescription:" + description + "\nDelivery Man In Charge:" + deliveryMan;
    }
}
