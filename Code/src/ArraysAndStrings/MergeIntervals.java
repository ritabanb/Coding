package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int[][] result = new int[len][2];
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int index = 0, i = 0;

        while (i < len) {
            result[index][0] = intervals[i][0];
            result[index][1] = intervals[i][1];
            for (int j = i + 1; j < len; j++) {
                if (result[index][0] <= intervals[j][0] && intervals[j][0] <= result[index][1]) {
                    if (intervals[j][1] > result[j][1]) {
                        result[index][1] = intervals[j][1];
                        i = j;
                    }
                }
            }
            index++;
            i++;
        }
        return result;
    }

    public int[][] merge1(int[][] intervals) {
        int len = intervals.length;
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int i = 0;

        while (i < len) {
            List<Integer> res = new ArrayList<>();
            res.add(intervals[i][0]);
            res.add(intervals[i][1]);
            for (int j = i + 1; j < len; j++) {
                if (res.get(0) <= intervals[j][0]
                        && intervals[j][0] <= res.get(1)) {
                    if (intervals[j][1] >= res.get(1)) {
                        res.set(1, intervals[j][1]);
                    }
                    i = j;
                }
            }
            i++;
            resultList.add(res);
        }

        int[][] result = new int[resultList.size()][2];
        for (i = 0; i < resultList.size(); i++) {
            List<Integer> row = resultList.get(i);
            result[i] = row.stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 3}};
        MergeIntervals obj = new MergeIntervals();
        int[][] result = obj.merge1(intervals);
        for (int[] res : result) {
            for (int r : res) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
