package fundamentalAlgorithms.fundamental.highPrecision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HighPrecisionAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        add(first, second);
    }

    public static void add(String a, String b) {
        if (a.length() < b.length()) {
            add(b, a);
        }

        int maxLength = a.length();
        int[] result = new int[maxLength + 1];
        result[maxLength] = -1;

        int temp = 0;
        int first = 0, second = 0;
        for (int i = 0; i < maxLength; i++) {
            first = a.charAt(a.length() - i - 1) - '0';
            if (i >= b.length()) {
                second = 0;
            } else {
                second = b.charAt(b.length() - i - 1) - '0';
            }
            int sum = first + second + temp;
            result[i] = sum % 10;
            temp = sum / 10;
        }

        if (temp != 0) {
            result[maxLength] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = maxLength; i >= 0; i--) {
            if (result[i] == -1) {
                continue;
            }

            sb.append(result[i]);
        }
        System.out.println(sb.toString());
    }
}
