class Solution {
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        
        char[] sb1 = s1.toCharArray();
        
        for (int i = 0; i < sb1.length; i++) {
            for (int j = 0; j < sb1.length; j++) {
                if (i != j) {
                    swap(sb1, i, j);
                    String swappeds = new String(sb1);
                    if (swappeds.equals(s2)) return true;
                    swap(sb1, i, j);
                }
            }
        }
        return false;
    }
}






