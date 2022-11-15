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
        int mod = 9901;
        int answer = 0;
        int[][] d = new int[n + 1][3];

        Arrays.fill(d[0], 1);

        for (int i = 1; i <= n; i++) {
            d[i][0] = d[i - 1][0] + d[i - 1][1] + d[i - 1][2];
            d[i][1] = d[i - 1][0] + d[i - 1][2];
            d[i][2] = d[i - 1][0] + d[i - 1][1];

            d[i][0] %= mod;
            d[i][1] %= mod;
            d[i][2] %= mod;

        }

        answer = d[n - 1][0] + d[n - 1][1] + d[n - 1][2];

        System.out.println(answer % mod);


    }



}