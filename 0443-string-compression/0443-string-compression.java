class Solution {
    public int compress(char[] chars) {
        
        int curIdx = 0 ; 
        int idx = 0 ; 
        
        while(idx < chars.length) {
            
            char c = chars[idx] ; 
            int count = 0 ; 
            
            while(idx < chars.length && chars[idx] == c) {
                count++ ; 
                idx++ ; 
            }
            
            chars[curIdx++] = c ;  
            
            if(count != 1) {
               // System.out.println("entering loop") ; 
                char[] temp = Integer.toString(count).toCharArray() ; 
                
                for(char ch : temp) {
                    chars[curIdx++] = ch ; 
                   // System.out.println(chars[curIdx-1] ) ; 
                }
            }    
        }
        return curIdx ; 
    }
}