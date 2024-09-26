
abstract class Abstract {
    abstract  double calculateVolume();
}

class Cylinder extends Abstract {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
}

class Cube extends Abstract {
    private double side;
    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double calculateVolume() {
        return side * side * side;
    }
}


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Choose the abstract to calculate volume: ");
//        System.out.println("1. Cylinder");
//        System.out.println("2. Cube");
//
//        int choice = scanner.nextInt();
//        Abstract abstract =null;
//        switch (choice) {
//            case 1:
//
//                System.out.println("Enter the radius of the cylinder: ");
//                double radius = scanner.nextDouble();
//                System.out.println("Enter the height of the cylinder: ");
//                double height = scanner.nextDouble();
//                abstract=new Cylinder(radius, height);
//                break;
//            case 2:
//                System.out.println("Enter the side length of the cube: ");
//                double side = scanner.nextDouble();
//                abstract =new Cube(side);
//                break;
//            default:
//                System.out.println("Invalid choice");
//                break;
//
//        }
//        if ( abstract !=null ){
//
//            System.out.println("The volume is:" + abstract.calculateVolume());
//
//        }
//        scanner.close();
//    }
//



