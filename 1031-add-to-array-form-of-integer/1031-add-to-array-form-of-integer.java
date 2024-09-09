class Solution {
    // Function to reverse the digits of a number
    int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
    
    public List<Integer> addToArrayForm(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = k;
        int n = nums.length;
        
        for (int i = n - 1; i >= 0; i--) {
            int sum = nums[i] + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }
        
        while (carry > 0) {
            result.add(carry % 10);
            carry /= 10;
        }
        
        Collections.reverse(result);
        return result;
    }
}