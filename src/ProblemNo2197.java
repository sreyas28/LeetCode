import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProblemNo2197 {
    public static void main(String[] args) {
        ProblemNo2197.Solution a = new ProblemNo2197().new Solution();
        System.out.println(a.replaceNonCoprimes(new int[]{287,41,49,287,899,23,23,20677,5,825}));
    }

    class Solution {
        public List<Integer> replaceNonCoprimes(int[] nums) {
            LinkedList<Integer> result = new LinkedList<>();

            for(int num: nums){
                while(!result.isEmpty() && GCD(result.peekLast(), num) != 1){
                    num = LCM(result.pollLast(), num);
                }
                result.add(num);
            }

            return result;
        }


        private int GCD(int num1, int num2){
            int a = Math.max(num1,num2);
            int r = Math.min(num1,num2);

            while(r != 0){
                int temp = r;
                r = a%r;
                a = temp;
            }

            return a;
        }

        private int LCM( int num1, int num2){
            return (num1/GCD(num1,num2)) * num2;
        }

    }

}
