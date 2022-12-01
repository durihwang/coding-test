import java.io.IOException;

public class Solution2 {

    static boolean[] check;
    static boolean answer;

    public boolean solution(int N, int[] A, int[] B) {

        answer = false;
        check = new boolean[N + 1];
        dfs(1, N, A, B);

        return answer;
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
    }

    public static void main(String[] args) throws IOException {
        Solution2 solution = new Solution2();

        int[] A = {2,4,5,3,1};
        int[] B = {3,5,6,4,2};
        System.out.println(solution.solution(6, A, B));
    }
}
