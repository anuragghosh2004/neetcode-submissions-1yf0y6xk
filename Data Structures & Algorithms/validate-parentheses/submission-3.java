class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character>map = new HashMap<>();
        Stack<Character>st = new Stack<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        int i =0;
        while(i<s.length()){
            if(map.containsKey(s.charAt(i))){
                if(!st.isEmpty() && st.peek()==map.get(s.charAt(i))){
                    st.pop();
                    
                }
                else {return false;}
            }
            else{
                st.push(s.charAt(i));
            }
         i++;
        }
     return st.isEmpty();
    }
}
