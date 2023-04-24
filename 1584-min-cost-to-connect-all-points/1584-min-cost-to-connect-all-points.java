class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public static List<List<Pair>> buildGraph(List<List<Integer>> edges, int n){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
           graph.add(new ArrayList<>());
        }
        for(List<Integer> edge:edges){
           graph.get(edge.get(0)).add(new Pair(edge.get(0),edge.get(2)));
           graph.get(edge.get(1)).add(new Pair(edge.get(0),edge.get(2)));
        }
        return graph;
    }
    
    private static int minCost(List<List<Integer>> edges, int n) {
        List<List<Pair>> graph =buildGraph(edges,n);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);
        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] mstSet = new boolean[n];


        distance[0] = 0;
        minHeap.offer(new Pair(0, distance[0]));

        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            int curr_node = pair.node;

            if (mstSet[curr_node])
                continue;
            mstSet[curr_node] = true;

            for (Pair nbrpair : graph.get(curr_node)) {
                if (!mstSet[nbrpair.node] && nbrpair.distance < distance[nbrpair.node]) {
                    distance[nbrpair.node] = nbrpair.distance;
                    minHeap.offer(new Pair(nbrpair.node, nbrpair.distance));
                }
            }
        }
        int cost = 0;
        for (int i = 0; i <n; i++) {
            cost += distance[i];
        }

        return cost;
    }
    public int minCostConnectPoints(int[][] points) {
        List<List<Integer>> edge=new ArrayList<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;
                int temp=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edge.add(Arrays.asList(i,j,temp));

            }
        }
        return (minCost(edge,points.length));
    }
}