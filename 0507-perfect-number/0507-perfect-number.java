// Your Code w/o Optimization
// class Solution {
//     public boolean checkPerfectNumber(int num) {
//         int sum = 0;
//         for(int i = 1; i <= num / 2; i++)
//         {
//             if(num % i == 0)
//                 sum += i;
//         }
//     return sum == num ? true : false; // Just write sum == num no need for all this!!!!
    
//     }
// }
/*
Explanation of Optimizations:

	1.	Start sum at 1: We start the sum at 1 because 1 is a divisor of all numbers, and the loop begins at 2.
	2.	Iterate up to sqrt(num): This is a common optimization for divisor problems. For every i where num % i == 0, you also have num / i as a divisor. Therefore, you only need to check divisors up to the square root of num.
	3.	Avoid adding the square root twice: When i is equal to num / i (i.e., when i is the square root of num), we only add i once to avoid duplication.
*/
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false; // No perfect number is less than or equal to 1

        int sum = 1; // Start with 1, since 1 is a divisor of any number

        // Iterate up to the square root of `num`
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i; // Add the divisor
                if (i != num / i) {
                    sum += num / i; // Add its pair divisor
                }
            }
        }

        // A perfect number is a number where the sum of divisors (excluding itself) equals the number
        return sum == num;
    }
}