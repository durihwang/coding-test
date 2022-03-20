import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dfs07 {

    static int answer = Integer.MAX_VALUE, n, m;
    static int[] arr, pm, ch;

    public int solution() {

        dfs(0);
        return 0;
    }

    /**
     * 순열(중복 X)
     *
     * @param L
     */
    public void dfs(int L) {

        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    pm[L] = arr[i];
                    ch[i] = 1;
                    dfs(L + 1);
                    ch[i] = 0;

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Dfs07 solution = new Dfs07();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[m];
        ch = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
//        System.out.println(solution.solution());
        solution.solution();
    }
}
