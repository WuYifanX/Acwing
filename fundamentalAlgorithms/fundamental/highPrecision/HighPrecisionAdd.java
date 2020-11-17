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
        int temp = 0;
        int maxLength = Math.max(a.length(), b.length());
        int[] result = new int[maxLength + 1];
        result[maxLength] = -1;
        for (int i = 0; i < maxLength; i++) {
            if (i < a.length()) {
                temp += a.charAt(a.length() - i - 1) - '0';
            }
            if (i < b.length()) {
                temp += b.charAt(b.length() - i - 1) - '0';
            }
            result[i] = temp % 10;
            temp = temp / 10;
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
