public class Manacher {

    public static String odd(String s) {

        var biggest = 0;
        // initialize first to one
        var sizes = new int[s.length()];
        sizes[0] = 1;

        int l = 0; // First symbol of the right most palindrome.
        int r = 0; // Last symbol of the right most palindrome.

        for (int i = 1; i < s.length(); i++) {

            int size = 0; // lays outside
            if (i <= r) { // lays inside or on the border
                size = sizes[l + (r -i)];
            }

            // can be expanded
            if (i + size > r) {
                while (i - sizes[i] >= 0 && i + sizes[i] < s.length() && s.charAt(i - sizes[i]) == s.charAt(i + sizes[i])) {
                    sizes[i]++;
                }
            }
            if (sizes[i] > sizes[biggest]) {
                biggest = i;
                l = i - sizes[i] + 1;
                r = i + sizes[i] - 1;
            }

        }

        return s.substring(biggest - sizes[biggest] + 1, biggest + sizes[biggest]);
    }

    public static String even(String s) {

        var biggest = 0;
        var sizes = new int[s.length()];

        int l = 0;
        int r = 0;

        for (int i = 1; i < s.length(); i++) {

            int size = 0;
            if (i <= r) {
                size = sizes[l + (r - i) + 1];
            }

            if (i + size > r) {
                while (i + sizes[i] < s.length() && (i - 1) - sizes[i] >= 0 && s.charAt(i + sizes[i]) == s.charAt((i - 1) - sizes[i])) {
                    sizes[i]++;
                }
            }
            if (sizes[i] > sizes[biggest]) {
                biggest = i;
                l = i - sizes[i];
                r = i + sizes[i] - 1;
            }
        }

        return s.substring(biggest - sizes[biggest], biggest + sizes[biggest]);
    }

    public static String longestPalindrome(String s) {

        var oddResult = odd(s);
        System.out.printf("oddResult: %s\n", oddResult);
        var evenResult = even(s);
        System.out.printf("evenResult: %s\n", evenResult);
        return oddResult.length() > evenResult.length() ? oddResult : evenResult;
    }

    public static void main(String[] args) {

        var input = "cccccc";

        var output = longestPalindrome(input);

        System.out.println(output);
    }

}
