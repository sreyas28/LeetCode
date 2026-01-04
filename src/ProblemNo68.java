import java.util.*;

public class ProblemNo68 {
    public static void main(String[] args) {

        ProblemNo68.Solution p = new ProblemNo68().new Solution();
        System.out.println(p.fullJustify(new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16));

    }

    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();

            List<String> list = new ArrayList<>();
            int row = maxWidth;
            for(String word: words){
                if(row - word.length() - list.size() >= 0){
                    list.add(word);
                    row -= word.length();
                    continue;
                }

                int mod = (list.size()-1) == 0 ? 0 : row % (list.size() - 1);
                int floorGap = (list.size()-1) == 0 ? row : (row / (list.size() - 1));

                StringBuilder builder = new StringBuilder();
                for(int i = 0; i < list.size(); i++){
                    builder.append(list.get(i));
                    if(i < mod) builder.append(" ".repeat(floorGap+1));
                    else if(i != list.size()-1 || list.size() == 1)builder.append(" ".repeat(floorGap));
                }
                result.add(builder.toString());

                list.clear();
                list.add(word);
                row = maxWidth - word.length();
            }

            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < list.size(); i++){
                builder.append(list.get(i));
                if(i != list.size()-1)builder.append(" ");
            }
            if(row - list.size() + 1 > 0) builder.append(" ".repeat(row-list.size() +1));
            result.add(builder.toString());

            return result;
        }
    }

}
