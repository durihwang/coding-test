import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public int solution(int m, int[][] n) {

        int answer = -1;
        for (int i = 0; i < n.length; i++) {

        }


        return answer;
    }

    public static void main(String[] args) throws IOException {

        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] nn = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            int[] ints = new int[2];
            ints[0] = Integer.parseInt(stt.nextToken());
            ints[1] = Integer.parseInt(stt.nextToken());
            nn[i] = ints;
        }

        System.out.println(solution.solution(m, nn));

        br.close();
    }
}
