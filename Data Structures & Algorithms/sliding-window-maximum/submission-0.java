
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 0; 
        int l = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        while (r < nums.length) {
            // 1. Add current right element to the map
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            
            // 2. If the window size exceeds k, shrink it from the left
            if (r - l + 1 > k) {
                if (map.get(nums[l]) > 1) {
                    map.put(nums[l], map.get(nums[l]) - 1);
                } else {
                    map.remove(nums[l]);
                }
                l++;
            }
            
            // 3. If the window is exactly size k, calculate the maximum
            if (r - l + 1 == k) {
                int max = Integer.MIN_VALUE; // Must be MIN_VALUE to handle negative numbers
                for (Map.Entry<Integer, Integer> en : map.entrySet()) {
                    max = Math.max(max, en.getKey());
                }
                arr.add(max);
            }
            r++;
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}