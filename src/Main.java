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
                n--;
                answer.append(ints[0]);
            } else {
                answer.append(ints[position]);
            }
        }

        return answer.reverse().toString();
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

        int[] sizes1 = {95};
        int[] sizes2 = {4};
        System.out.println(solution.solution(3));
    }
}
