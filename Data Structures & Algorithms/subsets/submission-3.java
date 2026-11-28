class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // sanity check
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // traverse
        List<Integer> path = new ArrayList<>();
        subsets(nums, 0, path, result);
        return result;
    }

    private void subsets(int[] nums, int i, List<Integer> path, List<List<Integer>> result) {
        // sanity check
        if (i >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // skip current
        subsets(nums, i + 1, path, result);

        // pick current
        path.add(nums[i]);
        subsets(nums, i + 1, path, result);
        path.removeLast();
    }
}
