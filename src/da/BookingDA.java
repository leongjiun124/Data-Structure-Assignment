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
import java.time.LocalDateTime;
import Entity.Booking;
import java.sql.ResultSet;
import adt.Array;
import adt.ArrayInterface;

/**
 *
 * @author Admin
 */
public class BookingDA {
    private String host = "jdbc:derby://localhost:1527/MyDataBase";
    private String user = "lee";
    private String password = "123";
    private String tableName = "Booking";
    private Connection conn;
    private PreparedStatement stmt;
    
    LocalDateTime now = LocalDateTime.now();
    int currentYear=now.getYear();
    int currentMonth=now.getMonthValue();
    int currentDay=now.getDayOfMonth();
    String CombineAll= currentDay + ("-") + currentMonth + ("-") + currentYear;

    public BookingDA() 
    {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
        public void addBooking(Booking booking) {
        
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, booking.getBookingId());
            stmt.setString(2, booking.getFlowerName());
            stmt.setString(3, booking.getTime());
            stmt.setString(4, booking.getDate());
            stmt.setString(5, booking.getAddress());
            stmt.setString(6, booking.getCustId());
            stmt.setInt(7, booking.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        
    public ArrayInterface<Booking> getAllProduct() {
        ArrayInterface<Booking> viewAll = new Array<>();
        try {
            stmt = conn.prepareStatement("select * from " + tableName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                viewAll.add(new Booking(rs.getString("BookingID"),rs.getString("flowerName"), rs.getInt("Quantity"), rs.getString("time"),rs.getString("date"),rs.getString("address"),rs.getString("custId")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return viewAll;
    }
    
    public Booking getRecord(String bookingID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE bookingID=?";
        Booking s = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, bookingID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                s = new Booking(rs.getString("BookingID"),rs.getString("flowerName"), rs.getInt("Quantity"), rs.getString("time"),rs.getString("date"),rs.getString("address"),rs.getString("custId"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return s;
        
    }
}
