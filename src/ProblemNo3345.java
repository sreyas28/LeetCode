public class ProblemNo3345 {
    public static void main(String[] args) {
        Solution a =  new ProblemNo3345().new Solution();
        System.out.println(a.smallestNumber(10,2));
    }

    class Solution {
        public int smallestNumber(int n, int t) {
            for(int i = n; i < n + 11; i++){
                String value = String.valueOf(i);

                int product = 1;
                for(char c : value.toCharArray()){
                    product *= (c - '0');
                }

                if (product % t == 0) return i;
            }

            return -1;
        }
    }

}
