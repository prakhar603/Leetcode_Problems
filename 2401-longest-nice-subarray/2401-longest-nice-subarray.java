class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int start = 0 ; 
        int end = 1 ; 
        int curSum = nums[start] ; 
        int ans = 1  ;

        while(end < nums.length) {

            while((curSum & nums[end]) != 0) {
                curSum^= nums[start++] ; 
            }
            curSum += nums[end] ; 
            ans = Math.max(ans, end-start+1) ; 
            end++ ; 
        }

    return ans ; 
    }
}