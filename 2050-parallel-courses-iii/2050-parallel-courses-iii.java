class Solution {
    
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] relation: relations){
            int prev=relation[0]-1;
            int next=relation[1]-1;
            graph.get(next).add(prev);

        }
        int[] record=new int[n];
        int mintime=0;

        for(int i=0; i<n; i++){
            mintime=Math.max(mintime, solve(i, graph, time, record));
        }
        return mintime;

    }

    public int solve(int course, List<List<Integer>> graph, int[] time, int[] record){
        if(record[course]!=0) return record[course];
        int max=0;

        for(int prev: graph.get(course)){
            max=Math.max(max, solve(prev, graph, time, record));
        }

        record[course]=max+time[course];
        return  record[course];
    }
}