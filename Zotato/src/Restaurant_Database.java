import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant_Database {
    protected HashMap<Integer,Restaurants> Restaurant_list;
    Restaurant_Database(){
        Restaurant_list=new HashMap<>(5);
        add_restaurants();
    }

    public void user_list() {
        System.out.println("Choose a Restaurant ");
        for (Map.Entry<Integer, Restaurants> x : Restaurant_list.entrySet()) {
            if (x.getValue().getClass() == Restaurants.class)
                System.out.println(x.getKey() + ".) " + x.getValue().getRestaurant_name());
            else
                System.out.println(x.getKey() + ".) " + x.getValue().getRestaurant_name() + "("+x.getValue().getRest_type()+")");
        }
    }
    public void add_restaurants(){
        Restaurants one=new Authentic("Palamaru Grill ");
        Restaurant_list.put(1,one);
        Restaurants two=new Restaurants("Ravi's");
        Restaurant_list.put(2,two);
        Restaurants three=new Fast_Food("Wang`s");
        Restaurant_list.put(3,three);
        Restaurants four=new Fast_Food("The Chinese");
        Restaurant_list.put(4,four);
        Restaurants five=new Authentic("Paradise");
        Restaurant_list.put(5,five);
    }
    public Restaurants return_Restaurant(int input){
        for (Map.Entry<Integer, Restaurants> x : Restaurant_list.entrySet()) {
            if (x.getKey() == input) return x.getValue();
        }
        return null;
    }


}
