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
            int midI = mid / n;
            int midJ = mid % n;
            int midVal = matrix[midI][midJ];
            if (midVal == target) {
                return true;
            }

            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
