import java.util.ArrayList;
import java.util.List;

public class MergeSort {
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
        List<Integer> sorted = mergeSort(new ArrayList<>(arr));
        long endTime = System.nanoTime();
        return new Result(sorted, endTime - startTime, comparisons);
    }

    private static List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int mid = arr.size() / 2;
        List<Integer> left = mergeSort(new ArrayList<>(arr.subList(0, mid)));
        List<Integer> right = mergeSort(new ArrayList<>(arr.subList(mid, arr.size())));
        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            comparisons++;
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) {
            result.add(left.get(i++));
        }
        while (j < right.size()) {
            result.add(right.get(j++));
        }
        return result;
    }
}
