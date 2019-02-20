package com.Module2_CorePlatform.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Palindrome class for Task #1.
 * <p>
 * This program asks an user to enter a string
 * and checks if the string is Palindrome or not.
 *
 * @author Polina Bochkareva
 * @version 1.0 10/29/2018
 */

public class Palindrome {
    /**
     * This is the main method which makes use of checkPalindrome method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in).useDelimiter("\\n")) {
            // Ask a user to enter a string
            System.out.println("Enter a string to check palindrome: ");
            String s = sc.next();
            s = removeAllPunctuationAndSpace(s);
            if (checkPalindrome(s)) {
                System.out.println("The string is palindrome");
            } else {
                System.out.println("The string isn't palindrome");
            }
        } catch (InputMismatchException exception) {
            System.out.println("Invalid input.");
        }
    }

    /**
     * This method is used to return true if a string is palindrome or false if not, ignore case
     *
     * @param s This is the first parameter to checkPalindrome method
     * @return boolean This returns true if a string is palindrome or false if not
     */
    private static boolean checkPalindrome(String s) {
        // reverse the given String
        String reverse = new StringBuffer(s).reverse().toString();
        // check whether the string is palindrome or not
        return s.equalsIgnoreCase(reverse);
    }

    /**
     * This method is used to remove all punctuation and spaces from a string
     *
     * @param s This is the first parameter to removeAllPunctuationAndSpace method
     * @return String This returns String without any punctuation or space
     */
    private static String removeAllPunctuationAndSpace(String s) {
        s = s.replaceAll("[^A-Za-z]+", "");
        return s;
    }
}
