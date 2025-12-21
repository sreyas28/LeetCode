public class ProblemNo944 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minDeletionSize(String[] strs) {
            int len = strs[0].length();
            int deleted = 0;

            for(int i=0; i < len; i++){
                char c = 'a';
                for(String s: strs){
                    if(c <= s.charAt(i)) {
                        c = s.charAt(i);
                    }
                    else {
                        deleted++;
                        break;
                    }
                }
            }
            return deleted;
        }
    }

}
