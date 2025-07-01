class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        int n = t.length();
        for(int i = 0;i < n;i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0) + 1);
        }
        int i = 0 , j = 0 , m = s.length() , count = mp.size();
        int minLen = Integer.MAX_VALUE;
        int start = 0; // TO track the best window start index.
        
        if(m < n)   return "";

        while(j < m){
            char cj = s.charAt(j);
            if(mp.containsKey(cj)){
                mp.put(cj,mp.get(cj) - 1);
                if(mp.get(cj) == 0)
                count --;
            }
            while(count == 0){
                if(j - i + 1 < minLen){
                    minLen = j - i + 1;
                    start = i;
                }
                char ci = s.charAt(i);
                if(mp.containsKey(ci)){
                    mp.put(ci,mp.get(ci) + 1);
                    if(mp.get(ci) > 0)
                    count ++;
                }
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start + minLen);
    }
}