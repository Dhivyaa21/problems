public class MinCostPath {

    static int minCost(int[][] cost, int r, int c) {
        if (r < 0 || c < 0) {
            return Integer.MAX_VALUE;
        }
        else if (r == 0 || c == 0) {
            return cost[r][c];
        }
        else {
            return cost[r][c] + min(minCost(cost, r, c -1),
                    minCost(cost, r - 1, c - 1),
                    minCost(cost, r - 1, c));
        }
    }

    static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    public static void main(String args[])
    {
        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3} };

        System.out.print(minCost(cost, 2, 2));
    }
}
