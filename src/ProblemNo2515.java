public class ProblemNo2515 {
    public static void main(String[] args) {

        ProblemNo2515.Solution p = new ProblemNo2515().new Solution();
        System.out.println(p.closestTarget(new String[]{"ibkgecmeyx","jsdkekkjsb","gdjgdtjtrs","jsdkekkjsb","jsdkekkjsb","jsdkekkjsb","gdjgdtjtrs","msjlfpawbx","pbgjhutcwb","gdjgdtjtrs"},
                "pbgjhutcwb", 0));

    }

    class Solution {
        public int closestTarget(String[] words, String target, int startIndex) {
            int n = words.length;
            if (words[startIndex].equals(target)) return 0;

            int L = (startIndex - 1 + n) % n;
            int R = (startIndex + 1 + n) % n;

            int i = 1;
            while(L != R){
                if (words[L].equals(target) || words[R].equals(target)) return i;

                L = (L - 1 + n) % n;
                R = (R + 1 + n) % n;
                i++;
            }

            if ( words[L].equals(target) ) return i;
            return -1;
        }
    }

}
