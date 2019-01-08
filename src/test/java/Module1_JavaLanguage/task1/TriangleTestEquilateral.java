package test.java.Module1_JavaLanguage.task1;

import main.java.com.Module1_JavaLanguage.task1.Triangle;
import main.java.com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test class for Triangle class (Task #1).
 * <p>
 * This program tests valid lengths of 3 sides for Equilateral Triangle.
 *
 * @author Polina Bochkareva
 * @version 1.0 01/04/2019
 */
public class TriangleTestEquilateral {
    private TriangleType result;

    /**
     * This method checks is triangle is EQUILATERAL depending on lengths of 3 sides
     *
     * @param a This is the first parameter to testEquilateralPass method
     * @param b This is the second parameter to testEquilateralPass method
     * @param c This is the third parameter to testEquilateralPass method
     */
    @Test(dataProvider = "testEquilateralDataProvider")
    public void testEquilateralPass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.EQUILATERAL);
    }

    /**
     * This method provides data for testEquilateralPass method
     *
     * @return Object[][] This returns Object[][] with min and max lengths for valid EQUILATERAL triangle
     */
    @DataProvider(name = "testEquilateralDataProvider")
    public Object[][] testEquilateralDataProvider() {
        return new Object[][]{
                {1, 1, 1}, // min values
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}, // max values
        };
    }
}