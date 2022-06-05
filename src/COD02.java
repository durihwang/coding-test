import java.io.IOException;
import java.util.Arrays;

public class COD02 {

    public int solution(int[] A) {

        Arrays.sort(A);
        int answer = 0;
        int right = A.length - 1;

        for (int left = 0; left < A.length; left++) {
            int first = A[left];
            while (left < right) {
                int last = A[right];
                int condition = first + last;
                if (last != 0 && condition == 0) {
                    return last;
                } else {
                    right--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        COD02 solution = new COD02();
        int[] s = {-2,-2,-2,-2,-2,-2,2,2,2,2,2,2,3,-3};
//        int[] s = {3,2,-2,5,-3};
//        int[] s = {1,1,2,-1,2,-1};
//        int[] s = {1,2,3,-4};
        System.out.println(solution.solution(s));
    }
}
