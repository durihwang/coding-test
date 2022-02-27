import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dfs03 {

    static String answer;
    static int ch[], arr[];
    static int n, total;

    /**
     * 합이 같은 부분집합
     * 주어진 집합을 둘로 나눴을 때 값이 같은 경우가 있으면 YES, 아니면 NO
     *
     * 풀이
     * 집합을 순회하면서 해당 값을 쓰는 경우와 쓰지 않는 경우를 재귀하여서 배열 개수만큼 다 돈 경우
     * 해당 값이 전체 집합의 합 값에서 현재 합 값을 뺀 값이랑 같으면 YES를 출력한다.
     *
     * @return
     */
    public String solution() {

        answer = "NO";
        dfs(0, 0);
        return answer;
    }

    public int dfs(int v, int sum) {
        if (n == v) {
            if ((total - sum) == sum) {
                answer = "YES";
                return 0;
            }
        } else {
            dfs(v + 1, sum + arr[v]);
            dfs(v + 1, sum);
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
        Dfs03 solution = new Dfs03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n];
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }*/

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        total = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            total += arr[i];
        }
//        m = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
        /*for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
        }*/

        System.out.println(solution.solution());
    }
}
