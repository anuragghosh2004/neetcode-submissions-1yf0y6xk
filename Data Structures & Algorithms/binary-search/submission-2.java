class Solution {
    public int search(int[] nums, int target) {
        int l = 0; int h = nums.length -1;
        int ans = binaryss(nums,target,h,l);
        return ans;
      
    }
    public int binaryss(int []nums,int target,int h,int l){
        int t = target;
          if(l<=h){
            int mid = (l+h)/2;
            if(t>nums[mid]){
               l=mid+1; 
               return binaryss(nums,t,h,l);
            }
            else if(t<nums[mid]){
                h=mid-1;
               return  binaryss(nums,t,h,l);
            }else{
                return mid;
            }

                    }else{return -1;}
                    

    }
}
