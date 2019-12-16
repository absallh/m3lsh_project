package control;

import Database.Service_Data;
import javax.swing.JOptionPane;

public class other_services extends employee {
    private service service;
    
    public other_services (){
        service = new service();
    }
    
    public Service_Data getServiceData (){
        return service.getService_Data();
    }
    
    public boolean addService (String name, double price, String desc){
        return service.add_service(name, price, desc);
    }
    
    public void deleteService (String service_name){
        service.delete_service(service_name);
    }
    
    public void updateService (String oldName, String name, double price, String desc){
        service.update_service(oldName, name, price, desc);
    }
    
}
