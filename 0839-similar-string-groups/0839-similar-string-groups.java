class Solution {

    public boolean similar(String s1, String s2){
        int count=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
            if(count>2) return false;
        }
        return true;
    }


    public void dfs(int node, String[] strs,boolean[] visited){
        visited[node]=true;
        for(int j=0; j<strs.length; j++){
            if(!visited[j] && similar(strs[node],strs[j])){
                dfs(j, strs, visited);
            }
        }
       
    }

    public int numSimilarGroups(String[] strs) {
        boolean[] visited=new boolean[strs.length];
        
        int res=0;
        for(int i=0; i<strs.length; i++){
            if(!visited[i]){
                dfs(i,strs, visited);
                res++;
            }
        }

     
        return res;
    }
}