public class Elite extends Customers {

    public Elite(String name, String place) {
        super(name, place);
        this.cust_type="Elite";
    }

    @Override
    public void setDelivery_charge() {
        this.delivery_charge=0;
    }

    @Override
    public void print_items() {
        super.print_items();
    }

    @Override
    public void Calculate_discount(float half_amount) {
        //super.Calculate_discount(half_amount);
        setDelivery_charge();
        if(half_amount > 200){
            half_amount -=50;
        }
        total_bill_value=half_amount+delivery_charge;
    }
}
