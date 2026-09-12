import java.util.*;

class Solution { // tc TC = O(n log n) and sc is O(N)

    int[][] a;
    Result[][] dp;

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0); // left
            a[i][1] = intervals.get(i).get(1); // right
            a[i][2] = intervals.get(i).get(2); // weight
            a[i][3] = i;                       // original index
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x[1], y[1]));

        dp = new Result[n][5];

        Result ans = solve(n - 1, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    private Result solve(int i, int k) {

        if (i < 0 || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // SKIP
        Result skip = solve(i - 1, k);

        // TAKE
        int prev = findPrevious(i);

        Result previous = solve(prev, k - 1);

        long takeScore = a[i][2] + previous.score;

        List<Integer> takeList = new ArrayList<>(previous.indices);
        takeList.add(a[i][3]);

        Collections.sort(takeList);

        Result take = new Result(takeScore, takeList);

        // Choose better score
        // If equal, choose lexicographically smaller indices
        if (take.score > skip.score) {
            dp[i][k] = take;
        } 
        else if (take.score < skip.score) {
            dp[i][k] = skip;
        } 
        else {
            dp[i][k] = lexicographicallySmaller(
                take.indices,
                skip.indices
            ) ? take : skip;
        }

        return dp[i][k];
    }

    private int findPrevious(int i) {

        int target = a[i][0];

        int low = 0;
        int high = i - 1;
        int ans = -1;

        // Need right < current left
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (a[mid][1] < target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean lexicographicallySmaller(
            List<Integer> x,
            List<Integer> y) {

        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {

            if (!x.get(i).equals(y.get(i))) {
                return x.get(i) < y.get(i);
            }
        }

        return x.size() < y.size();
    }
}