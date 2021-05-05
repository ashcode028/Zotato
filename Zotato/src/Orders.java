public class Orders {
    private Food_item item;
    private int quantity_ordered;
    private float total_order_value;
    private Restaurants rest;

    public Orders(Food_item item,int quantity_ordered,Restaurants rest) {
        this.item = item;
        this.quantity_ordered=quantity_ordered;
        this.rest=rest;
    }
///getters
    public float getTotal_order_value() {
        return total_order_value;
    }

    public Food_item getItem() {
        return item;
    }

    public Restaurants getRest() {
        return rest;
    }

    public int getQuantity_ordered() {
        return quantity_ordered;
    }
///setters
    public void setQuantity_ordered(int quantity_ordered) {
        this.quantity_ordered = quantity_ordered;
    }

    public void setTotal_order_value(float total_order_value) {
        this.total_order_value = total_order_value;
    }


}
