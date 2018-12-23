/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Entity.Booking;
import da.BookingDA;
import adt.ArrayInterface;

/**
 *
 * @author Admin
 */
public class BookingControl {
    private BookingDA bookingDA;
    
    public BookingControl()
    {
        bookingDA = new BookingDA();
    }
    
    public void addBooking(Booking booking)
    {
        bookingDA.addBooking(booking);
    }
    
    public ArrayInterface<Booking> getAllProduct() {
        return bookingDA.getAllProduct();
    }
    
    public Booking getRecord(String bookingID) {
        return bookingDA.getRecord(bookingID);
    }
    
}
