import java.util.Scanner;

public class Food_item {
    private String name, owner_type, Category;
    static int counter=0;
    private final int ID;
    private int item_discount,price;
    private int Quantity_present;
    Food_item(String name, String owner_type, String category, int quantity_present, int item_discount, int price){
        this.name = name;
        this.owner_type = owner_type;
        Category = category;
        Quantity_present = quantity_present;
        this.item_discount = item_discount;
        this.price = price;
        counter+=1;
        ID=counter;
    }
/// getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return Category;
    }

    public String getOwner_type() {
        return owner_type;
    }

    public int getID() {
        return ID;
    }

    public int getQuantity_present() {
        return Quantity_present;
    }

    public int getItem_discount() {
        return item_discount;
    }

    public int getPrice() {
        return price;
    }
  ///setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity_present(int reduced_value) {
        Quantity_present -= reduced_value;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setItem_discount(int item_discount) {
        this.item_discount = item_discount;
    }

    public void edit_item_details(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Attribute to edit");
        System.out.println("1.) Item Name");
        System.out.println("2.) Item Price");
        System.out.println("3.) Item Quantity");
        System.out.println("4.) Item Category");
        System.out.println("5.) Item Offer");
        int x=sc.nextInt();
        switch (x){
            case 1:
                System.out.println("Enter new Item Name");
                setName(sc.next());
                break;
            case 2:
                System.out.println("Enter new Item Price");
                setPrice(sc.nextInt());
                break;
            case 3:
                System.out.println("Enter new Item Quantity");
                setQuantity_present(getQuantity_present()-sc.nextInt());
                break;
            case 4:
                System.out.println("Enter new Item Category");
                setCategory(sc.next());
                break;
            case 5:
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected value: " + x);
        }
    }
    public float calculate_item_discount(int quantity){
        float discount=(getItem_discount()*quantity*getPrice())/100;
        float x=(getPrice()*quantity)-discount;
        return x;
    }
    public void print_item(){
        System.out.println(getID()+" "+getName()+" "+
                getPrice()+" "+getQuantity_present()+" "+getItem_discount()+"%off "+getCategory());
    }
}
