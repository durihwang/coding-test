import java.io.IOException;

public class Solution3 {

    public boolean solution(int N, int[] A, int[] B) {


        return true;
    }

    public boolean dfs(int level, int N) {
        if (N == level) {
            return true;
        } else {


        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Solution3 solution = new Solution3();

        int[] A = {1, 2, 4, 4, 3};
        int[] B = {2, 3, 1, 3, 1};
        System.out.println(solution.solution(4, A, B));
    }
}
