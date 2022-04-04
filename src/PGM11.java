import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PGM11 {

    public int solution(int[][] office, int k) {
        int answer = -1;

        for (int i = 0; i <= office.length - k; i++) {
            int warm = 0;
            for (int j = 0; j <= office.length - k; j++) {
                warm += office[i][j];
                for (int l = 1; l < k; l++) {
                    warm += office[i + l][j];
                    warm += office[i][j + l];
                    for (int m = l + 1; m < k; m++) {
                        warm += office[i + l][j + l];
                    }
                }
                answer = Math.max(answer, warm);
            }
        }

        return answer;
    }

    private int dfs(int L, int k, int sum, int[][] office) {
        if (L == k) {
            return sum;
        } else {
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        PGM11 solution = new PGM11();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[m];
        ch = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }*/

        int[][] size = {{1, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 0}};
        System.out.println(solution.solution(size, 4));
    }
}
