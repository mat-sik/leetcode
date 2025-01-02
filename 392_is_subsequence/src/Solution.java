import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        boolean out = isSubsequence("leeeeetcode", "leeeeetcode");
        System.out.println(out);
    }

    public static boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> indecies = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);

            List<Integer> l = indecies.get(curr);
            if (l == null) {
                l = new ArrayList<>();
                indecies.put(curr, l);
            }
            l.add(i);
        }

        Map<Character, Integer> counter = new HashMap<>();
        Integer prevIdx = null;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            List<Integer> l = indecies.get(curr);
            if (l == null) {
                return false;
            }

            Integer count = counter.get(curr);
            if (count == null) {
                count = 0;
            }
            if (l.size() - 1 < count) {
                return false;
            }

            boolean matched = false;
            int j;
            for (j = count; j < l.size(); j++) {
                int idx = l.get(j);
                if (prevIdx == null || idx > prevIdx) {
                    prevIdx = idx;
                    matched = true;
                    break;
                }
            }

            counter.put(curr, j);

            if (!matched) {
                return false;
            }

        }
        return true;
    }
}