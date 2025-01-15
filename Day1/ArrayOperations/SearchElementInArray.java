import java.util.Scanner;

public class SearchElementInArray {
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

        // Input element to search
        System.out.print("Enter the element to search: ");
        int elementToSearch = scanner.nextInt();

        // Search for the element in the array
        int position = -1; // Default value to indicate element not found
        for (int i = 0; i < n; i++) {
            if (arr[i] == elementToSearch) {
                position = i;
                break;
            }
        }
      

        // Output result
        if (position != -1) {
            System.out.println("Element " + elementToSearch + " is found at index: " + position);
        } else {
            System.out.println("Element " + elementToSearch + " is not found in the array.");
        }

        scanner.close();
    }
}
