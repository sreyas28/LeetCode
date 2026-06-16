public class ProblemNo3612 {
    public static void main(String[] args) {

    }

    class Solution {
        public String processStr(String s) {
            StringBuffer sb = new StringBuffer();

            for(char c : s.toCharArray()){
                if (c == '*') {
                    if (sb.length() - 1 >= 0)
                        sb.deleteCharAt(sb.length() - 1);
                }
                else if (c == '#') sb.append(sb.toString());
                else if (c == '%') sb.reverse();
                else sb.append(c);
            }

            return sb.toString();
        }
    }

}
