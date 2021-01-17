import java.util.ArrayDeque;
import java.util.Queue;

public class IslandsCounter {
    public static int numIslands(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int islands = 0;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true;
                    DFS(grid, visited, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void DFS(char[][] input, boolean[][] visited, int row, int col) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int R = input.length;
        int C = input[0].length;
        int[] rNbr = {-1, 0, 0, 1};
        int[] cNbr = {0, -1, 1, 0};

        queue.add(row * C + col);
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = (code / C);
            int c = (code % C);
            for (int k = 0; k < 4; k++) {
                int rowNbr = r + rNbr[k];
                int colNbr = c + cNbr[k];

                if (rowNbr >= 0 && colNbr >= 0 && rowNbr < R && colNbr < C && input[rowNbr][colNbr] == '1' && !visited[rowNbr][colNbr]) {
                    visited[rowNbr][colNbr] = true;
                    queue.add(rowNbr * C + colNbr);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
}
