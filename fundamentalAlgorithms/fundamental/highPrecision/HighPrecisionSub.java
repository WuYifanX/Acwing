package fundamentalAlgorithms.fundamental.highPrecision;

import java.io.*;

public class HighPrecisionSub {
    public static boolean isMinus = false;

    public static void main(String[] args) throws IOException {
        isMinus = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        sub(a, b);
    }

    public static boolean isBigger(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() > b.length();
        }

        for (int i = 0; i < a.length(); i++) {
            int currentDigitForA = a.charAt(i) - '0';
            int currentDigitForB = b.charAt(i) - '0';
            if (currentDigitForA != currentDigitForB) {
                return currentDigitForA > currentDigitForB;
            }
        }

        return true;
    }

    public static void sub(String a, String b) {
        if (!isBigger(a, b)) {
            isMinus = true;
            sub(b, a);
            return;
        }
        // For now, we can assure a is bigger than b;
        int[] C = new int[a.length()];

        int temp = 0;
        int A = 0, B = 0;
        for (int i = 0; i < a.length(); i++) {
            A = a.charAt(a.length() - i - 1) - '0';
            if (i >= b.length()) {
                B = 0;
            } else {
                B = b.charAt(b.length() - i - 1) - '0';
            }

            int currentDigit = A - B - temp;
            if (currentDigit >= 0) {
                temp = 0;
                C[i] = currentDigit;
            } else {
                temp = 1;
                C[i] = currentDigit + 10;
            }
        }

        int firstIndex = C.length - 1;
        while (firstIndex > 0) {
            if (C[firstIndex] == 0) {
                firstIndex--;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isMinus) {
            sb.append("-");
        }
        for (int i = firstIndex; i >= 0; i--) {
            sb.append(C[i]);
        }

        System.out.println(sb.toString());
    }
}
