import java.util.Arrays;

public class Product {

    private String name;
    private Double price;

    private Attribute[] attributes;

    private Product() {

    }

    public static class ProductBuilder {
        private String name;
        private Double price;

        private PhysicalDimensions width;
        private PhysicalDimensions height;
        private PhysicalDimensions length;
        private PhysicalDimensions weight;


        ProductBuilder(String name, Double price) {
            this.name  = name;
            this.price = price;
        }

        public ProductBuilder withDimensions(PhysicalDimensions width, PhysicalDimensions height, PhysicalDimensions length) {
            this.width  = width;
            this.height = height;
            this.length = length;
            return this;
        }

        public ProductBuilder withWeight(PhysicalDimensions weight) {
            this.weight  = weight;
            return this;
        }

        public Product build() {
            Product product = new Product();

            product.setName(name);
            product.setPrice(price);

            product.setAttributes(new Attribute[4]);
            if (width != null) {
                product.getAttributes()[0] = new Attribute("width", width);
            }
            if (height != null) {
                product.getAttributes()[1] = new Attribute("height", height);
            }
            if (length != null) {
                product.getAttributes()[2] = new Attribute("length", length);
            }
            if (weight != null) {
                product.getAttributes()[3] = new Attribute("weight", weight);
            }
            return product;
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }
    
    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", attributes=" + Arrays.toString(attributes) + "]";
    }

}