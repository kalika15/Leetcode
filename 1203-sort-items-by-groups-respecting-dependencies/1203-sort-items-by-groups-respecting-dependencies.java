class Solution {
    private List<Integer>[] groupItems;
    private List<Integer>[] itemGraph; 
    private int[] itemIndegrees; 
    private int[] groupIndegrees; 
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        buildGroupItems(n, group);
        buildItemGraph(n, beforeItems, group);
        
        int[] result=new int[n];
        int index=0;
        Queue<Integer> groupQueue=new LinkedList<>();
        
        
        for(int i=0; i<n; i++) {
            if(groupIndegrees[i]==0) {
                groupQueue.offer(i);
            }
        }
        
        while (!groupQueue.isEmpty()) {
            Integer groupId=groupQueue.poll();
            List<Integer> itemsInGroup=groupItems[groupId];
            
            if(itemsInGroup!=null) {
                Queue<Integer> itemQueue=new LinkedList<>();
                
                for(var item :itemsInGroup) {
                    if(itemIndegrees[item]==0) {
                        itemQueue.offer(item);
                    }
                }
                
                while(!itemQueue.isEmpty()) {
                    Integer item =itemQueue.poll();
                    result[index++] = item;
                    
                    if(itemGraph[item] != null) {
                        for(var neighbor :itemGraph[item]) {
                            itemIndegrees[neighbor]--;
                            
                            if(group[neighbor]!=groupId) {
                                if(--groupIndegrees[group[neighbor]]==0) {
                                    groupQueue.offer(group[neighbor]);
                                }
                            } else if(itemIndegrees[neighbor]==0) {
                                itemQueue.offer(neighbor);
                            }
                        }
                    }
                }
            }
        }
        
        if(index==n)return result;
        return new int[0];
    }
    
    private void buildGroupItems(int n, int[] group) {
        groupItems=new List[n];
        int index=n - 1;

        
        for (int i=0; i<n; i++) {
            if(group[i]==-1) {
                group[i]=index--;
            }
            
            if(groupItems[group[i]]==null) {
                groupItems[group[i]]=new ArrayList<>();
            }
            
            groupItems[group[i]].add(i);
        }
    }
    
    private void buildItemGraph(int n, List<List<Integer>> beforeItems, int[] group) {
        itemGraph = new List[n];
        itemIndegrees = new int[n];
        groupIndegrees = new int[n];
        
        for (int i=0; i<n; i++) {
            for (int j :beforeItems.get(i)) {
                if(itemGraph[j]==null) {
                    itemGraph[j]=new ArrayList<>();
                }
                
                itemGraph[j].add(i);
                itemIndegrees[i]++;
                
                if(group[i]!=group[j]) {
                    groupIndegrees[group[i]]++;
                }
            }
        }
    }
}