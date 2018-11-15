package main.java.com.Module2_CorePlatform.task2;

/**
 * NotMatchingBrackets class for Task #2.
 * <p>
 * This class defines NotMatchingBrackets Exception which is used in BracketsCombination class.
 *
 * @author Polina Bochkareva
 * @version 1.0 10/31/2018
 */
class NotMatchingBrackets extends Exception {

    NotMatchingBrackets() {
        System.out.println("The string contains not matching pairs of brackets");
    }
}
