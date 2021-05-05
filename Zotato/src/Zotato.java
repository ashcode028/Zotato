import java.util.Scanner;

public class Zotato {
    private static float company_value;
    private static float delivery_charges_collected;
// getters
    public float getCompany_value() {
        return company_value;
    }

    public float getDelivery_charges_collected() {
        return delivery_charges_collected;
    }
//setters
    public void setCompany_value(float company_value) {
        Zotato.company_value += company_value;
    }

    public void setDelivery_charges_collected(float delivery_charges_collected) {
        Zotato.delivery_charges_collected += delivery_charges_collected;
    }

    public static void main(String[] args) {
        Zotato obj=new Zotato();
        //obj.Zotato_Menu();
        Restaurant_Database res_obj = new Restaurant_Database();
        Customer_Database cus_obj=new Customer_Database();
        obj.Zotato_Menu(res_obj,cus_obj);

    }
    public void Zotato_Menu(Restaurant_Database res_obj,Customer_Database cus_obj){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Zotato");
        System.out.println("1.)Enter as Restaurant");
        System.out.println("2.)Enter as Customer");
        System.out.println("3.)Check user details");
        System.out.println("4.)Company Account details");
        System.out.println("5.)Exit");
        int x=sc.nextInt();
       switch (x){
            case 1: call_restaurant_menu(res_obj,cus_obj);
                break;
            case 2: call_customer_menu(res_obj,cus_obj);
                break;
            case 3:
                call_user_details(res_obj,cus_obj);
                break;
            case 4:
                print_company_details(res_obj,cus_obj);
                break;
            case 5:
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected value: " + x);
        }

    }
    public void print_company_details(Restaurant_Database res_obj,Customer_Database cus_obj){
        System.out.println("Total Company Balance:"+getCompany_value());
        System.out.println("Total Delivery Charges collected:"+getDelivery_charges_collected());
        Zotato_Menu( res_obj,cus_obj);
    }
    public void call_user_details(Restaurant_Database res_obj,Customer_Database cus_obj){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.) Customer List");
        System.out.println("2.) Restaurant List");
        int x=sc.nextInt();
        if(x==2){
            res_obj.user_list();
            int input= sc.nextInt();
            Restaurants obj2=res_obj.return_Restaurant(input);
            System.out.println("Welcome to "+obj2.getRestaurant_name());
            System.out.println("Items(IDs) present here are:");
            obj2.print_items();

        }
        else{
            cus_obj.user_list();
            int input= sc.nextInt();
            Customers obj2= cus_obj.return_customer(input);
            System.out.println(obj2.getCustomer_name()+" from "+obj2.getPlace()+" has "+obj2.getWallet()+" amount in wallet");
            System.out.println("Rewards won:"+obj2.getRewards_won());
        }
        Zotato_Menu(res_obj,cus_obj);
    }
    public void call_restaurant_menu(Restaurant_Database res_obj,Customer_Database cus_obj){
        Scanner sc=new Scanner(System.in);
        res_obj.user_list();
        int input= sc.nextInt();
        Restaurants obj2=res_obj.return_Restaurant(input);
        obj2.Menu(res_obj,cus_obj);
        Zotato_Menu(res_obj,cus_obj);

    }
    public void call_customer_menu(Restaurant_Database res_obj,Customer_Database cus_obj){
        Scanner sc=new Scanner(System.in);
        cus_obj.user_list();
        int input= sc.nextInt();
        Customers obj2= cus_obj.return_customer(input);
        obj2.Menu(res_obj,cus_obj);
        Zotato_Menu(res_obj,cus_obj);

    }

}
