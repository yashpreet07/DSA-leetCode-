class Solution {
    public int countOperations(int n1, int n2) {
        int noOp = 0;
        while(true)
        {
            if(n1 == 0 || n2 == 0)
                break;
            if(n1 >= n2)
            {
                n1 = n1 - n2;
                noOp++;
            }  
            else
            {
                n2 = n2 - n1;
                noOp++;
            }
        }
    return noOp;
    }
}