class Pair{
    int node,state;
    public Pair(int node,int state){
        this.node=node;
        this.state=state;
    }
}
class Solution {
    // public HashMap<Integer,int[]> buildGraph(int[][] graph, HashMap<Integer,int[]> Graph){
    //     for(int i=0; i<graph.length; i++){
    //         Graph.put(i,graph[i]);
    //     }
    //     return Graph;
    // }
    public int shortestPathLength(int[][] graph) {
        // HashMap<Integer,int[]> Graph=new HashMap<>();
        // buildGraph(graph,Graph);

        Queue<Pair> queue=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();

        int n=graph.length;
        int target=(1<<n)-1;
        int path=0;

        for(int i=0; i<graph.length; i++){
            int initialState=1<<i;
            Pair pair=new Pair(i,initialState);
            queue.offer(pair);
            visited.add(i+"-"+initialState);
        }

        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0; i<size; i++){
                Pair pair=queue.poll();
                int node=pair.node;
                int state=pair.state;

                if(state==target) return path;
            
                for(int neigh: graph[node]){
                    int nextState=state | 1<< neigh;
                    String key=neigh+"-"+nextState;

                    if(!visited.contains(key)){
                        Pair p=new Pair(neigh,nextState);
                        queue.offer(p);
                        visited.add(key);
                    }
                }
            }
            path++;
        }
        return -1;
    }
}