class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // sanity check
        if (nums1 == null || nums2 == null) {
            return 0;
        }

        // depending on odd or even count, we use findKth
        int m = nums1.length;
        int n = nums2.length;
        int t = m + n;
        if (t % 2 == 0) { // find t/2 and t/2 + 1
            return (double)(findKth(nums1, nums2, t / 2) + findKth(nums1, nums2, t / 2 + 1)) / 2;
        }

        return (double)(findKth(nums1, nums2, t / 2 + 1));
    }

    private int findKth(int[] a, int[] b, int k) {
        // to form the k nums, we will take some continous nums from a and rest from b
        // here we search the a, range from -1 to all elements in a
        // -1 means taken 0 from a
        int left = -1;
        int right = a.length - 1;
        int resultCountTakenFromA = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int aNext = mid + 1;
            int countTakenFromA = mid + 1;
            int countTakenFromB = k - countTakenFromA;
            int bLast = countTakenFromB - 1;

            if (countTakenFromB < 0) { // invalid
                right = mid - 1;
            } else if (countTakenFromB > b.length) { // invalid
                left = mid + 1;
            } else if (aNext == a.length) { // take all from A, enough
                resultCountTakenFromA = countTakenFromA;
                right = mid - 1;
            } else if (bLast == -1) { // take none from B, enough
                resultCountTakenFromA = countTakenFromA;
                right = mid - 1;
            } else if (a[aNext] < b[bLast]) { // need to take more from A
                left = mid + 1;
            } else { // taken from A is enough, let's keeping search for the least taken from A
                resultCountTakenFromA = countTakenFromA;
                right = mid - 1;
            }
        }

        int countTakenFromB = k - resultCountTakenFromA;
        if (resultCountTakenFromA == 0) {
            return b[countTakenFromB - 1];
        }

        if (countTakenFromB == 0) {
            return a[resultCountTakenFromA - 1];
        }

        return Math.max(
                a[resultCountTakenFromA - 1],
                b[countTakenFromB - 1]
        );
    }
}
