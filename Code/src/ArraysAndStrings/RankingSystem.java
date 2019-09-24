package ArraysAndStrings;

import java.util.*;

public class RankingSystem {
    public void rankScores(String[] scores) {
        Arrays.sort(scores, Collections.reverseOrder());
        int len = scores.length;
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String key = scores[i].split("\\s+")[0];
            int[] arr;
            if ((arr = map.get(key)) == null)
                arr = new int[]{i, 0};
            arr[1]++;
            map.put(key, arr);
        }
        int[][] groups = map.values().toArray(new int[map.size()][]);
        for (int i = 0, rank = 0, group = 0; i < len; i++) {
            if (group < groups.length && i == groups[group][0]) {
//                rank = i + 1;
                rank++;
                group++;
            }
            System.out.printf("%d %s%n", rank, scores[i]);
        }
    }

    public static void main(String[] args) {
        String[] scores = {"42 Solomon", "44 Jason", "42 Errol",
                "41 Garry", "41 Bernard", "50 Barry", "39 Stephen"};
        RankingSystem obj = new RankingSystem();
        obj.rankScores(scores);
    }
}
