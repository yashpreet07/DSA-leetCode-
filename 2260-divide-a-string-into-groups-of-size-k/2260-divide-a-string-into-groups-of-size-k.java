// class Solution {
//     public String[] divideString(String s, int k, char fill) {
//         int size = s.length() / k;
//         String res[] = new String[size];
//         for(int i = 0;i < size;i++){
//             if(i != size - 1)
//                 res[i] = s.substring(i * k,i + k);
//             else
//                 res[i] = s.substring(i * k);
//         }
//         while(res[size - 1].length() < k){
//             res[size] = res[size] + fill;
//         }
//         return res;
//     }
// }


class Solution {
    public String[] divideString(String s, int k, char fill) {
        int size = (s.length() + k - 1) / k;
        String[] res = new String[size];
        
        for (int i = 0; i < size; i++) {
            int start = i * k;
            int end = Math.min(start + k, s.length());
            res[i] = s.substring(start, end);
            
            // Fill the last group if it's shorter than k
            while (res[i].length() < k) {
                res[i] += fill;
            }
        }
        return res;
    }
}