import java.util.Scanner;

public class Calculator {
    public int Addition(int a, int b) {
        return a + b;
    }

    public int Subtraction(int a, int b) {
        return a - b;
    }

    public int Multiplication(int a, int b) {
        return a * b;
    }

    public double Division(int a, int b){
        if (b == 0){
            throw new ArithmeticException("Division by zero is not allowed");

    }

        System.out.println(a/b);
        System.out.println("Remainder : "+a%b);
        return a/b;

    }
}

class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("Enter the first number");
        int a = scanner.nextInt();
        System.out.println("Enter the second number");
        int b = scanner.nextInt();
        System.out.println("Enter the operator(+,-,*,/):");
        char operator = scanner.next().charAt(0);
        switch (operator) {
            case '+':
                System.out.println("Result:" + calculator.Addition(a, b));
                break;
            case '-':
                System.out.println("Results: " + calculator.Subtraction(a, b));
                break;
            case '*':
                System.out.println("Results: " + calculator.Multiplication(a, b));
                break;
            case '/':
                try {
                    System.out.print("Results ");
                    double quotient = calculator.Division(a, b);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid operator!");
        }

    }
}


