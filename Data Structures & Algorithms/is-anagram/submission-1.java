class Solution {
    public boolean isAnagram(String s, String t) {
HashMap<Character,Integer>ss =new HashMap<>();
HashMap<Character,Integer>tt=new HashMap<>();
for(char c:s.toCharArray()){
    ss.put(c,ss.getOrDefault(c,0)+1);
}
for(char p:t.toCharArray()){
    tt.put(p,tt.getOrDefault(p,0)+1);
}
if(ss.equals(tt)){
    return true;
}
else{return false;}
}
}