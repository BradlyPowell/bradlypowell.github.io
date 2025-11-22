// StudentGpaCalculator.java
// Compile: javac StudentGpaCalculator.java
// Run:     java StudentGpaCalculator
// Calculates both Unweighted and Weighted GPA (Regular, Honors +0.5, AP +1.0).

import java.util.*;

public class StudentGpaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Student GPA Calculator ===");
        System.out.print("How many classes? ");
        int n = readInt(sc);

        double totalUnweighted = 0.0;
        double totalWeighted = 0.0;
        double totalCredits = 0.0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nClass " + i + ":");
            System.out.print("  Enter letter grade (A, B, C, D, F): ");
            String letter = readLetter(sc);

            System.out.print("  Level (R=Regular, H=Honors, P=AP): ");
            char level = readLevel(sc);

            System.out.print("  Credits (e.g., 1.0): ");
            double credits = readDouble(sc);
            totalCredits += credits;

            double base = letterToGpa(letter);
            double weighted = base + levelBump(level);
            // Cap weighted to 5.0 to be safe:
            if (weighted > 5.0) weighted = 5.0;

            totalUnweighted += base * credits;
            totalWeighted += weighted * credits;
        }

        double uwGpa = totalCredits > 0 ? totalUnweighted / totalCredits : 0.0;
        double wGpa  = totalCredits > 0 ? totalWeighted / totalCredits : 0.0;

        System.out.printf("\nUnweighted GPA: %.3f%n", uwGpa);
        System.out.printf("Weighted GPA:   %.3f%n", wGpa);
        System.out.println("\nScale: A=4.0, B=3.0, C=2.0, D=1.0, F=0.0; Honors +0.5, AP +1.0 (capped at 5.0).");
        sc.close();
    }

    private static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("  Please enter a whole number: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("  Please enter a number (e.g., 1.0): ");
            }
        }
    }

    private static String readLetter(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim().toUpperCase();
            if (s.matches("[ABCDF]")) return s;
            System.out.print("  Enter A, B, C, D, or F: ");
        }
    }

    private static char readLevel(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim().toUpperCase();
            if (s.length() == 1 && "RHP".indexOf(s.charAt(0)) >= 0) return s.charAt(0);
            System.out.print("  Enter R (Regular), H (Honors), or P (AP): ");
        }
    }

    private static double letterToGpa(String letter) {
        switch (letter) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            default:  return 0.0;
        }
    }

    private static double levelBump(char level) {
        switch (level) {
            case 'H': return 0.5;
            case 'P': return 1.0; // AP
            default:  return 0.0; // Regular
        }
    }
}
