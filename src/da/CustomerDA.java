/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import Entity.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import testing.Array;
import testing.ArrayInterface;

/**
 *
 * @author Admin
 */
public class CustomerDA {
    private String host = "jdbc:derby://localhost:1527/MyDataBase";
    private String user = "lee";
    private String password = "123";
    private String tableName = "Customer";
    private Connection conn;
    private PreparedStatement stmt;
    
    public CustomerDA() 
    {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void addCust(Customer cust) {
        
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, cust.getCustId());
            stmt.setString(2, cust.getCustUsername());
            stmt.setString(3, cust.getCustPassword());
            stmt.setString(4, cust.getCustName());
            stmt.setString(5, cust.getIc());
            stmt.setString(6, cust.getPhone());
            stmt.setString(7, cust.getAddress());
            stmt.setString(8, cust.getStatus());
            stmt.setInt(9, cust.getCreditLimit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public ArrayInterface<Customer> getAllCustomer() {
        ArrayInterface<Customer> viewAll = new Array<>();
        try {
            stmt = conn.prepareStatement("select * from " + tableName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                viewAll.add(new Customer(rs.getString("CustId"),rs.getString("CustUsername"), rs.getString("custPassword"), rs.getString("custName"),rs.getString("ic"),rs.getString("phone"),rs.getString("address"),rs.getString("status"),rs.getInt("creditLimit")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return viewAll;
    }
    
    public Customer getRecord(String custId) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE custID=?";
        Customer s = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, custId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                s = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
        
    }
    
    public void updateStatus(Customer customer) {
        try {
            String updateStr = "UPDATE " + tableName + " SET STATUS = ?, CREDITLIMIT = ? WHERE CUSTID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, customer.getStatus());
            stmt.setInt(2, customer.getCreditLimit());
            stmt.setString(3, customer.getCustId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateCreditLimit(Customer customer){
        try{
            String updateStr = "UPDATE " + tableName + " SET CREDITLIMIT = ? WHERE CUSTID = ?";
            stmt = conn.prepareStatement(updateStr);
            stmt.setInt(1, customer.getCreditLimit());
            stmt.setString(2, customer.getCustId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
