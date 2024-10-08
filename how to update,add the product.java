import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(int id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", quantity=" + quantity + "]";
    }
}

public class InventoryManagementSystem {
    private static List<Product> products = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    updateProductQuantity(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(nextId++, name, description, price, quantity);
        products.add(product);

        System.out.println("Product added successfully!");
    }

    private static void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("\nProduct List:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static void updateProductQuantity(Scanner scanner) {
        System.out.print("Enter product ID to update quantity: ");
        int id = scanner.nextInt();

        Product productToUpdate = null;
        for (Product product : products) {
            if (product.getId() == id) {
                productToUpdate = product;
                break;
            }
        }

        if (productToUpdate == null) {
            System.out.println("Product not found.");
        } else {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            productToUpdate.setQuantity(newQuantity);
            System.out.println("Product quantity updated successfully!");
        }
    }
}
