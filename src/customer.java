public class customer extends person {
    private String comming_date;
    private String checkout;
    private bill customer_bill;
    private room customer_room;
    private service customer_service;

    public String getComming_date() {
        return comming_date;
    }

    public void setComming_date(String comming_date) {
        this.comming_date = comming_date;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    
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
