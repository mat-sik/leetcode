public class Solution {

    public static int reverseInt(int x) {

        boolean isNegative = x < 0;
        int border = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int output = 0;
        int tmp = x;

        while (tmp != 0) {
            int currBorder = (border - (tmp % 10)) / 10;
            if ((isNegative && output < currBorder) || (!isNegative) && output > currBorder) {
                return 0;
            }
            output = output * 10 + (tmp % 10);
            tmp /= 10;
        }

        return output;
    }

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        return x == reverseInt(x);
    }

    public static void main(String[] args) {

        var x = -404043;
        System.out.println(isPalindrome(x));
    }
}
