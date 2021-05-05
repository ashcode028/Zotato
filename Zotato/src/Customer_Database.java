import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer_Database{
    private HashMap<Integer,Customers> customers_list;
    Customer_Database(){
        customers_list=new HashMap<>();
        add_Customers();
    }

    public void user_list() {
        System.out.println("Choose a customer");
        for (Map.Entry<Integer, Customers> x : customers_list.entrySet()) {
            if (x.getValue().getClass() == Customers.class)
                System.out.println(x.getKey() + ".) " + x.getValue().getCustomer_name());
            else
                System.out.println(x.getKey() + ".) " + x.getValue().getCustomer_name() + "("+x.getValue().getCust_type()+")");
        }
    }
    public void add_Customers(){
        Customers one=new Elite("Ram","Pune ");
        customers_list.put(1,one);
        Customers two=new Elite("Sam","Delhi");
        customers_list.put(2,two);
        Customers three=new Special("Tim","Chennai");
        customers_list.put(3,three);
        Customers four=new Customers("Jim"," Bangalore");
        customers_list.put(4,four);
        Customers five=new Customers("Kim","Mumbai");
        customers_list.put(5,five);
    }
    public Customers return_customer(int input){
        for (Map.Entry<Integer, Customers> x : customers_list.entrySet()) {
            if (x.getKey() == input) {
                Customers value = x.getValue();
                return value;
            }
        }
        return null;
    }

}
