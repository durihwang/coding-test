import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] d_plus = new int[n];
        int[] d_minus = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(d_plus, 1);
        Arrays.fill(d_minus, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    d_plus[i] = Math.max(d_plus[i], d_plus[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    d_minus[i] = Math.max(d_minus[i], d_minus[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {

            answer = Math.max(answer, d_plus[i] + d_minus[i] - 1);
        }

        System.out.println(answer);

    }



}