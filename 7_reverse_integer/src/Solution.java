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

    public static void main(String[] args) {

        var x = -1111111118;
        var output = reverse(x);

        System.out.println(output);
    }
}
