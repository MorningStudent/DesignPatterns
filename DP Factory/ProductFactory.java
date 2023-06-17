public class ProductFactory {
    
    private static Product createBaseProduct(String type, String name, double price) {
        Product product = null;
        switch (type) {
            case "phone"  : product = new Phone();   break;
            case "printer": product = new Printer(); break;
            case "laptop" : product = new Laptop();  break;
        }
        if(product != null) {
            product.setName(name);
            product.setPrice(price);
        }

        return product;
    }

    public static Product createProduct(String type, String name, double price, int diagonal) {
        Product product = createBaseProduct(type, name, price);
        ((Phone)product).setDiagonal(diagonal);
        return product;
    }

    public static Product createProduct(String type, String name, double price, String value) {
        Product product = createBaseProduct(type, name, price);
        switch (type) {
            case "printer": ((Printer)product).setFormat(value); break;
            case "laptop" : ((Laptop)product).setCPU(value);     break;
        }
        return product;
    }

}
