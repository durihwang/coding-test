import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public int solution(int n, int[][] pos, int m, int[] moves) {

        int answer = 0;


        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /*StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());*/

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st3.nextToken());
        }
        System.out.println(solution.solution(n, arr, m, moves));
        /*for (int s : solution.solution(n, arr)) {
            System.out.println(s);
        }*/
    }
}
