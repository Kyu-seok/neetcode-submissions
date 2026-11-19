class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cycle = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<TaskInfo> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.nextAvailable != b.nextAvailable) {
                return Integer.compare(a.nextAvailable, b.nextAvailable);
            }

            return Integer.compare(a.count, b.count);
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            minHeap.offer(new TaskInfo(entry.getKey(), entry.getValue(), 0));
        }

        while (!minHeap.isEmpty()) {
            if (minHeap.peek().nextAvailable <= cycle) {
                TaskInfo ti = minHeap.poll();
                ti.count--;
                if (ti.count > 0) {
                    ti.nextAvailable += n + 1;
                    minHeap.offer(ti);
                }
            }
            cycle++;
        }

        return cycle;

    }

    class TaskInfo {
        char task;
        int count;
        int nextAvailable;

        TaskInfo(char task, int count, int nextAvailable) {
            this.task = task;
            this.count = count;
            this.nextAvailable = nextAvailable;
        }
    }
}
