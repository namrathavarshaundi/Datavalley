import java.io.*;

class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private double price;

    // Constructor
    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    // Method to print product details
    public void printDetails() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Product Category: " + category);
        System.out.println("Product Price: " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a product object
        Product product = createProduct();

        // Serialize the object
        serializeProduct(product);

        // Deserialize the object
        Product deserializedProduct = deserializeProduct();

        // Print the details of deserialized product
        System.out.println("Deserialized Product Details:");
        deserializedProduct.printDetails();
    }

    // Method to create a product object using runtime input
    public static Product createProduct() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(reader.readLine());

            System.out.print("Enter Product Name: ");
            String name = reader.readLine();

            System.out.print("Enter Product Category: ");
            String category = reader.readLine();

            System.out.print("Enter Product Price: ");
            double price = Double.parseDouble(reader.readLine());

            return new Product(id, name, category, price);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to serialize the product object
    public static void serializeProduct(Product product) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("product.ser"))) {
            outputStream.writeObject(product);
            System.out.println("Product serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to deserialize the product object
    public static Product deserializeProduct() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("product.ser"))) {
            return (Product) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
