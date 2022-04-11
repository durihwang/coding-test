import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] ints = {4, 1, 2};

        while (n > 0) {

            int position = n % 3;
            n /= 3;

            if (position == 0) {
                System.out.println(n);
                n --;
                System.out.println(n);
            }

            answer.append(ints[position]);
        }

        return answer.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] sizes1 = {{80,20}, {50,40}, {30,10}};
        /*int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }*/
        System.out.println(solution.solution(6));
    }
}
