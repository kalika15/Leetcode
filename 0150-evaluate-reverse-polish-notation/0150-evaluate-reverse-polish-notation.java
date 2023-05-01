class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String s: tokens){
            try {
                stack.push(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                int b=stack.pop();
                int a=stack.pop();
                int c=0;
                if(s.charAt(0)=='/') c=a/b;
                else if (s.charAt(0)=='*') c=a*b;
                else if(s.charAt(0)=='+') c=a+b;
                else if(s.charAt(0)=='-') c=a-b;
                stack.push(c);
            }
        }
        return stack.peek();
    }
}
