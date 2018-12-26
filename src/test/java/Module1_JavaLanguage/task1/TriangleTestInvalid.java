package test.java.Module1_JavaLanguage.task1;

import main.java.com.Module1_JavaLanguage.task1.Triangle;
import main.java.com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleTestInvalid {
    private Triangle triangle;
    private TriangleType result;
    public static final int MIN_ODD_A_FOR_RIGHT = 3;
    public static final int MIN_EVEN_A_FOR_RIGHT = 4;


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

    @Test(dataProvider = "testAcuteDataProvider")
    public void testAcutePass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.ACUTE);
    }

    @Test(dataProvider = "testObtuseDataProvider")
    public void testObtusePass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.OBTUSE);
    }

    @Test(dataProvider = "testInvalidDataProvider")
    public void testInvalidPass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.INVALID);
    }

    @DataProvider(name = "testEquilateralDataProvider")
    public Object[][] testEquilateralDataProvider() {
        return new Object[][]{
                {1, 1, 1}, // min values
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}, // max values
        };
    }

    @DataProvider(name = "testRightDataProvider")
    public Object[][] testRightDataProvider() {
        return new Object[][]{
                // Case 1 – a is an odd number, a - min value = 3
                {MIN_ODD_A_FOR_RIGHT, calcMinOddB(MIN_ODD_A_FOR_RIGHT), calcMinOddC(MIN_ODD_A_FOR_RIGHT)},
                // Case 2 – a is an even number, a - min value = 4
                {MIN_EVEN_A_FOR_RIGHT, calcMinEvenB(MIN_EVEN_A_FOR_RIGHT),
                        (int)(Math.pow(MIN_EVEN_A_FOR_RIGHT, 2) / 4 + 1)},
/*                // Case 3 – ф is an even number, с - max value = Integer.MAX_VALUE
                {(int)(Math.sqrt(2 * Integer.MAX_VALUE - 1)),  , Integer.MAX_VALUE},*/
        };
    }

    @DataProvider(name = "testAcuteDataProvider")
    public Object[][] testAcuteDataProvider() {
        return new Object[][]{
                {3, 5, 7},
        };
    }

    @DataProvider(name = "testObtuseDataProvider")
    public Object[][] testObtuseDataProvider() {
        return new Object[][]{
                {3, 5, 7},
        };
    }

    @DataProvider(name = "testInvalidDataProvider")
    public Object[][] testInvalidDataProvider() {
        return new Object[][]{
                {0, 0, 0},
        };
    }

    private int calculateMaxLengthC(){
        return 0;
    }

    public int calcMinOddB(int a){
        return (int)((Math.pow(a, 2) - 1)/2);
    }

    public int calcMinOddC(int a){
        return (int)((Math.pow(a, 2) + 1)/2);
    }

    public int calcMinEvenB(int a){
        return (int)(Math.pow(a, 2) / 4 - 1);
    }

    public int calcMinEvenC(int a){
        return (int)((Math.pow(a, 2) + 1)/2);
    }
}