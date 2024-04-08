import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] values = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        int sum = findSumOfDivisibleBy5And2(values);
        System.out.println("Sum of numbers divisible by 5 and 2: " + sum);

        scanner.close();
    }

    public static int findSumOfDivisibleBy5And2(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num % 5 == 0 && num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }
}
