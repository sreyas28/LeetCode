public class ProblemNo3443 {
    public static void main(String[] args) {

        ProblemNo3443.Solution a = new ProblemNo3443().new Solution();

        System.out.println(a.maxDistance("NWSE", 1));

    }

    class Solution {
        public int maxDistance(String s, int k) {
            int x = 0, y = 0, ans = 0;

            for(int i = 0; i < s.length(); i++){
                switch (s.charAt(i)){
                    case 'N':
                        y++;
                        break;

                    case 'S':
                        y--;
                        break;

                    case 'W':
                        x++;
                        break;

                    case 'E':
                        x--;
                        break;
                }
                ans = Math.max(ans, Math.min(Math.abs(x) + Math.abs(y) + k*2, i+1));
            }


            return ans;
        }
    }
}
