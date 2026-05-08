class Solution {
    public int maxArea(int[] heights) {
        int l = 0;int h=heights.length -1;
        int res=0;
        while(l<h){
            int volume = Math.min(heights[l],heights[h])*(h-l);
             res =Math.max(res,volume);
            if(heights[l]<=heights[h]){
                l++;
            }else{
                h--;
            }
        }
        return res;
    }
}
