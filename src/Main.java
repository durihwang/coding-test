import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int x : scoville) {
            priorityQueue.offer(x);
        }

        System.out.println(priorityQueue);
        System.out.println();

        while (!priorityQueue.isEmpty()) {
            Integer first = priorityQueue.poll();
            System.out.println(priorityQueue);
            if (first < K) {
                if (!priorityQueue.isEmpty()) {
                    Integer second = priorityQueue.poll();
                    System.out.println(priorityQueue);
                    int result = first + (second * 2);
                    System.out.println(priorityQueue);
                    priorityQueue.offer(result);
                    System.out.println(priorityQueue);
                    answer++;
                } else {
                    return -1;
                }
            } else {
                return answer;
            }

            System.out.println();
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

        int[] sizes1 = {1,2,3,9,10,12};
        int[] sizes2 = {4};
        System.out.println(solution.solution(sizes1, 7));
    }
}
