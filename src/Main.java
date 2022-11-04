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
        int max = 0;
        int[] test = new int[n];
        for (int i = 0; i < n; i++) {
            test[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, test[i]);
        }

        long mod = 1000000009L;
        long answer;

        long[][] d = new long[100001][4];

        for (int i = 1; i <= max; i++) {
            if (i - 1 >= 0) {
                d[i][1] = d[i - 1][2] + d[i - 1][3];
                if (i == 1) {
                    d[i][1] = 1;
                }
            }

            if (i - 1 >= 1) {
                d[i][2] = d[i - 2][1] + d[i - 2][3];
                if (i == 2) {
                    d[i][2] = 1;
                }
            }

            if (i - 1 >= 2) {
                d[i][3] = d[i - 3][1] + d[i - 3][2];
                if (i == 3) {
                    d[i][3] = 1;
                }
            }

            d[i][1] %= mod;
            d[i][2] %= mod;
            d[i][3] %= mod;
        }

        for (int i = 0; i < n; i++) {
            answer = d[test[i]][1] + d[test[i]][2] + d[test[i]][3];
            System.out.println(answer % mod);
        }
    }

}