//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        permanentEmployee permEmp = new permanentEmployee(101, "Esther", 25000, 1500);
        permEmp.calculatesalary();
        permEmp.displayDetails();

        System.out.println();

        TemporaryEmployee tempEmp = new TemporaryEmployee(102, "Ganesh", 15000, 20);
        tempEmp.calculatesalary();
        tempEmp.displayDetails();

    }
}