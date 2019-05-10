public class Power {
    public static void main(String args[]) {
        System.out.println(power(2, 3));
    }

    private static double power(double base, int exponent) {
        boolean invalidInput = false;
        if (base == 0 && exponent < 0) {
            invalidInput = true;
            return 0;
        }

        double result = 0;
        if (exponent < 0) {
            exponent = Math.abs(exponent);
            result = 1 / powerWithExponent(base, exponent);
        } else {
            result = powerWithExponent(base, exponent);
        }
        return result;
    }

    private static double powerWithExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}
