import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Test19 {

    /**
     * 공주 구하기
     *
     * 예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.
     * 이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.
     * N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
     *
     * 풀이
     * queue를 사용해서 문제를 풀어본다.
     * 주어진 숫자 n만큼 queue에 넣어준다.
     * queue에 마지막 남는 숫자가 답이기 때문에 queue가 비어질 때 까지 while문을 돌려준다.
     *
     * @param n
     * @param k
     * @return
     */
    public int solution(int n, int k) {

        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        // n만큼 queue에 담아준다.
        for (int i = 0; i < n; i++) {
            q.offer(i + 1);
        }

        // queue가 비어질 때 까지 while문을 돌려준다.
        // 막상 풀 때 while문 활용이 잘 안되기 때문에 꼭 기억해준다.
        while (!q.isEmpty()) {
            // 3번째 숫자를 빼야하기 때문에 1,2번째 숫자를 빼서 뒤로 넣어준다.
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }

            // 1,2번째 숫자를 빼서 뒤로 넣어주고 3번째 숫자를 answer에 담아준다.
            // 결국 마지막에 담긴 숫자가 답이 된다.
            answer = q.poll();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Test19 solution = new Test19();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution.solution(n, k));
        /*for (int s : solution.solution(n, arr)) {
            System.out.println(s);
        }*/
    }
}
