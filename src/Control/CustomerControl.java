/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Entity.Customer;
import da.CustomerDA;
import adt.ArrayInterface;
import adt.CustomerMaintainInterface;

/**
 *
 * @author Admin
 */
public class CustomerControl {
    private CustomerDA customerDA;
    
    public CustomerControl(){
        customerDA = new CustomerDA();
    }
    
    public void addCustomer(Customer customer){
        customerDA.addCust(customer);
    }
    
    public CustomerMaintainInterface<Customer> getAllCustomer() {
        return customerDA.getAllCustomer();
    }
    
    public Customer getRecord(String custID) {
        return customerDA.getRecord(custID);
    }
    
    public void updateStatus(Customer customer){
        customerDA.updateStatus(customer);
    }
    
    public void updateCreditLimit(Customer customer){
        customerDA.updateCreditLimit(customer);
    }
}
