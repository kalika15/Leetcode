class Solution {
    List<String> ans;
    public List<String> readBinaryWatch(int turnedOn) {
        ans = new ArrayList<>();
        search(0,turnedOn,0,0);
        return ans;
    }
    private void search(int i,int t,int h, int m){
        if(t==0){
            String s=h+":";
            if(m<10){
                s+="0";
            }
            s+=m;
            ans.add(s);
        }
        else if(i==10){
            //nothing
        }
        else{
            search(i+1,t,h,m);
            if(i<=3){
                h+=(1 << (3-i));
            }
            else{
                m+=(1 << (9-i));
            }
            if(h < 12 && m < 60) search(i+1, t-1, h, m);
        }
    }
}