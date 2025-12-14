import java.util.*;

class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        int i = 0;
        for(;i< Math.min(nums.length, k); i++){
            minHeap.offer(nums[i]);
        }

        for(;i<nums.length; i++){
            if(nums[i] > minHeap.peek()) {
                minHeap.offer(nums[i]);
                minHeap.poll();
            }
        }

    }

    public int add(int val) {
        if(minHeap.size() < k) minHeap.add(val);
        else if(val > minHeap.peek()) {
            minHeap.offer(val);
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */