
import java.util.Scanner;
public class Diamond {
    public static void main(String[] args) {
        // Makes a diamond shape based on the user input 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the diamond: ");
        int n = scanner.nextInt();

        // The Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) System.out.print(" ");
            for (int k = 1; k <= 2 * i - 1; k++) System.out.print("*");
            System.out.println();
        }

        // the Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--) System.out.print(" ");
            for (int k = 1; k <= 2 * i - 1; k++) System.out.print("*");
            System.out.println();
        }
        // ends the program
        scanner.close();
    }
}
