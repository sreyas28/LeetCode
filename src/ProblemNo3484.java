import java.util.*;

public class ProblemNo3484 {
    public static void main(String[] args) {

        ProblemNo3484.Spreadsheet a = new ProblemNo3484().new Spreadsheet(3);

        a.setCell("A1", 4);
        System.out.println(a.getValue("=A1+6"));
    }

    class Spreadsheet {
        private final Set<Character> alphabets;
        private final Map<Character, int[]> spreadSheet;

        public Spreadsheet(int rows) {
            alphabets = new HashSet<>();
            spreadSheet = new HashMap<>();
            for(char a = 'A'; a <= 'Z'; a++){
                spreadSheet.put(a, new int[rows+1]);
                alphabets.add(a);
            }
        }

        public void setCell(String cell, int value) {
            char col = cell.charAt(0);
            int row = Integer.parseInt(cell.substring(1));

            spreadSheet.get(col)[row] = value;
        }

        public void resetCell(String cell) {
            char col = cell.charAt(0);
            int row = Integer.parseInt(cell.substring(1));

            spreadSheet.get(col)[row] = 0;
        }

        public int getValue(String formula) {
            String[] values = formula.substring(1).split("\\+");

            int val_1 = 0, val_2 = 0;

            if(alphabets.contains( values[0].charAt(0)) ){
                char col = values[0].charAt(0);
                int row = Integer.parseInt(values[0].substring(1));

                val_1 = spreadSheet.get(col)[row];
            }
            else val_1 = Integer.parseInt(values[0]);

            if(alphabets.contains( values[1].charAt(0)) ){
                char col = values[1].charAt(0);
                int row = Integer.parseInt(values[1].substring(1));

                val_2 = spreadSheet.get(col)[row];
            }
            else val_2 = Integer.parseInt(values[1]);

            return val_1+val_2;
        }
    }

}
