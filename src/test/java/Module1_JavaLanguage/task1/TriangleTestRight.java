package test.java.Module1_JavaLanguage.task1;

import main.java.com.Module1_JavaLanguage.task1.Triangle;
import main.java.com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test class for Triangle class (Task #1).
 * <p>
 * This program tests valid length of 3 sides for Right Triangle.
 *
 * @author Polina Bochkareva
 * @version 1.0 01/08/2019
 */
public class TriangleTestRight {
    public static final int MIN_ODD_A = 3;
    public static final int MIN_EVEN_A = 4;
    private TriangleType result;

    /**
     * This method checks is triangle is RIGHT depending on lengths of 3 sides
     *
     * @param a This is the first parameter to testRightPass method
     * @param b This is the second parameter to testRightPass method
     * @param c This is the third parameter to testRightPass method
     */
    @Test(dataProvider = "testRightDataProvider")
    public void testRightPass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.RIGHT);
    }

    /**
     * This method provides data for testRightPass method
     *
     * @return Object[][] This returns Object[][] of valid lengths for RIGHT triangle
     */
    @DataProvider(name = "testRightDataProvider")
    public Object[][] testRightDataProvider() {
        return new Object[][]{
                // Case 1 – a is an odd number, min value of a = 3
                {MIN_ODD_A, calcOddB(MIN_ODD_A), calcOddC(MIN_ODD_A)},
                // Case 2 – a is an even number, min value of a = 4
                {MIN_EVEN_A, calcEvenB(MIN_EVEN_A), calcEvenC(MIN_EVEN_A)},
                // Case 3 – a is an odd number,  value of a = 3 * 10
                {MIN_ODD_A * 10, calcOddB(MIN_ODD_A) * 10, calcOddC(MIN_ODD_A) * 10},
                // Case 4 – a is an even number, value of a = 4 * 10
                {MIN_EVEN_A * 10, calcEvenB(MIN_EVEN_A) * 10, calcEvenC(MIN_EVEN_A) * 10},
        };
    }

    /**
     * This method calculates the length of b - triangle side when a is odd number
     *
     * @return int This returns the valid length of b for RIGHT triangle when a is odd number
     */
    public int calcOddB(int a) {
        return (int) ((Math.pow(a, 2) - 1) / 2);
    }

    /**
     * This method calculates the length of C (triangle side) when A (triangle side) is odd number
     *
     * @return int This returns the valid length of C for RIGHT triangle when A is odd number
     */
    public int calcOddC(int a) {
        return (int) ((Math.pow(a, 2) + 1) / 2);
    }

    /**
     * This method calculates the length of B - triangle side when A is even number
     *
     * @return int This returns the valid length of B for RIGHT triangle when A is even number
     */
    public int calcEvenB(int a) {
        return (int) (Math.pow(a, 2) / 4 - 1);
    }

    /**
     * This method calculates the length of C (triangle side) when A (triangle side) is even number
     *
     * @return int This returns the valid length of C for RIGHT triangle when A is even number
     */
    public int calcEvenC(int a) {
        return (int) (Math.pow(a, 2) / 4 + 1);
    }
}