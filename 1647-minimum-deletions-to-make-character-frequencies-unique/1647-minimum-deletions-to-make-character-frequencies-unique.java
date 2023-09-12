class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        HashSet<Integer> set=new HashSet<>();
        int count=0;

        for(char ch: map.keySet()){
            int temp=map.get(ch);
            while(temp>0 && set.contains(temp)){
                count++;
                temp--;
            }
            set.add(temp);
        }
        return count;
    }
}