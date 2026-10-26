class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Slice a = new Slice(nums1, 0, nums1.length);
        Slice b = new Slice(nums2, 0, nums2.length);
        int total = a.size() + b.size();

        int upper = kth(a, b, total / 2 + 1);
        int lower = total % 2 == 0
                ? kth(a, b, total / 2)
                : upper;

        return ((double) lower + upper) / 2.0;
    }

    // k is a 1-based rank among the elements in a and b.
    private int kth(Slice a, Slice b, int k) {
        if (a.size() == 0) {
            return b.get(k - 1);
        }
        if (b.size() == 0) {
            return a.get(k - 1);
        }

        int i = a.size() / 2;
        int j = b.size() / 2;

        // Keep the smaller middle value in a.
        if (a.get(i) > b.get(j)) {
            return kth(b, a, k);
        }

        int boundaryRank = i + j + 1;

        if (k <= boundaryRank) {
            // B's middle and everything after it are too late.
            return kth(a, b.before(j), k);
        }

        // A's middle and everything before it are too early.
        return kth(a.after(i), b, k - (i + 1));
    }

    // A view of values[from..to), without copying.
    private record Slice(int[] values, int from, int to) {
        int size() {
            return to - from;
        }

        int get(int index) {
            return values[from + index];
        }

        Slice before(int index) {
            return new Slice(values, from, from + index);
        }

        Slice after(int index) {
            return new Slice(values, from + index + 1, to);
        }
    }
}