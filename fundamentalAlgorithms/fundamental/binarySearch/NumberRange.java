package fundamentalAlgorithms.fundamental.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberRange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int times = Integer.parseInt(inputs[1]);

        int[] arr = new int[n];
        inputs = reader.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < times; i++) {
            int target = Integer.parseInt(reader.readLine());
            NumberRangeBinarySearch(arr, target);
        }
    }

    public static void NumberRangeBinarySearch(int[] arr, int target) {
        if(target > arr[arr.length-1] || target < arr[0]) {
            System.out.println("-1 -1");
        }
        int left = 0, right = arr.length - 1;
        String result = "";
        while(left < right) {
            int middle = (right - left) /2 + left;
            if(arr[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        if(arr[left] != target) {
            System.out.println("-1 -1");
        }
        result += left;

        left = 0;
        right = arr.length - 1;

        while(left < right) {
            int middle = left + (right - left + 1) / 2;

            if(arr[middle] <= target) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        result += " " + left;
        System.out.println(result);
    }
}
