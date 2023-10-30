class Solution {
    HashMap<Integer,List<Integer>> map=new HashMap<>();
    public void count(int num){
        int[] binary=new int[35];
        int i=0;
        int k=num;
        while(num>0){
            binary[i++]=num%2;
            num/=2;
        }
        int c=0;
        for(int bit: binary){
            if(bit==1) c++;
        }
        List<Integer> temp=map.getOrDefault(c, new ArrayList<>());
        temp.add(k);
        map.put(c, temp);

    }
    public int[] sortByBits(int[] arr) {
        int[] result=new int[arr.length];
        for(int num: arr){
            count(num);
        }
        int i=0;
        System.out.print(map);
        for(int key: map.keySet()){
            List<Integer> temp=map.get(key);
            Collections.sort(temp);
            for(int num: temp){
                result[i++]=num;
            }
            
        }
        return result;
    }
}