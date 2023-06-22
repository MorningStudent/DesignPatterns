public class App {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.subscribe(new Client("John Doe"));
        shop.subscribe(new Client("Marry Poppins"));
        shop.subscribe(new Client("Nicolas Deville"));

        System.out.println("The shop has the next subscribers:");
        for (Client client : shop.clients) {
            if(client != null)
                System.out.println("\t" + client.fullName);
        }
        System.out.println();

        shop.addProduct(new Product("Smartphone case R1 blue"));
        shop.addProduct(new Product("Smartphone case R3 red"));

        System.out.println();

        System.out.println("The shop has the next products:");
        for (Product product : shop.products) {
            if(product != null)
                System.out.println("\t" + product.name);
        }

    }


}

class Shop {
    public Product[] products = new Product[5];
    public Client[] clients   = new Client[10];

    private void addObjectIntoArray(Object object) {    // <--Good to be private
        Object[] array = new Object[1];
        switch (object.getClass().getName()) {
            case "Product": array = products; break;
            case "Client" : array = clients;  break;
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                array[i] = object;
                break;
            }
        }
    }

    public void addProduct(Product product) {
        addObjectIntoArray(product);
        for (Client client : clients) {
            if(client != null)
            client.update(product);
        }
    } 

    public void subscribe(Client  client) {
        addObjectIntoArray(client);
    }

    // ----First idea for the unsubscribe method----
    // public void unsubscribe(int index) {
    //     for (int i = 0; i < clients.length; i++) {
    //         if(i == index && clients[i + 1] != null && i != (clients.length - 1)) {
    //             for (int j = i + 1; j < clients.length; j++) {
    //                 clients[i++] = clients[j];
    //                 if(clients[j + 1] == null) {
    //                     clients[j] = null;
    //                     break;
    //                 }
    //             }
    //         } else if (i == index && clients[i + 1] == null) {
    //             clients[i] = null;
    //             break;
    //         } else if (i == index && i == (clients.length - 1)) {
    //             clients[i] = null;
    //         }
    //     }
    // }

    //--Optimized version, maybe it could be better though
    public void unsubscribe(int index) {                              
        if ( index == 0 || index == (clients.length-1)) {
            clients[index] = null;
        } else {
            for (int i=index; i < (clients.length-1); i++) {
                clients[i] = clients[i + 1];
            }
        }
    }
    
}

class Product {
    public String name;

    public Product(String name) {
        this.name = name;
    }

}

class Client {
    public String fullName;

    public Client(String fullName) {
        this.fullName = fullName;
    }
    
    public void update(Product product) {
        System.out.println("Me, " + fullName + ", i have decided to buy " + product.name);
    }
}