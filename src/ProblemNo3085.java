import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.HashMap;

public class ProblemNo3085 {
    public static void main(String[] args) {

        ProblemNo3085.Solution a = new ProblemNo3085().new Solution();
        System.out.println(a.minimumDeletions("aaabaaa", 2));

    }

    class Solution {
        public int minimumDeletions(String word, int k) {
            int max = 0;
            HashMap<Character, Integer> map = new HashMap<>();

            for(char c: word.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) > max) max = map.get(c);
            }
//            System.out.println(map + " " + max);

            int result = Integer.MAX_VALUE;
            for(int i = k; i <= max + k; i++){
                int[] range = {i-k, i + 1};
//                System.out.print(Arrays.toString(range) + " ");

                int removed = 0;
                for(int val: map.values()){
                    if(val < range[0]) removed += val;
                    else if(val >= range[1]) removed += (val - i);

                    if(removed > result) break;
                }
//                System.out.println(" -- " + removed);
                result = Math.min(result, removed);
            }

            return result;
        }
    }

}
