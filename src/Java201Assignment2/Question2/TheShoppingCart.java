package Java201Assignment2.Question2;

import java.util.ArrayList;

public class TheShoppingCart {
    public static void main(String[] args) {

        ShoppingCart cart1 = new ShoppingCart();

        // creating objects
        Food pasta = new Food("Baklava", "Mine", 55, "Pastry");
        Apparel phone = new Apparel("Honor 4x", "Huawei", 700, "Electronics");
        Beverage drink = new Beverage("Ice Tee", "Lipton", 3, false);
        Hardware washing_machine = new Hardware("Washing Machine", "Samsung", 900, 48);

        // adding items to the cart
        cart1.addItem(pasta);
        cart1.addItem(phone);
        cart1.addItem(drink);
        cart1.addItem(washing_machine);

        // displaying out
        System.out.println(cart1.toString());

    }
}

// this class is the parent class
// it contains all the necessary methods to be used later
class Product {
    String theTitle, theBrand;
    double price;

    // Constructor
    Product(String theTitle, String theBrand, double price) {
        this.theTitle = theTitle;
        this.theBrand = theBrand;
        this.price = price;
    }

    // setters and getters
    public void setTheTitle(String theTitle) {
        this.theTitle = theTitle;
    }
    public void setTheBrand(String theBrand) {
        this.theBrand = theBrand;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public String getTheTitle() {
        return theTitle;
    }
    public String getTheBrand() {
        return theBrand;
    }
}

class Food extends Product {
    private String theType;

    // constructor
    Food(String title, String brand, double price, String theType) {
        super(title, brand, price);
        this.theType = theType;
    }

    // setter and getter
    public void setTheType(String theType) {
        this.theType = theType;
    }
    public String getTheType() {
        return theType;
    }
}

class Apparel extends Product {
    String theSeason;

    // constructor
    Apparel(String title, String brand, double price, String theSeason) {
        super(title, brand, price);
        this.theSeason = theSeason;
    }

    // setter and getter
    public void setTheSeason(String theSeason) {
        this.theSeason = theSeason;
    }
    public String getTheSeason() {
        return theSeason;
    }
}

class Beverage extends Product {
    boolean isAlcoholic;

    // constructor
    Beverage(String title, String brand, double price, boolean isAlcoholic) {
        super(title, brand, price);
        this.isAlcoholic = isAlcoholic;
    }

    // setter and getter
    public void setIsAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }
    public boolean isAlcoholic() {
        return this.isAlcoholic;
    }
}

class Hardware extends Product {
    int theWarranty;

    // constructor
    Hardware(String title, String brand, double price, int theWarranty) {
        super(title, brand, price);
        this.theWarranty = theWarranty;
    }

    // setter and getter
    public void setTheWarranty(int theWarranty) {
        this.theWarranty = theWarranty;
    }
    public int getTheWarranty() {
        return theWarranty;
    }
}

class ShoppingCart{
    private ArrayList<Product> theCart;
    private int item_count;
    private int price_total;

    // constructor
    ShoppingCart() {
        theCart = new ArrayList<>();
    }

    // getters
    public int getItem_count() {
        return item_count;
    }
    public int getPrice_total() {
        return price_total;
    }

    // add an item to theCart, increment the count, and update the total price
    public void addItem(Product item){
        this.theCart.add(item);
        item_count++;
        price_total +=item.getPrice();
    }

    public String toString(){
        String string_output ="";
        for (Product product : theCart) {
            string_output += ( product.getTheTitle()+": \t\t-> "+product.getPrice()+" TL"+"\n");
        }
        string_output+=("=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n" +"Total itmes:\t" +this.getItem_count()+
                " items \nTotal price:\t"+this.getPrice_total()+" TL");

        return string_output;
    }

}
