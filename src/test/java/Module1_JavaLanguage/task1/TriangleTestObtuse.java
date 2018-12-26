package test.java.Module1_JavaLanguage.task1;

import main.java.com.Module1_JavaLanguage.task1.Triangle;
import main.java.com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleTestObtuse {
    private Triangle triangle;
    private TriangleType result;

    @BeforeMethod
    public void setUp() {
        triangle = new Triangle();
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(dataProvider = "testObtuseDataProvider")
    public void testObtusePass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.OBTUSE);
    }

    @DataProvider(name = "testObtuseDataProvider")
    public Object[][] testObtuseDataProvider() {
        return new Object[][]{
                {3, 5, 7},
        };
    }
}
