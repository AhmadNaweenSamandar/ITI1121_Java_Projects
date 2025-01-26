import java.util.Scanner;
import java.util.Arrays;

public class Q6 {
    public static void main(String[] args) {
        //scanner is initiated below to take input
        Scanner sc = new Scanner(System.in);
        double[] studGrades = new double[10];

        System.out.println("Please enter ten grades: ");
        for (int i = 0; i < 10; i++) {
            studGrades[i] = sc.nextDouble();
        }

        // Calculate and print results
        double average = calculateAverage(studGrades);
        double median = calculateMedian(studGrades);
        int numFailed = calculateNumberFailed(studGrades);
        int numPassed = calculateNumberPassed(studGrades);

        System.out.println("Average grade: " + average);
        System.out.println("Median grade: " + median);
        System.out.println("Number of students failed: " + numFailed);
        System.out.println("Number of students passed: " + numPassed);

        sc.close();
    }

    // Method to calculate the average of grades
    public static double calculateAverage(double[] notes) {
        double sum = 0;
        for (double grade : notes) {
            sum += grade;
        }
        return sum / notes.length;
    }

    // Method to calculate the median of grades
    public static double calculateMedian(double[] notes) {
        Arrays.sort(notes);
        int length = notes.length;
        if (length % 2 == 0) {
            return (notes[length / 2 - 1] + notes[length / 2]) / 2.0;
        } else {
            return notes[length / 2];
        }
    }

    // Method to calculate the number of students who failed (grade < 50)
    public static int calculateNumberFailed(double[] notes) {
        int count = 0;
        for (double grade : notes) {
            if (grade < 50) {
                count++;
            }
        }
        return count;
    }

    // Method to calculate the number of students who passed (grade >= 50)
    public static int calculateNumberPassed(double[] notes) {
        int count = 0;
        for (double grade : notes) {
            if (grade >= 50) {
                count++;
            }
        }
        return count;
    }
}
