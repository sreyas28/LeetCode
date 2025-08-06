import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProblemNo2402 {
    public static void main(String[] args) {

        ProblemNo2402.Solution a = new ProblemNo2402().new Solution();
        System.out.println(a.mostBooked(2, new int[][] {{43,44},{34,36},{11,47},{1,8},{30,33},{45,48},{23,41},{29,30}} ));

    }

    class Solution {
        public int mostBooked(int n, int[][] meetings) {
            PriorityQueue<int[]> occupied = new PriorityQueue<>( (a , b) -> a[1] - b[1]);
            PriorityQueue<Integer> free = new PriorityQueue<>();
            for(int i = 0; i< n; i++) free.add(i);

            PriorityQueue<int[]> delayed = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            for (int[] meeting : meetings) {
                delayed.add(new int[]{meeting[0], meeting[1] - meeting[0]});
            }

            int time = 0;
            int[] result = new int[n];

            while(!delayed.isEmpty()){
                while(!occupied.isEmpty() && occupied.peek()[1] == time){
                    int space = occupied.poll()[0];
                    free.add(space);
                }

                while (!free.isEmpty() && !delayed.isEmpty() && delayed.peek()[0] <= time) {
                    int[] meeting = delayed.poll();
                    int room = free.poll();
                    occupied.add(new int[]{room, time + meeting[1]});
                    result[room]++;
                }

                if(free.isEmpty()){
                    assert occupied.peek() != null;
                    time = occupied.peek()[1];
                }
                else time++;
            }

            System.out.println(Arrays.toString(result));

            int maxMeetingCount = 0, maxMeetingCountRoom = 0;
            for (int i = 0; i < n; i++) {
                if (result[i] > maxMeetingCount) {
                    maxMeetingCount = result[i];
                    maxMeetingCountRoom = i;
                }
            }

            return maxMeetingCountRoom;
        }
    }

}
//                System.out.println(free);
//                for(int[] a: occupied){
//                    System.out.print(Arrays.toString(a));
//                }
//                System.out.println();
//                for(int[] a: delayed){
//                    System.out.print(Arrays.toString(a));
//                }
//                System.out.println(time + "\n");