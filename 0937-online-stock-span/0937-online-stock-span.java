class StockSpanner {
    private Stack<int[]> stack; // Stores {price, index}
    private int index; // Keeps track of the current day index

    public StockSpanner() {
        stack = new Stack<>();
        index = 0;
    }

    public int next(int price) {
        // Current day
        index++;

        // Remove elements from stack while they have a smaller or equal price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        // Compute span: If stack is empty, span is the entire duration; otherwise, it's the difference
        int span = stack.isEmpty() ? index : index - stack.peek()[1];

        // Push current price and its index into the stack
        stack.push(new int[]{price, index});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */