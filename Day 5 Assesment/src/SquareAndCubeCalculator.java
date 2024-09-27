import java.util.Scanner;

public class SquareAndCubeCalculator {
    static double FindSquare(double number){
        return number * number;
    }
    static double FindCube(double number){
        return number * number;
    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter a  number :" );
        double number = scanner.nextDouble();
        double square = FindSquare(number);
        double cube = FindCube(number);
        System.out.println("square of " + number + " is " + square);
        System.out.println("cube of " + number + " is " + cube);
    }
}
