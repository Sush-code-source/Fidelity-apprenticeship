import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the abstract to calculate volume: ");
        System.out.println("1. Cylinder");
        System.out.println("2. Cube");

        int choice = scanner.nextInt();
        Abstract shape =null;
        switch (choice) {
            case 1:

                System.out.println("Enter the radius of the cylinder: ");
                double radius = scanner.nextDouble();
                System.out.println("Enter the height of the cylinder: ");
                double height = scanner.nextDouble();
                shape=new Cylinder(radius, height);
                break;
            case 2:
                System.out.println("Enter the side length of the cube: ");
                double side = scanner.nextDouble();
               shape=new Cube(side);
                break;
            default:
                System.out.println("Invalid choice");
                break;

        }
        if (shape!=null){

            System.out.println("The volume is:" + shape.calculateVolume());

        }
       // scanner.close();
    }


}
