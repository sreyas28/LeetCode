public class ProblemNo3541 {
    public static void main(String[] args) {
        ProblemNo3541.Solution a = new ProblemNo3541().new Solution();
        System.out.println(a.maxFreqSum("og"));
    }

    class Solution {
        public int maxFreqSum(String s) {
            int[] alphabet = new int[26];
            for(char c: s.toCharArray()){
                alphabet[c-'a']++;
            }

            int maxVowel = 0;
            int maxConsonants = 0;

            for(int i=0; i<alphabet.length; i++){
                switch (i){
                    case 0,'e'-'a','i'-'a','o'-'a','u'-'a':
                        maxVowel = Math.max(maxVowel,alphabet[i]);
                        break;
                    default:
                        maxConsonants = Math.max(maxConsonants,alphabet[i]);
                        break;
                }
            }
            return maxConsonants + maxVowel;
        }
    }

}
