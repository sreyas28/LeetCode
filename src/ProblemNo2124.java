public class ProblemNo2124 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean checkString(String s) {

            boolean findB = false;

            for ( char c : s.toCharArray()) {
                if (!findB && c == 'b') findB = true;
                else if (findB && c == 'a') return false;
            }

            return true;
        }
    }

}
