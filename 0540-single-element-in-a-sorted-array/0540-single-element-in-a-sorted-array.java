class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int l = 0 ; 
        int r = nums.length-1 ; 
        
        
        while(l < r) {
            
            int mid = l + (r-l)/2 ; 
            //System.out.println(mid) ; 
         
            //check number of elements on right side from mid pointer
            //if even number, it means numbers are associated in pair
            if(nums[mid] == nums[mid-1]) {
                if((r - mid) % 2 == 0) {
                    r = mid-2 ; 
                }
                else {
                    l = mid+1 ; 
                }
            }
            else if(nums[mid] == nums[mid+1]) {
                if((r - mid) % 2 == 0) {
                    l = mid+2 ; 
                }
                else {
                    r = mid-1 ; 
                }
            }
            else {
                return nums[mid] ; 
            }
        }
        return nums[l] ; 
    }
}

//T.C = O(log n) 
//S.C = O(1)