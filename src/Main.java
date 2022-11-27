import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int m;
    static ArrayList<Integer>[] g;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = new ArrayList[n + 1];
        check = new boolean[n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            g[x].add(y);
            g[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(i);
                answer++;
            }
        }


        System.out.println(answer);
    }

    static void dfs(int index) {
        if (check[index]) {
            return;
        }

        check[index] = true;
        for (int s : g[index]) {
            if (!check[s]) {
                dfs(s);
            }
        }


    }



}