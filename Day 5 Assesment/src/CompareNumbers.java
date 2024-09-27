import java.util.Scanner;

public class CompareNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x,y;
        System.out.print("Enter the value of x: ");
        x = scanner.nextInt();
        System.out.print("Enter the value of y: ");
        y=scanner.nextInt();
        boolean result = x < y;
        System.out.println("The results of whether x is less than y is "+ result);
        scanner.close();
    }
}
