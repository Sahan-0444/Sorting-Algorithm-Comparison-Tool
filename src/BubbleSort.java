import java.util.List;

public class BubbleSort {
    public static class Result {
        public List<Integer> sorted;
        public long time;
        public int steps;

        public Result(List<Integer> sorted, long time, int steps) {
            this.sorted = sorted;
            this.time = time;
            this.steps = steps;
        }
    }

    public static Result sort(List<Integer> arr) {
        long startTime = System.nanoTime();
        int n = arr.size();
        int swaps = 0;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // Swap
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        long endTime = System.nanoTime();
        return new Result(arr, endTime - startTime, swaps);
    }
}
