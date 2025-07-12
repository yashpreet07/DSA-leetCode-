import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        // Define keyboard rows as sets for fast lookup
        Set<Character> row1 = new HashSet<>(Arrays.asList(
            'q','w','e','r','t','y','u','i','o','p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList(
            'a','s','d','f','g','h','j','k','l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList(
            'z','x','c','v','b','n','m'));
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            Set<Character> currentRow = null;
            
            // Determine which row the first character belongs to
            char firstChar = lowerWord.charAt(0);
            if (row1.contains(firstChar)) {
                currentRow = row1;
            } else if (row2.contains(firstChar)) {
                currentRow = row2;
            } else if (row3.contains(firstChar)) {
                currentRow = row3;
            }
            
            boolean isValid = true;
            for (char c : lowerWord.toCharArray()) {
                if (!currentRow.contains(c)) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result.add(word); // Add original word
            }
        }
        
        return result.toArray(new String[0]);
    }
}