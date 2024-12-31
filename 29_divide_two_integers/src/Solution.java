class Solution {

    public static void main(String[] args) {
        int out = divide(-2147483648, 2);
        System.out.println(out);
    }

    public static int divide(long dividend, long divisor) {
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        boolean isDividendPositive = dividend > 0;
        boolean isDivisorPositive = divisor > 0;

        if (!isDividendPositive) {
            dividend *= -1;
        }

        if (!isDivisorPositive) {
            divisor *= -1;
        }

        long count = binarySearchDivide(dividend, divisor);

        if ((isDividendPositive && !isDivisorPositive) ||
                (!isDividendPositive && isDivisorPositive)) {
            count = -count;
        }

        return (int) count;
    }

    public static long binarySearchDivide(long dividend, long divisor) {
        long low = -1;
        long high = dividend + 1;
        while (high - low > 1) {
            long mid = (high - low) / 2 + low;
            if (mid * divisor > dividend) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }
}