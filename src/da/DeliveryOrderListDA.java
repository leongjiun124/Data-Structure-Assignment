/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import Entity.DeliveryOrderList;
import adt.ArrayQueue;
import adt.QueueInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lee3010
 */

public class DeliveryOrderListDA {
    private String host = "jdbc:derby://localhost:1527/MyDataBase";
    private String user = "lee";
    private String password = "123";
    private String tableName = "Delivery";
    private Connection conn;
    private PreparedStatement stmt;
    
    public DeliveryOrderListDA() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
        public void addDeliveryOrderList(DeliveryOrderList data) { 
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, data.getOrderId());
            stmt.setString(2, data.getItemName());
            stmt.setInt(3, data.getQuantity());
            stmt.setString(4, data.getAddress());
            stmt.setString(5, data.getDeliveryMan());
            stmt.setString(6, data.getEfficientRoute());
            stmt.setString(7, data.getPickupStatus());
            stmt.setDouble(8, data.getPaymentAmount());
            stmt.setString(9, data.getPaymentStatus());
            stmt.setString(10, data.getBookingId());
            stmt.setString(11, data.getPickupDate());
            stmt.setString(12, data.getPickupTime());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        
    public DeliveryOrderList getDeliveryOrderList(String orderID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ORDERID=?";
        DeliveryOrderList s = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, orderID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                s = new DeliveryOrderList(rs.getString("OrderId"),rs.getString("ItemName"),rs.getInt("Quantity"),rs.getString("Address"),rs.getString("DeliveryMan"),rs.getString("EfficientRoute"),rs.getString("PickupDate"),rs.getString("PickupTime"),rs.getString("PickupStatus"),rs.getDouble("PaymentAmount"),rs.getString("PaymentStatus"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
        
    }
        
     public QueueInterface<DeliveryOrderList> getAllDeliveryOrderList() {
        QueueInterface<DeliveryOrderList> viewAll = new ArrayQueue<>();
        try {
            stmt = conn.prepareStatement("select * from " + tableName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                viewAll.enqueue(new DeliveryOrderList(rs.getString("OrderId"),rs.getString("ItemName"),rs.getInt("Quantity"),rs.getString("Address"),rs.getString("DeliveryMan"),rs.getString("EfficientRoute"),rs.getString("PickupDate"),rs.getString("PickupTime"),rs.getString("PickupStatus"),rs.getDouble("PaymentAmount"),rs.getString("PaymentStatus")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return viewAll;
    }
     
     public void updateDeliveryOrderList(DeliveryOrderList deliveryorder) {
        try {
            String updateStr = "UPDATE " + tableName + " SET EFFICIENTROUTE = ? WHERE ORDERID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, deliveryorder.getEfficientRoute());
            stmt.setString(2, deliveryorder.getOrderId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     
    public void updatePickupOrderList(DeliveryOrderList deliveryorder) {
        try {
            String updateStr = "UPDATE " + tableName + " SET PICKUPSTATUS = ? WHERE ORDERID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, deliveryorder.getPickupStatus());
            stmt.setString(2, deliveryorder.getOrderId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updatePaymentStatus(DeliveryOrderList deliveryorder) {
        try {
            String updateStr = "UPDATE " + tableName + " SET PAYMENTSTATUS = ? WHERE ORDERID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, deliveryorder.getPaymentStatus());
            stmt.setString(2, deliveryorder.getOrderId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updatePaymentAmount(DeliveryOrderList deliveryorder) {
        try {
            String updateStr = "UPDATE " + tableName + " SET PAYMENTAMOUNT = ? WHERE ORDERID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setDouble(1, deliveryorder.getPaymentAmount());
            stmt.setString(2, deliveryorder.getOrderId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
