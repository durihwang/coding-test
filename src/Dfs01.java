import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dfs01 {

    /**
     * 음료수 얼려먹기
     * 구멍은 0, 칸막이는 1
     * 구멍이 뚫여있는 곳끼리 하나의 아이스크림이라고 가정했을 때
     * 총 만들 수 있는 아이스크림의 개수 구하기
     * 상 하 좌 우 로만 붙어있을 때 아이스크림을 만들 수 있다고 가정한다.
     *
     * 풀이
     * 특정 지점에서 상 하 좌 우를 방문하면서 값이 0이면서 아직 방문하지 않은 지점이라면 방문한다.
     * 또 그 지점에서 위의 내용을 반복하면 연결된 모든 지점을 방문할 수 있다.
     * 위에처럼 모든 연결된 지점을 방문했다면 ++ 해준다.
     * 위 내용을 각 지점마다 계속 반복해준다.
     *
     * @param x
     * @param y
     * @param arr
     * @return
     */
    public int solution(int x, int y, int arr[][]) {

        int answer = 0;

        // 각 지점별로 방문하여 함수를 실행한다.
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                // true가 return 되면 하나의 아이스크림을 만든 것이므로 정답개수를 ++ 해준다.
                if (dfs(i, j, x, y, arr)) {
                    answer ++;
                }
            }
        }

        return answer;

    }

    // 연결된 지점(상 하 좌 우)를 확인하는 재귀함수
    public static boolean dfs(int x, int y, int x_max, int y_max, int graph[][]) {

        // 범위 밖이면 그냥 false
        if (x <= -1 || x >= x_max || y >= y_max || y <= -1) {
            return false;
        }

        // 방문하지 않았다면 실행
        if (graph[x][y] == 0) {

            // 먼저 방문처리를 한다.
            graph[x][y] = 1;

            // 상 하 좌 우 를 방문하면서 확인한다. (재귀로 해당 지점의 상 하 좌 우 도 확인한다.)
            dfs(x - 1, y, x_max, y_max, graph);
            dfs(x, y - 1, x_max, y_max, graph);
            dfs(x + 1, y, x_max, y_max, graph);
            dfs(x, y + 1, x_max, y_max, graph);

            // 연결된 모든 지점을 방문했다면 true return
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Dfs01 solution = new Dfs01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][k];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        System.out.println(solution.solution(n, k, arr));
    }
}
