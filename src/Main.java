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
        int answer = 0;
        int[][] r = new int[n + 1][3];
        int[][] d = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i][0] = Integer.parseInt(st.nextToken());
            r[i][1] = Integer.parseInt(st.nextToken());
            r[i][2] = Integer.parseInt(st.nextToken());
        }

        d[1][0] = r[1][0];
        d[1][1] = r[1][1];
        d[1][2] = r[1][2];

        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + r[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + r[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + r[i][2];
        }

        answer = Math.min(d[n][0], d[n][1]);
        answer = Math.min(answer, d[n][2]);
        System.out.println(answer);

    }



}