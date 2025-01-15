import java.util.ArrayList;
import java.util.Scanner;

// Product Class
class Product {
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display Product Details
    public void displayProduct() {
        System.out.println("Name: " + name + ", Price: $" + price + ", Quantity: " + quantity);
    }
}

// Cart Class
class Cart {
    private ArrayList<Product> products;

    // Constructor
    public Cart() {
        products = new ArrayList<>();
    }

    // Add a product to the cart
    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(product.getName())) {
                // Update quantity if product already exists in the cart
                p.setQuantity(p.getQuantity() + product.getQuantity());
                System.out.println(product.getName() + " quantity updated in the cart.");
                return;
            }
        }
        products.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    // Remove a product from the cart
    public void removeProduct(String productName) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                products.remove(p);
                System.out.println(productName + " removed from the cart.");
                return;
            }
        }
        System.out.println(productName + " is not in the cart.");
    }

    // Calculate the total price of the cart
    public double calculateTotalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }

    // Display the cart details
    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Products in the cart:");
            for (Product p : products) {
                p.displayProduct();
            }
        }
    }
}

// Main Class
public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        boolean running = true;

        System.out.println("Welcome to the Shopping Cart System!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Cart");
            System.out.println("4. Calculate Total Price");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Product
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(name, price, quantity);
                    cart.addProduct(product);
                    break;

                case 2: // Remove Product
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the name of the product to remove: ");
                    String productName = scanner.nextLine();
                    cart.removeProduct(productName);
                    break;

                case 3: // View Cart
                    cart.displayCart();
                    break;

                case 4: // Calculate Total Price
                    double total = cart.calculateTotalPrice();
                    System.out.println("Total Price: $" + total);
                    break;

                case 5: // Exit
                    System.out.println("Thank you for using the Shopping Cart System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
