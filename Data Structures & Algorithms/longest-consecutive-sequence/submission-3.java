public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>sst= new HashSet<>();
        for(int i:nums){
            sst.add(i);
        }
        int longest =0;
        for(int i:sst){
            if(!sst.contains(i-1)){
                int length =1;
                while(sst.contains(i + length)){
                length++;
                }
                longest = Math.max(longest,length);
            }
            
        }
        return longest;
}
}
