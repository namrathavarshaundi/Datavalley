import java.util.Scanner;

public class DiscountPurchase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter quantity purchased: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price per item: ");
        double price = scanner.nextDouble();

        double total = quantity * price;
        double discount = 0;

        if (quantity > 50) {
            discount = total * 0.1;
        } else if (quantity >= 25) {
            discount = total * 0.05;
        }

        double finalPrice = total - discount;
        scanner.close();
        System.out.println("Total before discount: $" + total);
        System.out.println("Discount applied: $" + discount);
        System.out.println("Total after discount: $" + finalPrice);
    }
}
