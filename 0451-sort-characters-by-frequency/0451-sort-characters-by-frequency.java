class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Sort characters by frequency (Descending order)
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((a, b) -> b.getValue() - a.getValue()); // Sort by frequency

        // Step 3: Build the sorted string
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return sb.toString();
    }
}