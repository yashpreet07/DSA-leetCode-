class Solution {
    public double myPow(double x, int n) { 
        // Handle the case when n == Integer.MIN_VALUE
        if (n == Integer.MIN_VALUE) {
            // Perform one multiplication separately to avoid overflow
            return myPow(x, n + 1) / x;
        }
        
        if (n == 0) // base case
            return 1.0;
        
        // Handle negative powers
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        // Recursion with n divided by 2 (more efficient)
        double half = myPow(x, n / 2);
        
        // If n is even
        if (n % 2 == 0) {
            return half * half;
        } 
        // If n is odd
        else {
            return half * half * x;
        }
    }
}





// TLE 301 case passed out of 306.
// class Solution {
//     public double myPow(double x, int n) { 
//         if (n == 0) // base case
//             return 1.0;
        
//         // Handle negative powers
//         if (n < 0) {
//             x = 1 / x;
//             n = -n;
//         }
        
//         // Recursion with n divided by 2 (more efficient)
//         double half = myPow(x, n / 2);
        
//         // If n is even
//         if (n % 2 == 0) {
//             return half * half;
//         } 
//         // If n is odd
//         else {
//             return half * half * x;
//         }
//     }
// }
/*1. Decrementing n one by one:

If you decrement n by 1 in each recursive call, the number of recursive calls will be directly proportional to n. So, for an input n, the total number of recursive calls will be n itself.

	•	For example, if n = 1000, it will take 1000 recursive calls to reach n = 0.
	•	Time Complexity: O(n), where n is the exponent.

This is inefficient for large values of n, especially when n is very large (e.g., 1 million).

2. Dividing n by 2:

Instead of decrementing n one by one, dividing n by 2 in each step significantly reduces the number of recursive calls. Here’s why:

	•	Every time you divide n by 2, you’re reducing the problem size much more rapidly.
	•	The number of times you can divide n by 2 before it reaches 1 is approximately log2(n).
	•	For example, if n = 1000, the number of recursive calls will be around log2(1000) ≈ 10.

Thus, by dividing n by 2 in each step, the number of recursive calls drops from n to approximately log2(n), which is significantly smaller.

	•	Time Complexity: O(log n), where n is the exponent. */

