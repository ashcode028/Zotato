

import java.util.HashSet;
import java.util.Scanner;

public class Customers implements User{
    protected String Customer_name;
    protected String place;
    protected float total_bill_value;
    protected float wallet;
    protected int delivery_charge;
    protected float rewards_won;
    protected String cust_type;
    protected Orders present_order;
    protected HashSet<Orders> previous_orders;
    public Customers(String name, String place) {
        this.Customer_name = name;
        this.place = place;
        wallet=1000;
        cust_type = null;
        previous_orders=new HashSet<>();
    }
///getters
    public String getCustomer_name() {
        return Customer_name;
    }

    public String getPlace() {
        return place;
    }

    public String getCust_type() {
        return cust_type;
    }

    public int getDelivery_charge() {
        return delivery_charge;
    }

    public float getWallet() { return wallet; }

    public float getTotal_bill_value() {
        return total_bill_value;
    }

    public float getRewards_won() {
        return rewards_won;
    }

    public Orders getPresent_order() { return present_order; }

    ///setters
    public void setRewards_won(float rewards_won) {
        this.rewards_won = rewards_won;
    }

    public void setDelivery_charge() {
        this.delivery_charge = 40;
    }

    public void setTotal_bill_value(float total_bill_value) {
        this.total_bill_value = total_bill_value;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    @Override
    public void Menu(Restaurant_Database res_obj,Customer_Database cus_obj) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+getCustomer_name());
        System.out.println("1.) Select Restaurant");
        System.out.println("2.) Checkout Cart");
        System.out.println("3.) Rewards Won");
        System.out.println("4.) Print Recent Orders");
        System.out.println("5.) Exit");
        int x=sc.nextInt();
       switch (x){
            case 1:
                place_order(res_obj,cus_obj);
                Menu(res_obj,cus_obj);
                break;
            case 2:
                checkout_cart(res_obj,cus_obj);
                Menu(res_obj,cus_obj);
                break;
            case 3:
                System.out.println("Total rewards won: "+getRewards_won());
                Menu(res_obj,cus_obj);
                break;
            case 4:
                print_items();
                Menu(res_obj,cus_obj);
                break;
            case 5:
                Zotato obj2=new Zotato();
                obj2.Zotato_Menu(res_obj,cus_obj);

            default:
                System.out.println("Unexpected value: " + x);
        }


    }
    public void place_order(Restaurant_Database res_obj,Customer_Database cus_obj){
        Scanner sc=new Scanner(System.in);
        res_obj.user_list();
        int input=sc.nextInt();
        Restaurants temp=res_obj.return_Restaurant(input);
        System.out.println("Choose Item by their IDs only");
        temp.print_items();
        int ID = sc.nextInt();
        System.out.println("Enter quantity u want to buy");
        int quantity = sc.nextInt();
        Food_item temp2= temp.return_item(ID);
        present_order = new Orders(temp2, quantity, temp);
        System.out.println("Successfully Added to the cart,Please proceed to check out");
        temp.Calculate_discount(temp.return_item(ID), quantity);
        this.Calculate_discount(temp.getHalf_amount());
    }
    public void checkout_cart(Restaurant_Database res_obj,Customer_Database cus_obj){
        Scanner sc=new Scanner(System.in);
        int check=0;
        System.out.println("Items in the cart :");
        Food_item temp=getPresent_order().getItem();
        System.out.println(temp.getID()+" - "+getPresent_order().getRest().getRestaurant_name()+" - "+temp.getName()+
                " - "+temp.getPrice()+" - "+getPresent_order().getQuantity_ordered()+" - "+temp.getItem_discount());
        System.out.println("Delivery Charge: "+getDelivery_charge());
        System.out.println("Total order value: "+getTotal_bill_value());

        if (getRewards_won() != 0) {
            setTotal_bill_value(total_bill_value - getRewards_won());
        }
        if(getWallet()>getTotal_bill_value()){
            System.out.println("Amount is available");
            System.out.println("Enter 1 to proceed to pay");
             check=sc.nextInt();
        }
        else{
            System.out.println("Insufficient Balance");
            go_to_cart(res_obj,cus_obj);
        }
        if(check==1) {
            System.out.println("Successfully placed order");
            System.out.println(getPresent_order().getQuantity_ordered()+" items of "+getPresent_order().getItem().getName()+" @ "+getTotal_bill_value());
            getPresent_order().setTotal_order_value(getTotal_bill_value());
            previous_orders.add(getPresent_order());
            Calculate_reward();
            getPresent_order().getRest().setRewards_collected(getRewards_won());
            getPresent_order().getItem().setQuantity_present(getPresent_order().getQuantity_ordered());
            setWallet(getWallet()-getPresent_order().getTotal_order_value());
            getPresent_order().getRest().pay_to_company(getPresent_order().getTotal_order_value(), getDelivery_charge());
        }

    }
    public void go_to_cart(Restaurant_Database res_obj,Customer_Database cus_obj){
        Scanner sc= new Scanner(System.in);
        System.out.println("Your present quantity is "+getPresent_order().getQuantity_ordered());
        System.out.println("Enter new quantity");
        getPresent_order().setQuantity_ordered(sc.nextInt());
        System.out.println("Proceeding to pay");
        checkout_cart(res_obj,cus_obj);
    }
    @Override
    public void print_items(){
        if(!previous_orders.isEmpty())
        for (Orders x: previous_orders ){
            System.out.println(x.getItem().getID()+" - "+x.getQuantity_ordered()+" items of "+x.getItem().getName()+" @ "+getTotal_bill_value());
        }
        else{
            System.out.println("NO previous order available for "+getCustomer_name());
        }
    }
    public void Calculate_discount(float half_amount) {
        setDelivery_charge();
        setTotal_bill_value(half_amount+getDelivery_charge());
    }

    public void Calculate_reward() {
        float amount_paid=getTotal_bill_value();
        String owner=getPresent_order().getItem().getOwner_type();
        //System.out.println(owner);
        float reward=0;
        if(owner.equals("Fast Food") ){
            if(amount_paid > 150 )
            reward=(amount_paid/150)*10;
        }
        else if(owner.equals("Authentic")){
            if(amount_paid > 200 )
            reward=(amount_paid/200)*25;
        }
        else if(owner.equals("null")){
            if(amount_paid > 100 )
            reward=(amount_paid/100)*5;
        }
        setRewards_won(reward);
    }

}
