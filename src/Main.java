import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int m;

    static class Edge {

        int from, to;

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[][] a = new boolean[n][n];
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n];
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i=0; i<n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st2.nextToken());
            int to = Integer.parseInt(st2.nextToken());

            // 양방향 모두 친구가 가능하므로 양방향 모두 등록해준다.
            edges.add(new Edge(to, from));
            edges.add(new Edge(from, to));
            a[from][to] = a[to][from] = true;
            g[from].add(to);
            g[to].add(from);
        }

        // 양방향 모두 확인하기 위해서 두배로 늘려줌
        m *= 2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int A = edges.get(i).to;
                int B = edges.get(i).from;
                int C = edges.get(j).to;
                int D = edges.get(j).from;

                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue;
                }

                if (!a[B][C]) continue;

                for (int E : g[D]) {
                    if (A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }

        System.out.println("0");
    }


}