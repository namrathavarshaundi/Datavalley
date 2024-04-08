import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        printOddPositionCharacters(text);

        scanner.close();
    }

    public static void printOddPositionCharacters(String text) {
        // Remove white spaces
        String trimmedText = text.replaceAll("\\s+", "");
        
        // Print characters at odd positions
        System.out.println("Characters at odd positions (ignoring white spaces):");
        for (int i = 0; i < trimmedText.length(); i++) {
            if (i % 2 != 0) {
                System.out.print(trimmedText.charAt(i) + " ");
            }
        }
    }
}
