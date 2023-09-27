class Solution {
    public String decodeAtIndex(String s, int k) {
        // StringBuilder sb=new StringBuilder();
        // for(int i=0; i<s.length(); i++){
        //     if(Character.isDigit(s.charAt(i))){
        //         int temp=(int)s.charAt(i)-1;
        //         while(temp>=0){
        //             sb.append(sb);
        //             temp--;
        //         }
        //     }
        //     else{
        //         sb.append(s.charAt(i));
        //     }
        // }
        // return sb.charAt(k)+"";

        long length=0;
        int i=0;
        while(length<k){
            if(Character.isDigit(s.charAt(i))){
                length*=s.charAt(i)-'0';
            }
            else{
                length++;
            }
            i++;
        }

        for(int j=i-1; j>=0; j--){
            if(Character.isDigit(s.charAt(j))){
                length/=s.charAt(j)-'0';
                k%=length;
            }
            else{
                if(k==0 || k==length){
                    return Character.toString(s.charAt(j));
                }
                length--;
            }
        }
        return "";
    }
}