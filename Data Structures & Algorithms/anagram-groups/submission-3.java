class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<HashMap<Character,Integer>,ArrayList<String>>prefinal=new HashMap<>();
        ArrayList<List<String>>arr= new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            String st= strs[i];
            HashMap<Character,Integer>anagramap=new HashMap<>();
            for(int j=0;j<st.length();j++){
           anagramap.put(st.charAt(j),anagramap.getOrDefault(st.charAt(j),0)+1);
            }
prefinal.putIfAbsent(anagramap,new ArrayList<String>());
prefinal.get(anagramap).add(st);

        }
        for(Map.Entry<HashMap<Character,Integer>,ArrayList<String>>entry:prefinal.entrySet()){
arr.add(entry.getValue());
        }

        return arr;
    }
}
