import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.HashMap;
import java.util.Map;

public class ProblemNo3202 {
    public static void main(String[] args) {

        ProblemNo3202.Solution a = new ProblemNo3202().new Solution();
        System.out.println(a.maximumLength(new int[]{1,4,2,3,1,4}, 3));
    }

    class Solution {
        public int maximumLength(int[] nums, int k) {
            int[][] map = new int[k][k];
            int res = 0;
            for(int num: nums){
                num %= k;

                for(int i = 0; i< k; i++){
                    map[i][num] = map[num][i] + 1;
                    res = Math.max(res,map[i][num]);
                }
            }
            return res;
        }
    }

}

//brute force

//
//private int[] numbers;
//private int divider;
//private int[][][] map;
//
//public int maximumLength(int[] nums, int k) {
//    int len = nums.length;
//    map = new int[len+1][len+1][k];
//
//    numbers = nums;
//    divider = k;
//
//    int result = 0;
//    for(int i = 0; i < k; i++){
//        result = Math.max(result, dfs(0, len, i));
//        if(result == len) break;
//    }
//
//    return result;
//}
//
//private int dfs(int index, int prevIndex, int targetValue){
//    if (index >= numbers.length) return 0;
//    if(map[index][prevIndex][targetValue] != 0) return map[index][prevIndex][targetValue];
//
//    int a, b;
//    if(prevIndex == numbers.length){
//        a = dfs(index + 1, index, targetValue) + 1;
//    }
//    else{
//        int temp = ((numbers[index] % divider) + (numbers[prevIndex] % divider)) % divider;
//        if( temp == targetValue) a = dfs(index + 1, index, targetValue) + 1;
//        else a = 0;
//    }
//    b = dfs(index + 1, prevIndex, targetValue);
//    map[index][prevIndex][targetValue] = Math.max(a, b);
//
//    return map[index][prevIndex][targetValue];
//}
