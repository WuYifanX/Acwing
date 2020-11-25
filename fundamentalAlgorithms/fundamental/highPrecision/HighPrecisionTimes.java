package fundamentalAlgorithms.fundamental.highPrecision;

import java.io.*;

public class HighPrecisionTimes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String A = reader.readLine();
        int B = Integer.parseInt(reader.readLine());

        times(A, B);
    }

    public static void times(String A, int B) {
        int maxLength = A.length() + String.valueOf(B).length();
        int[] C = new int[maxLength];

        int prefix = 0;
        int j = String.valueOf(B).length() - 1;
        for (; j >= 0; j--) {
            int b = B % 10;
            B /= 10;
            for (int i = A.length() - 1; i >= 0; i--) {
                int iValue = A.charAt(i) - '0';
                C[A.length() - i - 1 + prefix] += iValue * b;
            }
            prefix++;
        }
        int next = 0;
        for (int i = 0; i < C.length; i++) {
            int temp = C[i] + next;
            C[i] = temp % 10;
            next = temp / 10;
        }
        // System.out.print(Arrays.toString(C));
        StringBuilder sb = new StringBuilder();
        int start = C.length - 1;
        while (start != 0 && C[start] == 0) {
            start--;
        }

        if (start == -1) {
            System.out.println("0");
        }
        for (int i = start; i >= 0; i--) {
            sb.append(String.valueOf(C[i]));
        }
        System.out.println(sb.toString());
    }
}
