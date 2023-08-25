class Solution {
    

    public void backTrack(int node, int[][] Graph, int target, List<Integer> path,List<List<Integer>> result){
        if(Graph[node].length==0){
            if(node<target) return;
        }
        if(target==node){
            List<Integer> newPath=new ArrayList<>(path);
            newPath.add(node);
            result.add(newPath);
            return;
        }
        for(int n: Graph[node]){
            List<Integer> newPath=new ArrayList<>(path);
            newPath.add(node);
            backTrack(n, Graph, target, newPath,result);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        backTrack(0, graph, graph.length -1, new ArrayList<>(),result);
        return result;

    }
}
