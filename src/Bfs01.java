import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bfs01 {

    /**
     * 미로 탈출
     * 시작 칸과 마지막 칸은 무조건 1
     * 1이면 갈 수 있는 길이다.
     * 최단 거리를 찾는다.
     *
     * 풀이
     * 큐를 생성한다.
     * 이동할 4가지 방향을 설정한다.
     *
     * @param x
     * @param y
     * @param arr
     * @return
     */

    //이동할 네 가지 방향 정의 {상, 하, 좌 ,우}
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static int [][]graph = new int[201][201];
    public static int n, k;

    public int solution(int x, int y) {

        Queue<Node> q = new LinkedList<>();

        // 1, 1에서부터 시작
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {

            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > n || ny > k) {
                    continue;
                }

                if (graph[nx][ny] == 0) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }

        }

        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][k - 1];

    }

    static class Node{
        final private int x;
        final private int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY(){
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        Bfs01 solution = new Bfs01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                graph[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        System.out.println(solution.solution(0, 0));
    }
}
