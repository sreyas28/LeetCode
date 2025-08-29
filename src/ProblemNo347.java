import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ProblemNo347 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> frequencies = new HashMap<>();
            for(int i: nums){
                frequencies.put(i, frequencies.getOrDefault(i,0)+1);
            }

            PriorityQueue<Integer> sorted = new PriorityQueue<>(
                    (a,b) -> frequencies.get(a) - frequencies.get(b)
            );

            for(int key:  frequencies.keySet()){
                sorted.add(key);
                if(sorted.size() > k) sorted.poll();
            }

            int[] result = new int[k];
            for(int i=k-1; i >= 0; i--){
                result[i] = sorted.poll();
            }

            return result;
        }
    }
}


//public int[] topKFrequent(int[] nums, int k) {
//    HashMap<Integer, Integer> frequencies = new HashMap<>();
//    for(int i: nums){
//        frequencies.put(i, frequencies.getOrDefault(i,0)+1);
//    }
//
//    TreeMap<Integer,Integer> sortedFrequencies = new TreeMap<>((a,b) -> {
//        int compare = frequencies.get(b).compareTo(frequencies.get(a));
//        return compare == 0 ? b.compareTo(a) : compare;
//    });
//    sortedFrequencies.putAll(frequencies);
//
//
//    int[] result = new int[k];
//
//    int ite = 0;
//    for(int key: sortedFrequencies.keySet()){
//        if(ite < k) result[ite++] = key;
//        else break;
//    }
//
//    return result;
//}
