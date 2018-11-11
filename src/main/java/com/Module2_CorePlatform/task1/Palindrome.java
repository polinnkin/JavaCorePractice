package main.java.com.Module2_CorePlatform.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Palindrome class for Task #1.
 *
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
     * @return Nothing.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        try {
            //* Ask a user to enter a string */
            System.out.println("Enter a string to check palindrome: ");
            String s = sc.next();
            s = removeAllPunctuationAndSpace(s);
            System.out.println(s);
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
        boolean isPalindrome = false;
        /** reverse the given String */
        String reverse = new StringBuffer(s).reverse().toString();
        /** check whether the string is palindrome or not */
        if (s.equalsIgnoreCase(reverse)) {
            isPalindrome = true;
        }
        return isPalindrome;
    }

    /**
     * This method is used to remove all punctuation and spaces from a string
     *
     * @param s This is the first parameter to removeAllPunctuationAndSpace method
     * @return String This returns String without any punctuation or space
     */
    private static String removeAllPunctuationAndSpace(String s) {
        s = s.replaceAll("\\p{Punct}", "");
        s = s.replaceAll("\\s+", "");
        return s;
    }
}
