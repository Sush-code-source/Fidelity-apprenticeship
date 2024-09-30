import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class EmployeeFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.println("Enter employees names(type 'exit' to exit): ");
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            employees.add(new Employee(input));
        }
        List<Employee>
                filteredEmployees = employees.stream().filter(e -> e.getName().startsWith("A")).collect(Collectors.toList());
        System.out.println("Employees whose names start with 'A': ");
        filteredEmployees.forEach(e -> System.out.println(e.getName()));
        scanner.close();

    }

}
