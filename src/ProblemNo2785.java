import java.util.*;

public class ProblemNo2785 {
    public static void main(String[] args) {

    }

    class Solution {
        public String sortVowels(String s) {
            StringBuilder result = new StringBuilder();

            ArrayList<Character> vowels = new ArrayList<>();
            for(char c: s.toCharArray()){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels.add(c);
                else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') vowels.add(c);
            }

            Collections.sort(vowels);
            int i = 0;
            for(char c: s.toCharArray()){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') result.append(vowels.get(i++));
                else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') result.append(vowels.get(i++));
                else result.append(c);
            }

            return result.toString();
        }

        //Kind Of faster
        private static Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        public String sortVowels_(String s) {
            StringBuilder result = new StringBuilder();

            ArrayList<Character> vowels = new ArrayList<>();
            for(char c: s.toCharArray()) if(VOWELS.contains(c)) vowels.add(c);

            Collections.sort(vowels);
            int i = 0;
            for(char c: s.toCharArray()){
                if(VOWELS.contains(c)) result.append(vowels.get(i++));
                else result.append(c);
            }

            return result.toString();
        }
    }

}
