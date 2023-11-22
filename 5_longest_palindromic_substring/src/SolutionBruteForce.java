public class SolutionBruteForce {

    public static boolean checkPali(String s, int start, int end) {

        while (end >= start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {

        int bestSize = 0;
        Integer bestStart = null;
        Integer bestEnd = null;

        var start = 0;
        var end = s.length() - 1;

        for (int i = start; i < s.length(); i++) {
            for (int j = end; j >= start; j--) {
                var isPali = checkPali(s, i, j);
                if (isPali) {
                    var size = j - i + 1;
                    if (size > bestSize) {
                        bestStart = i;
                        bestEnd = j;
                        bestSize = size;
                    }
                }
            }
        }

        if (bestStart == null | bestEnd == null) {
            return "";
        }

        return s.substring(bestStart, bestEnd + 1);
    }

    public static void main(String[] args) {

        var input = "babad";

        var output = longestPalindrome(input);

        System.out.println(output);
    }

}
