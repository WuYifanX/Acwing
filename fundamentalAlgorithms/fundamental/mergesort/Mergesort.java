package fundamentalAlgorithms.fundamental.mergesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mergesort {
    private static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        temp = new int[n];
        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        mergesort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

    public static void mergesort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int middle = l + (r - l) / 2;

        mergesort(arr, l, middle);
        mergesort(arr, middle + 1, r);
        int k = 0, left = l, right = middle + 1;

        while (left <= middle && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left];
                left++;
                k++;
            } else {
                temp[k] = arr[right];
                right++;
                k++;
            }
        }

        while (left <= middle) {
            temp[k] = arr[left];
            k++;
            left++;
        }
        while (right <= r) {
            temp[k] = arr[right];
            k++;
            right++;
        }

        for (int i = 0; i < k; i++) {
            arr[l + i] = temp[i];
        }
    }
}
