package main.java.com.Module2_CorePlatform.task2;

import java.util.Scanner;
import java.util.Stack;

public class BraketsCombination {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            //** Ask a user to enter a string *//*
            System.out.println("Enter a string: ");
            String str = sc.next();
            if(CheckBrackets(str)){
                System.out.println("Matching pair of brackets");
            }
            else{
                throw new NotMatchingBrackets("Not matching pair of brackets");
            }
        }
        catch (Exception e){
        }
    }

    private static boolean CheckBrackets(String str)
    {
        if (str.isEmpty())
            return true;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++)
        {
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '[' || current == '<' )
            {
                stack.push(current);
            }

            if (current == '}' || current == ')' || current == ']' || current == '>')
            {
                if (stack.isEmpty())
                    return false;

                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[' ||
                        current == '>' && last == '<')
                    stack.pop();
                else
                    return false;
            }

        }

        return stack.isEmpty();
    }
}
