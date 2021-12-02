import java.util.Scanner;

public class Test02 {

    /**
     * 봉우리
     * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
     * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다.
     * 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
     * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
     * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
     *
     * 풀이
     * 격자판 문제는 이중 for문으로 푼다.
     * 시계방향이 내 자신의 값보다 큰지 알기 위해서 dx, dy 배열을 미리 만들어둔다.
     * 그리고 그 자릿수가 내 자신보다 크거나 같으면 바로 for문을 종료한다.
     * 왜냐면 내 자신이 가장 커야지 봉우리가 되기 때문이다.
     * j for 문을 종료하고 flag 값이 true라면 answer에 ++을 해준다.
     * 시계방향을 탐색할 때 out of bounds exception을 피하기 위해서
     * 0보다 작거나 n보다 큰 경우는 검사하지 않는다.
     * 왜냐하면 문제에서 이미 NxN 배열의 가장자리는 0이라고 정해주었기 떄문이다.
     * @param n
     * @param arr
     * @return
     */
    public int solution(int n, int[][] arr) {

        // 시계방향의 값을 알기 위해서 미리 시계방향 탐색을 위한 배열을 만든다.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;

        // 이중 for 문을 돌면서 격자판 하나씩 탐색한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 봉우리인지 판단하기 위한 boolean 값을 설정한다.
                boolean flag = true;
                // 상하좌우값 크기 확인을 위한 for 문을 돌려준다.
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    // 여기서 i, j의 값이 0보다 작거나 n보다 큰지 확인을 먼저 한다.
                    // 위 조건에 해당이 안된다면 상하좌우 값이 내 자신 값보다 크다면 for문을 멈춘다.
                    // 내 자신 값이 무조건 커야하기 때문이다.
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= +arr[i][j]) {
                        flag = false;
                        break;
                    }
                }

                // 상하좌우값 확인이 끝나면 flag값이 true일 때 answer에 ++을 해준다.
                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test02 solution = new Test02();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution.solution(n, arr));

    }
}
