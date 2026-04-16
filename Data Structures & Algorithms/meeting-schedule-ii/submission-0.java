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
        Collections.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));

        List<List<Interval>> rooms = new ArrayList<>();

        for (Interval interval : intervals) {
            boolean hasAdded = false;

            int i = 0;
            while (!hasAdded && i < rooms.size()) {
                List<Interval> room = rooms.get(i);
                if (room.get(room.size() - 1).end <= interval.start) {
                    room.add(interval);
                    hasAdded = true;
                }
                i++;
            }

            if (!hasAdded) {
                List<Interval> room = new ArrayList<>();
                room.add(interval);
                rooms.add(room);
            }
        }

        return rooms.size();
    }
}
