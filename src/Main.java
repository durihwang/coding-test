import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int[] answer;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            answer = new int[n];
            check = new boolean[n];
            for (int i = 0; i < n; i++) {
                answer[i] = Integer.parseInt(st.nextToken());
            }
            go(0, 0);
            System.out.println();
        }
    }

    static void go(int level, int start) {
        if (level == 6) {
            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    System.out.print(answer[i] + " ");
                }
            }
            /*if (check[n-1]) {
                System.out.print(answer[n-1]);
            }*/
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                if (check[i]) {
                    continue;
                }
                check[i] = true;
                go(level + 1, i + 1);
                check[i] = false;
            }
        }
    }
}