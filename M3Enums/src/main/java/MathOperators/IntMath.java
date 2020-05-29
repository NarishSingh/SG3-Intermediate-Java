/*
Create an enum for math Operators: plus, minus, multiply, and divide.
Create an App class that reads in two operands and calls the calculate method (shown below) one time for each operator in your enum.
Output your results to the screen after every operation is performed.
 */
package MathOperators;

import java.util.Scanner;

public class IntMath {

    static public int calculate(Ops operator, int op1, int op2) {
        switch (operator) {
            case PLUS: {
                return op1 + op2;
            }
            case MINUS: {
                return op1 - op2;
            }
            case MULTIPLY: {
                return op1 * op2;
            }
            case DIVIDE: {
                return op1 / op2;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the basic calculator (enum edition)");
        System.out.println("Select calculation type:");
        System.out.println("1 | Addition");
        System.out.println("2 | Subtraction");
        System.out.println("3 | Multiplication");
        System.out.println("4 | Division");
        int menuChoice = input.nextInt();

        switch (menuChoice) {
            case 1: {
                System.out.print("Enter first number: ");
                int num1 = input.nextInt();
                System.out.print("Enter second number: ");
                int num2 = input.nextInt();
                System.out.println(calculate(Ops.PLUS, num1, num2));;
                break;
            }
            case 2: {
                System.out.print("Enter first number: ");
                int num1 = input.nextInt();
                System.out.print("Enter second number: ");
                int num2 = input.nextInt();
                System.out.println(calculate(Ops.MINUS, num1, num2));
                break;
            }
            case 3: {
                System.out.print("Enter first number: ");
                int num1 = input.nextInt();
                System.out.print("Enter second number: ");
                int num2 = input.nextInt();
                System.out.println(calculate(Ops.MULTIPLY, num1, num2));
                break;
            }
            case 4: {
                System.out.print("Enter first number: ");
                int num1 = input.nextInt();
                System.out.print("Enter second number: ");
                int num2 = 0;
                do {
                    num2 = input.nextInt();
                } while (num2 == 0);
                System.out.println(calculate(Ops.DIVIDE, num1, num2));
                break;
            }
            default:
                throw new AssertionError();
        }
    }

}
