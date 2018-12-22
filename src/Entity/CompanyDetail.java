/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class CompanyDetail {
    private String companyName;
    private double creditLimit;
    private String paymentStatus;
    
    public CompanyDetail(){
        
    }
    
    public CompanyDetail(String companyName, double creditLimit, String paymentStatus){
        this.companyName = companyName;
        this.creditLimit = creditLimit;
        this.paymentStatus = paymentStatus;
    }
    
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    
    public String getCompanyName(){
        return companyName;
    }
    
    public void setCreditLimit(double creditLimit){
        this.creditLimit = creditLimit;
    }
    
    public double getCreditLimit(){
        return creditLimit;
    }
    
    public void setPaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }
    
    public String getPaymentStatus(){
        return paymentStatus;
    }
    
    public String toString(){
        return companyName + ", " + creditLimit + ", " + paymentStatus;
    }
    
    public double resetCreditLimit(double newCredit){
        creditLimit = newCredit;
        return creditLimit;
    }
}
