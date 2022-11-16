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
        int[][] d = new int[10001][3];
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }
        // 1을 이용해서 n을 만드는 경우는 무조건 1개이다.
        for (int i = 1; i <= 10000; i++) {
            d[i][0] = 1;
        }

        for (int i = 0; i <= 10000; i++) {
            if (i - 1 >= 0) {
                d[i][0] = d[i - 1][0];
                if (i == 1) {
                    d[i][0] = 1;
                }
            }
            if (i - 1 >= 1) {
                d[i][1] = d[i - 2][0] + d[i - 2][1];
                if (i == 2) {
                    d[i][1] = 1;
                }
            }
            if (i - 1 >= 2) {
                d[i][2] = d[i - 3][0] + d[i - 3][1] + d[i - 3][2];
                if (i == 3) {
                    d[i][2] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(d[number[i]][0] + d[number[i]][1] + d[number[i]][2]);
        }


    }



}