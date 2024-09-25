import java.util.Scanner;

public class Q7 {
    public static int calculateaverage(int[] numbers) {
           int sum = 0;
           for (int num: numbers) {
                sum += num;
           }
        return sum / numbers.length;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int average = calculateaverage(numbers);
        System.out.println("The average is " + average);
        sc.close();
    }
}

