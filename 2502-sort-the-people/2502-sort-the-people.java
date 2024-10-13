class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> mp = new HashMap<>();
        int i = 0;
        while(i < names.length)
        {
            mp.put(heights[i],names[i]);
            i++;
        }
        Arrays.sort(heights);
        i = names.length - 1;
        int j = 0;
        while(i >= 0)
        {
            names[i] = mp.get(heights[j]);
            i--;
            j++;
        }
    return names;
    }
}
