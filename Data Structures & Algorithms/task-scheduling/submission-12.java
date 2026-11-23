class Solution {

    private class Task {
        int count;
        int readyAt;

        Task(int count) {
            this.count = count;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char task : tasks) {
            Integer count = frequencies.get(task);
            if (count == null) {
                frequencies.put(task, 1);
            } else {
                frequencies.put(task, count + 1);
            }
        }

        PriorityQueue<Task> ready = new PriorityQueue<>(new Comparator<Task>(){
            public int compare(Task a, Task b) {
                if (a.count == b.count) {
                    return 0;
                }
                if (a.count > b.count) {
                    return -1;
                }
                return 1;
            }
        });

        for (int count : frequencies.values()) {
            ready.add(new Task(count));
        }

        Deque<Task> cooling = new ArrayDeque<>();
        int time = 0;
        while (!ready.isEmpty() || !cooling.isEmpty()) {
            // fast forward time 
            if (ready.isEmpty()) {
                time = Math.max(cooling.peekFirst().readyAt, time);
            }

            // add back cooled tasks
            while (!cooling.isEmpty() && cooling.peekFirst().readyAt <= time) {
                ready.offer(cooling.pollFirst());
            }

            Task task = ready.poll();
            task.count--;
            time++;
            if (task.count > 0) {
                task.readyAt = time + n;
                cooling.offerLast(task);
            }
        }

        return time;
    }
}