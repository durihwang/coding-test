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

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            int[][] dist = new int[n][n];
            int[][] visited = new int[n][n];

            Queue<Node> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.add(new Node(x, y));
            visited[x][y] = 1;

            while (!q.isEmpty()) {
                Node poll = q.poll();
                int xx = poll.x;
                int yy = poll.y;

                for (int j = 0; j < 8; j++) {
                    int xxx = xx + dx[j];
                    int yyy = yy + dy[j];
                    if (xxx >= 0 && yyy >= 0 && xxx < n && yyy < n) {
                        if (visited[xxx][yyy] == 0) {
                            dist[xxx][yyy] = dist[xx][yy] + 1;
                            visited[xxx][yyy] = 1;
                            q.add(new Node(xxx, yyy));
                        }
                    }
                }
            }

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int location_x = Integer.parseInt(st2.nextToken());
            int location_y = Integer.parseInt(st2.nextToken());

            System.out.println(dist[location_x][location_y]);
        }

    }

    static void bfs(int[][] map, int[][] dist, int[][] visited, int x, int y) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = 1;
        dist[x][y] = dist[x][y] + 1;

        while (!q.isEmpty()) {
            Node poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = poll.x + dx[i];
                int yy = poll.y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                    if (map[xx][yy] == 1 && visited[xx][yy] == 0) {
                        q.add(new Node(xx, yy));
                        dist[xx][yy] = dist[poll.x][poll.y] + 1;
                        visited[xx][yy] = 1;
                    }
                }
            }
        }

    }


}