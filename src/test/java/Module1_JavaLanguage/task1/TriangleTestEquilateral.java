package test.java.Module1_JavaLanguage.task1;

import main.java.com.Module1_JavaLanguage.task1.Triangle;
import main.java.com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class TriangleTestEquilateral {
    private Triangle triangle;
    private TriangleType result;


    @BeforeMethod
    public void setUp() {
        triangle = new Triangle();
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(dataProvider = "testEquilateralDataProvider")
    public void testEquilateralPass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.EQUILATERAL);
    }

    @DataProvider(name = "testEquilateralDataProvider")
    public Object[][] testEquilateralDataProvider() {
        return new Object[][]{
                {1, 1, 1}, // min values
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}, // max values
        };
    }
}