package ArraysAndStrings;

import java.util.Arrays;

public class KClosestPointToOrigin {
    private double distanceFromOrigin(int[] point) {
        return Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
    }

    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        double[] distance = new double[len];
        for (int i = 0; i < len; i++) {
            distance[i] = distanceFromOrigin(points[i]);
        }

        Arrays.sort(distance);
        int[][] result = new int[K][2];
        int idx = 0;
        double kDistance = distance[K-1];

        for (int i = 0; i < len; i++) {
            if (distanceFromOrigin(points[i]) <= kDistance) {
                result[idx++] = points[i];
            }
        }
        return result;
    }
}
