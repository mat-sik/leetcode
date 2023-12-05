public class Solution {

    public static String convert(String s, int rowsAmount) {

        if (rowsAmount == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[rowsAmount];
        int idx;
        for (idx = 0; idx < rowsAmount; idx++) {
            rows[idx] = new StringBuilder();
        }

        boolean down = true; // Indicates whether to go up or down
        int rowIdx = 0;      // Current row index. When equal to row count, go up. Skip last and first row.
        for (idx = 0; idx < s.length(); idx++) {
            if (down) {
                rows[rowIdx++].append(s.charAt(idx));
                if (rowIdx == rowsAmount) {
                    down = false;
                    rowIdx -= 2;
                }
            } else {
                rows[rowIdx--].append(s.charAt(idx));
                if (rowIdx == 0) {
                    down = true;
                    rowIdx = 0;
                } else if (rowIdx < 0) {
                    down = true;
                    rowIdx = 1;
                }
            }
        }

        for (idx = 1; idx < rowsAmount; idx++) {
            rows[0].append(rows[idx]);
        }

        return rows[0].toString();
    }

/*
 ACBD

 A C
 B   D

 */

    public static void main(String[] args) {

        var s = "ABCD";
        var rows = 2;

        convert(s, rows);
    }
}