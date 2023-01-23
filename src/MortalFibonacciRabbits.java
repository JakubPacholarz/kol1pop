import java.util.Scanner;
public class MortalFibonacciRabbits {

    public static void main(String[] args) {

        System.out.println("This is Mortal Fibonacci Rabbits program.");
        Scanner input = new Scanner(System.in);
        System.out.print(" n = ");
        int n = input.nextInt();

        System.out.print(" m = ");
        int m = input.nextInt();
        input.close();

        long[] F = new long[n + 1];
        long[] rabit = new long[m];
        rabit[0] = 1;
        F[1] = 1;

        for (int i = 2; i <= n; i++) {

            long[] next = new long[m];
            for (int j = 1; j < m; j++) {
                next[j] = rabit[j - 1];
                next[0] += rabit[j];
            }

            for (int k = 0; k < m; k++) {
                rabit[k] = next[k];
                F[i] += rabit[k];
            }

            System.out.print(" " + F[i]);
        }

        System.out.println("\nAt " + n + "th month, there are " + F[n] + " rabbits.");

    }
}