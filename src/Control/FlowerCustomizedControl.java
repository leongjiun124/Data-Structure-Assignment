/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import da.FlowerCustomizedDA;
import Entity.FlowerCustomized;
import adt.QueueFlowerCustomized;
import adt.QueueFlowerCustomizedInterface;

/**
 *
 * @author Admin
 */
public class FlowerCustomizedControl {
    private FlowerCustomizedDA flowerCustomizedDA;
    
    public FlowerCustomizedControl(){
        flowerCustomizedDA = new FlowerCustomizedDA();
    }
    
    public void addFlower(FlowerCustomized flowerCustomized)
    {
        flowerCustomizedDA.addFlower(flowerCustomized);
    }
    
    public FlowerCustomized getRecord(String flowerID) {
        return flowerCustomizedDA.getRecord(flowerID);
    }
    
    public QueueFlowerCustomizedInterface<FlowerCustomized> getAllProduct() {
        return flowerCustomizedDA.getAllProduct();
    }
    
    public void updateProduct(FlowerCustomized flowerCustom) {
        flowerCustomizedDA.updateProduct(flowerCustom);

    }
}
