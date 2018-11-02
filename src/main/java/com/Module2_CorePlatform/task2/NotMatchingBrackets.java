package main.java.com.Module2_CorePlatform.task2;
/**
 *  NotMatchingBrackets class for Task #2.
 *
 *  This class defines NotMatchingBrackets Exception which is used in BracketsCombination class.
 *
 *  @version 1.0 10/31/2018
 *  @author Polina Bochkareva
 */
public class NotMatchingBrackets extends Exception {

    public NotMatchingBrackets() {
        System.out.println("The string contains not matching pairs of brackets");
    }
}
