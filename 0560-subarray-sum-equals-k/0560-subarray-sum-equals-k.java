class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store prefix sums and their frequencies
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // to handle the case when a prefix sum equals k
        
        int count = 0;
        int currentSum = 0;
        
        // Traverse the array
        for (int num : nums) {
            currentSum += num;
            
            // Check if there is a prefix sum that, when subtracted from currentSum, equals k
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Add the current sum to the map or update its frequency
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}


// Using Prefix Sum Which Doesn't gets accepted due to TLE.
// int sum=0;
//         int count=0;
//         int len=nums.length;
//         int ps[]=new int[len];
//         for(int i=0;i<len;i++)
//         {
//             if(i!=0)
//             ps[i]=ps[i-1]+nums[i];
//             else
//             ps[i]=nums[i];
//         }
//         for(int a=0;a<len;a++)
//         {
//          if(a!=len-1)
//         {
//                 for(int b=a+1;b<len;b++)
//             {
//                 sum=ps[b]-(a==0 ? 0 : ps[a-1]);
//                 if(sum==k){
//                     count++;
//                     break;
//                 }
//             }                
//         }
//         else
//                 if(nums[a]==k)
//                     count++;
//     }
        
//    return count;