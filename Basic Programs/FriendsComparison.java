import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    
        System.out.print("Enter Amar's age: ");
        int ageAmar = sc.nextInt();

        System.out.print("Enter Akbar's age: ");
        int ageAkbar = sc.nextInt();

        System.out.print("Enter Anthony's age: ");
        int ageAnthony = sc.nextInt();

    
        System.out.print("Enter Amar's height: ");
        double heightAmar = sc.nextDouble();

        System.out.print("Enter Akbar's height: ");
        double heightAkbar = sc.nextDouble();

        System.out.print("Enter Anthony's height: ");
        double heightAnthony = sc.nextDouble();

        if (ageAmar <= ageAkbar && ageAmar <= ageAnthony) {
            System.out.println("Youngest friend is Amar");
        } else if (ageAkbar <= ageAmar && ageAkbar <= ageAnthony) {
            System.out.println("Youngest friend is Akbar");
        } else {
            System.out.println("Youngest friend is Anthony");
        }

        if (heightAmar >= heightAkbar && heightAmar >= heightAnthony) {
            System.out.println("Tallest friend is Amar");
        } else if (heightAkbar >= heightAmar && heightAkbar >= heightAnthony) {
            System.out.println("Tallest friend is Akbar");
        } else {
            System.out.println("Tallest friend is Anthony");
        }

        sc.close();
    }
}
