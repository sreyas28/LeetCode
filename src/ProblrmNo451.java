import java.util.*;

public class ProblrmNo451 {
    public static void main(String[] args) {

    }

    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> charFreq = new HashMap<>();
            for(char c: s.toCharArray()) charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);

           List<Map.Entry<Character, Integer>> sorted = new ArrayList<>(charFreq.entrySet());
           sorted.sort((a,b) -> b.getValue().compareTo(a.getValue()));

            StringBuilder stringBuilder = new StringBuilder();

            for(Map.Entry<Character, Integer> val: sorted){
                stringBuilder.append(String.valueOf(val.getKey()).repeat(val.getValue()));
            }
            return stringBuilder.toString();
        }
    }

}
