class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> lst = new ArrayList<>();
        int maxCandy = 0;
        for (int ele : candies) {
            maxCandy = Math.max(maxCandy, ele);
        }
        for (int el : candies) {
            if (el + extraCandies >= maxCandy)
                lst.add(true);
            else
                lst.add(false);
        }
        return lst;
    }
}