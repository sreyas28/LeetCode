import java.util.*;

public class ProblemNo2598 {
    public static void main(String[] args) {

        ProblemNo2598.Solution a = new ProblemNo2598().new Solution();
        System.out.println(a.findSmallestInteger(new int[]{3,0,3,2,4,2,1,1,0,4}, 5));

    }

    class Solution {
        public int findSmallestInteger(int[] nums, int value) {
            Map<Integer, Integer> freq = new HashMap<>();

            for(int i: nums){
                int mod = ((i % value) + value) % value;
                freq.put(mod, freq.getOrDefault(mod, 0) + 1);
            }

            //System.out.println(freq);

            int number = 0;
            while(true){
                int num = number % value;

                if(freq.containsKey(num)){
                    freq.put(num, freq.get(num) - 1);
                    if(freq.get(num) == 0) freq.remove(num);
                }
                else{
                    return number;
                }

                number++;
            }
        }
    }

}
