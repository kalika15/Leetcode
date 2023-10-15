class Solution {
    HashMap<String,Long> map = new HashMap();
    public int numWays(int steps, int arrLen) {

        return (int) (solve(steps, arrLen, 0)%((Math.pow(10,9)) +7));
    }
    public long solve(int steps, int arrLen, int index){
        String curr=index+"->"+steps;

        if(index==0 && steps==0) return 1;
        else if(index<0 || (index>=arrLen) || steps==0) return 0;

        if(map.containsKey(curr)) return map.get(curr);

        long stay=solve(steps-1, arrLen, index);
        long right=solve(steps-1, arrLen, index+1);
        long left=solve(steps-1, arrLen, index-1);

        map.put(curr,(stay+left+right)%1000000007);

        return (stay+left+right)%1000000007;
    }
}