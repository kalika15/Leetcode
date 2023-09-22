class Solution {
    boolean[] fired;
    public long dis(int i, int j, int[][] bombs){
        long X=bombs[i][0]-bombs[j][0];
        long Y=bombs[i][1]-bombs[j][1];
        long z=X*X+Y*Y;
        return z;
    }
    public HashSet<Integer> getBombInRange(int i, int[][] bombs){
        HashSet<Integer> set=new HashSet<>();
        long radius=bombs[i][2];
        radius=radius*radius;
        for(int j=0; j<bombs.length; j++){
            if(i!=j && dis(i,j,bombs)<=radius){
                set.add(j);
            }
        }
        return set;
    }
    public int fire(int i, int[][] bombs){
        int count=1;
        fired[i]=true;
        HashSet<Integer> neighbors=getBombInRange(i,bombs);
        for(int neigh: neighbors){
            if(fired[neigh]==false){
                count+=fire(neigh, bombs);
            }
        }
        return count;
        
    }
    public int maximumDetonation(int[][] bombs) {
        fired=new boolean[bombs.length];
        int max=Integer.MIN_VALUE;
        for(int i=0; i<bombs.length; i++){
            Arrays.fill(fired,false);
            int c=fire(i, bombs);
            // System.out.println(c);
            // System.out.println(i);
            max=Math.max(max,c);
        }
        return max;
    }
}