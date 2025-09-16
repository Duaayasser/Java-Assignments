import java.util.ArrayList;
import java.util.Scanner;

public class BusinessSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        int numOfEmployees;
        int choice;
        char again = 'y';
        double totalPayroll;
        double managerPayroll;
        double salesPayroll;
        double internPayroll;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the company's new system");
        do {
            clearScreen();
            System.out.println("Choose the operation you wanna confirm: ");
            System.out.println("[1]Add employee\n[2]View all employees\n[3]View total payroll");
            choice = getValidChoice(scanner, 1, 3);

            switch (choice) {
                case 1 -> {
                    System.out.println("Please enter how many employees you wanna add: ");
                    numOfEmployees = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < numOfEmployees; i++) {
                        System.out.println("What type of employee number " + (i + 1) + " you will add?");
                        System.out.println("[1]Manager\n[2]Salesman\n[3]Intern");
                        choice = getValidChoice(scanner, 1, 3);
                        scanner.nextLine();
                        Employee employee = null;
                        switch (choice) {
                            case 1 -> employee = new Manager();
                            case 2 -> employee = new Salesman();
                            case 3 -> employee = new Intern();
                            default -> throw new AssertionError("Invalid choice!");
                        }
                        System.out.println("Please enter employee " + (i + 1) + " name: ");
                        String name = scanner.nextLine();
                        employee.setName(name);
                        System.out.println("Please enter employee " + (i + 1) + " ID: ");
                        int ID = scanner.nextInt();
                        employee.setID(ID);
                        if (employee instanceof Manager) {
                            System.out.println("Please enter the bonus: ");
                            ((Manager) employee).setBonus(scanner.nextDouble());
                        } else if (employee instanceof Salesman) {
                            System.out.println("Please enter the commission: ");
                            ((Salesman) employee).setCommission(scanner.nextDouble());
                        }
                        employees.add(employee);
                        scanner.nextLine();
                    }

                    System.out.println("The employees added successfully");
                    System.out.println("Total employees created so far: " + Employee.getEmployeeCount());
                    again = askToContinue(scanner);
                }

                case 2 -> {
                    if (!employees.isEmpty()) {
                        for (Employee emp : employees) {
                            emp.displayInfo();
                            System.out.println("Salary: " + emp.calculateSalary());
                            System.out.println("-------------------------");
                        }
                        System.out.println("Total employees created so far: " + Employee.getEmployeeCount());
                        again = askToContinue(scanner);
                    } else {
                        System.out.println("There is no employee to show!");
                        again = askToContinue(scanner);
                    }
                }

                case 3 -> {
                    totalPayroll = managerPayroll = salesPayroll = internPayroll = 0;
                    System.out.println("[1]For all employees\n[2]For each employee");
                    choice = getValidChoice(scanner, 1, 2);
                    switch (choice) {
                        case 1 -> {
                            for (Employee emp : employees) {
                                totalPayroll += emp.calculateSalary();
                            }
                            System.out.println("Employees total payroll: " + totalPayroll);
                            again = askToContinue(scanner);
                        }
                        case 2 -> {
                            for (Employee emp : employees) {
                                if (emp instanceof Manager) managerPayroll += emp.calculateSalary();
                                else if (emp instanceof Salesman) salesPayroll += emp.calculateSalary();
                                else if (emp instanceof Intern) internPayroll += emp.calculateSalary();
                            }
                            System.out.println("Manager total payroll: " + managerPayroll);
                            System.out.println("Salesman total payroll: " + salesPayroll);
                            System.out.println("Intern total payroll: " + internPayroll);
                            again = askToContinue(scanner);
                        }
                        default -> {
                            System.out.println("Invalid choice!");
                            throw new AssertionError();
                        }
                    }
                }

                default -> {
                    System.out.println("Invalid choice!");
                    throw new AssertionError("It's an invalid choice");
                }
            }
        } while (again == 'y' || again == 'Y');

        if (again != 'y') System.out.println("Thanks for using our system");
        scanner.close();
    }

    static char askToContinue(Scanner scanner) {
        System.out.println("Do you want to perform another operation? [Y/N]");
        return scanner.next().charAt(0);
    }
/*
 * [22] function used to clear the terminal each time its called
 */
    static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
/* 
 * [23] function to handle errors caused by menu choices
 */
    static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        boolean valid = false;

        while (!valid) {
            try {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    System.out.print("Invalid choice! Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input! Please enter a number: ");
                scanner.nextLine(); // clear invalid input
            }
        }
        return choice;
    }
}
