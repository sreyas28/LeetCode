import java.util.*;


public class ProblemNo1807 {
    public static void main(String[] args) {
    }

    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>();

            for(List<String> list : knowledge) map.put(list.get(0), list.get(1));

            StringBuilder result = new StringBuilder();

            int i = 0;
            StringBuilder curr = new StringBuilder();
            while(i < s.length()) {
                char c = s.charAt(i);

                if (Character.isAlphabetic(c)) curr.append(c);
                else {
                    if (c == '('){
                        result.append(curr);
                    }
                    else if (c == ')'){
                        result.append(map.getOrDefault(curr.toString(), "?"));
                    }
                    curr = new StringBuilder();
                }

                i++;
            }

            result.append(curr);

            return result.toString();
        }
    }

}
