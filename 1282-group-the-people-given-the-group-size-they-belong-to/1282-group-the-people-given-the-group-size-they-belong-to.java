class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result=new ArrayList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0; i<groupSizes.length; i++){
            List<Integer> temp=map.getOrDefault(groupSizes[i], new ArrayList<>());
            temp.add(i);
            map.put(groupSizes[i], temp);
        }
        // System.out.print(map);
        for(int key: map.keySet()){
            List<Integer> groups= map.get(key);
            List<Integer> group=new ArrayList<>();

            for(int g: groups){
                if(group.size()<key) group.add(g);
                else{
                    List<Integer> temp=new ArrayList<>(group);
                    result.add(temp);
                    group.clear();
                    group.add(g);
                }
                // System.out.print(group);
            }
            List<Integer> temp=new ArrayList<>(group);
            result.add(temp);
            group.clear();
        }

        return result;

    }
}