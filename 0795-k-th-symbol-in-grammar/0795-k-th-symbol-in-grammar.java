class Solution {
    public int kthGrammar(int n, int k) {
        // Base Case
        if(n == 1 && k == 1)
            return 0;
        int mid = ((int)Math.pow(2,n - 1))/2;

        // Induction + Hypothesis
        if(k <= mid)
            return kthGrammar(n -  1,k);
        else
            return 1 - kthGrammar(n - 1,k - mid);
    }
}