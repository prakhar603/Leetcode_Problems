class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<>() ; 
        
        for(String s : strs) {
            char[] charArray = s.toCharArray() ; 
            Arrays.sort(charArray) ; 
            String temp = String.valueOf(charArray) ; 
            
            if(!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>()) ; 
            }
            map.get(temp).add(s) ; 
        }
        List<List<String>> ansList = new ArrayList<>() ; 
        
        for(List<String> li : map.values()) {
            ansList.add(li) ; 
        }
        return ansList ;
    }
}