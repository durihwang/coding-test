import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    static int n, m, k, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int ch[], dis[];
    static int ch2[];

    public void solution() {
        ch2[1] = 1;
        dfs(1);
        System.out.println();
        bfs(1);

        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + dis[i]);
        }

        System.out.println(answer);
    }

    public int bfs(int v) {

        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        q.offer(v);

        while (!q.isEmpty()) {
            int cv = q.poll();
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }

        return 0;
    }

    public int dfs(int v) {

        if (n == v) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch2[nv] == 0) {
                    ch2[nv] = 1;
                    dfs(nv);
                    ch2[nv] = 0;
                }
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
//        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        ch = new int[n + 1];
        ch2 = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
        }

        solution.solution();
    }
}
