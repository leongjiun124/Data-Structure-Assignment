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
public class PromotionList {
    int month;
    int year;
    String Title;
    
    public int getMonth() {
        return month;
    } 
    public int getYear() {
        return year;
    } 
     public String getTitle() {
        return Title;
    } 
     
     public void setMonth(int month) {
        this.month = month;
    }
     
     public void setYear(int year) {
        this.year = year;
    }
     
      public void setTitle(String Title) {
        this.Title = Title;
    }
    

}
