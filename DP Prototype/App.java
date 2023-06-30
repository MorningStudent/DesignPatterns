import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Product bread  = new Product(1001, "Franzela alba", new Money(200, "EUR"), 10);
        Product milk   = new Product(1002, "Casuta mea", new Money(100, "EUR"), 5);
        Product water  = new Product(1003, "Spark", new Money(300, "EUR"), 100);

        Shop shop = new Shop();
        shop.products[0] = bread;
        shop.products[1] = milk;
        shop.products[2] = water;

        System.out.println("\tBEFORE the client adds to his cart the products!");
        System.out.println(shop);

        Cart cart = new Cart();
        cart.addProduct(water, 2);

        shop.products[2].price.amount +=50;

        System.out.println("\tAFTER the client adds to his cart the products!");
        System.out.println(shop);
        System.out.println(cart);

    }
}

class Money implements Cloneable {
    public int amount;
    public String currency;
    
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return  amount + " " + currency;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class Product implements Cloneable {
    public int id;
    public String name;
    public Money price;
    public int quantity;

    public Product(int id, String name, Money price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "\n\tProduct [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clonned = super.clone();
        ((Product)clonned).price = (Money)((Product)clonned).price.clone();
        return clonned;
    }
    
}

class Shop {
    Product[] products = new Product[3];

    @Override
    public String toString() {
        return "Shop [products=\n" + Arrays.toString(products) + "\n]";
    }
    
}

class Cart {
    Product[] products = new Product[1];

    public void addProduct(Product product, int quantity) {
        try {
            Product clonnedProduct = (Product)product.clone();
            products[0] = clonnedProduct;
            clonnedProduct.quantity = quantity;
            product.quantity -= quantity;
        } catch (CloneNotSupportedException e) {
            System.out.println("CLONE ERROR!");
        }
    }

    @Override
    public String toString() {
        return "Cart [products=\n" + Arrays.toString(products) + "\n]";
    }
    
}