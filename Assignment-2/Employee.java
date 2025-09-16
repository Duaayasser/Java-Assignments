public abstract class Employee {
    protected int ID;
    protected String name;
    protected double baseSalary;
    private static int employeeCount = 0;
   /*
    * [1] a constructor to initialize varibles
    */
    public Employee() {
        ID = 0;
        name = " ";
        baseSalary = 0.0;
        employeeCount++;
    }
    /*
     * [2] set the anme to the given value
     */
    public void setName(String name){
        this.name = name;
    }
    /*
     * [3] set the ID to the given value
     */
    public void setID(int ID){
        this.ID = ID;
    }
    /*
     * [4] return the ID
     */
    public int getID(){
        return this.ID;
    }
    /*
     * [5] return the name
     */
    public String getName(){
        return this.name;
    }
    /*
     * [6] return the base salary
     */
    public double getBaseSalary(){
        return this.baseSalary;
    }
    /*
     * [7] abstract method to calculate salary depends on employee type
     */
    public abstract double calculateSalary();
    /*
     * [8] method to display employee info
     */
    public void displayInfo(){
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getID());
        System.out.println("Base Salary: "+getBaseSalary());
    }
    /*
     * [9] return number of employees added
     */
    public static int getEmployeeCount(){
        return employeeCount;
    }
}
