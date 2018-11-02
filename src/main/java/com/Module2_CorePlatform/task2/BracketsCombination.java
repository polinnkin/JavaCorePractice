package main.java.com.Module2_CorePlatform.task2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  BracketsCombination class for Task #2.
 *
 *  This program asks an user to enter a string
 *  and checks if the string contains only full pairs of brackets (), [], {}, <>,
 *  if there are not full pairs of the brackets, it throws NotMatchingBrackets Exception
 *
 *  @version 1.0 10/31/2018
 *  @author Polina Bochkareva
 */

public class BracketsCombination {
    /**
     * This is the main method which makes use of CheckBrackets method.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) throws NotMatchingBrackets {
        Scanner sc = new Scanner(System.in);
        try {
            //** Ask a user to enter a string *//*
            System.out.println("Enter a string:");
            String str = sc.next();
            if(CheckBrackets(str)){
                System.out.println("The string contains matching pairs of brackets");
            }
            else{
                throw new NotMatchingBrackets();
            }
        }
        catch (InputMismatchException exception){
            System.out.println("Invalid input.");
        }
    }
    /**
     * This method is used to return true if a string contains matching pairs of brackets
     * @param str This is the first parameter to CheckBrackets method
     * @return boolean This returns true if a string contains matching pairs of brackets or false if not
     */
    private static boolean CheckBrackets(String str)
    {
        if (str.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '[' || current == '<' ) {
                stack.push(current);
            }
            if (current == '}' || current == ')' || current == ']' || current == '>') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[' ||
                        current == '>' && last == '<') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
