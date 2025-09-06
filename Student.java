public class Student {
    private String studentName;
    private int studentID;
    private float[] grades; 
    
/*
 * [1] set student's name
 */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
 /*
 * [2] set student's ID
 */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
/*
 * [3] set student's grades
 */
     public void setGrades(float[] grades) {
        this.grades = grades;
    }
/*
 * [4] get student's ID
 */
    public int getStudentID() {
        return studentID;
    }
/*
 * [5] get student's name
 */
    public String getStudentName() {
        return studentName;
    }

/*
 * [5] calculate the average for the student's grades
 * initialize the sum grades equal to 0
 * generate a for loop to calculate the sum for the input grades
 * return the sumgrades divided by grades length as the average
 */
    float calculateAVG() {
      float sumGrades = 0;
        for(int i=0; i<grades.length;i++)
      {
        sumGrades+=grades[i];
      }
          return sumGrades / grades.length;
    }
/*
 * [6] check if the student is passed or not depends on the calculateAVG returned value
 */
  boolean isPassed(){
    return calculateAVG() >= 50;
  }
/*
 * [7] display student's information in a report
 */
  void studentInfo(){
    System.out.println("---Student Report---");
    System.out.println("Name: " + getStudentName());
    System.out.println("ID: " + getStudentID());
    System.out.println("Average: " + calculateAVG());
    System.out.println(isPassed() ? "Result: Passed" : "Result: Failed");
    System.out.println("----------------------");
  }
}