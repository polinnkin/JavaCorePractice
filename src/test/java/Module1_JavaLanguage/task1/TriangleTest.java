package test.java.Module1_JavaLanguage.task1;

import main.java.com.Module1_JavaLanguage.task1.Triangle;
import main.java.com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

public class TriangleTest {
    private Triangle triangle;
    TriangleType result;

    private Scanner sc;

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

    @Test(dataProvider = "testRightDataProvider")
    public void testRightPass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.RIGHT);
    }

    @Test
    public void testAcutePass() {
    }

    @Test
    public void testAcuteFail() {
    }

    @Test
    public void testInvalidPass() {
    }

    @DataProvider(name = "testEquilateralDataProvider")
    public Object[][] testEquilateralDataProvider() {
        return new Object[][]{
                {1, 1, 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
        };
    }

    @DataProvider(name = "testRightDataProvider")
    public Object[][] testRightDataProvider() {
        return new Object[][]{
                {3, (int)((Math.pow(3, 2) - 1)/2), (int)(Math.pow(3, 2) + 1)/2}
        };
    }
}