class Solution {

public int longestConsecutive(int[] nums) {

// FIXED: Added edge case check to prevent crash if array is empty (nums[0] would fail)

if (nums == null || nums.length == 0) {

return 0;

}



HashSet<Integer> set = new HashSet<>();

int max = nums[0];

int min = nums[0]; // FIXED: Added missing semicolon



for(int i : nums){

if(i > max){ max = i; } // FIXED: Added missing semicolon

if(i < min){ min = i; } // FIXED: Added missing semicolon

set.add(i); // FIXED: Added missing semicolon

}



ArrayList<Integer> alist = new ArrayList<>();

int maxx = 1;

int c = 1;


// FIXED: Changed from '0' to 'min'. If original started at 0,

// the else-block would jump 'i' back to 1 even if 'min' was 100.

int original = min;



for(int i = min; i < max;){

if(set.contains(i + 1) && set.contains(i)){

c++;

maxx = c;

i++;

original = i;

alist.add(maxx); // FIXED: Added semicolon AND changed 'max' to 'maxx'

} else {

c = 1;

maxx = c;

original++;

i = original;

}

}



// FIXED: Renamed to 'finalMax' because 'int maxx' was already declared above.

int finalMax = 0;

for(int i : alist){

if(i > finalMax){ finalMax = i; } // FIXED: Added missing semicolon

}



// FIXED: If the loop never ran (e.g., array is [0,0]), finalMax would be 0, but streak is 1.

if (finalMax == 0 && nums.length > 0) {

return 1;

}



return finalMax;

}

}