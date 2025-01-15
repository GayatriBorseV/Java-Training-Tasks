import java.util.Scanner;

public class FindLargestSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array of integers
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find the largest and smallest numbers
        int largest = arr[0];
        int smallest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
            if (num < smallest) {
                smallest = num;
            }
        }

        // Output results
        System.out.println("Largest Number: " + largest);
        System.out.println("Smallest Number: " + smallest);

        scanner.close();
    }
}
