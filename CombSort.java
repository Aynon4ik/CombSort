import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CombSort {

    public static void main(String[] args) {
        String fileName = "File.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                int[] arr = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                // измерение времени работы алгоритма
                long startTime = System.nanoTime();

                combSort(arr);

                long endTime = System.nanoTime();
                long duration = (endTime - startTime);

                // измерение количества итераций
                int iterations = combSortIterations(arr);

                System.out.println("Time taken: " + duration + " ns");
                System.out.println("Iterations: " + iterations);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    public static int combSortIterations(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        int iterations = 0;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    swapped = true;
                }
                iterations++;
            }
        }
        return iterations;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }
}