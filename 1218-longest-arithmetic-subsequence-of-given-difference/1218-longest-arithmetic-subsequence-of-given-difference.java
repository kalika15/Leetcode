import java.util.*;

class Solution {
    int size;
    int[] next;

    public int longestSubsequence(int[] arr, int difference) {
        size = arr.length;
        next = new int[size];
        calculateNext(arr, difference);
        return solve(size - 1, arr, difference)+1;
    }

    private void calculateNext(int[] arr, int difference) {
        Arrays.fill(next, -1);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        for (int i = 1; i < size; i++) {
            if (map.containsKey(arr[i] - difference))
                next[i] = map.get(arr[i] - difference);
            map.put(arr[i], i);
        }
    }

    private int solve(int n, int[] arr, int difference) {
        if (n == 0)
            return 0;
        else
            return Math.max(solve(n - 1, arr, difference), solve2(n, arr, difference));
    }

    private int solve2(int idx, int[] arr, int difference) {
        if (idx < 0)
            return 0;
        else if (next[idx] == -1)
            return 0;
        else
            return 1 + solve2(next[idx], arr, difference);
    }
}
