class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        List<String> distinctList = new ArrayList<>();

        // First pass: Count occurrences
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Second pass: Store distinct elements in order
        for (String str : arr) {
            if (frequencyMap.get(str) == 1) { // Only add distinct elements
                distinctList.add(str);
            }
        }

        // Return k-th distinct element if it exists
        return (k <= distinctList.size()) ? distinctList.get(k - 1) : "";
    }
}