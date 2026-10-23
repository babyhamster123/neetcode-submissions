class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // sanity
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // binary search
        // 1D index = i x n + j
        // n: matrix[0].length
        // m: matrix.length
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int mid_i = mid / n;
            int mid_j = mid % n;
            int mid_val = matrix[mid_i][mid_j];
            if (mid_val == target) {
                return true;
            }

            if (mid_val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
