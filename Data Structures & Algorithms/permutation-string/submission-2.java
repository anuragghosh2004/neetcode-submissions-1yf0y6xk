class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer>map1= new HashMap<>();
        HashMap<Character,Integer>map2=new HashMap<>();
        int fl=0;
        for (int i =0 ;i<s1.length();i++){
          map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);}
          int l=0;int r=0;
          while(r<s2.length()){
            map2.put(s2.charAt(r),map2.getOrDefault(s2.charAt(r),0)+1);
            while(map2.getOrDefault(s2.charAt(r),0)>map1.getOrDefault(s2.charAt(r),0) || 
            map1.containsKey(s2.charAt(r))!=true && l<r) {
              if(map2.getOrDefault(s2.charAt(l),0)>1){
                map2.put(s2.charAt(l),map2.get(s2.charAt(l))-1);
              }else{
                map2.remove(s2.charAt(l));
              }
              l++;
            }
            
            if(map2.equals(map1)){
              fl=1;
              break;
            }
            r++;
          }
          if (fl ==1){
            return true;
          }
          else{return false;}
    }
}
