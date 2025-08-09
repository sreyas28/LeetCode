import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemNo47 {
    public static void main(String[] args) {

        ProblemNo47.Solution a = new ProblemNo47().new Solution();
        System.out.println(a.permuteUnique(new int[]{1,2,3,3,4}));

    }

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Map<Integer, Integer> val_freq = new HashMap<>();

            for(int i : nums) val_freq.put(i, val_freq.getOrDefault(i, 0) + 1);
            System.out.println(val_freq);

            permutations(result, new ArrayList<>(), val_freq);

            return result;
        }

        private void permutations(List<List<Integer>> result, List<Integer> current, Map<Integer, Integer> val_freq ){
            if(val_freq.isEmpty()) {
                result.add(new ArrayList<>(current));
                return;
            }
            for(int key: new ArrayList<>(val_freq.keySet())){
                int freq = val_freq.get(key);

                current.add(key);
                val_freq.put(key, freq - 1);
                if(freq - 1 == 0) val_freq.remove(key);

                permutations(result,current,val_freq);

                current.removeLast();
                val_freq.put(key, freq);
            }
        }

    }

}
