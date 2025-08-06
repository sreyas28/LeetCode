import java.util.HashSet;
import java.util.Set;

public class ProblemNo3136 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isValid(String word) {
            if(word.length() < 3) return false;

            char[] vowels = {'a','e','i','o','u', 'A','E','I','O','U'};
            Set<Character> vowelsSet = new HashSet<>();
            for (char c : vowels) vowelsSet.add(c);

            boolean vowels_ = false, consonants = false;

            for(char c: word.toCharArray()){
                if(c == '@' || c == '#' || c == '$') return false;
                else if(Character.isAlphabetic(c)) {

                    if(vowelsSet.contains(c)) vowels_ = true;
                    else consonants = true;
                }
            }




            return vowels_ && consonants;
        }
    }

}
