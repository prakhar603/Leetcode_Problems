class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int max = arr.length - 1;
        int min = 0;
        int ans = -1;
        
        while (max >= min) {
            int mid = (max + min) / 2;
            if (arr[mid] - mid - 1 >= k) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        if (ans == -1) {
            return arr[arr.length - 1] + (k - (arr[arr.length - 1] - arr.length));
        } else {
            return arr[ans] - ((arr[ans] - ans - 1) - k + 1);
        }
    }
}