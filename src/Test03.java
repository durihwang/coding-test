import java.util.Scanner;

class Test03 {

    /**
     * 수들의 합
     * N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
     * 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가
     * M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
     *
     * 풀이
     * 투포인터 알고리즘을 이용해서 푼다.
     * 연속된 수열의 합이기 때문에 rt 포인터를 증가시켜주면서 값을 누적해준다.
     * 그러다가 M보다 크거나 같아지는 경우에 lt를 증가시켜 주면서 lt값만큼 sum에서 빼주고
     * 연속된 수열의 합이 m이랑 같은지 확인한다.
     * 연속된 수열이 같아지는 경우에도 lt를 증가시켜 주면서 빼주는 이유가 헷갈렸는데 그 이유는
     * 연속된 수열이 m이랑 같아지면 그 사이에서는 더이상 같은 수가 나올 수 없다는 말이기 때문에
     * 한칸 앞으로 이동하기 위해서 lt값만큼 빼주고 lt 자리를 증가시켜 주는 것이다.
     * @param n
     * @param m
     * @param arr
     * @return
     */
    public int solution(int n, int m, int[] arr) {
        int answer = 0, lt = 0, sum = 0;

        for (int rt = 0; rt < n; rt++) {

            // rt값을 누적해준다.
            sum += arr[rt];

            // sum 값이 m이랑 같은지 확인한다.
            if (sum == m) {
                answer++;
            }

            // sum이 m보다 크거나 같을때(같을 때는 sum에서 값을 빼고 lt값을 한칸 앞으로 이동하기 위해서 넣어주어야 한다.)
            // sum에서 lt값을 빼고 한칸 앞으로 이동해준다.
            // 그러다가 sum이랑 m이랑 같으면 또 answer를 증가시켜준다.
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test03 solution = new Test03();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution.solution(n, m, arr));
    }
}
