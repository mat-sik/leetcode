public class Solution {

    public static int charToInt(char x) {
        return switch (x) {
            case '0' -> 0;
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            default -> -1;
        };
    }

    public static int myAtoi(String s) {

        if (s.isEmpty() || s.isBlank()) {
            return 0;
        }

        int start = 0;
        while (s.charAt(start) == ' ') {
            start++;
        }

        boolean isNegative = false;
        if (s.charAt(start) == '-') {
            isNegative = true;
            start++;
        } else if (s.charAt(start) == '+') {
            start++;
        }

        int border = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int accumulator = 0;

        for (int i = start; i < s.length(); i++) {
            int diff = charToInt(s.charAt(i));
            if (diff == -1) {
                break;
            }
            if (isNegative) {
                diff *= -1;
            }

            int currBorder = (border - diff) / 10;
            if (isNegative && accumulator < currBorder) {
                return Integer.MIN_VALUE;
            } else if (!isNegative && accumulator > currBorder) {
                return Integer.MAX_VALUE;
            }

            accumulator = accumulator * 10 + diff;
        }

        return accumulator;
    }

    public static void main(String[] args) {

        var input = " ";

        System.out.println(myAtoi(input));
    }
}