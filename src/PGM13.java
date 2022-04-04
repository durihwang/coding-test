import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PGM13 {

    public int solution(int N) {
        int answer = 0;
        int[] arr = new int[N + 1];

        if(N < 2) {
            answer =  1;
        } else {
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 2; i < N + 1; i++) {
                arr[i] = arr[i - 2] + arr[i - 1];
                System.out.println(arr[i]);
            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        PGM13 solution = new PGM13();
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
        int[][] sizes1 = {{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}};
        System.out.println(solution.solution(3));
    }
}
