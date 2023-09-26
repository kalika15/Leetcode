class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack<>();
        HashSet<Character> set=new HashSet<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        for(int i=0; i<s.length(); i++) {
            char ch=s.charAt(i);
            if(!set.contains(ch)) {
                while(!stack.isEmpty() && stack.peek()> ch && map.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                stack.push(ch);
                set.add(ch);
            }
        }
        // System.out.print(stack);
        StringBuilder result=new StringBuilder();
        for(Character ch: stack){
            result.append(ch);
        }
        return result.toString();
    }
}