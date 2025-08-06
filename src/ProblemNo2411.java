import java.util.Arrays;

public class ProblemNo2411 {
    public static void main(String[] args) {

        ProblemNo2411.Solution a = new ProblemNo2411().new Solution();

        System.out.println(Arrays.toString(a.smallestSubarrays(new int[]{1,0,2,1,3})));

    }

    class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            int[] bitLastSeen = new int[32]; // tracks last index each bit is seen

            Arrays.fill(bitLastSeen, -1); // initialize as -1

            for (int i = n - 1; i >= 0; i--) {
                int maxReach = i;
                for (int b = 0; b < 32; b++) {
                    if ((nums[i] & (1 << b)) != 0) {
                        bitLastSeen[b] = i;
                    }
                    if (bitLastSeen[b] != -1) {
                        maxReach = Math.max(maxReach, bitLastSeen[b]);
                    }
                }

                result[i] = maxReach - i + 1;
            }

            return result;
        }
    }

}

//class Solution {
//    public int[] smallestSubarrays(int[] nums) {
//
//        int[] result = new int[nums.length];
//        int max = 0;
//
//        for(int i= nums.length-1; i >=0 ;i--){
//            max |= nums[i];
//            int or = 0;
//            for(int j=i; j < nums.length; j++){
//                or |= nums[j];
//                if(or == max){
//                    result[i] = (j - i) + 1;
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//}