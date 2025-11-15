import java.util.*;

public class ProblemNo187 {
    public static void main(String[] args) {
        ProblemNo187.Solution a = new ProblemNo187().new Solution();
        System.out.println(a.findRepeatedDnaSequences("CAAAAAAAAAC"));
    }

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String, Integer> freq = new HashMap<>();
            List<String> result = new ArrayList<>();

            if(10 <= s.length()) freq.put(s.substring(0, 10), 1);

            for(int i = 10; i < s.length(); i++){
                String val = s.substring(i-10, i);
                freq.put(val, freq.getOrDefault(val, 0) + 1);
            }

            for(String str: freq.keySet()){
                if(freq.get(str) > 1) result.add(str);
            }

            return result;
        }
    }

    class Solution_ {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String, Integer> freq = new HashMap<>();

            StringBuilder a = new StringBuilder();
            for(int i = 0; i < 10 && i < s.length(); i++ ){
                a.append(s.charAt(i));
            }

            freq.put(a.toString(), 1);

            for(int i = 10; i < s.length(); i++){
                a.deleteCharAt(0);
                a.append(s.charAt(i));

                String val = a.toString();
                freq.put(val, freq.getOrDefault(val, 0) + 1);
            }

            List<String> result = new ArrayList<>();
            for(String str: freq.keySet()){
                if(freq.get(str) > 1) result.add(str);
            }


            return result;
        }
    }

}
