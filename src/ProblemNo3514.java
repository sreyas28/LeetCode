import java.util.*;

public class ProblemNo3514 {
    public static void main(String[] args) {

    }

    class Solution {
        public int uniqueXorTriplets(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num);

            List<Integer> numsList = new ArrayList<>(set);
            int N = numsList.size();

            set = new HashSet<>();

            for(int i = 0; i < N; i++){
                int A = numsList.get(i);
                for(int j = i; j < N; j++){
                    set.add(numsList.get(j) ^ A);
                }
            }
            List<Integer> pairXOR = new ArrayList<>(set);

            set = new HashSet<>();
            for(int pair : pairXOR){
                for(int num : numsList){
                    set.add(num ^ pair);
                }
            }

            return set.size();
        }
    }

}
