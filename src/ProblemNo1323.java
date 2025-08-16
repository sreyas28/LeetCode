import java.util.ArrayList;
import java.util.List;

public class ProblemNo1323 {
    public static void main(String[] args) {

        ProblemNo1323.Solution a = new ProblemNo1323().new Solution();
        System.out.println(a.maximum69Number(669));

    }

    class Solution {
        public int maximum69Number (int num) {
            int result = 0;
            List<Integer> number = new ArrayList<>();
            while(num != 0){
                number.add(num%10);
                num /= 10;
            }
            number = number.reversed();

            boolean done = false;
            for(int i: number){
                if(!done && i == 6){
                    result = result*10 + 9;
                    done = true;
                }
                else{
                    result = result*10 + i;
                }
            }

            return result;
        }
    }

}
