package StudentGradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!");

        // Prompt user to enter number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = sc.nextInt();

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        System.out.println("\nYou will enter marks for " + numberOfSubjects + " subjects.");
        System.out.println("Please enter marks out of 100 for each subject.\n");

        // Get marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            marks[i] = getValidMarks(sc, i + 1);
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;
        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResult:");
        System.out.println("--------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }

    // Method to get valid marks from user
    private static int getValidMarks(Scanner sc, int subjectNumber) {
        int marks;
        while (true) {
            System.out.print("Enter marks for subject " + subjectNumber + ": ");
            if (sc.hasNextInt()) {
                marks = sc.nextInt();
                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input. Marks should be between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer value.");
                sc.next(); // Clear the invalid input
            }
        }
        return marks;
    }

    // Method to calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 91) {
            return 'A';
        } else if (averagePercentage >= 81) {
            return 'B';
        } else if (averagePercentage >= 71) {
            return 'C';
        } else {
            return 'D';
        }
    }
}

