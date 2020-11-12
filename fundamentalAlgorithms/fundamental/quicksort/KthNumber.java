package fundamentalAlgorithms.fundamental.quicksort;

import java.io.*;

public class KthNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLines = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLines[0]);
        int k = Integer.parseInt(firstLines[1]);
        int[] arr = new int[n];

        String[] strs = reader.readLine().split(" ");
        reader.close();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        findKth(arr, 0, arr.length - 1, k - 1);
    }

    public static void findKth(int[] arr, int l, int r, int k) {
        int pivtal = partition(arr, l, r, k);

        if (pivtal == k) {
            System.out.println(arr[k]);
        } else if (pivtal > k) {
            findKth(arr, l, pivtal - 1, k);
        } else {
            findKth(arr, pivtal + 1, r, k);
        }
    }

    public static int partition(int[] arr, int l, int r, int k) {
        if (l >= r)
            return r;

        swap(arr, l, (r - l) / 2 + l);
        int lessAndEqualIndex = l;

        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= arr[l]) {
                lessAndEqualIndex++;
                swap(arr, lessAndEqualIndex, i);
            }
        }
        swap(arr, lessAndEqualIndex, l);
        return lessAndEqualIndex;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
