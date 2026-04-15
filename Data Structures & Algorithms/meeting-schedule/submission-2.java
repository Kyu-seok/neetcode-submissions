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
        if (intervals == null || intervals.size() == 0) return true;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            int newStart = intervals.get(i).start;
            int newEnd = intervals.get(i).end;

            if (newStart < end) return false;

            end = newEnd;
        }

        return true;
    }
}
