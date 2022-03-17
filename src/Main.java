import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int answer = Integer.MIN_VALUE, n, m;

    public int solution(int[] a, int[] b) {

        dfs(0, 0, 0, a, b);

        return answer;
    }

    public void dfs(int L, int sum, int time, int[] a, int[] b) {

        if (time > m) {
            return;
        }

        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(L + 1, sum + a[L], time + b[L], a, b);
            dfs(L + 1, sum, time, a, b);
        }
    }



    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int c = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st2.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(solution.solution(a, b));
    }
}
