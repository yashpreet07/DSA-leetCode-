class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        String[] words = text.split(" ");  // Split the input text into words
        
        for (String word : words) {
            boolean canType = true;
            
            // Check if any letter in the word is present in brokenLetters
            for (char ch : word.toCharArray()) {
                if (brokenLetters.indexOf(ch) != -1) {
                    canType = false;
                    break;
                }
            }
            
            if (canType) {
                count++;
            }
        }
        
        return count;
    }
}