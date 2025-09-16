public class Salesman extends Employee {
    private double commission;
    /*
     * [15] constructor to initialize base salary for salesman
     */
    public Salesman() {
        baseSalary = 4000;
    }
    /*
     * [16] set commission to the given value
     */
    public void setCommission(double commission){
        this.commission = commission;
    }
    /*
     * [17] return commission
     */
    public double getCommission(){
        return this.commission;
    }
    /*
     * [18] override calculate salary method to calculate salesman salary
     */
    @Override
    public double calculateSalary() {
        return baseSalary + this.commission;
    }
    /*
     * [19] override display info method
     */
    @Override
    public void displayInfo() {
        System.out.println("---Salesman---");
        super.displayInfo();
        System.out.println("Commission: "+getCommission());
    }
    
    
}
