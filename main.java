import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int numOfStudents;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, I'm schooly the new student grade system.\nLet's start to do what you want!");
        System.out.print("Please enter the number of students: ");
        numOfStudents = scanner.nextInt();
        scanner.nextLine(); 

        do{ 
            Student[] students = new Student[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            students[i] = new Student(); 
            System.out.println("----------------------");
            System.out.print("Enter student " + (i+1) +" name: ");
            String name = scanner.nextLine();
            students[i].setStudentName(name);

            System.out.print("Enter student " + (i+1) +" ID: ");
            int ID = scanner.nextInt();
            students[i].setStudentID(ID);

            float[] grades = new float[3];
            for (int j = 0; j < grades.length; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + ": ");
                grades[j] = scanner.nextFloat();
            }
            students[i].setGrades(grades);
            scanner.nextLine(); 
        }

        scanner.close();

        
        for (Student s : students) {
            s.calculateAVG();
            s.studentInfo();
        }
    } while(numOfStudents > 1);
}}
