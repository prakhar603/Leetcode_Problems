class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int i = 0; 
        int j = matrix[0].length -1 ; 
        
        while(i >=0 && i < matrix.length && j>=0 && j < matrix[0].length) {
            
            int num = matrix[i][j] ; 
            
            if(num == target) return true ; 
            
            else if(num > target) j-- ; 
            else if(num < target) i++ ; 
        }
        return false ; 
    }
}