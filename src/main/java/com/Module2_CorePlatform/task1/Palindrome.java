package main.java.com.Module2_CorePlatform.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Palidrome {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            /** Ask a user to enter a string */
            System.out.println("Enter a string to check palindrome: ");
            String s = sc.next();
            if(checkPalindrome(s)){
                System.out.println("The string is palindrome" );
            }
            else {
                System.out.println("The string isn't palindrome" );
            }
        }
        catch (InputMismatchException exception){
            System.out.println("Error - wrong input.");
        }
    }

    private static boolean checkPalindrome(String s)
    {
        boolean isPalindrome = false;

        /** reverse the given String */
        String reverse = new StringBuffer(s).reverse().toString();

        /** check whether the string is palindrome or not */
        if (s.equals(reverse)) {
            isPalindrome = true;
        }
        return isPalindrome;
    }
}
