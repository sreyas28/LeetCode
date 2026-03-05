public class ProblemNo1758 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minOperations(String s) {
            int countL = 0,  countR = 0;
            boolean flag = true;

            for(char c : s.toCharArray()){
                if (flag && c != '1') countL++;
                else if (!flag && c != '0') countL++;

                if (!flag && c != '1') countR++;
                else if (flag && c != '0') countR++;

                flag = !flag;
            }

            return Math.min(countL, countR);
        }
    }

}
