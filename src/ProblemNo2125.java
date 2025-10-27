public class ProblemNo2125 {
    public static void main(String[] args) {

        ProblemNo2125.Solution a = new ProblemNo2125().new Solution();
        System.out.println(a.numberOfBeams(new String[]{"011001","000000","010100","001000"}));

    }

    class Solution {
        public int numberOfBeams(String[] bank) {

            int[] bankRowOnes = new int[bank.length];

            for(int i=0; i< bank.length; i++){
                bankRowOnes[i] = ones(bank[i]);
            }

            int result = 0, previous = 0;
            for(int current: bankRowOnes){

                if(current == 0) continue;

                result += current * previous;
                previous = current;
            }

            return result;
        }

        private int ones(String row){
            int count = 0;
            for(char c: row.toCharArray()){
                if(c == '1') count++;
            }

            return count;
        }

    }

}
