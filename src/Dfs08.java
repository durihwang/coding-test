import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dfs08 {

    static int answer = Integer.MAX_VALUE, n, m;
    static int[] arr;

    /**
     * 동전 교환
     *
     * @return
     */
    public int solution() {

        dfs(0, 0);
        return answer;
    }

    public void dfs(int L, int sum) {

        if (sum > m) {
            return;
        }

        if (L >= answer) {
            return;
        }

        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Dfs08 solution = new Dfs08();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int c = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        System.out.println(solution.solution());
    }
}