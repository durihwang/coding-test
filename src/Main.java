import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int mod = 1000000000;
        int[][] d = new int[k + 1][n + 1];
        Arrays.fill(d[1], 1);

        for (int i = 1; i <= k; i++) d[i][0] = 1;

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = d[i - 1][j] + d[i][j - 1];
                d[i][j] %= mod;
            }
        }

        System.out.println(d[k][n]);

    }



}