public class Manager extends Employee{
    private double bonus;
    /*
     * [10] constructor to initialize base salary for the manager
     */
    public Manager() {
        baseSalary = 5000;
    }
    /*
     * [11] set bonus with the given value
     */
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    /*
     * [12] return bonus
     */
    public double getBonus()
    {
        return this.bonus;
    }
    /*
     * [13] override calculate salary method to calculate manager salary
     */
    @Override
    public double calculateSalary() {
        return baseSalary + this.bonus;
    }
    /*
     * [14] override display info method
     */
    @Override
    public void displayInfo() {
        System.out.println("---Manager---");
        super.displayInfo();
        System.out.println("Bonus: "+getBonus());
    }
    
}
