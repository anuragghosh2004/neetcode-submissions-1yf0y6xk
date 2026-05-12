class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0; int r = 0;
        int maxx =0;int ll=0;
        HashSet<Character>set= new HashSet<>();
        while(r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            ll=r-l+1;
            maxx = Math.max(maxx,ll);

         set.add(s.charAt(r));
         r++;
        }
        return maxx;
    }
   

}
