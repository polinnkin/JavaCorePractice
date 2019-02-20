package Module1_JavaLanguage.task1;

import com.Module1_JavaLanguage.task1.Triangle;
import com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test class for Triangle class (Task #1).
 * <p>
 * This program tests invalid length of 3 sides for Triangle class.
 *
 * @author Polina Bochkareva
 * @version 1.0 01/08/2019
 */
public class TriangleTestInvalid {

    private TriangleType result;

    /**
     * This method checks is triangle is invalid depending on lengths of 3 sides
     *
     * @param a This is the first parameter to testInvalidPass method
     * @param b This is the second parameter to testInvalidPass method
     * @param c This is the third parameter to testInvalidPass method
     */
    @Test(dataProvider = "testInvalidDataProvider")
    public void testInvalidPass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.INVALID);
    }

    /**
     * This method provides data for testInvalidPass method
     *
     * @return Object[][] This returns Object[][] of invalid lengths for RIGHT, ACUTE, OBTUSE OR Equilateral triangle
     */
    @DataProvider(name = "testInvalidDataProvider")
    public Object[][] testInvalidDataProvider() {
        return new Object[][]{
                {0, 0, 0},
                {-1, -1, -1},
                {10, 100, 1}
        };
    }

}