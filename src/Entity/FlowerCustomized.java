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
public class FlowerCustomized {
    private String flowerId;
    private String flowerType;
    private String flowerSize;
    private String flowerName;
    private String flowerAccessory;
    private String pickUpPriority;
    private String bookingId;
    
    public FlowerCustomized(){
        
    }
    
    public FlowerCustomized(String flowerId, String flowerType, String flowerSize, String flowerName, String flowerAccessory,String bookingId){
        this.flowerId = flowerId;
        this.flowerType = flowerType;
        this.flowerSize = flowerSize;
        this.flowerName = flowerName;
        this.flowerAccessory = flowerAccessory;
        this.bookingId = bookingId;
    }
//    
//    public FlowerCustomized(String flowerId, String flowerType, String flowerSize, String flowerName, String flowerAccessory, String pickUpPriority,String bookingId){
//        this.flowerId = flowerId;
//        this.flowerType = flowerType;
//        this.flowerSize = flowerSize;
//        this.flowerName = flowerName;
//        this.flowerAccessory = flowerAccessory;
//        this.pickUpPriority = pickUpPriority;
//    }
//    
    public FlowerCustomized(String flowerId, String flowerType, String flowerSize, String flowerName, String flowerAccessory, String pickUpPriority, String bookingId){
        this.flowerId = flowerId;
        this.flowerType = flowerType;
        this.flowerSize = flowerSize;
        this.flowerName = flowerName;
        this.flowerAccessory = flowerAccessory;
        this.pickUpPriority = pickUpPriority;
        this.bookingId = bookingId;
    }
    
    public void setFlowerId(String flowerId){
        this.flowerId = flowerId;
    }
    
    public String getFlowerId(){
        return flowerId;
    }
    
    public String getFlowerType(){
        return flowerType;
    }
    
    public void setFlowerType(String flowerType){
        this.flowerType = flowerType;
    }
    
    public String getFlowerSize(){
        return flowerSize;
    }
    
    public void setFlowerSize(String flowerSize){
        this.flowerSize = flowerSize;
    }
    
    public String getFlowerName(){
        return flowerName;
    }
    
    public void setFlowerName(String flowerName){
        this.flowerName = flowerName;
    }
    
    public String getFlowerAccessory(){
        return flowerAccessory;
    }
    
    public void setFlowerAccessory(String flowerAccessory){
        this.flowerAccessory = flowerAccessory;
    }
    
    public String getPickUpPriority(){
        return pickUpPriority;
    }
    
    public void setPickUpPriority(String pickUpPriority){
        this.pickUpPriority = pickUpPriority;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    
    public String toString(){
        return "Flower Arrangement Style: " + flowerType + "\nFlower Size: " + flowerSize + "\nFlower :"
                + flowerName + "\nFlower Accessory: " + flowerAccessory;
    }
    
    public static String generateID(int index) {
        char[] id = "F00000".toCharArray();
        int length = id.length;
        while (index != 0) {
            id[length - 1] = (char) (index % 10 + 48);
            length--;
            index /= 10;
        }
        return String.valueOf(id);
    }
    
}
