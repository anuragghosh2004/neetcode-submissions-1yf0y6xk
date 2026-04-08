class Solution {

    public String encode(List<String> strs) {
        StringBuilder ss = new StringBuilder();
        for(String s : strs){
            ss.append(s.length()).append('#').append(s);
        } 
        return ss.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < str.length(); ) {
            // FIX 1: Initialize the variable to prevent compiler errors
            int hashposition = 0; 
            
            // Your manual loop to find the '#'
            for(int k = i; k < str.length(); k++){
                char ch = str.charAt(k);
                if (ch == '#'){
                    hashposition = k;
                    break;
                }
            }
            
            int len = Integer.parseInt(str.substring(i, hashposition));
            
            // FIX 2: Corrected spelling of 'hashposition'
            int j = hashposition + 1; 
            int upl = j + len;
            
            String ans = str.substring(j, upl);
            list.add(ans);
            i = upl;
        }
        return list;
    }
}