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
public class Staff {
    private String userId;
    private String name;
    private String userName;
    private String password;
    
    public Staff(){
        
    }
    
    public Staff(String userId, String name, String userName, String password){
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    
    public String getUserId(){
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
