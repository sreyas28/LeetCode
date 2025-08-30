public class ProblemNo706 {
    public static void main(String[] args) {

    }

    class MyHashMap {
        int[] keysValues;
        public MyHashMap() {
            this.keysValues = new int[1000001];
        }

        public void put(int key, int value) {
            keysValues[key] = value+1;
        }

        public int get(int key) {
            return keysValues[key]-1;
        }

        public void remove(int key) {
            keysValues[key] = 0;
        }
    }

}
