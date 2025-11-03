public class ProblemNo1578 {
    public static void main(String[] args) {

        ProblemNo1578.Solution a = new ProblemNo1578(). new Solution();
        System.out.println(a.minCost("aabaa", new int[]{1,2,3,4,1}));

    }

    class Solution {
        public int minCost(String colors, int[] neededTime) {

            char last = colors.charAt(0);
            int resultSum = 0;
            int sum = neededTime[0], lastMax = neededTime[0];

            for(int i=1; i < colors.length(); i++){

                if(colors.charAt(i) == last){
                    sum += neededTime[i];
                    lastMax = Math.max(lastMax, neededTime[i]);
                }

                else{
                    last = colors.charAt(i);
                    resultSum += (sum - lastMax);
                    lastMax = sum = neededTime[i];
                }
            }

            resultSum += (sum - lastMax);

            return resultSum;
        }
    }

}
