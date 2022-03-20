import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dfs06 {

    static int answer = Integer.MIN_VALUE, n, m;
    static int[] pm;

    public int solution(int[] pm) {

        dfs(0);

        return 0;
    }

    /**
     * 중복 순열
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
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                dfs(L + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Dfs06 solution = new Dfs06();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int c = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        /*for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            pm[i] = Integer.parseInt(st2.nextToken());
        }*/
        System.out.println(solution.solution(pm));
    }
}
