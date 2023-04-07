class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        Map<Integer,Integer> InDegree=new HashMap<>();
        BuildGraph(numCourses,prerequisites,graph,InDegree);
        Queue<Integer> queue=new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:InDegree.entrySet()){
            if(entry.getValue()==0) queue.add(entry.getKey());
        }
        List<Integer> SortedOrder=new ArrayList<>();
        while(!queue.isEmpty()){
            int curr=queue.poll();
            SortedOrder.add(curr);
            for(int nbr: graph.get(curr)){
                InDegree.put(nbr,InDegree.get(nbr)-1);
                if(InDegree.get(nbr)==0) queue.add(nbr);
            }
        }
        return SortedOrder.size()==numCourses ? true : false;
    }
    private void BuildGraph(int numCourses, int[][] prerequisites,List<List<Integer>> graph,Map<Integer,Integer> InDegree){
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
            InDegree.put(i,0);
        }
        for(int[] pre:prerequisites){
            graph.get(pre[0]).add(pre[1]);
            
            InDegree.put(pre[1],InDegree.get(pre[1])+1);
        }
    }
}