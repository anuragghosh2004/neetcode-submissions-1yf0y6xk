class Solution {
    public boolean isPalindrome(String s) {
       int i=0;int j=s.length()-1;
       while(i<j){
        while(i<j && !(isAlphanumeric(s.charAt(i))) ){
            i++;
            
        }
           while(j>i && !(isAlphanumeric(s.charAt(j))) ){
            
            j--;
        }
        if(Character.toLowerCase(s.charAt(j))!=Character.toLowerCase(s.charAt(i))){
return false;
        }
        i++;j--;
       }
       return true;
}
public boolean isAlphanumeric(char c){
    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
        return true;
    } else {
        return false;
    }
}}
