class Solution {
    public int countValidWords(String sentence) {
        int hyphenCount=0;
        int wordCount=0;
        char[] number=new char[]{'0','1','2','3','4','5','6','7','8','9'};
        char[] alphabet=new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String[] l=sentence.split(" ");
        List<Character> numberList = new ArrayList<>();
        for (char c : number) {
            numberList.add(c);
        }

        List<Character> alphabetList = new ArrayList<>();
        for (char c : alphabet) {
            alphabetList.add(c);
        }
        for(int i=0; i<l.length; i++){
            hyphenCount=0;
            for(char j=0; j<l[i].length(); j++){
                int n=l[i].length();
                if(l[i].charAt(j)=='-'){
                    hyphenCount++;
                    if(hyphenCount==1 && j-1>=0 && j+1<n && alphabetList.contains(l[i].charAt(j-1))&& alphabetList.contains(l[i].charAt(j+1))){
                        continue;
                    }
                    else{
                        break;
                    }
                }
                if(l[i].charAt(j)=='!' || l[i].charAt(j)=='.' || l[i].charAt(j)==','){
                    if(j!=n-1) break;
                }
                if(numberList.contains(l[i].charAt(j))){
                    break;
                }
                if(j==n-1){
                    wordCount++;
                }
            }
        }
        return wordCount;
    }
}