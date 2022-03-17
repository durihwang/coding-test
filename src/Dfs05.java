import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dfs05 {

    static int answer = Integer.MIN_VALUE, n, m;

    /**
     * 최대 점수 구하기
     *
     * 설명
     * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
     * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
     * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
     * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
     *
     *
     * 입력
     * 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
     * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
     *
     * 출력
     * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
     *
     * @param a
     * @param b
     * @return
     */
    public int solution(int[] a, int[] b) {

        dfs(0, 0, 0, a, b);

        return answer;
    }

    // 최대점수, 걸린 시간을 누적하고 레벨을 하나씩 증가시켜 준다.
    public void dfs(int L, int sum, int time, int[] a, int[] b) {

        if (time > m) {
            return;
        }

        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(L + 1, sum + a[L], time + b[L], a, b);
            dfs(L + 1, sum, time, a, b);
        }
    }



    public static void main(String[] args) throws IOException {
        Dfs05 solution = new Dfs05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int c = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st2.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(solution.solution(a, b));
    }
}
