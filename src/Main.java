import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public int solution(int n) {
        int answer = 1;
        int sum = 0;
        int start = 0;
        int limit = n / 2 + 1;
        int[] arr = new int[limit];

        for (int i = 0; i < limit; i++) {
            arr[i] = i + 1;
        }

        for (int end = 0; end < limit; end++) {
            sum += arr[end];

            if (sum == n) {
                answer++;
            }

            while (sum >= n) {
                sum -= arr[start++];

                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
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

//        int[][] sizes1 = {{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}};
//        String[] sizes1 = {"??b", "abc", "cc?"};
//        int[] sizes1 = {6,10,2};
//        int[] sizes1 = {3,30,34,5,9};
//        System.out.println(solution.solution("JEROEN"));
        /*int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }*/

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution.solution(n));
    }
}
