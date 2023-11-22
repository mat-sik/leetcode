public class SolutionDynamicProgramming {
    public static String longestPalindrome(String s) {

        boolean[][] visited = new boolean[s.length()][s.length()];

        int longestPaliSize = 0;
        Integer bestStart = null;
        Integer bestEnd = null;

        for (int i = 0; i < s.length(); i++) {

            for (int start = 0, end = i; end < s.length(); start++, end = start + i) {

                if (s.charAt(start) == s.charAt(end)) {
                    var isPali = true;
                    var problemSize = end - start + 1;
                    var hasSubProblem = problemSize > 2;
                    if (hasSubProblem) {
                        var subProblemStart = start + 1;
                        var subProblemEnd = end - 1;
                        var isSubProblemPali = visited[subProblemStart][subProblemEnd];
                        isPali = isSubProblemPali;
                    }
                    if (isPali && (problemSize > longestPaliSize)) {
                        longestPaliSize = problemSize;
                        bestStart = start;
                        bestEnd = end;
                    }
                    visited[start][end] = isPali;
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