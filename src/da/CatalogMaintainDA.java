/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Entity.DomainCatalogMaintain;

/**
 *
 * @author User
 */
public class CatalogMaintainDA {
    private String host = "jdbc:derby://localhost:1527/MyDataBase";
    private String user = "lee";
    private String password = "123";
    private String tableName = "CatalogMaintain";
    private Connection conn;
    private PreparedStatement stmt;
    
    LocalDateTime now = LocalDateTime.now();
    int currentYear=now.getYear();
    int currentMonth=now.getMonthValue();
    int currentDay=now.getDayOfMonth();
    String CombineAll= currentDay + ("-") + currentMonth + ("-") + currentYear;

    public CatalogMaintainDA() 
    {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void addProduct(DomainCatalogMaintain catalogMaintain) {
        
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, catalogMaintain.getProductID());
            stmt.setString(2, catalogMaintain.getProductName());
            stmt.setString(3, catalogMaintain.getProductDesc());
            stmt.setString(4, catalogMaintain.getProductCategory());
            stmt.setInt(5, catalogMaintain.getProductQuantity());
            stmt.setInt(6, catalogMaintain.getProductWarningLvl());
            stmt.setString(7, catalogMaintain.getLastUpdate());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     public ArrayList<DomainCatalogMaintain> getAllProduct() {
        ArrayList<DomainCatalogMaintain> viewAll = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select * from " + tableName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                viewAll.add(new DomainCatalogMaintain(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return viewAll;
    }
     
     public void updateProduct(DomainCatalogMaintain productItem) {
        try {
            String updateStr = "UPDATE " + tableName + " SET productName=?, productDesc=?, productCategory=?, productQuantity=?, productWarningLvl=?, lastUpdate=? WHERE productID=?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(7, productItem.getProductID());
            stmt.setString(1, productItem.getProductName());
            stmt.setString(2, productItem.getProductDesc());
            stmt.setString(3, productItem.getProductCategory());
            stmt.setInt(4, productItem.getProductQuantity());
            stmt.setInt(5, productItem.getProductWarningLvl());
            stmt.setString(6, productItem.getLastUpdate());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     
     public void deleteProduct(String productID) {
        try {
            String deleStr = "DELETE FROM " + tableName + " WHERE productID=?";
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, productID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     
     public DomainCatalogMaintain getRecord(String ProductID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE productID=?";
        DomainCatalogMaintain s = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ProductID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                s = new DomainCatalogMaintain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
    }
    
    
}
