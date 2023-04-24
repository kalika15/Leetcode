class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        for(int c=0;c< s.length();c++){
            int a=map.getOrDefault(s.charAt(c),0);
            map.put(s.charAt(c),a+1);
            if(map.get(s.charAt(c))==2){
                return s.charAt(c);
            }
        }
        return ' ';
    }
}