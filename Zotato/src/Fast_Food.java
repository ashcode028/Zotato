import java.util.Scanner;

public class Fast_Food extends Restaurants {
    protected float additional_discount;

    Fast_Food(String name) {
        super(name);
        additional_discount=0;
        rest_type="Fast Food";
    }

    public float getAdditional_discount() {
        return additional_discount;
    }

    public void setAdditional_discount(float additional_discount) {
        this.additional_discount = additional_discount;
    }

    @Override
    public void Calculate_discount(Food_item item, int quantity) {
        super.Calculate_discount(item, quantity);
        if(getAdditional_discount() !=0){
            setHalf_amount(getHalf_amount() * ((100-getAdditional_discount())/100));
        }

    }

    @Override
    public void Menu(Restaurant_Database res_obj,Customer_Database cus_obj) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to "+getRestaurant_name());
        System.out.println("1.) Add Item");
        System.out.println("2.) Edit Item");
        System.out.println("3.) Print Rewards Won");
        System.out.println("4.) Set Discount on bill value");
        System.out.println("5.) Exit");
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
                System.out.println("Enter the amount of discount you want to keep in %");
                setAdditional_discount(sc.nextInt());
                Menu(res_obj,cus_obj);
                break;
            case 5:
                Zotato obj=new Zotato();
                obj.Zotato_Menu(res_obj,cus_obj);
                break;

            default:
                System.out.println("Unexpected value: " + x);
        }
    }
}


