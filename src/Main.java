import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static int[][] graph;
    static int[] ch;
    static int[] ch2;
    static int n, m, k, answer = 0;

    public void solution() {
        dfs(k);
        System.out.println();
        bfs(k);
    }

    public int bfs(int v) {

        // 큐를 선언해준다.
        Queue<Integer> q = new LinkedList<>();
        // 처음 시작되는 v값을 넣어준다.
        q.offer(v);

        // 큐가 비어있을 떄까지 while문을 돌린다.
        while (!q.isEmpty()) {
            // 제일 위에 큐를 꺼낸다.
            Integer p = q.poll();
            // 큐를 출력한다.
            System.out.print(p + " ");

            // 입력된 간선의 최대수만큼 for문을 돌려준다.
            for (int i = 1; i <= n; i++) {
                // 입력된 값이 존재하고, 방문하지 않았는지 체크해준다.
                if ((graph[p][i] == 1 || graph[i][p] == 1) && ch2[i] == 0) {
                    // 제일 처음 방문 표시를 한다.
                    ch2[i] = 1;
                    // 꺼낸 큐에서 이동된 값이 i 이므로 i를 큐에 넣어준다.
                    q.offer(i);
                }
            }
        }

        return 0;
    }

    public int dfs(int v) {

        System.out.print(v + " ");

        // 정점의 개수만큼 for문을 돌면서 모든 경우의 수를 탐색한다.
        for (int i = 1; i <= n; i++) {
            // 맨처음이면 v는 k일 것이고 1에서 1,2,3,4,5를 돌아서 갈 수 있는 길을 탐색한다.
            // 1은 자기자신이니까 안되고 2부터 도는데 ch값이 1이면 이미 갔던 길이거나 못가는 길이므로 이것도 제외한다.
            if ((graph[v][i] == 1 || graph[i][v] == 1) && ch[i] == 0) {
                // 모든 경우의 수를 따질 때는 항상 먼처 이 길을 지나갔다는 체크를 해준다.
                ch[i] = 1;
                // 위 조건을 모두 만족하면 해당 정점에서 다시 재귀함수를 돌려준다.
                dfs(i);
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main solution = new Main();
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
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        ch2 = new int[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph[a][b] = 1;
        }
        ch[k] = 1;
        ch2[k] = 1;
        solution.solution();
    }
}
