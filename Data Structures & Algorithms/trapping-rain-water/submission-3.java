class Solution {
    public int trap(int[] height) {
        // sanity check
        int[] h = height;
        if (h == null || height.length < 3) {
            return 0;
        }

        // prefix[i]: the height of the highest bar to the left of i
        int[] prefix = getPrefix(h);

        // suffix[i]: the height of the highest bar to the right of i
        int[] suffix = getSuffix(h);

        // amount[i] = max(0, min(suffix[i], prefix[i]) - h[i])
        int result = 0;
        for (int i = 0; i < h.length; i++) {
            int amount = Math.max(0, Math.min(suffix[i], prefix[i]) - h[i]);
            result = amount + result;
        }

        return result;
    }

    private int[] getPrefix(int[] h) {
        int[] p = new int[h.length];
        for (int i = 0; i < h.length; i++) {
            if (i == 0) {
                p[i] = 0;
                continue;
            }

            p[i] = Math.max(p[i - 1], h[i - 1]);
        }
        return p;
    }

    private int[] getSuffix(int[] h) {
        int[] s = new int[h.length];
        for (int j = h.length - 1; j >=0; j--) {
            if (j == h.length - 1) {
                s[j] = 0;
                continue;
            }

            s[j] = Math.max(s[j + 1], h[j + 1]);
        }
        return s;
    }
}
