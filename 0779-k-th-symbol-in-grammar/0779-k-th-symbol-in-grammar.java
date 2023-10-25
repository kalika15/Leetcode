class Solution {
    public int kthGrammar(int n, int k) {
        boolean flag=false;
        int number=(int)Math.pow(2,n);
        while(number!=1){
            number/=2;
            if(k>number){
                k-=number;
                flag=!flag;
            }
        }
        if(flag==true) return 1;
        else return 0;
    }
}