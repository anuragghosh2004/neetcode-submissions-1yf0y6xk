class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int r = 0;
        
        // Changed to a for-loop to prevent an infinite loop, 
        // and fixed tokens.length() to tokens.length
        for (int i = 0; i < tokens.length; i++) {
            
            if (tokens[i].equals("*")) {
                r = stack.pop() * stack.pop();
                stack.push(r);
            } 
            // Fixed 'elseif' to 'else if'
            else if (tokens[i].equals("+")) {
                r = stack.pop() + stack.pop();
                stack.push(r);
            } 
            else if (tokens[i].equals("/")) {
                int divisor = stack.pop();
                int divident = stack.pop();
                r = divident / divisor;
                stack.push(r);
            } 
            else if (tokens[i].equals("-")) {
                int divisor = stack.pop();
                int divident = stack.pop();
                r = divident - divisor;
                stack.push(r);
            } 
            else {
                // Fixed String to int conversion
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        // Return the final integer, not the Stack object
        return stack.pop();
    }
}