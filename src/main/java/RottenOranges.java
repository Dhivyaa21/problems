import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {
        Queue<Coordinate> queue = new ArrayDeque<>();

        int ans = 0;
        int freshOranges = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[] rNbrs = {-1, 0, 0, 1};
        int[] cNbrs = {0, -1, 1, 0};

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 2) {
                    Coordinate coordinate = new Coordinate(row, col);
                    queue.add(coordinate);
                }
                if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        while (freshOranges > 0 && !queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                System.out.println("ans - " + ans + " : queue size - " + qSize);
                Coordinate coordinate = queue.remove();
                int r = coordinate.row;
                int c = coordinate.col;
                for (int k = 0; k< 4; k++) {
                    int rNbr = r + rNbrs[k];
                    int cNbr = c + cNbrs[k];

                    if (rNbr >= 0 && cNbr >= 0 && rNbr < rowSize && cNbr < colSize && grid[rNbr][cNbr] == 1) {
                        grid[rNbr][cNbr] = 2;
                        Coordinate coord = new Coordinate(rNbr, cNbr);
                        queue.add(coord);
                        freshOranges--;
                    }
                }
            }
            ans++;
        }

        if (freshOranges > 0) return -1;
        return ans;
    }

    public static void main(String[] args) {
        int[][] input = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        //int[][] input = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        //int[][] input = {{0, 2}};
        printFrame(input);
        System.out.println(orangesRotting(input));
        printFrame(input);
    }

    public static void printFrame(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Coordinate {
    public int row;
    public int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}