import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class PGM12 {

    static int[][] check;

    public long solution(long n) {
        long answer = 0;
        long three = 1L;

        LinkedList<Long> q = new LinkedList<>();

        while (n > 0) {
            q.offer(n % 2);
            n /= 2;
        }

        while (!q.isEmpty()) {
            answer += q.poll() * three;
            three *= 3;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        PGM12 solution = new PGM12();
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
        System.out.println(solution.solution(11));
    }
}
