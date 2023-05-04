class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result=new ArrayList<>();
        HashSet<Integer> temp1=new HashSet<>();
        HashSet<Integer> temp2=new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            boolean found = false;
            for(int j=0; j<nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    found = true;
                    break;
                }
            }
            if(!found){
                temp1.add(nums1[i]);
            }
        }
        
        for(int i=0; i<nums2.length; i++){
            boolean found = false;
            for(int j=0; j<nums1.length; j++) {
                if(nums2[i] == nums1[j]) {
                    found = true;
                    break;
                }
            }
            if(!found){
                temp2.add(nums2[i]);
            }
        }
        
        List<Integer> temp1List = new ArrayList<>(temp1);
        List<Integer> temp2List = new ArrayList<>(temp2);
        result.add(temp1List);
        result.add(temp2List);
        return result;
    }
}
