import javax.swing.event.ListDataEvent;
import java.util.*;
import java.util.stream.Stream;

public class ProblemNo3606 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
            List<String> electronics = new ArrayList<>();
            List<String> grocery = new ArrayList<>();
            List<String> pharmacy = new ArrayList<>();
            List<String> restaurant = new ArrayList<>();

            Set<String> businessLines = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));

            for(int i=0; i<code.length; i++){
                String b = businessLine[i];
                if(businessLines.contains(b) && isActive[i] && codeCorrect(code[i])) {
                    switch (b) {
                        case "electronics" -> electronics.add(code[i]);
                        case "grocery" -> grocery.add(code[i]);
                        case "pharmacy" -> pharmacy.add(code[i]);
                        case "restaurant" -> restaurant.add(code[i]);
                    }
                }
            }

            electronics.sort(String::compareTo);
            grocery.sort(String::compareTo);
            pharmacy.sort(String::compareTo);
            restaurant.sort(String::compareTo);

            List<String> result = new ArrayList<>();

            result.addAll(electronics);
            result.addAll(grocery);
            result.addAll(pharmacy);
            result.addAll(restaurant);

            return result;
        }

        private boolean codeCorrect(String code){
            if(code.isEmpty()) return false;

            for(char c: code.toCharArray()){
                if(!(Character.isDigit(c) || Character.isAlphabetic(c) || c == '_')) return false;
            }
            return true;
        }
    }

}
