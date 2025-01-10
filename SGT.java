import java.util.ArrayList;
import java.util.Scanner;

public class SGT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        boolean running = true;

        System.out.println("Welcome to the Student Grade Tracker!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a grade");
            System.out.println("2. Display grades");
            System.out.println("3. Calculate average");
            System.out.println("4. Find highest grade");
            System.out.println("5. Find lowest grade");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the grade to add (0-100): ");
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully.");
                    } else {
                        System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                    }
                    break;

                case 2:
                    System.out.println("Grades: " + grades);
                    break;

                case 3:
                    if (!grades.isEmpty()) {
                        double average = calculateAverage(grades);
                        System.out.println("Average grade: " + average);
                    } else {
                        System.out.println("No grades available to calculate average.");
                    }
                    break;

                case 4:
                    if (!grades.isEmpty()) {
                        int highest = findHighestGrade(grades);
                        System.out.println("Highest grade: " + highest);
                    } else {
                        System.out.println("No grades available to find the highest grade.");
                    }
                    break;

                case 5:
                    if (!grades.isEmpty()) {
                        int lowest = findLowestGrade(grades);
                        System.out.println("Lowest grade: " + lowest);
                    } else {
                        System.out.println("No grades available to find the lowest grade.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public static int findHighestGrade(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static int findLowestGrade(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
