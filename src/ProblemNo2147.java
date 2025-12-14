import java.util.*;

public class ProblemNo2147 {
    public static void main(String[] args) {

        ProblemNo2147.Solution a = new ProblemNo2147().new Solution();
        System.out.println(a.numberOfWays("SPSPPSSPSSSS"));

    }

    class Solution {
        public int numberOfWays(String corridor) {
            final int MOD = (int) 1e9+7;

            List<Integer> seats = new ArrayList<>();

            for(int i=0; i<corridor.length(); i++){
                if(corridor.charAt(i) == 'S') seats.add(i);
            }

            int result = 0;
            if(seats.size() % 2 == 0 && !seats.isEmpty()){
                result = 1;
                for(int i = 2; i < seats.size(); i += 2){
                    result =(int) (((long) result * (seats.get(i)-seats.get(i-1))) % MOD);
                }
            }

            return result;
        }
    }

}
