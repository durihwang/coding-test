import java.util.*;

class Test01 {

    /**
     * 0과 1로 구성된 길이가 N인 수열이 주어집니다.
     * 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
     * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
     * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
     * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
     * 여러분이 만들 수 있는 1이 연속된 연속부분수열은 8입니다.
     *
     * 풀이
     * rt는 항상 앞으로 가고 lt는 조건이 다를 때 쫓아간다.
     * rt가 0을 만나면 1로 바꿔주고 cnt를 ++ 해준다.
     * 그리고 cnt가 k보다 클때만 lt를 앞으로 보내면서 lt 자리가 0일떄 cnt를 다시 -- 해준다.
     * 그리고 lt는 앞으로 한칸 이동한다.
     * 마지막에 최대수열의 길이를 구하는데 최대수열은 rt에서 lt를 뺀 값의 +1을 해주면 된다.
     * @param n
     * @param k
     * @param arr
     * @return
     */
    public int solution(int n, int k, int[] arr) {

        int answer = 0;
        int cnt = 0, lt = 0;

        for (int rt = 0; rt < n; rt++) {
            // rt자릿수의 값이 0일때 cnt를 ++ 해준다.
            if (arr[rt] == 0) {
                cnt++;
            }

            // cnt가 k보다 크면 안되니까 커지는 순간부터 rt의 이동을 멈추고 lt를 이동시킨다.
            while (cnt > k) {
                // lt를 이동시키면서 lt가 0을 만나면 아까 rt에서 ++ 해줬으니 다시 -- 해준다.
                if (arr[lt] == 0) {
                    cnt--;
                }
                // cnt를 -- 해주고 나서 lt를 앞으로 이동시킨다.
                lt++;
            }

            // 위 단계를 다 거치고 난 다음에 answer의 길이를 구한다.
            answer = Integer.max(answer, rt - lt + 1);

        }

        return answer;
    }

    public static void main(String[] args) {
        Test01 solution = new Test01();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution.solution(n, k, arr));

    }
}


