class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // per the problem constaint, answer is alwyas unique for the test cases
        // sanity check
        int[] topK = new int[k];
        if (nums == null || k == 0 || nums.length < k) {
            return topK;
        }

        // count the frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        // allocate a bucket to track the frequency to its num
        List<List<Integer>> freqBucket = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            freqBucket.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int num = e.getKey();
            int freq = e.getValue();
            freqBucket.get(freq).add(num);
        }

        // scan the bucket reverse for the top k
        int j = 0;
        for (int i = freqBucket.size() - 1; i >= 0; i--) {
            List<Integer> numsAtFreq = freqBucket.get(i);
            for (int n : numsAtFreq) {
                topK[j] = n;
                j++;
                if (j >= topK.length) {
                    return topK;
                }
            }
        }

        return topK;
    }
}
