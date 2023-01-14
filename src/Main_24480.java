import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_24480 {
    static ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();
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
        for (int i = 0; i < N+1; i++) {
            dfs.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());

            dfs.get(u).add(v);
            dfs.get(v).add(u);
        }
        for (ArrayList<Integer> d : dfs) {
            Collections.sort(d, Collections.reverseOrder());
        }

        dfs(R);
        for (int i : seq) {
            System.out.println(i);
        }
    }
    public static void dfs(int start) {
        if (!visit[start]) {
            seq[sequence++] = start;
            visit[start] = true;
            for (Integer integer : dfs.get(start)) {
                dfs(integer);
            }
        }
    }
}
