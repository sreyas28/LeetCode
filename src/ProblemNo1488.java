import java.util.*;

public class ProblemNo1488 {
    public static void main(String[] args) {
        ProblemNo1488.Solution a = new ProblemNo1488().new Solution();
        System.out.println(Arrays.toString(a.avoidFlood(new int[]{1,2,3,4})));
    }

    class Solution {
        public int[] avoidFlood(int[] rains) {
            int[] result = new int[rains.length];
            Arrays.fill(result, 1);

            Map<Integer, Integer> rainDay = new HashMap<>();
            TreeSet<Integer> dryDay = new TreeSet<>();

            for(int i = 0; i < rains.length; i++ ){

                if(rains[i] == 0) dryDay.add(i);
                else{
                    result[i] = -1;
                    if(rainDay.containsKey(rains[i])) {
                        Integer canGetDry = dryDay.ceiling(rainDay.get(rains[i]));
                        if(canGetDry == null) return new int[0];
                        result[canGetDry] = rains[i];
                        dryDay.remove(canGetDry);
                    }
                    rainDay.put(rains[i],i);
                }
            }

            return result;
        }
    }

}

//            for(int i=0; i<rains.length; i++){
//        if(rains[i] == 0) canDry.offer(i);
//                else {
//result[i] = -1;
//        if(gotFull.contains(rains[i])) {
//        if(!canDry.isEmpty()) {
//        gotFull.remove(rains[i]);
//result[canDry.poll()] = rains[i];
//        }
//        else return new int[]{};
//        }
//        else {
//        gotFull.add(rains[i]);
//                    }
//                            }
//                            }
