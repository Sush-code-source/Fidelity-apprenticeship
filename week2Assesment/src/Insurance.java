import java.util.Scanner;
class Insurance {
    private String insuranceNo;
    private String insuranceName;
    private double amountCovered;


   public String getInsuranceNo() {
    return insuranceNo;
}
public String getInsuranceName() {
    return insuranceName;
}
public double getAmountCovered() {
    return amountCovered;
}
public Insurance(String insuranceNo, String insuranceName, double amountCovered) {
    this.insuranceNo = insuranceNo;
    this.insuranceName = insuranceName;
    this.amountCovered = amountCovered;
    }
}

class MotorInsurance extends Insurance {
    private double idv;
    private float depPercent;

    public double getIdv() {
        return idv;
    }

    public float getDepPercent() {
        return depPercent;
    }

    public MotorInsurance(String insuranceNo, String insuranceName, double amountCovered, float depPercent) {
        super(insuranceNo, insuranceName, amountCovered);
        this.depPercent = depPercent;
        this.idv = amountCovered-((amountCovered * depPercent) / 100);
    }

    public double calculatePremium() {
        return 0.03 * idv;//3%of IDV
    }
}
class LifeInsurance extends Insurance {
    private int policyTerm;
    private float benefitPercent;
    public int getPolicyTerm() {
        return policyTerm;
    }
    public float getBenefitPercent() {
        return benefitPercent;
    }
    public LifeInsurance(String insuranceNo, String insuranceName, double amountCovered, int policyTerm,float benefitPercet) {
        super(insuranceNo, insuranceName, amountCovered);
        this.policyTerm = policyTerm;
        this.benefitPercent = benefitPercet;
    }
    public double calculatePremium() {
        return(getAmountCovered()-((getAmountCovered()*benefitPercent)/100))/policyTerm;
    }
}
class program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insurance Number:");
        String insuranceNo = scanner.nextLine();
        System.out.println("Insurance Name:");
        String insuranceName = scanner.nextLine();
        System.out.println("Amount Covered:");
        double amountCovered = scanner.nextDouble();
        System.out.println("Select");
        System.out.println("1.Life Insurance");
        System.out.println("2.Motor Insurance");
        int option=scanner.nextInt();
        if(option == 1) {
            System.out.println("Policy Term:");
            int policyTerm = scanner.nextInt();
            System.out.println("Benefit Percent:");
            float benefitPercent = scanner.nextFloat();
            LifeInsurance lifeInsurance = new LifeInsurance(insuranceNo, insuranceName, amountCovered, policyTerm, benefitPercent);
            double premium = addPolicy(lifeInsurance, option);
            System.out.println("Calculated Premium:" + premium);
        }
        else if (option == 2) {
            System.out.println("Depreciation Percent:");
            float depPercent = scanner.nextFloat();

            MotorInsurance motorInsurance = new MotorInsurance(insuranceNo, insuranceName, amountCovered, depPercent);
            double premium = addPolicy(motorInsurance,option);
            System.out.println("Calculated Premium:" + premium);
        } else {
            System.out.println("Invalid Option selected.");
        }
        scanner.close();
    }

    public static double addPolicy(Insurance ins, int opt) {
        if (opt == 1) {
            return ((LifeInsurance) ins).calculatePremium();
        } else if (opt == 2) {
            return ((MotorInsurance) ins).calculatePremium();
        }
        return 0;
    }
}






