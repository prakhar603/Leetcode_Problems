class Solution {
    public int maximumCount(int[] nums) {
        
        int n = nums.length ; 
        int lastNegative =  findNegative(nums, 0) ; 
        int firstPositive = n - findNegative(nums, 1) ;
        
        return Math.max(lastNegative, firstPositive) ; 
        
    }
    public int findNegative(int[] nums, int num) {
        
        int l = 0 ; 
        int r = nums.length - 1 ; 
        
        while(l <= r) {
            int mid = (l + r)/2 ; 
            
            if(nums[mid] == num) {
                r = mid-1 ; 
            }
            else if(nums[mid] < num) {
                l = mid+1 ; 
            }
            else {
                r = mid -1 ; 
            }
        }
        return l ; 
    }
}