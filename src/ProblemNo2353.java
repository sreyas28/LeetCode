import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ProblemNo2353 {
    public static void main(String[] args) {

    }

    class FoodRatings {
        static class Food{
            String Name;
            String Cuisine;
            int Rating;

            Food(String Name, String Cuisine, int Rating){
                this.Name = Name;
                this.Cuisine = Cuisine;
                this.Rating = Rating;
            }
        }

        private Map<String, Food> foodMap;
        private Map<String, PriorityQueue<Food>> cuisineMaxHeap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodMap = new HashMap<>();
            cuisineMaxHeap = new HashMap<>();

            for(int i=0; i<foods.length; i++){
                Food foo = new Food(foods[i],cuisines[i], ratings[i]);
                foodMap.put(foods[i],foo);

                cuisineMaxHeap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>( (a,b) -> {
                    if (b.Rating != a.Rating) return b.Rating - a.Rating;
                    return a.Name.compareTo(b.Name); // Lexicographical order
                }) ).add(foo);
            }
        }

        public void changeRating(String food, int newRating) {
            Food oldFood = foodMap.get(food);
            Food updatedFood = new Food(food, oldFood.Cuisine, newRating);

            foodMap.put(food, updatedFood);
            cuisineMaxHeap.get(oldFood.Cuisine).add(updatedFood);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> pq = cuisineMaxHeap.get(cuisine);

            while (!pq.isEmpty()) {
                Food top = pq.peek();
                Food current = foodMap.get(top.Name);

                if (top.Rating == current.Rating) {
                    return top.Name;
                } else {
                    pq.poll(); // Remove stale entry
                }
            }

            return ""; // Shouldn't happen if data is consistent
        }
    }

    class FoodRatings__ {
        Map<String, Map<String, Integer>> cuisineFoodRating;
        Map<String, String> foodCuisine;
        Map<String, String> cuisineToHighestFood;

        public FoodRatings__(String[] foods, String[] cuisines, int[] ratings) {

            cuisineFoodRating = new HashMap<>();
            foodCuisine = new HashMap<>();
            cuisineToHighestFood = new HashMap<>();

            for(int i = 0; i < foods.length; i++){

                String food = foods[i];
                String cuisine = cuisines[i];
                int rate = ratings[i];

                cuisineFoodRating.computeIfAbsent(cuisine, k -> new HashMap<>()).put(food, rate);
                foodCuisine.put(food, cuisine);

                String currentHighestFood = cuisineToHighestFood.getOrDefault(cuisine, "");
                int currentHighestRating = cuisineFoodRating.get(cuisine).getOrDefault(currentHighestFood, Integer.MIN_VALUE);

                if(rate > currentHighestRating || (rate == currentHighestRating && food.compareTo(currentHighestFood) < 0)){
                    cuisineToHighestFood.put(cuisine, food);
                }
            }

        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodCuisine.get(food);
            cuisineFoodRating.get(cuisine).put(food, newRating); //adding new Rating

            String currentHighestFood = cuisineToHighestFood.get(cuisine);
            int currentHighestRating = cuisineFoodRating.get(cuisine).get(currentHighestFood);

            if(newRating > currentHighestRating || (newRating == currentHighestRating && food.compareTo(currentHighestFood) < 0)){
                cuisineToHighestFood.put(cuisine, food);
            }

            else if(food.equals(currentHighestFood)){
                String newHighestFood = "";
                int maxRating = Integer.MIN_VALUE;

                for (Map.Entry<String, Integer> entry : cuisineFoodRating.get(cuisine).entrySet()) {
                    String candidateFood = entry.getKey();
                    int rating = entry.getValue();

                    if (rating > maxRating ||
                            (rating == maxRating && candidateFood.compareTo(newHighestFood) < 0)) {
                        newHighestFood = candidateFood;
                        maxRating = rating;
                    }
                }

                cuisineToHighestFood.put(cuisine, newHighestFood);
            }
        }

        public String highestRated(String cuisine) {
            return cuisineToHighestFood.get(cuisine);
        }
    }
    class FoodRatings_ {

        Map<String, Map<String, Integer>> cuisineFoodRating;
        Map<String, String> foodCuisine;

        public FoodRatings_(String[] foods, String[] cuisines, int[] ratings) {
            cuisineFoodRating = new HashMap<>();
            foodCuisine = new HashMap<>();

            for(int i = 0; i < foods.length; i++){
                if(cuisineFoodRating.containsKey(cuisines[i])){
                    cuisineFoodRating.get(cuisines[i]).put(foods[i], ratings[i]);
                }

                else{
                    cuisineFoodRating.put(cuisines[i], new HashMap<>());
                    cuisineFoodRating.get(cuisines[i]).put(foods[i], ratings[i]);
                }

                foodCuisine.put(foods[i], cuisines[i]);
            }

        }

        public void changeRating(String food, int newRating) {
            String Cuisine = foodCuisine.get(food);
            cuisineFoodRating.get(Cuisine).put(food, newRating);
        }

        public String highestRated(String cuisine) {

            Map<String, Integer> foodRating =  cuisineFoodRating.get(cuisine);

            String food = "";
            int Max = 0;

            for(String foo: foodRating.keySet()){
                int rating = foodRating.get(foo);
                if(rating > Max || (rating == Max && foo.compareTo(food) < 0)){
                    food = foo;
                    Max = rating;
                }
            }

            return food;
        }
    }

}
