

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 2. Create an ArrayList that holds OTHER ArrayLists (not arrays!)
        ArrayList<List<Integer>> list = new ArrayList<>();
        
        // 3. PRE-FILL the ArrayList to avoid IndexOutOfBoundsException
        // The max frequency is nums.length, so we fill up to that index.
        for (int i = 0; i <= nums.length; i++) {
            list.add(new ArrayList<>());
        }

        // 4. Put numbers into their frequency buckets
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue(); 
            
            // Because we pre-filled it, this is perfectly safe now
            list.get(frequency).add(number);
        }
        
        // 5. Fetch the top K elements
        int[] arr = new int[k];
        int c = 0;
        
        // Go backwards through the frequencies (highest to lowest)
        for (int i = list.size() - 1; i >= 0; i--) {
            // Check every number sitting in this frequency bucket
            for (int num : list.get(i)) {
                arr[c] = num;
                c++;
                // Once our result array is full, stop and return
                if (c == k) {
                    return arr;
                }
            }
        }
        
        return arr;
    }
}