class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(char ch: t.toCharArray()){
            if(map.containsKey(ch)){
                int count=map.get(ch);
                count--;
                if(count==0) map.remove(ch);
                else map.put(ch,count);
            }
            else{
                return ch;
            }
        }
        return 'a';
    }
}