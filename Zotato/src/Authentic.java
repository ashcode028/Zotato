public class Authentic extends Fast_Food {



    Authentic(String name) {
        super(name);
        this.rest_type="Authentic";
    }

    @Override
    public void Calculate_discount(Food_item item, int quantity) {
        super.Calculate_discount(item, quantity);
        if(getHalf_amount() >= 100){
            setHalf_amount(half_amount - 50);
        }
    }

}
