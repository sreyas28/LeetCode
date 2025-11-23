import java.util.*;

public class ProblemNo1262 {
    public static void main(String[] args) {

        ProblemNo1262.Solution a = new ProblemNo1262().new Solution();
        System.out.println(a.maxSumDivThree(new int[]{2,3,36,8,32,38,3,30,13,40}));

    }

    class Solution {
        public int maxSumDivThree(int[] nums) {

            PriorityQueue<Integer> rem1 = new PriorityQueue<>();
            PriorityQueue<Integer> rem2 = new PriorityQueue<>();
            int sum = 0;

            for(int i: nums){
                int rem = i % 3;
                if(rem == 1) rem1.offer(i);
                else if(rem == 2) rem2.offer(i);

                sum += i;
            }

//            System.out.println(rem1);
//            System.out.println(rem2);
//            System.out.println(sum);

            int rem = sum % 3;
            if(rem == 0) return sum;
            else if(rem == 1) {
                int min1 = !rem1.isEmpty() ? rem1.poll() : Integer.MAX_VALUE;
                int min2 = rem2.size() >= 2 ? rem2.poll() + rem2.poll() : Integer.MAX_VALUE;

                sum -= Math.min(min1, min2);
            }
            else {
                int min1 = !rem2.isEmpty() ? rem2.poll() : Integer.MAX_VALUE;
                int min2 = rem1.size() >= 2 ? rem1.poll() + rem1.poll() : Integer.MAX_VALUE;

                sum -= Math.min(min1, min2);
            }

            return sum;
        }
    }


    class Solution_ {
        public int maxSumDivThree(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            Set<Integer> val = new HashSet<>();

            for(int i: nums){
                sum += i;
                val.add(sum);
                val.add(i);
            }

            int rem = sum % 3;
            while(sum % 3 != 0){
                if(val.contains(rem)) sum -= rem;
                else rem += 3;
            }

            return sum;
        }
    }

}
