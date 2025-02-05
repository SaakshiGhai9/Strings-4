// Time Complexity O(n log n) because of sorting
// Space complexity: O(n)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReOrderLogFiles {
    public static String [] reorderFiles( String [] logs){

        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for( String log : logs){
            String [] parts = log.split(" " , 2); // split the string by identifier and the content
            if(Character.isDigit(parts[1].charAt(0))){  // if character at 0th position of parts[1] is a digit add it to digit logs
                digitLogs.add(log);
            } else{                                      // else add to letter logs
                letterLogs.add(log);
            }
        }

        // Sort  the letter logs first by comparing content then if content is same compare identifier
        letterLogs.sort((log1, log2) -> {
            String [] parts1 = log1.split (" ",2);
            String [] parts2 = log2.split(" ", 2);

            int cmp = parts1[1].compareTo(parts2[1]); // compare the contents of the letter log

            if( cmp != 0) {
                return cmp;  // if the contents are equal

            }
            return parts1[0].compareTo(parts2[0]); // comapre the identifier
        });

        letterLogs.addAll(digitLogs);
       return letterLogs.toArray(new String [0]);
    }

    public static void main ( String [] args){
        String[] logs = {
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };

        System.out.println(Arrays.toString(reorderFiles(logs)));
    }

}
