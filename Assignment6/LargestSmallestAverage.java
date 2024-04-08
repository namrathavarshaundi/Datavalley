package FINDLARGEST;

import java.util.Scanner;

public class LargestSmallestAverage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        double largest = Double.MIN_VALUE;
        double smallest = Double.MAX_VALUE;

        char choice;

        do {
            System.out.print("Enter a number (or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            double number = Double.parseDouble(input);
            count++;
            sum += number;

            largest = Math.max(largest, number);
            smallest = Math.min(smallest, number);

            System.out.print("Do you want to enter another number (y/n): ");
            choice = scanner.nextLine().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        if (count > 0) {
            double average = sum / count;
            System.out.println("Largest number: " + largest);
            System.out.println("Smallest number: " + smallest);
            System.out.println("Average: " + average);
        } else {
            System.out.println("No numbers were entered.");
        }
    }
}
