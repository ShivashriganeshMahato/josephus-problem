import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Comparing 2 solutions to Josephus Problem: tracing and bit manipulation
 *
 * @author Shivashriganesh Mahato
 */
public class Main {
    public static void main(String[] args) {
        int n;

        // Input number of soldiers
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Please enter the number of soldiers: ");
                n = scan.nextInt();
                if (n <= 0)
                    throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again");
                scan.nextLine();
                continue;
            }
            break;
        }

        long oldTime = System.nanoTime();

        // Bit manipulation
        String toBinary = Integer.toBinaryString(n);
        String shiftedBinary = toBinary.substring(1, toBinary.length()) + toBinary.substring(0, 1);
        System.out.println("\nMethod 1 Safe position: " + Integer.parseInt(shiftedBinary, 2));

        System.out.println("Elapsed Time: " + (System.nanoTime() - oldTime) + " ns\n");
        oldTime = System.nanoTime();

        // Tracing
        ArrayList<Integer> people = new ArrayList<>();
        for (int l = 1; l <= n; l++)
            people.add(l);

        for (int k = 0; people.size() > 1; k = k + 1 >= people.size() ? 0 : k + 1)
            people.remove((k + 1) % people.size());
        System.out.println("Method 2 Safe Position: " + people.get(0));

        System.out.println("Elapsed Time: " + (System.nanoTime() - oldTime) + " ns");
    }
}
