class Solution {
    public int partitionString(String s) {
        
        int count = 0 ; 
        
        HashSet<Character> letter =new HashSet<Character>();
        
        for(int i=0;i<s.length();i++){
            if(letter.contains(s.charAt(i))){
                letter.clear();
                count ++;
            }
            
            letter.add(s.charAt(i));
        }
        
        return count+1 ;
    }
}