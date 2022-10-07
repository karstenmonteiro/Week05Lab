package models;

/**
 *
 * @author Karsten Monteiro
 */
public class AccountService {
    
    String username1 = "abe";
    String username2 = "barb";
    String password = "password";
    
    /**
     * 
     * @param username
     * @param password
     * @return a User object if login is valid,
     *         null if login is invalid
     */
    public User login(String username, String password) {
        if ((username.equals(username1) || username.equals(username2)) && password.equals(this.password)) {
            User user = new User(username, this.password);
            user.setPassword(null);
            
            return user;
        }
        
        return null;
    }   
}