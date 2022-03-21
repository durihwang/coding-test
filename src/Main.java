import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    static int n, m, answer;
    static int[] pm, ch;


    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int divisor = divisor(i);
            if (divisor % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    private int divisor(int N) {

        System.out.println("N = " + N);
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            System.out.println("i = " + i);
            if (i * i == N) count++;
            else if (N % i == 0) count += 2;
        }

        return count;
    }

    public void dfs(int L, int[] nums) {

        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0 && pm[L] != nums[i]) {
                    pm[L] = nums[i];
                    ch[i] = 1;
                    dfs(L + 1, nums);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[m];
        ch = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }*/

        System.out.println(solution.solution(10, 17));
    }
}
