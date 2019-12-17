package control;

import Database.Service_Data;
import java.util.ArrayList;

public class other_services extends employee {
    private service service;
    
    public other_services (){
        service = new service();
    }
    
    public String[] getServiceDates (String serviceName){
        ArrayList<String> dateList = service.getServiceDates(serviceName);
        String[] dates = (String[]) dateList.toArray(new String [dateList.size()]);
        return dates;
    }
    
    public int[] countService(String[] dates, String serviceName){
        ArrayList<String> Dates = new ArrayList<>();
        
        for (String x: dates){
            Dates.add(x);
        }
        
        ArrayList<Integer> countList = service.countService(Dates, serviceName);
        int[] count = new int[countList.size()];
        for (int i = 0; i < countList.size(); i++){
            count [i] = (int) countList.get(i);
        }
        
        return count;
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
