package test.java.Module1_JavaLanguage.task1;

import main.java.com.Module1_JavaLanguage.task1.Triangle;
import main.java.com.Module1_JavaLanguage.task1.TriangleType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleTestRight {
    private Triangle triangle;
    private TriangleType result;
    public static final int MIN_ODD_A = 3;
    public static final int MIN_EVEN_A = 4;


    @BeforeMethod
    public void setUp() {
        triangle = new Triangle();
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(dataProvider = "testRightDataProvider")
    public void testRightPass(int a, int b, int c) {
        result = Triangle.classify(a, b, c);
        assertEquals(result, TriangleType.RIGHT);
    }

    @DataProvider(name = "testRightDataProvider")
    public Object[][] testRightDataProvider() {
        return new Object[][]{
                // Case 1 – a is an odd number, a - min value = 3
                {MIN_ODD_A, calcMinOddB(MIN_ODD_A), calcMinOddC(MIN_ODD_A)},
                // Case 2 – a is an even number, a - min value = 4
                {MIN_EVEN_A, calcMinEvenB(MIN_EVEN_A), calcMinEvenC(MIN_EVEN_A)},
/*                // Case 3 – a is an even number, с - max value = Integer.MAX_VALUE
                {(int)(Math.sqrt(2 * Integer.MAX_VALUE - 1)),  , Integer.MAX_VALUE},*/
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
        return (int)(Math.pow(a, 2) / 4 + 1);
    }
}