class Node {
    int row; 
    int col;
    int time;
    public Node(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int minimumTime(int[][] grid) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.time - n2.time);
        
        int[][] time = new int[grid.length][grid[0].length];
        for(int[] t : time) {
            Arrays.fill(t, Integer.MAX_VALUE);
        }

        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        minHeap.offer(new Node(0, 0, 0));
        time[0][0] = 0;
        
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int currRow = node.row;
            int currCol = node.col;
            int currTime = node.time;

            if(currTime > time[currRow][currCol]) {
                continue;
            }

            for(int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                    if(currTime + 1 < time[newRow][newCol]) {
                        if(currTime + 1 >= grid[newRow][newCol]) {
                            time[newRow][newCol] = currTime + 1;
                        } else {
                            time[newRow][newCol] = (grid[newRow][newCol] % 2) == (currTime % 2) ? grid[newRow][newCol] + 1 : grid[newRow][newCol];
                        }
                        minHeap.offer(new Node(newRow, newCol, time[newRow][newCol]));
                    }
                    
                }
            } 
        }
        
        return time[grid.length - 1][grid[0].length - 1];
    }
}