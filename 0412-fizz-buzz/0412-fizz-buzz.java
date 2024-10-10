class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> lst = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            if(i % 3 != 0 && i % 5 != 0)
                lst.add(String.valueOf(i));
            if(i % 3 == 0 && i % 5 != 0)
            lst.add("Fizz");
            if(i % 5 == 0 && i % 3 != 0)
            lst.add("Buzz");
            if(i % 3 == 0 && i % 5 == 0)
            lst.add("FizzBuzz");
        }
    
    return lst;
    }
}