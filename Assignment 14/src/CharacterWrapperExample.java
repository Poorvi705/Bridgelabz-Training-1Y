import java.util.Scanner;

public class CharacterWrapperExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int letters = 0;
        int digits = 0;
        int specialChars = 0;

        // Loop through each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                letters++;
            }
            else if (Character.isDigit(ch)) {
                digits++;
            }
            else if (!Character.isWhitespace(ch)) {
                specialChars++;
            }
        }

        // Output results
        System.out.println("Total Letters: " + letters);
        System.out.println("Total Digits: " + digits);
        System.out.println("Total Special Characters: " + specialChars);

        sc.close();
    }
}