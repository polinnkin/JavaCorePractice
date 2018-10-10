import java.util.Scanner;

//     Task #1
//     This program uses the Triangle class to create a triangle object.
//     It uses enum class TriangleType to test what type of triangle it is.

public class Triangle {

    // Types of triangle
    enum TriangleType {
        EQUILATERAL, INVALID, ACUTE, RIGHT, OBTUSE
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user for 3 dimensions of triangle.
        System.out.println ("Enter side1 length: ");
        int a = sc.nextInt();

        System.out.println ("Enter side2 length: ");
        int b = sc.nextInt();

        System.out.println ("Enter side3 length: ");
        int c = sc.nextInt();
        TriangleType result =  classify(a, b, c);

        System.out.print("Triangle is ");

        switch (result)
        {
            case EQUILATERAL:
                System.out.println("EQUILATERAL.");
                break;
            case INVALID:
                System.out.println("INVALID.");
                break;
            case ACUTE:
                System.out.println("ACUTE.");
                break;
            case RIGHT:
                System.out.println("RIGHT.");
                break;
            default:
                System.out.println("OBTUSE.");
                break;
        }
    }

    // This method returns a type of triangle
    static TriangleType classify(int a, int b, int c) {
        int diff = a*a + b*b - c*c;
        if (a <= 0 || b <= 0 || c <= 0) return TriangleType.INVALID;
        if (a == b && b == c) return TriangleType.EQUILATERAL;
        if (a >= b+c || c >= b+a || b >= a+c) return TriangleType.INVALID;
        if (diff == 0) return TriangleType.RIGHT;
        if (diff > 0) return TriangleType.ACUTE;
        return TriangleType.OBTUSE;
    }
}
