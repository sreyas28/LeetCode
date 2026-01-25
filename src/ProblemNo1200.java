import java.util.*;

public class ProblemNo1200 {
    public static void main(String[] args) {

    }

    class Solution_ {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Map<Integer, List<List<Integer>>> map = new TreeMap<>();

            Arrays.sort(arr);
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] < arr[i+1]){
                    int diff =  arr[i+1] - arr[i];

                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[i+1]);
                    map.computeIfAbsent(diff, a -> new ArrayList<>()).add(list);
                }
            }

            for(int key : map.keySet()){
                return map.get(key);
            }

            return null;
        }
    }

    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<List<Integer>> ans = new ArrayList<>();
            int mn = Integer.MAX_VALUE;

            Arrays.sort(arr);

            for (int i = 1; i < arr.length; ++i) {
                final int diff = arr[i] - arr[i - 1];
                if (diff < mn) {
                    mn = diff;
                    ans.clear();
                }
                if (diff == mn)
                    ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }

            return ans;
        }
    }

}
