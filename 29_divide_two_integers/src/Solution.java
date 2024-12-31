class Solution {

    public static void main(String[] args) {
        int out = divide(-2147483648, 2);
        System.out.println(out);
    }

    public static int divide(int dividendA, int divisorA) {
        long dividend = dividendA;
        long divisor = divisorA;
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        if (dividend == 0) {
            return 0;
        }

        boolean isDividendPositive = dividend > 0;
        boolean isDivisorPositive = divisor > 0;

        if (!isDividendPositive) {
            dividend *= -1;
        }

        if (!isDivisorPositive) {
            divisor *= -1;
        }

        long count;

        if (dividend == divisor) {
            count = 1;
        } else if (divisor == 1) {
            count = dividend;
        } else {
            count = findCount(dividend, divisor);
        }

        if ((isDividendPositive && !isDivisorPositive) ||
                (!isDividendPositive && isDivisorPositive)) {
            count = -count;
        }

        return (int) count;
    }

    public static long findCount(long dividend, long divisor) {
        long low = 0;
        long high = dividend / 2;
        while (high - low > 1) {
            long mid = (high - low) / 2 + low;
            if (mid * divisor > dividend) {
                high = mid;
            } else {
                low = mid;
            }
        }

        while ((low + 1) * divisor <= dividend) {
            low++;
        }

        return low;
    }
}