import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] check;
    static ArrayList<Integer> answer = new ArrayList<>();

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        check = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 단지가 존재하고 방문하지 않았다면 bfs 실행
                if (map[i][j] == 1 && check[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int s : answer) {
            System.out.println(s);
        }

    }


    static void bfs(int x, int y) {

        int cnt = 0;
        Queue<Node> q = new LinkedList();
        q.offer(new Node(x, y));
        check[x][y] = 1;
        cnt++;

        while (!q.isEmpty()) {
            Node poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = poll.x + dx[i];
                int yy = poll.y + dy[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < n) {
                    if (map[xx][yy] == 1 && check[xx][yy] == 0) {
                        check[xx][yy] = 1;
                        q.offer(new Node(xx, yy));
                        cnt++;
                    }
                }
            }
        }

        answer.add(cnt);

    }


}