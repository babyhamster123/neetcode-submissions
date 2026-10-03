class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sanity check
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // sort the array
        Arrays.sort(nums);

        // fix one num and search in the rest
        // since sorted, we can skip consecutive same nums[i]
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> pairs = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> p : pairs) {
                p.add(nums[i]);
                result.add(p);
            }
        }

        return result;
    }


    // return all the unique tuplets
    public List<List<Integer>> twoSum(int[] sortedNums, int startIndex, int target) {
        // use two pointers to scan the right pair
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = startIndex, j = sortedNums.length - 1; i < j;) {
            if (i > startIndex && sortedNums[i] == sortedNums[i - 1]) {
                i++;
                continue;
            }

            int sum = sortedNums[i] + sortedNums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                List<Integer> pair = new ArrayList<>();
                pair.add(sortedNums[i]);
                pair.add(sortedNums[j]);
                pairs.add(pair);
                i++;
            }
        }

        return pairs;
    }
}
