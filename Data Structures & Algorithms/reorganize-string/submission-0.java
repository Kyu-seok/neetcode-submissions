class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxFreq = 0;

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            maxFreq = Math.max(maxFreq, count[c - 'a']);
        }

        if (maxFreq > (s.length() + 1) / 2) return "";

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.offer(new Pair((char) ('a' + i), count[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = null;

        while (!maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            if (curr == null) return "";

            sb.append(curr.ch);
            curr.freq--;

            if (prev != null) {
                maxHeap.offer(prev);
                prev = null;
            }

            if (curr.freq > 0) {
                prev = curr;
            }
        }

        return sb.toString();
    }

    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}