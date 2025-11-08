import java.util.PriorityQueue;

public class ProblemNo1046 {
    public static void main(String[] args) {

    }

    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
            for(int i: stones) maxHeap.offer(i);

            while(maxHeap.size() > 1){
                int big = maxHeap.poll();
                int small = maxHeap.poll();

                if(big != small ) maxHeap.offer(big-small);
            }

            return maxHeap.peek() != null ? maxHeap.peek(): 0;
        }
    }
}
