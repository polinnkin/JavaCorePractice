package main.java.com.Module1_JavaLanguage.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Triangle class for Task #1.
 * <p>
 * This program ask an user to enter 3 side lengths for triangle
 * and returns a type of triangle using Enum class TriangleType.
 *
 * @author Polina Bochkareva
 * @version 1.1 10/12/2018
 */

public class Triangle {
    /**
     * This is the main method which makes use of classify method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            // Ask a user for 3 dimensions of triangle
            System.out.println("Enter side1 length: ");
            int a = sc.nextInt();
            System.out.println("Enter side2 length: ");
            int b = sc.nextInt();
            System.out.println("Enter side3 length: ");
            int c = sc.nextInt();

            // Print the triangle type
            TriangleType result = classify(a, b, c);
            System.out.println("Triangle is " + result);
        } catch (InputMismatchException exception) {
            System.out.println("Error - a side length should be an integer.");
        }
    }

    /**
     * This method is used to return a type of triangle depending on lengths of 3 sides
     *
     * @param a This is the first parameter to classify method
     * @param b This is the second parameter to classify method
     * @param c This is the third parameter to classify method
     * @return TriangleType This returns TriangleType enum type
     */
    public static TriangleType classify(int a, int b, int c) {
        double diff = a * a + b * b - c * c;
        if ( (a <= 0 || b <= 0 || c <= 0)  ) {
            return TriangleType.INVALID;
        }
        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        }
        if (a >= b + c || c >= b + a || b >= a + c) {
            return TriangleType.INVALID;
        }
        if (diff == 0) {
            return TriangleType.RIGHT;
        }
        if (diff > 0) {
            return TriangleType.ACUTE;
        }
        return TriangleType.OBTUSE;
    }

}