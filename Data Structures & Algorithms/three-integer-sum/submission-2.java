
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>parent = new ArrayList<>();
         for(int  i=0;i<nums.length;i++){
            if(nums[i]>0){break;}
            if(i>0 && nums[i]==nums[i-1]){
                
                continue;
            }
            int j= i+1;int l=nums.length-1;
            while(j<l){
                int sum = nums[i]+nums[j]+nums[l];
                if(sum>0){
                    l--;
                }
                else if(sum<0){ j++;}
                else{
                    List<Integer>child=new ArrayList<>();
                    child.add(nums[i]);
                    child.add(nums[l]);
                    child.add(nums[j]);
                    parent.add(child);
                    j++;l--;
                    while (j<l && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
         }
         return parent;
    }
}
