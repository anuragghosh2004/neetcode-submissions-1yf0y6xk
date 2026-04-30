class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> parent = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                int k = j + 1;
                int l = nums.length - 1;
                
                while (k < l) {
                    // Create a brand new child list for this specific loop iteration
                    List<Integer> child = new ArrayList<>();
                    
                    // FIX 1: Cast to long to prevent overflow
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        child.add(nums[i]);
                        child.add(nums[j]);
                        child.add(nums[k]);
                        child.add(nums[l]);
                        parent.add(child);
                        
                        // FIX 2: REMOVED child.clear(); It is not needed and breaks your list!
                        
                        k++;
                        l--;
                        
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        // FIX 3: Moved return statement outside of the 'i' loop
        return parent;
    }
}