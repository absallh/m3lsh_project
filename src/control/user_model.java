package control;

import javax.swing.JOptionPane;

public class user_model extends employee {
    private customer custo;
    
    @Override//start the user model
    public void work(){
        JOptionPane.showMessageDialog(null, "Welcom to user_model", "User_Model", JOptionPane.PLAIN_MESSAGE);
    }
    
    public user_model(){
    }
    
    void add_customer() {
        
    }

    void update_customer() {
        
    }

    void delete_customer() {
        
    }
        
}
