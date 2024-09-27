import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        String reversedSentence = "";
        for(int i = words.length - 1; i >= 0; i--) {
            reversedSentence += words[i] + " ";
        }
        System.out.println(reversedSentence.trim());
        scanner.close();


    }
}
