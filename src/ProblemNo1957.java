public class ProblemNo1957 {
    public static void main(String[] args) {

        ProblemNo1957.Solution a = new ProblemNo1957(). new Solution();
        System.out.println(a.makeFancyString("aaabaaaa"));

    }

    class Solution {
        public String makeFancyString(String s) {
            StringBuilder res = new StringBuilder();

            int[] charInt = new int[2];
            for(char c: s.toCharArray()){
                if (charInt[0] != (c-'a') ){
                    charInt[0] = c-'a';
                    charInt[1] = 1;
                    res.append(c);
                }
                else{
                    if(charInt[1] + 1 > 2) continue;
                    else{
                        charInt[1]++;
                        res.append(c);
                    }
                }

            }

            return res.toString();
        }
    }

}
