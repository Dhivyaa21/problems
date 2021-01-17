import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland {
    public static int treasureIsland(char[][] island) {
        int rSize = island.length;
        int cSize = island[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rSize][cSize];
        //int steps = 1;
        int[] point = {0, 0};
        queue.add(point);
        visited[0][0] = true;

        int[] rNbr = {-1, 0, 0, 1};
        int[] cNbr = {0, -1, 1, 0};
        //int[][] nbrs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int steps = 1; !queue.isEmpty(); steps++) {
            for (int sz = queue.size(); sz > 0; sz--) {
                int[] coordinate = queue.poll();
                int row = coordinate[0];
                int col = coordinate[1];
                System.out.println(row + "," + col);
                for (int k = 0; k < 4; k++) {
                    int rowNbr = row + rNbr[k];
                    int colNbr = col + cNbr[k];
                    if (rowNbr >= 0 && colNbr >= 0 && rowNbr < rSize && colNbr < cSize && !visited[rowNbr][colNbr] && island[rowNbr][colNbr] != 'D') {
                        if (island[rowNbr][colNbr] == 'X') {
                            return steps;
                        }
                        int[] p = {rowNbr, colNbr};
                        queue.add(p);
                        //System.out.println(rowNbr + "," + colNbr);
                        visited[rowNbr][colNbr] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] input = {
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
        System.out.println(treasureIsland(input));
    }
}
