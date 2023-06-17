public class ShopApp {
    public static void main(String[] args) {
        
        Product smartPhone = ProductFactory.createProduct("phone", "SamsungXXII", 1000.00, 10);
        Product inkPrinter = ProductFactory.createProduct("printer", "CANNON PIXMA600", 250.00, "A4");
        Product smallLaptop = ProductFactory.createProduct("laptop", "Apple X", 2500.00, "M2");


        System.out.println(smartPhone);
        System.out.println(inkPrinter);
        System.out.println(smallLaptop);
    }
}
