import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int[] v;
    static long[] a;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new long[n];
        long[] d = new long[n];
        v = new int[n];

        long answer = 0;
        int p = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
            v[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (d[j] + 1 > d[i] && a[i] > a[j]) {
                    d[i] = d[j] + 1;
                    v[i] = j;
                }
            }
        }

        for (int i = 0; i < d.length; i++) {
            if (d[i] > answer) {
                answer = d[i];
                p = i;
            }
        }

        System.out.println(answer);
        System.out.println(Arrays.toString(v));
        go(p);
    }

    static void go(int p) {

        if (p == -1) {
            return;
        }

        go(v[p]);
        System.out.print(a[p] + " ");
    }

}