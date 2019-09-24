package ArraysAndStrings;

import java.util.Arrays;

public class MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int rooms = 0;
        int[] startIntervals = new int[n];
        int[] endIntervals = new int[n];
        int i = 0;
        while (i < n) {
            startIntervals[i] = intervals[i][0];
            endIntervals[i] = intervals[i][1];
            i++;
        }
        Arrays.sort(startIntervals);
        Arrays.sort(endIntervals);
        int start = 0, end = 0;
        while (start < n) {
            if (startIntervals[start] < endIntervals[end])
                rooms++;
            else
                end++;
            start++;
        }
        return rooms;
    }
}
