package fundamentalAlgorithms.fundamental.quicksort;

import java.io.*;

class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] strs = reader.readLine().split(" ");
        reader.close();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        // 0, 1
        int pivtal = partition(arr, l, r);
        quickSort(arr, l, pivtal - 1);
        quickSort(arr, pivtal + 1, r);
    }

    public static int partition(int[] arr, int l, int r) {
        if (l >= r) {
            return r;
        }

        int smallAndEqualIndex = l;
        swap(arr, l, l + (r - l) / 2);
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= arr[l]) {
                smallAndEqualIndex++;
                swap(arr, smallAndEqualIndex, i);
            }
        }

        swap(arr, smallAndEqualIndex, l);
        return smallAndEqualIndex;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
