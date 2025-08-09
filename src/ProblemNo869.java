import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemNo869 {

    public static void main(String[] args) {

        ProblemNo869.Solution a = new ProblemNo869().new Solution();
        System.out.println(a.reorderedPowerOf2(46));

    }

    class Solution {
        public boolean reorderedPowerOf2(int n) {

            List<Integer> numberPermutations = new ArrayList<>();
            Map<Integer, Integer> numFreq = new HashMap<>();

            while(n != 0){
                int val = n%10;
                numFreq.put(val, numFreq.getOrDefault(val, 0) + 1);
                n /= 10;
            }
            permutations(numberPermutations, numFreq, 0);

            return !numberPermutations.isEmpty();
        }

        private void permutations(List<Integer> numberPermutations, Map<Integer, Integer> numFreq, int number){
            if(numFreq.isEmpty()) {
                int val = number;
                while(val != 1){
                    if(val % 2 != 0) return;
                    val /= 2;
                }
                numberPermutations.add(number);
                return;
            }

            if(!numberPermutations.isEmpty()) return;

            for(int key: new ArrayList<>(numFreq.keySet())){
                if(number ==0 && key == 0) continue;

                int freq = numFreq.get(key);
                number = number*10 + key;

                numFreq.put(key, freq - 1);
                if(freq - 1 == 0) numFreq.remove(key);

                permutations(numberPermutations,numFreq,number);

                number /= 10;
                numFreq.put(key, freq);
            }
        }

    }

}
