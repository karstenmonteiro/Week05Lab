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
     * login() Method -- Validates the username and password used to login.
     * 
     * @param username
     * @param password
     * @return 
     */
    public User login(String username, String password) {
        if ((username.equals(username1) || username.equals(username2)) && password.equals(this.password)) {
            // VALID LOGIN, set user's pass to 'null' & return user
            User user = new User(username, this.password);
            user.setPassword(null);

            return user;
        }
        
        // INVALID LOGIN, return null
        return null;
    }
}