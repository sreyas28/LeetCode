public class ProblemNo2833 {
    class Solution {
        public int furthestDistanceFromOrigin(String moves) {

            int countL = 0, countR = 0, count_ = 0;

            for(char c: moves.toCharArray()) {
                switch(c){
                    case 'L':
                        countL++;
                        break;
                    case 'R':
                        countR++;
                        break;
                    case '_':
                        count_++;
                        break;
                }
            }

            if (countL >= countR) return (countL + count_) - countR;
            else return (countR + count_) - countL;
        }
    }
}
