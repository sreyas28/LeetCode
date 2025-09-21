import java.util.*;

public class ProblemNo3508 {
    public static void main(String[] args) {

    }

    class Router {
        private final LinkedHashMap<String, int[]> ordered;       // key -> packet, preserves insertion order
        private final HashMap<Integer, ArrayList<Integer>> destTimes; // dest -> list of timestamps (increasing)
        private final HashMap<Integer, Integer> destHead;         // dest -> first valid index in destTimes.get(dest)
        private final int memoryLimit;
        private static final int[] EMPTY_PACKET = new int[]{};

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            this.ordered = new LinkedHashMap<>();
            this.destTimes = new HashMap<>();
            this.destHead = new HashMap<>();
        }

        private String keyOf(int s, int d, int t) {
            return s + "-" + d + "-" + t;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            String key = keyOf(source, destination, timestamp);
            if (ordered.containsKey(key)) return false;

            // Evict oldest if at capacity
            if (ordered.size() >= memoryLimit) {
                Iterator<Map.Entry<String, int[]>> it = ordered.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<String, int[]> oldest = it.next();
                    int[] oldPkt = oldest.getValue();
                    it.remove(); // removes oldest from ordered

                    int oldDest = oldPkt[1];
                    int oldTs = oldPkt[2];
                    ArrayList<Integer> list = destTimes.get(oldDest);
                    if (list != null) {
                        int head = destHead.getOrDefault(oldDest, 0);
                        // Common case: head points to the oldest timestamp for that destination
                        if (head < list.size() && list.get(head) == oldTs) {
                            destHead.put(oldDest, head + 1);
                            if (destHead.get(oldDest) >= list.size()) {
                                destTimes.remove(oldDest);
                                destHead.remove(oldDest);
                            }
                        } else {
                            // Rare fallback: find exact timestamp and advance head to index+1
                            for (int i = head; i < list.size(); i++) {
                                if (list.get(i) == oldTs) {
                                    destHead.put(oldDest, i + 1);
                                    if (destHead.get(oldDest) >= list.size()) {
                                        destTimes.remove(oldDest);
                                        destHead.remove(oldDest);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            // Insert new packet
            int[] packet = new int[] { source, destination, timestamp };
            ordered.put(key, packet);

            ArrayList<Integer> times = destTimes.computeIfAbsent(destination, k -> new ArrayList<>());
            times.add(timestamp);
            destHead.putIfAbsent(destination, 0);

            return true;
        }

        public int[] forwardPacket() {
            Iterator<Map.Entry<String, int[]>> it = ordered.entrySet().iterator();
            if (!it.hasNext()) return EMPTY_PACKET;

            Map.Entry<String, int[]> ent = it.next();
            it.remove();
            int[] pkt = ent.getValue();

            int dest = pkt[1];
            int ts = pkt[2];
            ArrayList<Integer> list = destTimes.get(dest);
            if (list != null) {
                int head = destHead.getOrDefault(dest, 0);
                if (head < list.size() && list.get(head) == ts) {
                    destHead.put(dest, head + 1);
                    if (destHead.get(dest) >= list.size()) {
                        destTimes.remove(dest);
                        destHead.remove(dest);
                    }
                } else {
                    for (int i = head; i < list.size(); i++) {
                        if (list.get(i) == ts) {
                            destHead.put(dest, i + 1);
                            if (destHead.get(dest) >= list.size()) {
                                destTimes.remove(dest);
                                destHead.remove(dest);
                            }
                            break;
                        }
                    }
                }
            }

            return pkt;
        }

        public int getCount(int destination, int startTime, int endTime) {
            ArrayList<Integer> list = destTimes.get(destination);
            if (list == null) return 0;
            int head = destHead.getOrDefault(destination, 0);
            int n = list.size();
            if (head >= n) return 0;

            int left = lowerBound(list, head, n - 1, startTime);
            if (left == -1) return 0;
            int right = upperBound(list, left, n - 1, endTime);
            if (right == -1 || right < left) return 0;
            return right - left + 1;
        }

        // returns first index in [l..r] with value >= target, or -1 if none
        private int lowerBound(ArrayList<Integer> arr, int l, int r, int target) {
            int res = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr.get(mid) >= target) {
                    res = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return res;
        }

        // returns last index in [l..r] with value <= target, or -1 if none
        private int upperBound(ArrayList<Integer> arr, int l, int r, int target) {
            int res = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr.get(mid) <= target) {
                    res = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return res;
        }
    }

    class Router__ {

        private final LinkedHashMap<String, int[]> sourceDestinationTimestamp;
        private final HashMap<Integer, LinkedList<int[]>> destinationMap;
        private static final int[] EMPTY_PACKET = new int[]{};
        private final int memoryLimit;


        public Router__(int memoryLimit) {
            this.sourceDestinationTimestamp = new LinkedHashMap<>();
            this.destinationMap = new HashMap<>();
            this.memoryLimit = memoryLimit;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            int[] packet = {source, destination, timestamp};
            String key = getKey(packet);

            if(sourceDestinationTimestamp.containsKey(key)) return false;

            if(sourceDestinationTimestamp.size() >= memoryLimit){
                int[] value = sourceDestinationTimestamp.firstEntry().getValue();
                String rmvKey = sourceDestinationTimestamp.firstEntry().getKey();
                sourceDestinationTimestamp.remove(rmvKey);
                destinationMap.get(value[1]).removeIf((p) -> p[0] == value[0] && p[1] == value[1] && p[2] == value[2]);
            }

            sourceDestinationTimestamp.put(key, packet);
            destinationMap.computeIfAbsent(destination, (k) -> new LinkedList<>()).add(packet);

            return true;
        }

        public int[] forwardPacket() {
            if(sourceDestinationTimestamp.isEmpty()) return EMPTY_PACKET;

            int[] value = sourceDestinationTimestamp.firstEntry().getValue();
            String key = sourceDestinationTimestamp.firstEntry().getKey();
            sourceDestinationTimestamp.remove(key);

            destinationMap.get(value[1]).removeIf((p) -> p[0] == value[0] && p[1] == value[1] && p[2] == value[2]);

            return value;
        }

        public int getCount(int destination, int startTime, int endTime) {
            LinkedList<int[]> list = destinationMap.get(destination);
            if (list == null) return 0;

            int count = 0;
            for (int[] packet : list) {
                if (packet[2] < startTime) continue;
                if (packet[2] > endTime) break;
                count++;
            }

            return count;
        }

        private String getKey(int[] packet){
            return packet[0] +"-"+ packet[1] +"-"+ packet[2];
        }
    }

    class Router_ {
        private final Queue<int[]> sourceDestinationTimestamp;
        private final Set<String> packetSet;
        private final Map<Integer, LinkedList<int[]>> destinationMap;
        private final int memoryLimit;

        private static final int[] EMPTY_PACKET = new int[]{};

        public Router_(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            this.sourceDestinationTimestamp = new LinkedList<>();
            this.destinationMap = new HashMap<>();
            this.packetSet = new HashSet<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            int[] packet = {source, destination, timestamp};
            String key = getKey(packet);

            if(packetSet.contains(key)) return false;
            if(sourceDestinationTimestamp.size() >= memoryLimit) {
                int[] rmv = sourceDestinationTimestamp.poll();
                String rmvKey = getKey(rmv);
                packetSet.remove(rmvKey);

                LinkedList<int[]> list = destinationMap.get(rmv[1]);
                if(list != null) list.removeFirst();
            }

            sourceDestinationTimestamp.offer(packet);
            packetSet.add(key);
            destinationMap.computeIfAbsent(destination, (k) -> new LinkedList<>()).add(packet);
            return true;
        }

        public int[] forwardPacket() {
            if(sourceDestinationTimestamp.isEmpty()) return EMPTY_PACKET;

            int[] rmv = sourceDestinationTimestamp.poll();
            String rmvKey = getKey(rmv);
            packetSet.remove(rmvKey);

            LinkedList<int[]> list = destinationMap.get(rmv[1]);
            if(list != null) list.removeFirst();

            return rmv;
        }

        public int getCount(int destination, int startTime, int endTime) {
            LinkedList<int[]> list = destinationMap.get(destination);
            if (list == null) return 0;

            int count = 0;
            for (int[] packet : list) {
                if (packet[2] < startTime) continue;
                if (packet[2] > endTime) break;
                count++;
            }

            return count;
        }

        private String getKey(int[] packet){
            return packet[0] +"-"+ packet[1] +"-"+ packet[2];
        }
    }

}
