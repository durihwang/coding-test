import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (N % 10 != 0) {
                enable_print = 1;
                System.out.print(N % 10);
            }
            else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        solution.solution(1);
    }
}
