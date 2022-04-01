import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PGM10 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0, i = 0;
        Queue<Integer> q = new LinkedList<>();

        while (true) {
            if (i == truck_weights.length) {
                break;
            }
            if (q.size() == bridge_length) {
                Integer poll = q.poll();
                sum -= poll;
            } else if (sum + truck_weights[i] > weight) {
                q.offer(0);
                answer++;
            } else {
                q.offer(truck_weights[i]);
                sum += truck_weights[i];
                i++;
                answer++;
            }
        }


        return answer + bridge_length;
    }

    public static void main(String[] args) throws IOException {
        PGM10 solution = new PGM10();
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

        int[] sizes1 = {7,4,5,6};
        int[] sizes2 = {4};
        System.out.println(solution.solution(2, 10, sizes1));
    }
}
