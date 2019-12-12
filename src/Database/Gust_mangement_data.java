/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
/**
 *
 * @author absal
 */
public class Gust_mangement_data extends Data {
    public static final String DEFAULT_QUERY = "select customer.customer_id, first_name, last_name, coming_date, check_out_date, customer_room.Room_number" +
                    " from customer left join customer_room" +
                    " on customer.customer_id = customer_room.customer_id";
    public Gust_mangement_data (){
        setQuery(DEFAULT_QUERY);
    }
}
