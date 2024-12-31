public class Alternative {
    public static void main(String[] args) {
        long out = div(-2147483648, -1);
        System.out.println(out);
    }

    public static long div(long dividend, long divisor) {
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
