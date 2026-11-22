class Solution {
    public int leastInterval(char[] tasks, int n) {
        // sanity check
        if (tasks == null || tasks.length == 0 || n < 0) {
            return 0;
        }

        // count char freq
        int maxF = 0;
        Map<Character, Integer> taskCount = new HashMap<>();
        for (char t : tasks) {
            Integer count = taskCount.get(t); 
            if (count == null) {
                count = 0;
            }
            count++;
            taskCount.put(t, count);
            maxF = Math.max(maxF, count);
        }

        return Math.max(tasks.length, (n + 1) * (maxF - 1) + countTasksWithCount(maxF, taskCount));
    }

    private int countTasksWithCount(int count, Map<Character, Integer> taskCount) {
        int result = 0;
        for (int c : taskCount.values()) {
            if (c == count) {
                result ++;
            }
        }
        return result;
    }
}
