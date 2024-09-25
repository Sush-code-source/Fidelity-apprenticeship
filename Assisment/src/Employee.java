public class Employee {
    int id;
    String name;
    float basicsalary;
    float bonus;
    float netsalary;

    public Employee(int id, String name, float basicSalary) {
        this.id = id;
        this.name = name;
        this.basicsalary = basicSalary;
    }

    public void calculateBonus() {

    }

    public void calculatesalary() {

    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Basic Salary: " + basicsalary);
        System.out.println("Employee Bonus: " + bonus);
        System.out.println("Employee Netsalary: " + netsalary);
    }
}

class permanentEmployee extends Employee {
    int pf;
    public permanentEmployee(int id, String name, float basicSalary, int pf) {
        super(id, name, basicSalary);
        this.pf = pf;
    }
    @Override
    public void calculateBonus() {
        if(pf<1000){
            bonus = 0.10f*basicsalary;
        }
        else if (pf>=1000 && pf<1500){
            bonus = 0.11f*basicsalary;
        }
        else if (pf>=1500 && pf<1800){
            bonus = 0.12f*basicsalary;
        }
        else{
            bonus = 0.15f*basicsalary;
        }
    }

    @Override
    public void calculatesalary() {
        netsalary = basicsalary - pf;
        calculateBonus();
        netsalary += bonus;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("PF:" + pf);
    }
}

class TemporaryEmployee extends Employee {
    int dailyWages;
    int noOfDays;

    public TemporaryEmployee(int id, String name, int dailyWages, int noOfDays) {
        super(id, name, dailyWages*noOfDays);
        this.dailyWages = dailyWages;
        this.noOfDays = noOfDays;
    }

    @Override
    public void calculateBonus() {
        if(dailyWages<1000){
            bonus = 0.15f*netsalary;
        }else if(dailyWages>=1000 && dailyWages<1500){
            bonus = 0.12f*netsalary;
        }else if(dailyWages>=1500 && dailyWages<1750){
            bonus = 0.11f*netsalary;
        }else {
            bonus = 0.88f*netsalary;
        }
    }

    @Override
    public void calculatesalary() {
        netsalary=dailyWages*noOfDays;
        calculateBonus();
        netsalary += bonus;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Daily Wages: " + dailyWages);
        System.out.println("No. of Days Worked: " + noOfDays);
    }
}
