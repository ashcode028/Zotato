import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Restaurants implements User {
    protected String Restaurant_name;
    protected float Rewards_collected;
    protected HashMap<Integer,Food_item> items;
    protected float half_amount;
    protected String rest_type;
    Restaurants(String name){
        Restaurant_name=name;
        rest_type = "null";
        items = new HashMap<>();
    }
///getters
    public String getRestaurant_name() {
        return Restaurant_name;
    }

    public float getRewards_collected() {
        return Rewards_collected;
    }

    public float getHalf_amount() {
        return half_amount;
    }

    public String getRest_type() {
        return rest_type;
    }

    public HashMap<Integer, Food_item> getItems() { return items; }
    /// setters
    public void setRewards_collected(float rewards_collected) { Rewards_collected = rewards_collected; }

    public void setHalf_amount(float half_amount) { this.half_amount = half_amount; }

    public void Calculate_discount(Food_item item, int quantity) { setHalf_amount(item.calculate_item_discount(quantity)); }

    @Override
    public void print_items(){
        //System.out.println("Choose Item by ID");
        if(!items.isEmpty())
        for (Map.Entry<Integer, Food_item> x : getItems().entrySet()) {
            System.out.println(x.getValue().getID() + " - " + x.getValue().getName() + " - " +
                    x.getValue().getPrice() + " - " + x.getValue().getQuantity_present() +
                    " - " + x.getValue().getItem_discount() + " - " + x.getValue().getCategory());
        }
        else
        System.out.println("Empty:Items not yet added to this restaurant ");
    }

    public Food_item return_item(int input){
        for (Map.Entry<Integer, Food_item> x : getItems().entrySet()) {
            if (x.getKey() == input) {
                return x.getValue();
            }
        }
        return null;
    }

    public void pay_to_company(float total_amount,float delivery_charges){
        float balance=(total_amount-delivery_charges)/100;
        Zotato obj=new Zotato();
        obj.setCompany_value(balance);
        obj.setDelivery_charges_collected(delivery_charges);
    }

    protected void add_food_item(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Food Item Details");
        System.out.println("Enter Food Name");
        String name=sc.next();
        System.out.println("Enter Item price");
        int price=sc.nextInt();
        System.out.println("Enter Item Quantity");
        int quantity=sc.nextInt();
        System.out.println("Enter Item Category ");
        String category=sc.next();
        System.out.println("Enter Item Offer in % ");
        int offer=sc.nextInt();
        Food_item obj=new Food_item(name,getRest_type(),category,quantity,offer,price);
        items.put(obj.getID(),obj);
        obj.print_item();
    }

    protected void call_edit_item(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose Items by their IDs to edit");
        print_items();
        int input=sc.nextInt();
        Food_item x=return_item(input);
        x.edit_item_details();
        x.print_item();
    }

    @Override
    public void Menu(Restaurant_Database res_obj,Customer_Database cus_obj) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to "+getRestaurant_name());
        System.out.println("1.) Add Item");
        System.out.println("2.) Edit Item");
        System.out.println("3.) Print Rewards Won");
        System.out.println("4.) Exit");
        int x=sc.nextInt();
        switch (x){
            case 1:
                add_food_item();
                Menu(res_obj,cus_obj);
                break;
            case 2:
                call_edit_item();
                Menu(res_obj,cus_obj);
                break;
            case 3:
                System.out.println("Total rewards won: "+getRewards_collected());
                Menu(res_obj,cus_obj);
                break;
            case 4:
                Zotato obj=new Zotato();
                obj.Zotato_Menu(res_obj,cus_obj);
                break;

            default:
                System.out.println("Unexpected value: " + x);
        }
    }

}
