package control;

import Database.Service_Data;
import java.util.ArrayList;

public class service {
    private Service_Data service_Data;
    
    public service (){
        service_Data = new Service_Data();
    }

    public Service_Data getService_Data() {
        return service_Data;
    }
    
    public boolean add_service(String name, double price, String desc)
    {
        return service_Data.add(name, price, desc);
    }
    
    public void delete_service(String service_name)
    {
        service_Data.delete(service_name);
    }
    
    public void update_service (String oldName, String name, double price, String desc)
    {
        service_Data.update(oldName, name, price, desc);
    }
    
    public ArrayList servicesNames (){
         return service_Data.servicesNames();
    }
    
    public ArrayList getAssignedServices(int id){
        return service_Data.getAssignedServices(id);
    }
    
    public void assignServices (int id, String []services){
        service_Data.assignServices(id, services);
    }

    void close() {
        service_Data.disconnectFromDatabase();
    }
}
