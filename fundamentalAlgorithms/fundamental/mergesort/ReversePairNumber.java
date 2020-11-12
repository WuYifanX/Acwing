package fundamentalAlgorithms.fundamental.mergesort;

import java.io.*;

public class ReversePairNumber {
    private static int[] temp;
    private static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] inputs = reader.readLine().split(" ");
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt((inputs[i]));
        }

        mergesort(arr, 0, n - 1);
        System.out.println(count);
    }

    public static void mergesort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int middle = l + (r - l) / 2;
        mergesort(arr, l, middle);
        mergesort(arr, middle + 1, r);
        mergeAndCount(arr, l, middle, r);
    }

    private static void mergeAndCount(int[] arr, int l, int middle, int r) {

        int k = 0, left = l, right = middle + 1;

        while (left <= middle && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left];
                left++;
            } else {
                temp[k] = arr[right];
                right++;
                count += middle - left + 1;
            }
            k++;
        }

        while (left <= middle) {
            temp[k] = arr[left];
            k++;
        }

        while (right <= r) {
            temp[k] = arr[right];
            k++;
        }

        for (int i = 0; i < k; i++) {
            arr[i + l] = temp[i];
        }

    }
}
