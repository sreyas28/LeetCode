import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProblemNo966 {
    public static void main(String[] args) {

        ProblemNo966.Solution a = new ProblemNo966().new Solution();
        System.out.println(Arrays.toString(a.spellchecker(
                new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"})
        ));


    }

    class Solution {
        public String[] spellchecker(String[] wordlist, String[] queries) {
            Map<String, String> exactWord = new HashMap<>();
            Map<String, String> CaseInsensitive = new HashMap<>();
            Map<String, String> IgnoreVowelsWord = new HashMap<>();

            for(String word: wordlist){
                exactWord.put(word,word);
                CaseInsensitive.putIfAbsent(word.toLowerCase(), word);
                IgnoreVowelsWord.putIfAbsent(vowelRemover(word), word);
            }

            String[] result = new String[queries.length];

            for(int i=0; i < queries.length; i++){
                String query = queries[i];

                if(exactWord.containsKey(query)) result[i] = exactWord.get(query);
                else if(CaseInsensitive.containsKey(query.toLowerCase())) result[i] = CaseInsensitive.get(query.toLowerCase());
                else result[i] = IgnoreVowelsWord.getOrDefault(vowelRemover(query), "");
            }

            return result;
        }

        private String vowelRemover (String word){
            return word.toLowerCase().replaceAll("[aeiou]", "*");
        }

    }


}


//not fast
//public String[] spellchecker(String[] wordlist, String[] queries) {
//    String[] result = new String[queries.length];
//
//    String[] wordListVowels = vowelsRemover(wordlist);
//    String[] queriesVowels = vowelsRemover(queries);
//
//
//    for(int i=0; i< queries.length; i++){
//        String query = queries[i];
//        String possibleWord = "";
//        boolean Capital = false;
//
//        for(int j=0; j<wordlist.length; j++){
//            String word = wordlist[j];
//            // exact match
//            if(word.equals(query)) {
//                result[i] = word;
//                break;
//            }
//
//            // Capitalization
//            else if (!Capital && word.equalsIgnoreCase(query)) {
//                possibleWord = word;
//                Capital = true;
//            }
//
//            // vowel error
//            else if (!Capital && possibleWord.isEmpty()) {
//                if(wordListVowels[j].equals(queriesVowels[i])) possibleWord = word;
//            }
//        }
//
//        if(result[i] == null) result[i] = possibleWord;
//    }
//
//    return result;
//}
//
//private String[] vowelsRemover (String[] list){
//    String[] result = new String[list.length];
//
//    for(int i=0; i< list.length; i++){
//        String tempQuery =  list[i].toLowerCase().replaceAll("[aeiou]",  "*");
//        result[i] = tempQuery;
//    }
//
//    return result;
//}
