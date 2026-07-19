import java.util.*;

public class ProblemNo1081 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1081().new Solution();
        System.out.println(a.smallestSubsequence("bcabc"));

    }

    class Solution {
        public String smallestSubsequence(String s) {
            Map<Character, Integer> lastOccurrence = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                lastOccurrence.put(s.charAt(i), i);
            }

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(curr);
                    continue;
                }
                if (!stack.contains(curr)){
                    while(!stack.isEmpty() && stack.peek() > curr && lastOccurrence.get(stack.peek()) > i) stack.pop();
                    stack.push(curr);
                }
            }

            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                res.insert(0, stack.pop());
            }

            return res.toString();
        }
    }

    // TLE Brute Force
    class Solution_ {
        public String smallestSubsequence(String s) {
            return DFS(s, new HashSet<>(), 0, new StringBuilder());
        }

        private String maxString(String a, String b) {
            if (a.length() == b.length()) return a.compareTo(b) < 0 ? a : b;
            return a.length() > b.length() ? a : b;
        }

        private String DFS(String str, Set<Character> set, int i, StringBuilder made) {
            if  (i == str.length()) return made.toString();
            char ch = str.charAt(i);

            String res = "";

            // not adding
            res = DFS(str, new HashSet<>(set), i + 1, new StringBuilder(made));

            // for adding
            if (!set.contains(ch)) {
                made.append(ch);
                set.add(ch);

                res = maxString(res, DFS(str, new HashSet<>(set), i + 1, new StringBuilder(made)));
            }

            return res;
        }
    }

}
