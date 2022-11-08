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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        int[][] d = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 0은 제거하지 않는 경우 -> 기존대로 연속합의 최대값을 저장해준다.
        // 1은 제거하는 경우 -> 현재 수를 제거하는 경우와 제거하지 않는 경우로 나누어진다.
        d[0][0] = d[0][1] = a[0];
        int answer = a[0];

        for (int i = 1; i < n; i++) {
            d[i][0] = Math.max(d[i - 1][0] + a[i], a[i]);
            d[i][1] = Math.max(d[i - 1][0], d[i - 1][1] + a[i]);
            answer = Math.max(answer, Math.max(d[i][0], d[i][1]));
        }

        System.out.println(answer);

    }

}