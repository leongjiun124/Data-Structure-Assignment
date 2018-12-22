/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entity.FlowerCustomized;
import java.sql.ResultSet;
import testing.QueueInterface;
import testing.Queue;

/**
 *
 * @author Admin
 */
public class FlowerCustomizedDA {
    private String host = "jdbc:derby://localhost:1527/MyDataBase";
    private String user = "lee";
    private String password = "123";
    private String tableName = "FlowerCustomized";
    private Connection conn;
    private PreparedStatement stmt;
    
    public FlowerCustomizedDA() 
    {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
        public void addFlower(FlowerCustomized data) {
        
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, data.getFlowerId());
            stmt.setString(2, data.getFlowerType());
            stmt.setString(3, data.getFlowerSize());
            stmt.setString(4, data.getFlowerName());
            stmt.setString(5, data.getFlowerAccessory());
            stmt.setString(6, data.getPickUpPriority());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        
    public FlowerCustomized getRecord(String flowerID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE customizedID=?";
        FlowerCustomized s = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, flowerID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                s = new FlowerCustomized(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
        
    }
        
     public QueueInterface<FlowerCustomized> getAllProduct() {
        QueueInterface<FlowerCustomized> viewAll = new Queue<>();
        try {
            stmt = conn.prepareStatement("select * from " + tableName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                viewAll.enqueue(new FlowerCustomized(rs.getString("customizedID"),rs.getString("arrangementStyle"),rs.getString("arrangementSize"),rs.getString("flowerType"),rs.getString("accessories"),rs.getString("priority")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return viewAll;
    }
     
     public void updateProduct(FlowerCustomized flowerCustom) {
        try {
            String updateStr = "UPDATE " + tableName + " SET PRIORITY = ? WHERE CUSTOMIZEDID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, flowerCustom.getPickUpPriority());
            stmt.setString(2, flowerCustom.getFlowerId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
