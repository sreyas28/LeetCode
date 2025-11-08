import java.util.PriorityQueue;

public class ProblemNo215 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

            for(int i=0; i<k; i++) maxHeap.offer(nums[i]);

            for(int i=k; i<nums.length; i++){
                if(maxHeap.peek() < nums[i]) {
                    maxHeap.poll();
                    maxHeap.offer(nums[i]);
                }
            }

            return maxHeap.poll();
        }
    }

}
