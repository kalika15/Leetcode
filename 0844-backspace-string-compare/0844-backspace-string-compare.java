class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        for(int i=0; i<s.length(); i++){
            s1.push(s.charAt(i));
            if(s1.peek()=='#'){
                if(s1.size()>1) {
                    s1.pop();
                    s1.pop();
                }
                else if(s1.size()==1){
                    s1.pop();
                }
            }
        }
        for(int i=0; i<t.length(); i++){
            s2.push(t.charAt(i));
            if(s2.peek()=='#'){
                if(s2.size()>1) {
                    s2.pop();
                    s2.pop();
                }
                else if(s2.size()==1){
                    s2.pop();
                }
            }
        }
        System.out.print(s1);
        System.out.print(s2);

        if(s1.size()!=s2.size()) return false;
        while(!s1.isEmpty()){
            if(s1.peek()!=s2.peek()) return false;
            s1.pop();
            s2.pop();
        }
        return true;

    }
}