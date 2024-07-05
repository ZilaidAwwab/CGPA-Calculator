import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    /*
    Formulas:
    total points / total credits
    points for a class = grade value * credits

    Grades:
    A = 4, B = 3, C = 2
    */

    Scanner scanner = new Scanner(System.in);

    Integer totalPoints = 0;
    Integer totalCredits = 0;

    boolean moreClasses = false;
    do {

      Integer credits = 0;
      boolean validCredits = true;
  
      do {
        validCredits = true;
        System.out.println("Enter number of credits:");
        String creditsString = scanner.nextLine();
    
        try {
          credits = Integer.parseInt(creditsString);
        } catch (Exception e) {
          System.out.println("Enter a valid integer.");
          validCredits = false;
        }
      } while (validCredits == false);
      
      boolean validGrade = true;
      
      Integer gradeValue = 0;
      String grade = "";
      
      do {
        
        System.out.println("Enter grade:");
        grade = scanner.nextLine();
  
        if (grade.equalsIgnoreCase("A")) {
          gradeValue = 4;
        } else if (grade.equalsIgnoreCase("B")) {
          gradeValue = 3;
        } else if (grade.equalsIgnoreCase("C")) {
          gradeValue = 2;
        } else if (grade.equalsIgnoreCase("D")) {
          gradeValue = 1;
        } else if (grade.equalsIgnoreCase("F")) {
          gradeValue = 0;
        } else {
          System.out.println("Enter a valid grade from A to D or F.");
          validGrade = false;
        }
      } while (!validGrade);
      
      Integer points = gradeValue * credits;
      totalPoints += points;
      totalCredits += credits;

      System.out.println("Would you like to enter an other class? (Y/N)");
      String moreClassesString = scanner.nextLine();

      moreClasses = moreClassesString.equalsIgnoreCase("Y");
    } while (moreClasses);
    
    DecimalFormat df = new DecimalFormat("0.00");

    Double gpa = 1.0 * totalPoints / totalCredits;

    System.out.println("Credits: " + totalCredits);
    System.out.println("Points: " + totalPoints);
    System.out.println("GPA: " + df.format(gpa));

    scanner.close();
  }
}
