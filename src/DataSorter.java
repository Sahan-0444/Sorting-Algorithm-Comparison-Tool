import java.util.*;

public class DataSorter {
    private static List<Integer> data = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    enterNumbersManually();
                    break;
                case 2:
                    generateRandomNumbers();
                    break;
                case 3:
                    performBubbleSort();
                    break;
                case 4:
                    performMergeSort();
                    break;
                case 5:
                    performQuickSort();
                    break;
                case 6:
                    compareAllAlgorithms();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
        System.out.println("1. Enter numbers manually");
        System.out.println("2. Generate random numbers");
        System.out.println("3. Perform Bubble Sort");
        System.out.println("4. Perform Merge Sort");
        System.out.println("5. Perform Quick Sort");
        System.out.println("6. Compare all algorithms (show performance table)");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void enterNumbersManually() {
        System.out.print("Enter numbers separated by spaces: ");
        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");
        data.clear();
        for (String part : parts) {
            try {
                data.add(Integer.parseInt(part));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + part + ". Skipping.");
            }
        }
        System.out.println("Data entered: " + data);
    }

    private static void generateRandomNumbers() {
        System.out.print("Enter the number of random numbers to generate: ");
        try {
            int count = Integer.parseInt(scanner.nextLine());
            if (count <= 0) {
                System.out.println("Number must be positive.");
                return;
            }
            data.clear();
            Random rand = new Random();
            for (int i = 0; i < count; i++) {
                data.add(rand.nextInt(1000)); // Random numbers 0-999
            }
            System.out.println("Generated data: " + data);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }

    private static void performBubbleSort() {
        if (data.isEmpty()) {
            System.out.println("No data available. Please enter or generate data first.");
            return;
        }
        List<Integer> copy = new ArrayList<>(data);
        BubbleSort.Result result = BubbleSort.sort(copy);
        System.out.println("Bubble Sort Result:");
        System.out.println("Sorted Data: " + result.sorted);
        System.out.println("Execution Time: " + result.time + " nanoseconds");
        System.out.println("Number of Swaps: " + result.steps);
    }

    private static void performMergeSort() {
        if (data.isEmpty()) {
            System.out.println("No data available. Please enter or generate data first.");
            return;
        }
        List<Integer> copy = new ArrayList<>(data);
        MergeSort.Result result = MergeSort.sort(copy);
        System.out.println("Merge Sort Result:");
        System.out.println("Sorted Data: " + result.sorted);
        System.out.println("Execution Time: " + result.time + " nanoseconds");
        System.out.println("Number of Comparisons: " + result.steps);
    }

    private static void performQuickSort() {
        if (data.isEmpty()) {
            System.out.println("No data available. Please enter or generate data first.");
            return;
        }
        List<Integer> copy = new ArrayList<>(data);
        QuickSort.Result result = QuickSort.sort(copy);
        System.out.println("Quick Sort Result:");
        System.out.println("Sorted Data: " + result.sorted);
        System.out.println("Execution Time: " + result.time + " nanoseconds");
        System.out.println("Number of Comparisons: " + result.steps);
    }

    private static void compareAllAlgorithms() {
        if (data.isEmpty()) {
            System.out.println("No data available. Please enter or generate data first.");
            return;
        }
        List<Integer> copy1 = new ArrayList<>(data);
        BubbleSort.Result bubble = BubbleSort.sort(copy1);

        List<Integer> copy2 = new ArrayList<>(data);
        MergeSort.Result merge = MergeSort.sort(copy2);

        List<Integer> copy3 = new ArrayList<>(data);
        QuickSort.Result quick = QuickSort.sort(copy3);

        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("%-15s %-20s %-15s%n", "Algorithm", "Execution Time (ns)", "Steps");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-15s %-20d %-15d%n", "Bubble Sort", bubble.time, bubble.steps);
        System.out.printf("%-15s %-20d %-15d%n", "Merge Sort", merge.time, merge.steps);
        System.out.printf("%-15s %-20d %-15d%n", "Quick Sort", quick.time, quick.steps);
    }
}
