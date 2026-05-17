class Solution {
    public int characterReplacement(String s, int k) {
       int l =0; int r =0;int size= 0 ; int max = 0 ;int mlen=0;
       HashMap<Character,Integer>map = new HashMap<>();
       while(r<s.length()){
     map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
     size = r-l+1;
     for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if(entry.getValue()>max){
          max=entry.getValue();
        }   
          }
     
     if(size - max >k){ map.put(s.charAt(l),map.get(s.charAt(l))-1);
        l++;}
        mlen=Math.max(mlen, r-l+1);
     r++;
       } 
       return mlen;
    }
}
