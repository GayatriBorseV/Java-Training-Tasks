import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
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

        // Sort the array in ascending order
        int[] ascending = arr.clone();
        Arrays.sort(ascending);

        // Sort the array in descending order
        int[] descending = ascending.clone();
        for (int i = 0; i < descending.length / 2; i++) {
            int temp = descending[i];
            descending[i] = descending[descending.length - 1 - i];
            descending[descending.length - 1 - i] = temp;
        }

        // Output results
        System.out.println("Sorted in Ascending Order: " + Arrays.toString(ascending));
        System.out.println("Sorted in Descending Order: " + Arrays.toString(descending));

        scanner.close();
    }
}
