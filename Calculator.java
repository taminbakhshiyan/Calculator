import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a mathematical expression
        System.out.print("Enter a mathematical expression (e.g., 12 + 5): ");
        String input = scanner.nextLine();

        // Regular expression to extract numbers and operator
        Pattern pattern = Pattern.compile("\\s*(-?\\d+(\\.\\d+)?)\\s*([+\\-*/])\\s*(-?\\d+(\\.\\d+)?)\\s*");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            System.out.println("Error: Invalid expression format.");
            scanner.close();
            return;
        }

        double num1 = Double.parseDouble(matcher.group(1));
        char operator = matcher.group(3).charAt(0);
        double num2 = Double.parseDouble(matcher.group(4));
        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    scanner.close();
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Error: Invalid operator.");
                scanner.close();
                return;
        }

        System.out.println("Result: " + result);

        // Close the scanner object to prevent resource leaks
        scanner.close();
    }
}