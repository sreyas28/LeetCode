import java.util.*;

public class ProblemNo1912 {
    public static void main(String[] args) {

    }

    class MovieRentingSystem {

        static class Entry {
            final int shop;
            final int movie;
            final int price;

            Entry(int shop, int movie, int price) {
                this.shop = shop;
                this.movie = movie;
                this.price = price;
            }

            // equality based on shop + movie so we can remove the exact entry from sets
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Entry)) return false;
                Entry e = (Entry) o;
                return shop == e.shop && movie == e.movie;
            }

            @Override
            public int hashCode() {
                return Objects.hash(shop, movie);
            }
        }

        private final Map<Integer, TreeSet<Entry>> available;
        private final TreeSet<Entry> rented;
        private final Map<String, Entry> ref;

        public MovieRentingSystem(int n, int[][] entries) {
            available   = new HashMap<>();
            ref = new HashMap<>();

            rented = new TreeSet<>((a, b) ->  {
                if(a.price != b.price) return a.price - b.price;
                if(a.shop != b.shop) return a.shop - b.shop;
                return a.movie - b.movie;
            });

            for(int[] e: entries){
                Entry entry = new Entry(e[0], e[1], e[2]);

                ref.put(key(e[0], e[1]), entry);
                available.computeIfAbsent(e[1], k -> new TreeSet<>((a, b) -> {
                    if (a.price != b.price) return a.price - b.price;
                    return a.shop - b.shop;
                }
                )).add(entry);
            }

        }

        private String key(int shop, int movie) {
            return shop + "-" + movie;
        }


        public List<Integer> search(int movie) {
            List<Integer> ans = new ArrayList<>();
            TreeSet<Entry> set = available.get(movie);
            if (set == null) return ans;
            int cnt = 0;
            for (Entry e : set) {
                ans.add(e.shop);
                if (++cnt == 5) break;
            }
            return ans;
        }

        public void rent(int shop, int movie) {
            Entry e = ref.get(key(shop, movie));
            TreeSet<Entry> set = available.get(movie);
            if (set != null) set.remove(e);
            rented.add(e);
        }

        public void drop(int shop, int movie) {
            Entry e = ref.get(key(shop, movie));
            rented.remove(e);
            available.computeIfAbsent(movie, k -> {
                // should use same comparator as constructor
                return new TreeSet<>((a, b) -> {
                    if (a.price != b.price) return a.price - b.price;
                    return a.shop - b.shop;
                });
            }).add(e);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> ans = new ArrayList<>();
            int cnt = 0;
            for (Entry e : rented) {
                ans.add(Arrays.asList(e.shop, e.movie));
                if (++cnt == 5) break;
            }
            return ans;
        }
    }


    class MovieRentingSystem_ {
        static class Entry{
            int shop;
            int movie;
            int price;
            boolean rented;

            Entry(int shop, int movie, int price, boolean rented){
                this.shop = shop;
                this.movie = movie;
                this.price = price;
                this.rented = rented;
            }
        }

        private final HashMap<Integer, PriorityQueue<Entry>> movieToEntry;
        private final HashMap<String, Entry> reference;
        private final TreeSet<Entry> rented;

        public MovieRentingSystem_(int n, int[][] entries) {
            movieToEntry = new HashMap<>();
            reference = new HashMap<>();
            rented = new TreeSet<>((a, b) -> {
                if (a.price != b.price) return a.price - b.price;
                if (a.shop != b.shop) return a.shop - b.shop;
                return a.movie - b.movie;
            });

            for(int[] entry: entries){
                Entry entry1 = new Entry(entry[0],entry[1],entry[2], false);
                movieToEntry.computeIfAbsent(entry[1], (k) ->new PriorityQueue<>((a, b) -> {
                    if (a.rented != b.rented) return Boolean.compare(a.rented, b.rented); // false < true
                    if (a.price != b.price) return a.price - b.price;
                    return a.shop - b.shop;
                }
                )).offer(entry1);
                reference.put(get_Key(entry1.shop, entry1.movie), entry1);
            }
        }

        private String get_Key(int shop, int movie){
            return shop +"-"+ movie;
        }

        public List<Integer> search(int movie) {
            List<Integer> result = new ArrayList<>();
            List<Entry> temp = new ArrayList<>();
            PriorityQueue<Entry> ref = movieToEntry.get(movie);

            if (ref == null) return result;

            while(result.size() < 5 && !ref.isEmpty() ){
                Entry top = ref.peek();
                if(!top.rented) {
                    temp.add(top);
                    result.add(ref.poll().shop);
                }
                else break;
            }
            ref.addAll(temp);
            return result;
        }

        public void rent(int shop, int movie) {
            String key = get_Key(shop, movie);

            Entry ref = reference.get(key);
            movieToEntry.get(movie).remove(ref);
            ref.rented = true;
            movieToEntry.get(movie).offer(ref);

            rented.add(ref);
        }

        public void drop(int shop, int movie) {
            String key = get_Key(shop, movie);

            Entry ref = reference.get(key);
            rented.remove(ref);
            movieToEntry.get(movie).remove(ref);
            ref.rented = false;
            movieToEntry.get(movie).offer(ref);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> result = new ArrayList<>();

            for(Entry entry: rented){
                if(result.size() == 5) break;
                result.add(Arrays.asList(entry.shop, entry.movie));
            }

            return result;
        }

    }

}
