import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Test12 {

    /**
     * 소수의 연속합
     * 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.
     *
     * 3 : 3 (한 가지)
     * 41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
     * 53 : 5+7+11+13+17 = 53 (두 가지)
     * 하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다.
     * 7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다. 또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.
     *
     * 자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.
     *
     * 풀이
     *
     * 일단 n까지의 소수를 먼저 구해야 한다. 에라토스테네스의 체를 이용하여 소수를 구한다.
     * 이중 for문 이지만 그냥 이중 for문을 돌리면 시간초과가 발생하므로 에라토스테네스의 체를 꼭 이용해야 한다.
     * 소수를 구했으면 그 뒤에는 투 포인터 알고리즘을 이용해서 연속합이 n이랑 똑같은지만 확인하면 된다.
     * @param n
     * @return
     */
    public int solution(int n) {

        int answer = 0;
        int sum = 0;
        int lt = 0, rt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                System.out.println("j = " + j);
                prime[j] = true;
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if (!prime[i]) {
                list.add(i);
            }
        }

        while (true) {

            if (sum >= n) {
                sum -= list.get(lt++);
            } else if (rt == list.size()) {
                break;
            } else {
                sum += list.get(rt++);
            }

            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Test12 solution = new Test12();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
//        int s = Integer.parseInt(st.nextToken());

        /*int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }*/

        System.out.println(solution.solution(n));
    }
}
