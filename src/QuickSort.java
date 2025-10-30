import java.util.List;

public class QuickSort {
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

    private static int comparisons = 0;

    public static Result sort(List<Integer> arr) {
        comparisons = 0;
        long startTime = System.nanoTime();
        List<Integer> sorted = new java.util.ArrayList<>(arr);
        quickSort(sorted, 0, sorted.size() - 1);
        long endTime = System.nanoTime();
        return new Result(sorted, endTime - startTime, comparisons);
    }

    private static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr.get(j) < pivot) {
                i++;
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        // Swap pivot
        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }
}
