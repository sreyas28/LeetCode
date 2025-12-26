import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProblemNo2402 {
    public static void main(String[] args) {

        ProblemNo2402.Solution a = new ProblemNo2402().new Solution();
        System.out.println(a.mostBooked(2, new int[][] {{0,10},{1,5},{2,7},{3,4}} ));
        System.out.println(a.mostBooked(3, new int[][] {{1,20},{2,10},{3,5},{4,9},{6,8}} ));
        System.out.println(a.mostBooked(4, new int[][] {{18,19},{3,12},{17,19},{2,13},{7,10}} ));

    }

    class Solution {
        public int mostBooked(int n, int[][] meetings) {
            Arrays.sort(meetings, (a,b)->a[0]-b[0]);
            int[] rooms = new int[n];
            PriorityQueue<Integer> unused = new PriorityQueue<>();
            PriorityQueue<int[]> occupiedRooms = new PriorityQueue<>( (a,b) -> {
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });

            for(int i=0;i<n;i++) unused.add(i); // adding unused rooms

            for(int[] meeting:meetings){
                // checking if rooms are free for the new meeting
                while(!occupiedRooms.isEmpty()){
                    if(meeting[0] >= occupiedRooms.peek()[1]){
                        unused.offer(occupiedRooms.poll()[0]);
                    }
                    else break;
                }

                if(!unused.isEmpty()) {
                    int room = unused.poll();
                    rooms[room]++;
                    occupiedRooms.offer(new int[]{room, meeting[1]});
                }
                else {
                    int[] curr = occupiedRooms.poll();
                    rooms[curr[0]]++;

                    if(curr[1] >= meeting[0]) curr[1] += meeting[1] - meeting[0];
                    else curr[1] = meeting[1];

                    occupiedRooms.offer(curr);
                }
            }

//            System.out.println(Arrays.toString(rooms));

            int maxMeetsRoom = 0, maxMeets = Integer.MIN_VALUE;
            for(int room=0; room<n;room++){
                if(rooms[room]>maxMeets){
                    maxMeets = rooms[room];
                    maxMeetsRoom = room;
                }
            }

            return maxMeetsRoom;
        }
    }

    class Solution_ {
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