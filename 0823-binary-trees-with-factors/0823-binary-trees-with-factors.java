class Solution {
    int mod=(int) 1e9+7;
    HashSet<Integer> set=new HashSet<>();
    HashMap<Integer, Long> map=new HashMap<>();
    public int numFactoredBinaryTrees(int[] arr) {
        for(int val: arr){
            set.add(val);
        }
        int res=0;
        for(int val: arr){
            res+=solve(val);
            res%=mod;
        }
        return res;
    }
    public long solve(int root){
        if(map.containsKey(root)) return map.get(root);
        long count =1;
        for(int val: set){
            if(root%val!=0) continue;
            int factor=root/val;
            if(set.contains(factor)){
                count+=solve(val)*solve(factor);
                count%=mod;
            }
        }
        map.put(root,count);
        return count;
    }
}