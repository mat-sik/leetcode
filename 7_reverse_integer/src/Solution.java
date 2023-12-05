public class Solution {

    public static int reverse(int x) {

        String value = String.valueOf(x);

        var output = new StringBuilder();

        boolean isNegative = value.charAt(0) == '-';
        int endIndex = 0;
        if (isNegative) {
            output.append('-');
            endIndex = 1;
        }

        for (int i = value.length() - 1; i >= endIndex; i--) {
            output.append(value.charAt(i));
        }

        try {
            return Integer.parseInt(output.toString());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

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

    public static void main(String[] args) {

        var x = -1111111119;
        var output = reverseInt(x);

        System.out.println(output);
    }
}