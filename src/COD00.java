import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class COD00 {

    static class Edge {
        int node, flow, capacity;
        Edge revEdge;

        public Edge(int node, int flow, int capacity) {
            this.node = node;
            this.flow = flow;
            this.capacity = capacity;
        }

        int spare() {
            return capacity - flow;
        }

        void addFlow(int n) {
            flow += n;
            revEdge.flow -= n;
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static int[] level, work;

    static void makeGraph(int start, int dest, int capacity) {
        Edge st = new Edge(start, 0, 0);
        Edge de = new Edge(dest, 0, capacity);
        st.revEdge = de;
        de.revEdge = st;
        graph.get(start).add(de);
        graph.get(dest).add(st);
    }

    static int dfs(int cur, int dest, int flow) {
        if (cur == dest) return flow;

        for (int i = work[cur]; i < graph.get(cur).size(); i++) {
            work[cur] = i;
            Edge next = graph.get(cur).get(i);

            if (level[next.node] == level[cur] + 1 && next.spare() > 0) {
                int df = dfs(next.node, dest, Math.min(flow, next.spare()));
                if (df > 0) {
                    next.addFlow(df);
                    return df;
                }
            }
        }

        return 0;
    }


    static boolean bfs(int sink) {
        level = new int[sink + 1];
        Arrays.fill(level, -1);
        level[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (Edge next : graph.get(cur)) {
                if (level[next.node] == -1 && next.spare() > 0) {
                    level[next.node] = level[cur] + 1;
                    q.offer(next.node);
                }
            }
        }

        return level[sink] != -1;
    }

    public String solution(int U, int L, int[] C) {

        StringBuilder answer = new StringBuilder();
        int n = 2;
        int k = 0;
        int maxFlow = 0;
        int A = U + L;
        int B = 0;

        int sink = 2 + C.length + 1;
        for (int i = 0; i <= sink; i++) {
            graph.add(new ArrayList<>());
        }

        // 행 생성
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                k = U;
            } else {
                k = L;
            }
            makeGraph(0, i + 1, k);
        }

        // 열 생성
        for (int i = n + 1; i < sink; i++) {
            B += C[i - 3];
            makeGraph(i, sink, C[i - 3]);

            for (int j = 1; j <= n; j++) makeGraph(j, i, 1);
        }

        while (bfs(sink)) {
            work = new int[sink + 1];
            while (true) {
                int f = dfs(0, sink, Integer.MAX_VALUE);
                if (f == 0) break;
                maxFlow += f;
            }
        }

        if (A != B || A != maxFlow) {
            return "IMPOSSIBLE";
        }

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < graph.get(i).size(); j++) {
                if (graph.get(i).get(j).flow > 0) {
                    answer.append("1");
                } else {
                    answer.append("0");
                }
            }
            if (i != 2) {
                answer.append(",");
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        COD00 solution = new COD00();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }*/

        int[] s = {2,1,1,0,1};
        System.out.println(solution.solution(3, 2, s));
    }
}
