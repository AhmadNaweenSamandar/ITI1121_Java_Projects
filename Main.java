import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two integers (a and b):");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Enter an operator (+, -, *, /, %):");
        String opr = sc.next();

        switch (opr) {
            case "+":
                System.out.println("The sum: " + (a + b));
                break;
            case "-":
                System.out.println("The diff: " + (a - b));
                break;
            case "*":
                System.out.println("The mul: " + (a * b));
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    System.out.println("The Division: " + (a / b));
                }
                break;
            case "%":
                if (b == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    System.out.println("The Reminder: " + (a % b));
                }
                break;
            default:
                System.out.println("Error: Invalid operator entered.");
        }

        sc.close(); // Close the scanner to release resources
    }
}
