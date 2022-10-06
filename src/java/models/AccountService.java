package models;

/**
 *
 * @author Karsten Monteiro
 */
public class AccountService {
    
    String username1 = "abe";
    String username2 = "barb";
    String password = "password";
    
    public User login(String username, String password) {
        if (username.equals(username1) || username.equals(username2) && password.equals(this.password)) {
            this.password = null;
            
            User user = new User(username, this.password);
            
            return user;
        }
        
        return null;
    }
    
}