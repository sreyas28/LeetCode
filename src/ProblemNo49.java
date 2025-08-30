import java.util.*;

public class ProblemNo49 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for(String s: strs){

                char[] string = s.toCharArray();
                Arrays.sort(string);
                String key = new String(string);

                List<String> val = new ArrayList<>();
                if(map.containsKey(key)) {
                    val = map.get(key);
                    val.add(s);
                }
                else val.add(s);

                map.put(key, val);
            }

            List<List<String>> result = new ArrayList<>();

            for(String key: map.keySet()){
                result.add(map.get(key));
            }

            return result;
        }
    }

}
