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
public class FlowerCustomized {
    private String flowerType;
    private String flowerSize;
    private String flowerName;
    private String flowerAccessory;
    private String pickUpPriority;
    
    public FlowerCustomized(){
        
    }
    
    public FlowerCustomized(String flowerType, String flowerSize, String flowerName, String flowerAccessory){
        this.flowerType = flowerType;
        this.flowerSize = flowerSize;
        this.flowerName = flowerName;
        this.flowerAccessory = flowerAccessory;
    }
    
    public FlowerCustomized(String flowerType, String flowerSize, String flowerName, String flowerAccessory, String pickUpPriority){
        this.flowerType = flowerType;
        this.flowerSize = flowerSize;
        this.flowerName = flowerName;
        this.flowerAccessory = flowerAccessory;
        this.pickUpPriority = pickUpPriority;
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
    
    public String toString(){
        return "Flower Arrangement Style: " + flowerType + "\nFlower Size: " + flowerSize + "\nFlower :"
                + flowerName + "\nFlower Accessory: " + flowerAccessory;
    }
    
}
