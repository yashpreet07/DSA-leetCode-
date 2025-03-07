class Solution {
    public int[] closestPrimes(int left, int right) {
        // Step 1: Use Sieve of Eratosthenes to find all primes up to 'right'
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int num = 2; num * num <= right; num++) {
            if (isPrime[num]) {
                for (int multiple = num * num; multiple <= right; multiple += num) {
                    isPrime[multiple] = false;
                }
            }
        }

        // Step 2: Collect prime numbers in the range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 3: Find the closest prime pair
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int[] minPair = new int[]{-1, -1};

        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                minPair[0] = primes.get(i);
                minPair[1] = primes.get(i + 1);
            }
        }

        return minPair;
    }
}
