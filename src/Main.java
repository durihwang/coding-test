import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st2.nextToken());
        int y = Integer.parseInt(st2.nextToken());
        int dir = Integer.parseInt(st2.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        while (true) {

            // 청소하지 않았다면(0), 청소했다는 표시로 2를 넣어준다. (1은 벽)
            if (a[x][y] == 0) {
                a[x][y] = 2;
            }

            // 4방향 모두 0이 아니면(청소를 했거나 벽이면) 청소기를 멈추거나 후진을 시켜준다.
            if (a[x - 1][y] != 0 && a[x][y - 1] != 0 && a[x + 1][y] != 0 && a[x][y + 1] != 0) {

                // 현재 바라보는 방향의 반대방향이 벽이면 작동을 멈춘다.
                if (a[x - dx[dir]][y - dy[dir]] == 1) {
                    break;
                } else {
                    // 현재 바라보는 방향 반대 방향이 벽이 아니면 해당 방향으로 이동한다. (후진)
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else {

                // 현재 방향에서 왼쪽 방향으로 회전하기 위해 dir값 조정
                dir = (dir + 3) % 4;

                // 현재 방향에서 왼쪽 방향 위치에 청소가 안되어있으면 그 방향으로 회전
                if (a[x + dx[dir]][y + dy[dir]] == 0) {
                    x += dx[dir];
                    y += dy[dir];
                }
            }
        }

        int answer = 0;

        // 청소를 한 곳(2)을 카운트 해준다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 2) {
                    answer++;
                }
            }
        }

        System.out.println(answer);


    }


}