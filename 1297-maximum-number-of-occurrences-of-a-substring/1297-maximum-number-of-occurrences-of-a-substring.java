class Solution {
    public int CountCharacter(String s){
        HashSet<Character> set=new HashSet<>();
        for(Character ch: s.toCharArray()){
            set.add(ch);
        }
        return set.size();
    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> substringMap=new HashMap<>();

        int start=0;
        int end=minSize-1;

        while(end<s.length()){
            String subString=s.substring(start,end+1);
            int countChar=CountCharacter(subString);

            if(countChar<=maxLetters && subString.length()>=minSize && subString.length()<=maxSize){
                int ele=substringMap.getOrDefault(subString, 0);
                ele++;
                substringMap.put(subString, ele);
            }
            start++;
            end++;

        }

        int max=0;

        for(String key : substringMap.keySet()){
            max=Math.max(max, substringMap.get(key));
        }

        // System.out.print(substringMap);
        return max;

    }

}