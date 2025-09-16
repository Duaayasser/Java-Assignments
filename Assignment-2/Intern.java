public class Intern extends Employee {
    
    /*
     * [20] constructor to initialize base salary for the intern
     */
    public Intern() {
        baseSalary = 3000;
    }
    /*
     * [21] override calculate salary method to calculate intern salary
     */
    @Override
    public double calculateSalary() {
        return 3000;
    }
    
}
