import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemNo1390 {
    public static void main(String[] args) {
        ProblemNo1390.Solution p = new ProblemNo1390().new Solution();
        System.out.println(p.sumFourDivisors(new int[]{21,4,7}));
    }

    class Solution {
        public int sumFourDivisors(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            int sum = 0;
            for(int num : nums){

                if(map.containsKey(num)) {
                    sum += map.get(num);
                    continue;
                }
                int curSum = 0;
                int count = 0;
                for(int i = 1; i*i <= num; i++){
                    if(num % i == 0){
                        curSum += i;
                        count++;

                        if(i != num/i){
                            curSum += num/i;
                            count++;
                        }

                    }
                    if(count > 4) break;
                }

                if(count == 4){
                    sum += curSum;
                    map.put(num, curSum);
                }
                else map.put(num, 0);
            }

            return sum;
        }
    }


}
