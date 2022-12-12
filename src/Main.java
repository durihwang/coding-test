import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int t;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max = 200000;
        boolean[] check = new boolean[max];
        int[] dist = new int[max];
        int[] from = new int[max];

        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;
        dist[n] = 0;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            // x-1
            if (now - 1 >= 0) {
                if (!check[now - 1]) {
                    check[now - 1] = true;
                    q.add(now - 1);
                    from[now - 1] = now;
                    dist[now - 1] = dist[now] + 1;
                }
            }

            // x+1
            if (now + 1 < max) {
                if (!check[now + 1]) {
                    check[now + 1] = true;
                    q.add(now + 1);
                    from[now + 1] = now;
                    dist[now + 1] = dist[now] + 1;
                }
            }

            // 2*x
            if (now * 2 < max) {
                if (!check[now * 2]) {
                    check[now * 2] = true;
                    q.add(now * 2);
                    from[now * 2] = now;
                    dist[now * 2] = dist[now] + 1;
                }
            }
        }

        System.out.println(dist[m]);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = m; i != n; i = from[i]) {
            list.add(i);
        }

        list.add(n);

        for (int i = list.size(); i > 0; i--) {
            System.out.print(list.get(i-1) + " ");
        }


    }



}