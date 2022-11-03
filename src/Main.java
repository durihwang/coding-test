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
        int mod = 1000000000;
        int answer = 0;

        int[][] d = new int[101][10];
        for (int i = 1; i < 10; i++) {
            d[1][i] = 1;
        }

        //
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) {
                    d[i][j] += d[i - 1][j - 1];
                }
                if (j < 9) {
                    d[i][j] += d[i - 1][j + 1];
                }
                d[i][j] %= mod;
            }
        }

        /*for (int[] s : d) {
            System.out.println(Arrays.toString(s));
        }*/

        // 점화식
        for (int i = 0; i <= 9; i++) {
            answer += d[n][i];
        }

        System.out.println(answer % mod);
    }

}