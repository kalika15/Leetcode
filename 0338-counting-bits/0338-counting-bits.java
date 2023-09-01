class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        String[] temp=new String[n+1];
        for(int i=0; i<n+1; i++){
            String l=Integer.toBinaryString(i);
            temp[i]=l;
        }
        for(int i=0; i<n+1; i++){
            String curr=temp[i];
            int count=0;
            for(int j=0; j<curr.length(); j++){
                if(curr.charAt(j)=='1') count++;
            }
            ans[i]=count;
        }
        return ans;
    }
}