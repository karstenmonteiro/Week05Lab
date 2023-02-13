package models;

import java.io.Serializable;

/**
 *
 * @author Karsten Monteiro
 */
public class User implements Serializable {

    private String username;
    private String password;
    
    // constructors
    public User() {
        this.username = "";
        this.password = "";
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // 'get' & 'set' methods
    public String getUsername() {
        return username;
    }
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
}