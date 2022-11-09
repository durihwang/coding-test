import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int[] size;
    static int[][] map;
    static boolean[][] visited;

    // 상 하 좌 우 확인
    static int[] location_x = {0, 0, -1, 1};
    static int[] location_y = {1, -1, 0, 0};
    static Queue<Node> queue = new LinkedList<>();

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        size = new int[3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                size[j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            map = new int[size[0]][size[1]];
            visited = new boolean[size[0]][size[1]];

            for (int j = 0; j < size[2]; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int i1 = Integer.parseInt(st2.nextToken());
                int j1 = Integer.parseInt(st2.nextToken());
                map[i1][j1] = 1;
            }

            for (int j = 0; j < size[0]; j++) {
                for (int k = 0; k < size[1]; k++) {
                    if (!visited[j][k] && map[j][k] == 1) {
                        // dfs 혹은 bfs 시작
                        answer++;
                        bfs(j, k);
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void bfs(int x, int y) {

        visited[x][y] = true;
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int xx = node.x + location_x[i];
                int yy = node.y + location_y[i];
                if (location_check(xx, yy) && !visited[xx][yy] && map[xx][yy] == 1) {
                    visited[xx][yy] = true;
                    queue.offer(new Node(xx, yy));
                }
            }
        }
    }

    public static void dfs() {

    }

    public static boolean location_check(int x, int y) {
        return x >= 0 && x < size[0] && y >= 0 && y < size[1];
    }

}