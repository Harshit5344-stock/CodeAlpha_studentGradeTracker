import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> grades = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Add student
    public static void addStudent() {

        System.out.print("Enter student name: ");
        String name = sc.next();

        System.out.print("Enter grade (0-100): ");
        int grade = sc.nextInt();

        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade! Enter between 0 and 100.");
            return;
        }

        names.add(name);
        grades.add(grade);

        System.out.println("Student added successfully!");
    }

    // Display all students
    public static void displayStudents() {

        if (names.size() == 0) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n========== STUDENT LIST ==========");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(
                    (i + 1) + ". " +
                    names.get(i) +
                    " - Grade: " +
                    grades.get(i)
            );
        }
    }

    // Calculate average
    public static void calculateAverage() {

        if (grades.size() == 0) {
            System.out.println("No grades available.");
            return;
        }

        int total = 0;

        for (int grade : grades) {
            total = total + grade;
        }

        double average = (double) total / grades.size();

        System.out.println("Average Score: " + average);
    }

    // Find highest and lowest
    public static void findHighestLowest() {

        if (grades.size() == 0) {
            System.out.println("No grades available.");
            return;
        }

        int highest = grades.get(0);
        int lowest = grades.get(0);

        String highestStudent = names.get(0);
        String lowestStudent = names.get(0);

        for (int i = 1; i < grades.size(); i++) {

            if (grades.get(i) > highest) {
                highest = grades.get(i);
                highestStudent = names.get(i);
            }

            if (grades.get(i) < lowest) {
                lowest = grades.get(i);
                lowestStudent = names.get(i);
            }
        }

        System.out.println("Highest Score: " + highest +
                           " (" + highestStudent + ")");

        System.out.println("Lowest Score: " + lowest +
                           " (" + lowestStudent + ")");
    }

    // Complete report
    public static void summaryReport() {

        if (grades.size() == 0) {
            System.out.println("No student data available.");
            return;
        }

        int total = 0;
        int highest = grades.get(0);
        int lowest = grades.get(0);

        for (int grade : grades) {

            total = total + grade;

            if (grade > highest) {
                highest = grade;
            }

            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = (double) total / grades.size();

        System.out.println("\n=================================");
        System.out.println("       STUDENT SUMMARY REPORT");
        System.out.println("=================================");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(
                    "Student: " + names.get(i) +
                    " | Grade: " + grades.get(i)
            );
        }

        System.out.println("---------------------------------");
        System.out.println("Total Students : " + names.size());
        System.out.println("Average Score  : " + average);
        System.out.println("Highest Score  : " + highest);
        System.out.println("Lowest Score   : " + lowest);
        System.out.println("=================================");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========== STUDENT GRADE TRACKER ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Calculate Average");
            System.out.println("4. Find Highest & Lowest");
            System.out.println("5. Summary Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    calculateAverage();
                    break;

                case 4:
                    findHighestLowest();
                    break;

                case 5:
                    summaryReport();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
