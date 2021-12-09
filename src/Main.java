import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public int solution(int n, int s, int[] arr) {

        int answer = 100001;
        System.out.println("answer = " + answer);
        int sum = 0;
        int rt = 0;
        int lt = 0;

        while (true) {
            if (sum >= s) {
                sum -= arr[lt++];
                answer = Integer.min(answer, rt - lt + 1);
            } else if (rt == n) {
                break;
            } else {
                sum += arr[rt++];
            }
        }

        if (answer == 100001) {
            return 0;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(solution.solution(n, s, arr));
    }
}
