import java.util.*;

public class Quest2 {

    public static void main(String[] args) {
        int[] arr = {10, 77, 92, 1, 30, 81, 1, 4, 1, 20, 17, 1, 16, 33};
        //int[] arr2 = {10, 3, 8, 9, 6, 9, 4, 6, 7, 2, 2};
        List<String> result = test(arr, 1, 10);
        result.forEach(System.out::println);
    }

    public static List<String> test(int[] Y, int X, int Z) {
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer num : Y) {
            if (num != X) {
                queue.add(num);
            }
        }

        //filling array with non zero elements from start
        int i = 0;
        while (!queue.isEmpty()) {
            Y[i] = queue.poll();
            i++;
        }

        //filling rest of the place with the value of X
        while (i < Y.length) {
            Y[i] = X;
            i++;
        }

        //array with all the X at the end
        System.out.println(Arrays.toString(Y));

        for (int j = 0; j < Y.length; j++) {
            if (Y[j] % Z == 0) {
                map.put(j, Y[j]);
            }
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e -> result.add("Index " + e.getKey() + " and value " + e.getValue()));

        return result;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
