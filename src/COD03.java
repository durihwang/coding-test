import java.io.IOException;
import java.util.Arrays;

public class COD03 {

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < m; j++) {
                if (i < m - 1 && B[i] < A[k])
                    i += 1;
            }
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        COD03 solution = new COD03();
        int[] a = {9,9};
        int[] b = {1,1,1,1,1,1,1,1,1,9};
//        int[] a = {2,1};
//        int[] b = {3,3};
        System.out.println(solution.solution(a, b));
    }
}
