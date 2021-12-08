import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public int[] solution(int n, int[] arr) {

        int[] answer = new int[2];
        int result = Integer.MAX_VALUE;
        int lt = 0, rt = n-1;

        Arrays.sort(arr);

        while (lt < rt) {
            int i = arr[rt] + arr[lt];

            if (Math.abs(i) < result) {
                answer[0] = arr[lt];
                answer[1] = arr[rt];
                result = Math.abs(i);
                if (i == 0) {
                    break;
                }
            }

            if (i > 0) {
                rt--;
            } else {
                lt++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] solution1 = solution.solution(n, arr);
        System.out.println(solution1[0] + " " + solution1[1]);
    }
}
