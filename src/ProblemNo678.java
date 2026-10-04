import java.util.*;

public class ProblemNo678 {
    public static void main(String[] args) {

        Solution a = new ProblemNo678().new Solution();
        System.out.println(a.checkValidString("(*))"));
        System.out.println(a.checkValidString("(*)"));
        System.out.println(a.checkValidString("()"));
        System.out.println(a.checkValidString("("));
        System.out.println(a.checkValidString("***********************************************"));

    }

    // Backtracking with MEMO
    class Solution {
        private Boolean[][] memo;

        public boolean checkValidString(String s) {
            this.memo = new Boolean[s.length() + 1][s.length() * 2 + 1];
            return backTracking(0, 0, s);
        }

        private boolean backTracking(int balance, int i, String s) {
            if (i == s.length() && balance == 0) return true;
            else if (i == s.length() || balance < 0) return false;

            if (memo[i][balance] != null) return memo[i][balance];

            char c = s.charAt(i);

            switch (c) {
                case '(' -> {
                    memo[i][balance] = backTracking(balance + 1, i + 1, s);
                }
                case ')' -> {
                    memo[i][balance] = backTracking(balance - 1, i + 1, s);
                }
                case '*' -> {
                    if (backTracking(balance + 1, i + 1, s) || (backTracking(balance - 1, i + 1, s)))
                        memo[i][balance] = true;
                    else memo[i][balance] = backTracking(balance, i + 1, s);
                }
            }
            return memo[i][balance];
        }
    }


    // faster but still TLE
    class Solution__ {
        public boolean checkValidString(String s) {
            return backTracking(0, 0, s);
        }

        private boolean backTracking(int balance, int i, String s) {

            if (i == s.length() && balance == 0) return true;
            else if (i == s.length() || balance < 0) return false;

            char c = s.charAt(i);
            i++;

            switch (c) {
                case '(' -> {
                    return backTracking(balance + 1, i, s);
                }
                case ')' -> {
                    return backTracking(balance - 1, i, s);
                }
                case '*' -> {
                    if (backTracking(balance + 1, i, s)) return true;
                    else if (backTracking(balance - 1, i, s)) return true;
                    return backTracking(balance, i, s);
                }
            }
            return false;
        }
    }

    // exponential Time
    class Solution_ {
        public boolean checkValidString(String s) {
            final int N = s.length();

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0}); // {balance, index}

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();

                int balance = curr[0];
                int index = curr[1];

                if (balance < 0) continue;
                else if (index == N && balance == 0) return true;
                else if (index != N) {
                    switch (s.charAt(index)) {
                        case '(' -> queue.offer(new int[]{balance + 1, index + 1});
                        case ')' -> queue.offer(new int[]{balance - 1, index + 1});
                        case '*' -> {
                            queue.offer(new int[]{balance + 1, index + 1}); // considering as (
                            queue.offer(new int[]{balance - 1, index + 1}); // considering as )
                            queue.offer(new int[]{balance, index + 1}); // and null
                        }
                        default -> {

                        }
                    }
                }
            }

            return false;
        }
    }

}
