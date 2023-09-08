class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n=words[0].length();
        int permutationLength=n*words.length;

        List<Integer> result=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();

        for(String word: words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        for(int i=0; i<=s.length()-permutationLength; i++){
            HashMap<String,Integer> tempmap=new HashMap<>(map);
            int j=i;
            while(j<i+permutationLength){
                String temp=s.substring(j,j+n);
                if(!tempmap.containsKey(temp) || tempmap.get(temp)==0){
                    break;
                }
                tempmap.put(temp, tempmap.get(temp)-1);
                j+=n;
            }
            if(j==i+permutationLength){
                result.add(i);
            }
        }

        return result;
    }
}