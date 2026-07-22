class Solution {
    public int search(int[] nums, int target) {
        int l = 0; int h = nums.length -1;int t = target;
        while(l<=h){
            int mid = (l+h)/2;
            if(t>nums[mid]){
               l=mid+1; 
            }
            else if(t<nums[mid]){
                h=mid-1;
            }else{
                return mid;
            }

                    }
                    return -1;
    }
}
