class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int r = temperatures.length - 1;
        int[] output = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();
        while (r >= 0) {
            while (!st.isEmpty() && st.peek()[0] <= temperatures[r]) {
                st.pop();
            }
            if (st.isEmpty()) {
                output[r] = 0;
            } else {
                int idx = st.peek()[1];
                output[r] = idx - r;
            }
            st.push(new int[]{temperatures[r], r});
            r--;
        }
        return output;
    }
}