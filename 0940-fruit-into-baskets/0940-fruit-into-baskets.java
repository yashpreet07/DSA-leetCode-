class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0 , j = 0 , max = 0 , n = fruits.length;
        Map<Integer,Integer> mp = new HashMap<>();
        while(j < n){
            mp.put(fruits[j],mp.getOrDefault(fruits[j],0) + 1);
            if(mp.size() <= 2){
                max = Math.max(max,j - i + 1);
                j++;
            }else{
                while(mp.size() > 2){
                    mp.put(fruits[i],mp.get(fruits[i]) - 1);
                    if(mp.get(fruits[i]) == 0)
                        mp.remove(fruits[i]);
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
