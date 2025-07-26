package CodeAlpha_StudentGradeTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
	 public static double convertGrade(String letter) {
	        switch (letter.toUpperCase()) {
	            case "A+": return 97;
	            case "A": return 93;
	            case "A-": return 90;
	            case "B+": return 87;
	            case "B": return 83;
	            case "B-": return 80;
	            case "C+": return 77;
	            case "C": return 73;
	            case "C-": return 70;
	            case "D": return 65;
	            case "F": return 50;
	            default: return -1; // Invalid grade
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Student> students = new ArrayList<>();

	        System.out.println("=== Student Grade Tracker ===");
	        System.out.print("Enter number of students: ");
	        int numStudents = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        for (int i = 0; i < numStudents; i++) {
	            System.out.print("Enter name for Student " + (i + 1) + ": ");
	            String name = scanner.nextLine();

	            String letterGrade;
	            double numericGrade;

	            while (true) {
	                System.out.print("Enter letter grade for " + name + " (e.g., A, B+, C-): ");
	                letterGrade = scanner.nextLine();
	                numericGrade = convertGrade(letterGrade);
	                if (numericGrade != -1) break;
	                System.out.println("Invalid grade. Try again.");
	            }

	            students.add(new Student(name, letterGrade, numericGrade));
	        }

	        double total = 0;
	        double highest = -1;
	        double lowest = 101;
	        String topStudent = "", lowStudent = "";

	        System.out.println("\n--- Student Report ---");
	        for (Student s : students) {
	            System.out.println(s.name + ": " + s.letterGrade + " (" + s.numericGrade + ")");
	            total += s.numericGrade;

	            if (s.numericGrade > highest) {
	                highest = s.numericGrade;
	                topStudent = s.name;
	            }

	            if (s.numericGrade < lowest) {
	                lowest = s.numericGrade;
	                lowStudent = s.name;
	            }
	        }

	        double average = total / numStudents;

	        System.out.println("\n--- Summary ---");
	        System.out.printf("Average Grade: %.2f%n", average);
	        System.out.println("Highest Grade: " + highest + " (by " + topStudent + ")");
	        System.out.println("Lowest Grade: " + lowest + " (by " + lowStudent + ")");
	    }

}
