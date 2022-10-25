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
    static int answer;
    static boolean check;
    static int[] d;
    static int[] p;
    static ArrayList<Long> reduction = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        p = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = 0;

        // 1부터 n번째 까지의 카드팩의 가격 모두 구한다.
        for (int i = 1; i <= n; i++) {

            // 1은 1번, 2는 2번 ... n은 n번 카드를 얻을 수 있다.
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i - j] + p[j]);
            }
        }

        System.out.println(Arrays.toString(d));

    }

}