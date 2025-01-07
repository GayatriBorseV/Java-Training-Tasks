public class mathOperators{

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        int subResult = subtract(a, b);
        int mulResult = multiply(a, b);
        int addResult = add(a, b);
        int divisionResult = division(a,b);

        System.out.println("Subtraction: " + subResult);
        System.out.println("Multiplication: " + mulResult);
        System.out.println("Addition: " + addResult);
        System.err.println("Division: " + divisionResult);
    }

    public static int subtract(int x, int y) {
        return y - x;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int add(int x, int y) {
        return x + y;
    }
    public static int division(int x, int y) {
        return x/y;
    }
}