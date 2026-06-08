class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();

        for (String deadend : deadends) {
            deads.add(deadend);
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int count = 0;

        if (deads.contains("0000")) return -1;

        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (target.equals(current)) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    char[] charArr = current.toCharArray();
                    if (charArr[j] == '9') {
                        charArr[j] = '0';
                    } else {
                        charArr[j]++;
                    }
                    String next = new String(charArr);
                    if (!visited.contains(next) && !deads.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }

                for (int j = 0; j < 4; j++) {
                    char[] charArr = current.toCharArray();
                    if (charArr[j] == '0') {
                        charArr[j] = '9';
                    } else {
                        charArr[j]--;
                    }
                    String next = new String(charArr);
                    if (!visited.contains(next) && !deads.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            count++;
        }

        return -1;
    }
}