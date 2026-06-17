

class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE; // Must be a large number so 'len < min' works on the first try
        String ss = "";              // Must be initialized to avoid compilation errors
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        // Fill up map1 with the frequency of characters in string t
        int c = 0; 
        while (c < t.length()) {
            map1.put(t.charAt(c), map1.getOrDefault(t.charAt(c), 0) + 1);
            c++;
        }
        
        while (r < s.length()) {
            // Only add the character to map2 if it's required by map1
            if (map1.containsKey(s.charAt(r))) {
                map2.put(s.charAt(r), map2.getOrDefault(s.charAt(r), 0) + 1);
            }
            
            // Shrink the window from the left *while* the current window has all required characters
            while (isValid(map1, map2)) {
                int len = r - l + 1;
                
                // If we found a smaller valid window, update our minimum and result string
                if (len < min) {
                    min = len; 
                    ss = s.substring(l, r + 1);
                }
                
                // Shrink from the left: remove the left character from map2 if it's leaving the window
                char leftChar = s.charAt(l);
                if (map1.containsKey(leftChar)) {
                    map2.put(leftChar, map2.get(leftChar) - 1);
                }
                l++;
            }
            
            r++;
        }
        
        return ss;
    }
    
    // Helper method to check if map2 has at least the character counts required by map1
    private boolean isValid(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (Character key : map1.keySet()) {
            // Strictly less than (<): if we are missing even one required character, the window is invalid
            if (map2.getOrDefault(key, 0) < map1.get(key)) {
                return false;
            }
        }
        return true;
    }
}