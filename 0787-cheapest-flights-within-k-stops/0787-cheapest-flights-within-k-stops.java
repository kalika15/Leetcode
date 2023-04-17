class Node {
    int node;
    int distance;
    int stops;
    public Node(int node, int distance, int stops) {
        this.node = node;
        this.distance = distance;
        this.stops = stops;
    }
}
class Pair {    
    int node;
    int distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    private List<List<Pair>> buildGraph(int n, int[][] flights) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        return graph;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = buildGraph(n, flights);
        PriorityQueue<Node> minHeap = 
                new PriorityQueue<>((n1, n2) -> (n1.distance - n2.distance));
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        distance[src] = 0;
        stops[src] = 0;
        minHeap.offer(new Node(src, 0, 0));

        while(!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            int currNode = curr.node;
            int currDistance = curr.distance;
            int currStops = curr.stops;

            if(currNode == dst) return currDistance;

            if(currStops == k + 1) continue;

            for(Pair pair : graph.get(currNode)) {
                int nbrNode = pair.node;
                int nbrDistance = pair.distance;
                
                int newDistance = currDistance + nbrDistance;
                int newStop = currStops + 1;
                if(newDistance < distance[nbrNode]) {
                    distance[nbrNode] = newDistance;
                    stops[nbrNode] = newStop;
                    minHeap.offer(new Node(nbrNode, newDistance, newStop));
                } else if(newStop < stops[nbrNode]) {
                    minHeap.offer(new Node(nbrNode, newDistance, newStop));
                }
            }
        }
        return -1;

    }
}