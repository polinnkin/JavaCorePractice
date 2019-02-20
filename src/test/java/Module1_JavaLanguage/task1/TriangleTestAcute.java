package Module1_JavaLanguage.task1;

import com.Module1_JavaLanguage.task1.Triangle;
import com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Test class for Triangle class (Task #1).
 * <p>
 * This program tests valid length of 3 sides for Acute Triangle.
 *
 * @author Polina Bochkareva
 * @version 1.0 01/08/2019
 */
public class TriangleTestAcute {
    private TriangleType result;

    /**
     * This method checks is triangle is Acute depending on lengths of 3 sides
     *
     * @param a This is the first parameter to testAcutePass method
     * @param b This is the second parameter to testAcutePass method
     * @param c This is the third parameter to testAcutePass method
     */
    @Test(dataProvider = "testAcuteDataProvider")
    public void testAcutePass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.ACUTE);
    }

    /**
     * This method provides data for testAcutePass method
     *
     * @return Object[][] This returns Object[][] of valid lengths for Acute triangle
     */
    @DataProvider(name = "testAcuteDataProvider")
    public Object[][] testAcuteDataProvider() {
        return new Object[][]{
                {4, 6, 7},
        };
    }
}