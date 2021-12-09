import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Test11 {

    /**
     * 부분합
     * 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
     * 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중,
     * 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
     *
     * 풀이
     * 투포인터는 while문으로 푸는 것이 좋을 거 같다.
     * 두개의 포인터의 시작을 둘다 처음부터 할 것인지, 처음과 끝에서 할 것인지 잘 판단하자.
     * 여기서는 연속된 부분합이기 때문에 둘다 처음에서 시작한다.
     * 첫번쨰 포인터를 움직이면서 값을 누적하고 s보다 같거나 크면 이동을 멈춘다.
     * 두번째 포인터를 움직이면서 누적된 값에서 빼면서 포인터를 증가시켜준다.
     * 그러다 첫번째 포인터가 끝에 도착하면 while문을 멈춘다.
     * 값을 누적할때마다 첫번쨰와 두번째 포인터의 길이를 넣어주고, answer값에서 더 작은걸로 바꿔준다.
     *
     * @param n
     * @param s
     * @param arr
     * @return
     */
    public int solution(int n, int s, int[] arr) {

        // 숫자의 크기가 주어지면 거기에 맞게 값을 초기화 해준다.
        int answer = 100001;
        int sum = 0;
        int rt = 0;
        int lt = 0;

        while (true) {

            // 누적된 값이 s보다 크거나 같으면 이동을 멈추고 lt값을 누적된 값에서 뺴주면서 이동한다.
            if (sum >= s) {
                sum -= arr[lt++];
                // 여기서 두 포인터의 길이를 담고 더 작은 값으로 answer를 바꿔준다.
                answer = Integer.min(answer, rt - lt + 1);
            // rt값이 끝에 도착하면 while문을 멈춘다.
            } else if (rt == n) {
                break;
            // 누적된 값이 s보다 더 작으면 rt를 이동시키면서 값을 누적한다.
            } else {
                sum += arr[rt++];
            }
        }

        // answer값이 그대로인 경우 0을 리턴해준다.
        if (answer == 100001) {
            return 0;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Test11 solution = new Test11();
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
