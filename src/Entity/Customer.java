/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author han wen
 */
public class Customer {  
    private String custId;
    private String custUsername;
    private String custPassword;
    private String custName;
    private String ic;
    private String phone;
    private String address;
    private String status;
    
    public Customer(String custID, String custUsername,String custPassword,String custName,String ic,String phone,String address){   
        this.custId = custID;
        this.custUsername = custUsername;
        this.custPassword = custPassword;
        this.custName = custName;
        this.ic = ic;
        this.phone = phone;
        this.address = address;
    }
    
    public Customer(String custId, String custUsername,String custPassword,String custName,String ic,String phone,String address, String status){   
        this.custId = custId;
        this.custUsername = custUsername;
        this.custPassword = custPassword;
        this.custName = custName;
        this.ic = ic;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }
    
     @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Customer)super.clone();
    }
    
    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }
    
    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
    
     
    public String getIc(){
        return ic;
    }
    
    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public static String generateID(int index) {
        char[] id = "C00000".toCharArray();
        int length = id.length;
        while (index != 0) {
            id[length - 1] = (char) (index % 10 + 48);
            length--;
            index /= 10;
        }
        return String.valueOf(id);
    }
}
