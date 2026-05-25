public class ProblemNo1871 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1871().new Solution();
        System.out.println(a.canReach("00111010", 3, 5));

    }

    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            final int N = s.length();
            if (s.charAt(0) != '0' || s.charAt(N - 1) != '0') return false;

            boolean[] visited = new boolean[N];
            visited[0] = true;
            int maxReached = 0;

            for (int i = 0; i < N; i++) {
                if (!visited[i] || s.charAt(i) != '0') continue;

                int lo = i + minJump;
                int hi = Math.min(i + maxJump, N - 1);

                int start = Math.max(lo, maxReached);

                for (int j = start; j <= hi; j++) {
                    if (s.charAt(j) == '0' && !visited[j]) {
                        visited[j] = true;
                    }
                }

                maxReached = Math.max(maxReached, hi);

                if (visited[N - 1]) return true;
            }

            return visited[N - 1];
        }
    }

}
