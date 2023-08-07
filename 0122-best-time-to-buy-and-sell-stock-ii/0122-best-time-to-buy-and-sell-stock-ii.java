class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        int n=prices.length-1;
        int cost=0;
        while(n>=0){
            int curr=prices[n];
            if(!stack.isEmpty() && stack.peek()>curr){
                cost+=Math.abs(curr-stack.peek());
            }
            stack.push(curr);
            n-=1;
        }
        return cost;

    }
}