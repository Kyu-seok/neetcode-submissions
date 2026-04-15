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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }

            return Integer.compare(a.end, b.end);
        });

        int lastEnd = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (interval.start < lastEnd) {
                return false;
            }

            lastEnd = interval.end;
        }

        return true;
    }
}
