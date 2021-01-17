import java.util.*;

public class TreeMapExample {
    private static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {

        int aSize = a.size();
        int bSize = b.size();

        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();

        for (int i = 0; i < aSize; i++) {
            int[] x = a.get(i);
            for (int j = 0; j < bSize; j++) {
                int[] y = b.get(j);
                int sum = x[1] + y[1];
                if (sum <= target) {
                    List<int[]> entry = treeMap.getOrDefault(sum, new ArrayList<>());
                    entry.add(new int[]{x[0], y[0]});
                    treeMap.put(sum, entry);
                }
            }
        }

//        for (Map.Entry<Integer, List<int[]>> entry: treeMap.entrySet()) {
//            System.out.println(entry.getKey());
//            for (int[] ar: entry.getValue()) {
//                System.out.println(ar[0] + "," + ar[1]);
//            }
//        }
        return treeMap.floorEntry(target).getValue();
    }

    public static void main(String[] args) {
        List<int[]> a = new ArrayList<int[]>(Arrays.asList(new int[]{1, 2}, new int[]{2, 4}, new int[]{3, 6}));
        List<int[]> b = new ArrayList<int[]>(Arrays.asList(new int[]{1, 2}));
        List<int[]> list = getPairs(a, b, 7);
        for (int[] arr: list) {
            System.out.println(arr[0] + "," + arr[1]);
        }
    }
}
