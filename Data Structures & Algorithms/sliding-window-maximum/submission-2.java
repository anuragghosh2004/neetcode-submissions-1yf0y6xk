
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer>dq = new ArrayDeque<>();
       int r = 0; int l =0;
       ArrayList<Integer> arr = new ArrayList<>();
       
       while(r<nums.length){
        while(!dq.isEmpty() && dq.peekLast()< nums[r]){
            dq.pollLast();
        }
        dq.offerLast(nums[r]);
          if(r-l+1>k){
             if(nums[l]==dq.peekFirst()){
                dq.pollFirst();
             }
             l++;
        }
        if(r-l+1 ==k ){
         arr.add(dq.peekFirst());
        }
      
        r++;
       }
       return arr.stream().mapToInt(i -> i).toArray();
    }
}