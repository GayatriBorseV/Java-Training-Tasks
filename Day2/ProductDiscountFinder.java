import java.util.Scanner;

public class ProductDiscountFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();

        for (int i = 1; i <= numberOfProducts; i++) {
            System.out.println("\nProduct " + i);

            // Input: Original price of the product
            System.out.print("Enter the original price of the product: ");
            double originalPrice = scanner.nextDouble();

            // Input: Discount percentage
            System.out.print("Enter the discount percentage: ");
            double discountPercentage = scanner.nextDouble();

            // Calculate the discounted price
            double discountAmount = (originalPrice * discountPercentage) / 100;
            double discountedPrice = originalPrice - discountAmount;

            // Display the discounted price
            System.out.println("Discounted Price: " + String.format("%.2f", discountedPrice));
        }

        System.out.println("\nThank you for using the Product Discount Finder!");
        scanner.close();
    }
}
