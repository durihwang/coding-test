import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        int sum;
        int[][] paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 일자
                if (j + 4 < m) {
                    sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
                    answer = Math.max(answer, 3);
                }

                // 네모

                // ㄱ자

                // ㄹ자

                // ㅗ자
            }
        }

        System.out.println(answer);

    }
}
