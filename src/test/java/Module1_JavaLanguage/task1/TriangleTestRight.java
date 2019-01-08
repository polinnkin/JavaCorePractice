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
 * @version 1.0 01/04/2019
 */
public class TriangleTestRight {
    private TriangleType result;
    public static final int MIN_ODD_A = 3;
    public static final int MIN_EVEN_A = 4;

    @Test(dataProvider = "testRightDataProvider")
    public void testRightPass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.RIGHT);
    }

    @DataProvider(name = "testRightDataProvider")
    public Object[][] testRightDataProvider() {
        return new Object[][]{
                // Case 1 – a is an odd number, min value of a = 3
                {MIN_ODD_A, calcOddB(MIN_ODD_A), calcOddC(MIN_ODD_A)},
                // Case 2 – a is an even number, min value of a = 4
                {MIN_EVEN_A, calcEvenB(MIN_EVEN_A), calcEvenC(MIN_EVEN_A)},
                // Case 3 – a is an even number, max value of c = Integer.MAX_VALUE
        };
    }

/*    private int[] calculateMaxLengthsOdd(int max_value){
        int a;
        int b = 4;
        int c = 5;
        for (a = MIN_ODD_A; c < max_value; a=+2 ){
            c = calcOddC(a);
            b = calcOddB(a);
        }
        return new int[]{a, b, c};
    }*/

    public int calcOddB(int a){
        return (int)((Math.pow(a, 2) - 1)/2);
    }

    public int calcOddC(int a){
        return (int)((Math.pow(a, 2) + 1)/2);
    }

    public int calcEvenB(int a){
        return (int)(Math.pow(a, 2) / 4 - 1);
    }

    public int calcEvenC(int a){
        return (int)(Math.pow(a, 2) / 4 + 1);
    }
}