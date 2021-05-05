public class Special extends Customers {

    public Special(String name, String place) {
        super(name, place);
        this.cust_type="Special";
    }

    @Override
    public void setDelivery_charge() {
        this.delivery_charge=20;
    }

    @Override
    public void print_items() {
        super.print_items();
    }

    @Override
    public void Calculate_discount(float half_amount) {
        //super.Calculate_discount(half_amount);
        if(half_amount>200){
            half_amount -=25;
        }
        setDelivery_charge();
        total_bill_value=half_amount+getDelivery_charge();
    }
}
