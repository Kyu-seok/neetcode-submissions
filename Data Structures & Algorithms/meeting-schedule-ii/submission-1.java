/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] arr = new int[1_000_001];

        int max = 0;

        for (Interval interval : intervals) {
            for (int i = interval.start; i <= interval.end; i++) {
                arr[i]++;
                max = Math.max(max, arr[i]);
            }
        }

        return max;
    }
}
