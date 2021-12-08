import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Test08 {

    /**
     * 두 용액
     * KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다.
     * 각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다.
     * 산성 용액의 특성값은 1부터 1,000,000,000까지의 양의 정수로 나타내고,
     * 알칼리성 용액의 특성값은 -1부터 -1,000,000,000까지의 음의 정수로 나타낸다.
     * 같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다.
     * 이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.
     * 예를 들어, 주어진 용액들의 특성값이 [-2, 4, -99, -1, 98]인 경우에는 특성값이 -99인 용액과
     * 특성값이 98인 용액을 혼합하면 특성값이 -1인 용액을 만들 수 있고, 이 용액이 특성값이 0에 가장 가까운 용액이다.
     * 참고로, 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을
     * 만드는 경우도 존재할 수 있다.
     *
     * 산성 용액과 알칼리성 용액의 특성값이 주어졌을 때, 이 중 두 개의 서로 다른 용액을 혼합하여
     * 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
     *
     * 풀이
     *
     * scanner를 사용하면 시간초과가 발생한다.
     * BufferReader를 사용하자 앞으로는.
     *
     * ~과 가까운 것을 찾을 때는 절대값으로 찾아야 한다. Math.abs()로 찾자.
     * 0에 가까운 값을 찾으려면 두 수의 합의 절대값이 제일 작은게 답이다.
     * 먼저 합한 다음에 절대값으로 비교해야 한다. 그래야 0과 가까운 값을 찾을 수 있다.
     * 비교값을 max_value 로 넣어주고 비교값보다 작으면 비교값을 갱신해준다.
     * 그리고 그때 두 용액도 같이 갱신해준다.
     * 다 돌고 나서 두 용액을 출력해준다.
     * @param n
     * @param arr
     * @return
     */
    public int[] solution(int n, int[] arr) {

        int answer[] = new int[2];
        int result = Integer.MAX_VALUE;
        int lt = 0, rt = n-1;

        Arrays.sort(arr);

        while (lt < rt) {
            int i = arr[rt] + arr[lt];

            if (Math.abs(i) < result) {
                answer[0] = arr[lt];
                answer[1] = arr[rt];
                result = Math.abs(i);

                if (i == 0) {
                    break;
                }
            }

            if (i > 0) {
                rt--;
            } else {
                lt++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Test08 solution = new Test08();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] solution1 = solution.solution(n, arr);
        System.out.println(solution1[0] + " " + solution1[1]);
    }
}
