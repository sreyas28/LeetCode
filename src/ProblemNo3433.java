import java.util.*;

public class ProblemNo3433 {
    public static void main(String[] args) {
        List<List<String>> x = new ArrayList<>();
        x.add(Arrays.asList("MESSAGE", "5", "HERE"));
        x.add(Arrays.asList("OFFLINE", "10", "0"));
        x.add(Arrays.asList("MESSAGE", "15", "HERE"));
        x.add(Arrays.asList("OFFLINE", "18", "2"));
        x.add(Arrays.asList("MESSAGE", "20", "HERE"));


        ProblemNo3433.Solution a = new ProblemNo3433().new Solution();
        System.out.println(Arrays.toString(a.countMentions(3, x)));
    }

    class Solution {
        public int[] countMentions(int numberOfUsers, List<List<String>> events) {
            events.sort((a, b) -> {
                int x = Integer.parseInt(a.get(1));
                int y = Integer.parseInt(b.get(1));
                if(x == y) return b.get(0).compareTo(a.get(0));
                return x - y;
            });

            int[] result = new int[numberOfUsers];
            int[] offline = new int[numberOfUsers];

            System.out.println(events);

            for(List<String> event: events){
                String eve = event.get(0);
                int timeStamp = Integer.parseInt(event.get(1));
                String[] users = event.get(2).split(" ");

                if(eve.equals("MESSAGE")){
                    if(users[0].equals("ALL")){
                        for(int i=0; i<numberOfUsers; i++) result[i]++;
                    }

                    else if(users[0].equals("HERE")){
                        for(int i=0; i<numberOfUsers; i++) {
                            if(offline[i] <= timeStamp) result[i]++;
                        }
                    }

                    else{
                        for(String s: users){
                            int index = Integer.parseInt(s.substring(2));
                            result[index]++;
                        }
                    }
                }

                else{
                    int index = Integer.parseInt(users[0]);
                    offline[index] = timeStamp+60;
                }
            }

            return result;
        }
    }

}
