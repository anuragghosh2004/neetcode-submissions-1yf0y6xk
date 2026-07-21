class Solution {
    public int largestRectangleArea(int[] heights) {
        int nl[] =new int [heights.length];
        int pl[] =new int[heights.length];
        nl =nextLesserElement(heights);
        pl = previousLesserElement(heights);
        int maxArea =Integer.MIN_VALUE;
        int i =0;int area =0;
        while(i<heights.length){
         area = heights[i]*(nl[i]-pl[i]-1);
         maxArea = Math.max(maxArea,area);
         i++;

        }
        return maxArea;


    }
    public int[] nextLesserElement(int[] h){
        int r = h.length-1;
        int output[] = new int[h.length];
        Stack<int[]>stack =new Stack<>();
        while(r>=0){
            while(!stack.isEmpty() && stack.peek()[0]>=h[r]){
                stack.pop();
            }
            if(stack.isEmpty()){
                output[r]=h.length;
                }else{
                    int val = stack.peek()[1];
                    output[r]=val;
                }
                stack.push(new int[]{h[r],r});
                r--;
        }
        return output;
    }
    public int[] previousLesserElement(int []h){
       int r = 0;
        int output[] = new int[h.length];
        Stack<int[]>stack =new Stack<>();
        while(r<=h.length-1){
            while(!stack.isEmpty() && stack.peek()[0]>=h[r]){
                stack.pop();
            }
            if(stack.isEmpty()){
                output[r]=-1;
                }else{
                    int val = stack.peek()[1];
                    output[r]=val;
                }
                stack.push(new int[]{h[r],r});
                r++;
        }
        return output;

    }








}
