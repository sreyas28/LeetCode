public class ProblemNo3227 {
    public static void main(String[] args) {

    }

    class Solution {

        public boolean doesAliceWin(String s) {
            for(char c: s.toCharArray()){
                switch (c) {
                    case 'a', 'e', 'i', 'o', 'u':
                        return true;
                }
            }
            return false;
        }
    }

}
