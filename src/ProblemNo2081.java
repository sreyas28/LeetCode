public class ProblemNo2081 {
    public static void main(String[] args) {
        ProblemNo2081.Solution a = new ProblemNo2081().new Solution();
        System.out.println(a.kMirror(2, 5));
    }

    class Solution {
        public long kMirror(int k, int n) {
            int left = 1, count = 0;
            long result = 0;

            while(count < n){
                int right = left * 10;

                for(int op=0; op < 2; op++ ){
                    for(int i = left; i < right && count < n; i++){
                        long combined  = i;
                        int x = (op == 0) ? i/10 : i;

                        while(x > 0) {
                            combined = combined * 10 + (x%10);
                            x /= 10;
                        }

                        if(isPalindrome(combined, k)){
                            count++;
                            result += combined;
                        }
                    }
                }
                left = right;
            }


            return result;
        }

        private boolean isPalindrome(long n, int k){
            StringBuilder s = new StringBuilder();
            while(n > 0){
                s.append(n % k);
                n /= k;
            }
            String original = s.toString();
            String reverse = s.reverse().toString();

            return original.equals(reverse);
        }

    }

}
