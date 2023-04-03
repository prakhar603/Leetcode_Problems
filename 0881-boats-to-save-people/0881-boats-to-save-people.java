class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
       Arrays.sort(people) ; 
       
        int count = 0 ; 
        int i = 0 ; 
        int j = people.length - 1 ; 
        
        while(i <= j) {
            int sum = people[i] + people[j] ; 
            
            if(sum <= limit) {
                i++ ; 
                j-- ; 
                count++ ; 
            }
            else if(sum > limit) {
                j-- ; 
                count++ ; 
            }
        }
    
        return count ; 
        
    }
}