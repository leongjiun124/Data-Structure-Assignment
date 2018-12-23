/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import da.DeliveryOrderListDA;
import Entity.DeliveryOrderList;
import adt.QueueInterface;
import adt.ArrayQueue;

/**
 *
 * @author lee3010
 */
public class DeliveryOrderListControl {
    private DeliveryOrderListDA deliveryOrderListDA;
    
    public DeliveryOrderListControl(){
        deliveryOrderListDA = new DeliveryOrderListDA();
    }
    
    public void addDeliveryOrderList(DeliveryOrderList deliveryOrderList)
    {
        deliveryOrderListDA.addDeliveryOrderList(deliveryOrderList);
    }
    
    public DeliveryOrderList getDeliveryOrderList(String orderID) {
        return deliveryOrderListDA.getDeliveryOrderList(orderID);
    }
    
    public QueueInterface<DeliveryOrderList> getAllDeliveryOrderList() {
        return deliveryOrderListDA.getAllDeliveryOrderList();
    }
    
    public void updateDeliveryOrderList(DeliveryOrderList deliveryorder) {
        deliveryOrderListDA.updateDeliveryOrderList(deliveryorder);
    }
    
    public void updatePickupOrderList(DeliveryOrderList deliveryorder) {
        deliveryOrderListDA.updateDeliveryOrderList(deliveryorder);
    }
    
    public void updatePaymentStatus(DeliveryOrderList deliveryorder) {
        deliveryOrderListDA.updatePaymentStatus(deliveryorder);
    }
    
    public void updatePaymentAmount(DeliveryOrderList deliveryorder) {
        deliveryOrderListDA.updatePaymentAmount(deliveryorder);
    }
}