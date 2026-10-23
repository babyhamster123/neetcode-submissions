class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // sanity check
        if (piles == null || piles.length == 0 || h <= 0) {
            return -1;
        }

        // use binary search to find the min k speed so koko can finish it within h hours
        // all the indiecs representt the speed
        int left = 1;
        int right = Integer.MAX_VALUE;
        int result = right;
        while (left <= right) {
            // to keep simple, just take care the overflow with this appraoch, assuming the timeToEat return int is also enough. we can discuss if extra handle needed
            int mid = left + (right - left) / 2;
            int t = timeToEat(piles, mid);
            // too slow, need speed up
            if (t > h) { 
                left = mid + 1;
            } else { // fast enough, lets keep search see if converge ?
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    private int timeToEat(int[] piles, int k) {
        int result = 0;
        for (int p : piles) {
            result = result + p / k + (p % k == 0 ? 0 : 1);
        }
        
        return result;
    }
}
