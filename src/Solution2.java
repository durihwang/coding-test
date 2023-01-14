import java.io.IOException;
import java.util.ArrayList;

public class Solution2 {

    static boolean[] check;
    static boolean answer;

    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }

    public void dfs(int level, int N, int[] A, int[] B) {

        // 배열의 크기 N과 level이 같은 경우라면 정답이므로 true
        if (N == level) {
            answer = true;
        } else {
            for (int i = 0; i < A.length; i++) {
                int x = A[i];
                int y = B[i];

                // 방문했는지 체크
                if (!check[i]) {
                    // 무방향 그래프이므로 x나 y 둘중에 오름차순의 순서가 해당되는지 확인
                    if (x == level && y == level + 1) {
                        check[i] = true;
                        dfs(level + 1, N, A, B);
                    } else if (y == level && x == level + 1) {
                        check[i] = true;
                        dfs(level + 1, N, A, B);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Solution2 solution = new Solution2();

        int[] A = {1,2,2,4};
        System.out.println(solution.solution(A, 4));
    }
}
