import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        try {
            String expression = scanner.nextLine();
            if (expression.matches(".*[a-zA-Z]+.*")) {
                throw new Exception("Invalid input. Enter again.");
            }

            // Split the expression into operands and operators
            String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");

            // Saves the operands and operators in separate lists
            List<Double> operands = new ArrayList<>();
            List<Character> operators = new ArrayList<>();
            for (String token : tokens) {
                if (token.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                    operands.add(Double.parseDouble(token));
                } else if (token.matches("[-+*/]")) {
                    operators.add(token.charAt(0));
                }
            }

            double result = operands.get(0);
            int i = 1;

            // Iterate over the operators and operands in parallel
            for (char operator : operators) {
                double  operand = operands.get(i);
                i++;




                // Calculates expresion based on the operator
                switch (operator) {
                    case '+':
                        result += operand;
                        break;
                    case '-':
                        result -= operand;
                        break;
                    case '*':
                        result *= operand;
                        break;
                    case '/':
                        if (operand == 0) {
                            System.out.println("Cannot divide by zero.");
                            return;
                        }
                        result /= operand;
                        break;
                    default:
                        System.out.println("Invalid operator entered.");
                        break;
                }
            }

            // Output the result
             System.out.println("Output: " + result);
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }


        scanner.close();
     }
}
