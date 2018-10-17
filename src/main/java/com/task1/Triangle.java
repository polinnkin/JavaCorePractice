package main.java.com.task1;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 *  Triangle class for Task #1.
 *
 *  This program ask an user to enter 3 side lengths for triangle
 *  and returns a type of triangle using Enum class TriangleType.
 *
 *  @version 1.1 10/12/2018
 *  @author Polina Bochkareva
 */

public class Triangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Ask a user for 3 dimensions of triangle
            System.out.println("Enter side1 length: ");
            int a = sc.nextInt();
            System.out.println("Enter side2 length: ");
            int b = sc.nextInt();
            System.out.println("Enter side3 length: ");
            int c = sc.nextInt();

            // Print the triangle type
            TriangleType result = classify(a, b, c);
            System.out.print("Triangle is " + result);
        }
        catch (InputMismatchException exception){
            System.out.println("Error - a side length should be an integer.");
        }
    }

    // This method returns a type of triangle
    private static TriangleType classify(int a, int b, int c) {
        double diff = a * a + b * b - c * c;
        if (a <= 0 || b <= 0 || c <= 0) {
            return TriangleType.INVALID;
        }
        if (a == b && b == c){
            return TriangleType.EQUILATERAL;
        }
        if (a >= b + c || c >= b + a || b >= a + c){
            return TriangleType.INVALID;
        }
        if (diff == 0){
            return TriangleType.RIGHT;
        }
        if (diff > 0){
            return TriangleType.ACUTE;
        }
        return TriangleType.OBTUSE;
    }
}