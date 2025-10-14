import java.util.List;

public class ProblemNo3349 {
    public static void main(String[] args) {



    }

    class Solution {
        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            if( k == 1) return true;

            for(int i = 0; i <= nums.size() - (2*k); i++){
                boolean left = true;
                for(int iterate = i+1; iterate < i+k; iterate++){
                    if(nums.get(iterate-1) >= nums.get(iterate)) {
                        left = false;
                        break;
                    }
                }
                boolean right = true;
                for(int iterate = i+k+1; iterate < i+(2*k); iterate++){
                    if(nums.get(iterate-1) >= nums.get(iterate)) {
                        right = false;
                        break;
                    }
                }

                if(left && right) return true;
            }

            return false;
        }
    }

    class Solution_ {
        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            int count = 0;
            int left = 0, right = 1;

            for( right = 1; right < nums.size(); right++){
                if (nums.get(right-1) >= nums.get(right)) {
                    if((right - left) >= k){
                        count += (right - left) / k;
                        if(count >= 2) return true;
                        else count = 0;
                    }
                    left = right;
                }
            }

            if((right - left) >= k){
                count += (right - left) / k;
            }

            return count >= 2;
        }
    }

}
