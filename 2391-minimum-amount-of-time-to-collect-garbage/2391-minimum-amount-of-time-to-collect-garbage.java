class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int mincost=0;
        int n=garbage.length;
        for(int i=0; i<n-1; i++){
            mincost+=3*travel[i];
        }
        for(String s: garbage){
            mincost+=s.length();
        }
        for(int i=n-1; i>0 ; i--){
            if(!garbage[i].contains("G")){
                mincost-=travel[i-1];
            }
            else{
                break;
            }
        }
        for(int i=n-1; i>0; i--){
            if(!garbage[i].contains("P")){
                mincost-=travel[i-1];
            }
            else break;
        }
        for(int i=n-1; i>0; i--){
            if(!garbage[i].contains("M")){
                mincost-=travel[i-1];
            }
            else break;
        }
        return mincost;
    }
}