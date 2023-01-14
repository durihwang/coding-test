import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static ArrayList<Integer> dfs[];
    static boolean[] visit;
    static int[] seq;
    static int M, N, sequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());       // 정점의 수
        M = Integer.parseInt(st.nextToken());       // 간선의 수
        int R = Integer.parseInt(st.nextToken());   // 시작 정점

        visit = new boolean[N+1];
        seq = new int[N];
        dfs = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            dfs[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());

            dfs[u].add(v);
            dfs[v].add(u);
        }
        for (ArrayList<Integer> d : dfs) {
            d.sort(Collections.reverseOrder());
        }

        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seq.length; i++) {
            System.out.println(seq[i]);
        }
    }
    public static void dfs(int start) {
        seq[start] = sequence++;
        for (Integer integer : dfs[start]) {
            if (!visit[integer]) {
                visit[integer] = true;
                dfs(integer);
            }
        }
    }


}