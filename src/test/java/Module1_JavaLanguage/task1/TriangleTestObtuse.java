package Module1_JavaLanguage.task1;

import com.Module1_JavaLanguage.task1.Triangle;
import com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test class for Triangle class (Task #1).
 * <p>
 * This program tests valid length of 3 sides for Obtuse Triangle.
 *
 * @author Polina Bochkareva
 * @version 1.0 01/08/2019
 */
public class TriangleTestObtuse {
    private TriangleType result;

    /**
     * This method checks is triangle is Obtuse depending on lengths of 3 sides
     *
     * @param a This is the first parameter to testObtusePass method
     * @param b This is the second parameter to testObtusePass method
     * @param c This is the third parameter to testObtusePass method
     */
    @Test(dataProvider = "testObtuseDataProvider")
    public void testObtusePass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.OBTUSE);
    }

    /**
     * This method provides data for testObtusePass method
     *
     * @return Object[][] This returns Object[][] of valid lengths for OBTUSE triangle
     */
    @DataProvider(name = "testObtuseDataProvider")
    public Object[][] testObtuseDataProvider() {
        return new Object[][]{
                {3, 5, 7},
        };
    }
}
