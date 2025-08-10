class Solution {
    public boolean reorderedPowerOf2(int n) {
        // Precompute sorted strings for powers of 2
        Set<String> powerOfTwoSet = new HashSet<>();
        for (int i = 0; i < 31; i++) { // 2^0 to 2^30 covers int range
            int power = 1 << i;
            powerOfTwoSet.add(sortDigits(power));
        }

        // Check if n matches any
        return powerOfTwoSet.contains(sortDigits(n));
    }

    String sortDigits(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}