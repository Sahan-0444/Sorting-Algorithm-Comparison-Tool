import java.util.Arrays;

public class BubbleSort {
    private long steps; // To track the number of comparisons (steps)

    public BubbleSort() {
        this.steps = 0;
    }

    // Bubble Sort implementation with step tracking
    public int[] sort(int[] array) {
        this.steps = 0; // Reset steps for each sort
        int n = array.length;
        boolean swapped;
        long startTime = System.nanoTime(); // Start timing

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                this.steps++; // Increment steps for each comparison
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }

        long endTime = System.nanoTime(); // End timing
        long duration = endTime - startTime; // Duration in nanoseconds

        // Print results (for demonstration; in full app, this would be handled by UI)
        System.out.println("Bubble Sort Results:");
        System.out.println("Sorted Array: " + Arrays.toString(array));
        System.out.println("Execution Time: " + duration + " nanoseconds");
        System.out.println("Number of Steps (Comparisons): " + this.steps);

        return array;
    }

    // Getter for steps
    public long getSteps() {
        return this.steps;
    }
}
