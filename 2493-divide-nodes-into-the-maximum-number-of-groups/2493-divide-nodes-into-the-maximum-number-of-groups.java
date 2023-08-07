

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        List<Set<Integer>> components = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (seen.contains(i)) {
                continue;
            }
            Deque<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(i);
            visited.add(i);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            components.add(visited);
            seen.addAll(visited);
        }
        
        int[] longest = new int[components.size()];
        Arrays.fill(longest, -1);
        for (int k = 0; k < components.size(); k++) {
            for (int i : components.get(k)) {
                longest[k] = Math.max(longest[k], bfs(graph, i));
            }
        }
        
        int total = 0;
        for (int l : longest) {
            total += l;
        }
        if (Arrays.stream(longest).min().getAsInt() < 0) {
            return -1;
        }
        return total;
    }
    
    public int bfs(Map<Integer, List<Integer>> graph, int i) {
        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> seenLevel = new HashSet<>();
        queue.offer(i);
        seen.add(i);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            Set<Integer> nextLevel = new HashSet<>();
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                int node = queue.poll();
                for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (seenLevel.contains(neighbor)) {
                        return -1;
                    }
                    if (seen.contains(neighbor)) {
                        continue;
                    }
                    seen.add(neighbor);
                    nextLevel.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            seenLevel = nextLevel;
        }
        return ans;
    }
}
