package control;

import javax.swing.JOptionPane;

public class room_mangement extends employee {
    private other_services otherService;
    
    @Override
    public void work() {
        JOptionPane.showMessageDialog(null, "Welcom to room_mangement", "Room_Mangmenet", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void enter_user_date (){}
    
    public void enter_gust_date (){}
    
    public void filter_rooms (String keys){}
    
    public void assign_room (int room_number, customer custo){}
    
    @Override
    void add() {
        
    }

    @Override
    void update() {
        
    }

    @Override
    void delete(int id) {
        
    }
    
}
