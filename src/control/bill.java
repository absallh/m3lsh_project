package control;

import Database.bill_Data;
import java.util.ArrayList;

public class bill {
    private bill_Data data;
    
    public bill(){
        data = new bill_Data();
    }
    
    public ArrayList showServicesPrices (ArrayList service){
        return data.showServicesPrices(service);
    }
}
