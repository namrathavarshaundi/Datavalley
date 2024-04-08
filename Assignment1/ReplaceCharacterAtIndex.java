import java.util.Scanner;

public class ReplaceCharacterAtIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter  ");
        int ind = scanner.nextInt();

        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter ");
        char replacementChar = scanner.nextLine().charAt(0);

        String replaceString = replaceCharAtIndex(inputString, ind, replacementChar);
        System.out.println("String after replacement: " + replaceString);

        scanner.close();
    }

    public static String replaceCharAtIndex(String str, int index, char replaceChar) {
        if (ind < 0 || ind >= str.length()) {
            return "Invalid index";
        }

        char[] chars = str.toCharArray();
        chars[ind] = replaceChar;
        return new String(chars);
    }
}
