import java.util.ArrayList;

public class ProblemNo3304 {
    public static void main(String[] args) {

        ProblemNo3304.Solution a = new ProblemNo3304().new Solution();

        System.out.println(a.kthCharacter(500));

    }

    class Solution {
        public char kthCharacter(int k) {
            StringBuilder list = new StringBuilder();
            list.append('a');

            while(list.length() < k){
                StringBuilder temp = new StringBuilder();

                for(char c: list.toString().toCharArray()){
                    int val = (((int) c + 1) - 'a') % 26;
                    temp.append((char) (val + 'a'));
                }
                list.append(temp);
                System.out.println(list);
            }


            return list.charAt(k-1);
        }
    }

}
