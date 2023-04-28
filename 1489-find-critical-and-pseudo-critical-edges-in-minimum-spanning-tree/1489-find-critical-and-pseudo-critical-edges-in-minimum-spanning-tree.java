class Solution {
    public int find(int n, int[] parent){
        if(parent[n]==n) return n;
        return find(parent[n],parent);
    }
   public void union(int u,int v,int[] parent){
        int p1=find(u,parent);
        int p2=find(v,parent);
        if(p1!=p2){
            parent[p2]=p1;
        }
    }
    public int mst(int n, int[][] edges, int[] include, int[] exclude){
        int[] parent=new int[n];
        for(int i=0 ;i<n ;i++){
            parent[i]=i;
        }
        int cost=0;
        if(include!=null){
            int p1=find(include[0],parent);
            int p2=find(include[1],parent);
            union(p1,p2,parent);
            cost+=include[2];
        }
        for(int[] edge:edges){
            if(include != null && include[0]==edge[0] && include[1]==edge[1] && include[2]==edge[2]){
                continue;
            }
            if(exclude != null && exclude[0]==edge[0] && exclude[1]==edge[1] && exclude[2]==edge[2]){
                continue;
            }

            int u=edge[0];
            int v=edge[1];
            int c=edge[2];
            int p1=find(u,parent);
            int p2=find(v,parent);
            if(p1!=p2){
                union(p1,p2,parent);
                cost+=c;
            }
        }
        return cost;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] OriginalEdges=new int[edges.length][3];
        for(int i=0; i<edges.length; i++ ){
            OriginalEdges[i]=edges[i];
        }
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> criticalEdges=new ArrayList<>();
        List<Integer> pseudoCriticalEdges=new ArrayList<>();

        Arrays.sort(edges,(a,b)-> a[2]-b[2]);
        int originalCost=mst(n,edges, null, null);
        for(int i=0; i<edges.length; i++){
            int excludedCost=mst(n,edges,null,OriginalEdges[i]);
            int includedCost=mst(n,edges,OriginalEdges[i],null);
            if(excludedCost > originalCost || excludedCost < originalCost){
                criticalEdges.add(i);
            }
            else if(includedCost==originalCost){
                pseudoCriticalEdges.add(i);
            }

        }
        result.add(criticalEdges);
        result.add(pseudoCriticalEdges);
        return result;

    }
}