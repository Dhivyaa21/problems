import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Battleship {
    public static String solution(int N, String S, String T) {
        int shipsHit = 0;
        int shipsSunk = 0;
        List<String> hits = Arrays.asList(T.split(" "));
        String[] ships = S.split(",");
        for (String ship: ships) {
            List<String> battleShip = new ArrayList<>();
            for (int row = ship.charAt(0); row <= ship.charAt(3); row++) {
                for (int col = ship.charAt(1); col <= ship.charAt(4); col++) {
                    System.out.println("" + (char)row + (char)col);
                    battleShip.add("" + (char)row + (char)col);
                }
            }
            long fired = battleShip.stream().filter(x -> !hits.contains(x)).count();
            if (fired > 0) shipsHit++;
            if (fired == 0) shipsSunk++;
        }
        return "" + shipsHit + "," + shipsSunk;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));
    }
}
