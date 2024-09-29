class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;  // Handle special cases
        
        int left = 1, right = x / 2;
        int result = 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;  // Avoid overflow
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                result = mid;  // mid is a candidate
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }/*
    Explanation:

	•	Initial check for 0 and 1: Since the square root of 0 is 0 and of 1 is 1, these are handled directly.
	•	Binary Search:
	•	We search for the integer square root in the range [1, x / 2] because any number greater than x / 2 would have a square greater than x.
	•	We compute mid * mid and compare it with x:
	•	If it’s equal, return mid.
	•	If it’s smaller, move the left pointer to search the right half and keep track of mid as a potential result.
	•	If it’s larger, move the right pointer to search the left half.
	•	The result is the largest mid where mid * mid is less than or equal to x.

Time Complexity:

	•	O(log x): The binary search reduces the search space by half each time, making the time complexity logarithmic.

This approach works efficiently even for large values of x, and ensures we avoid overflow by using long when multiplying mid * mid.
    */
}

// your code..... Wrong!!
// class Solution {
//     public int mySqrt(int x) {
//         int sqrt = 1;
//         int i = 2;
//         while(i < x)
//         {
//             sqrt = i;
//             i *= i;
//         }
//     return sqrt;}
// }