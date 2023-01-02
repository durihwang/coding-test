import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int m;
    static int l;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 행 검사
        for (int i = 0; i < n; i++) {
            int[] d = new int[n];
            for (int j = 0; j < n; j++) {
                d[j] = a[i][j];
            }
            if (check(d, l)) {
                answer += 1;
            }
        }

        // 열 검사
        for (int j = 0; j < n; j++) {
            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = a[i][j];
            }
            if (check(d, l)) {
                answer += 1;
            }
        }

        System.out.println(answer);

    }

    private static boolean check(int[] a, int l) {

        boolean[] c = new boolean[n];

        for (int i = 1; i < n; i++) {

            // 인접한 칸의 높이가 다르면 경사로 설치
            if (a[i - 1] != a[i]) {

                // 경사로의 칸이 1칸 차이인지 확인
                int diff = Math.abs(a[i - 1] - a[i]);
                if (diff != 1) {
                    return false;
                }

                // 왼쪽 칸이 작은 경우
                if (a[i - 1] < a[i]) {

                    // 1번부터 l만큼 경사로를 설치할 수 있는지 확인
                    for (int j = 1; j <= l; j++) {

                        // 범위를 벗어나는지 확인
                        if (i - j < 0) {
                            return false;
                        }

                        // 길이가 모두 같은지 확인
                        if (a[i - 1] != a[i - j]) {
                            return false;
                        }

                        // 경사로를 이미 설치했는지 확인
                        if (c[i - j]) {
                            return false;
                        }

                        // 위에서 전부 안걸리면 경사로 설치
                        c[i - j] = true;
                    }

                } else {    // 오른쪽 칸이 작은 경우

                    for (int j = 0; j < l; j++) {

                        // 범위 벗어나는지 확인
                        if (i + j >= n) {
                            return false;
                        }

                        // 길이가 모두 같은지 확인
                        if (a[i] != a[i + j]) {
                            return false;
                        }

                        // 경사로를 이미 설치했는지 확인
                        if (c[i + j]) {
                            return false;
                        }

                        // 위에서 젅부 안걸리면 경사로 설치
                        c[i + j] = true;
                    }
                }
            }
        }
        return true;
    }


}