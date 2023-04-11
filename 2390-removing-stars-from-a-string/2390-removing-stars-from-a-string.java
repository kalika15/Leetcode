class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.size()>0 && s.charAt(i)=='*'){
                stack.pop();
                continue;
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder ans= new StringBuilder(stack.size());
        Iterator value = stack.iterator();
        while(value.hasNext()) {
            ans.append(value.next());
        }
        return ans.toString();
        
    }
}