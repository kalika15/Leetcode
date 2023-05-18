class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> graph=buildgraph(edges,n);
        Queue<Integer> queue=new LinkedList<>();
        Boolean[] ristrict=new Boolean[n];
        Arrays.fill(ristrict,false);
        for(int i=0; i<restricted.length; i++){
            ristrict[restricted[i]]=true;
        }
        queue.add(0);
        int count=0;
        HashSet<Integer> visited=new HashSet<>();
        visited.add(0);
        while(!queue.isEmpty()){
            int curr=queue.poll();
            count+=1;
            for(int nbr: graph.get(curr)){
                if(ristrict[nbr]==true){
                    continue;
                }
                else{
                    if(!visited.contains(nbr)){
                        visited.add(nbr);
                        queue.add(nbr);
                    }
                }
            }
        }
        return count;
    }
    public List<List<Integer>>  buildgraph(int[][] edges, int n){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}