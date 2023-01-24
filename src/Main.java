import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<Integer> linkedList[];
    static int[] parentNodes;
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        linkedList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            linkedList[i] = new ArrayList<>();
        }

        // 부모 노드 저장
        parentNodes = new int[n + 1];
        // 방문 여부 확인
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            linkedList[l].add(m);
            linkedList[m].add(l);
        }

        dfs(1);
        for (int i = 2; i < n + 1; i++) {
            System.out.println(parentNodes[i]);
        }
    }

    public static void dfs(int node) {
        int v = node;
        visited[v] = true;
        for (int child : linkedList[v]) {
            if (!visited[child]) {
                visited[child] = true;
                parentNodes[child] = v;
                dfs(child);
            }
        }
    }



}