
class Solution {
    private int solve(Map<Character, Integer> D) {
        int count = 0;
        for (Map.Entry<Character, Integer> entry : D.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value > 0) {
                entry.setValue(value - 1);
                count += solve(D);
                entry.setValue(value);
            }
        }
        return count + 1;
    }

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> D = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            D.put(c, D.getOrDefault(c, 0) + 1);
        }
        return solve(D) - 1;
    }
}
