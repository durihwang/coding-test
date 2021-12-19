import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Test14 {

    /**
     * 크레인 인형뽑기(카카오)
     *
     * N x N 격자판에 인형이 들어있고 그 인형을 moves 배열로 옮긴다.
     * 같은 인형이(같은 숫자) moves 배열에 들어오면 인형을 없애고 answer를 +2 해준다.
     * 첫 줄에 자연수 N(5<=N<=30)이 주어집니다.
     * 두 번째 줄부터 N*N board 배열이 주어집니다.
     * board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
     * 0은 빈 칸을 나타냅니다.
     * 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
     * board배열이 끝난 다음줄에 moves 배열의 길이 M이 주어집니다.
     * 마지막 줄에는 moves 배열이 주어집니다.
     * moves 배열의 크기는 1 이상 1,000 이하입니다.
     * moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
     *
     * 풀이
     *
     * @param n
     * @param pos
     * @param m
     * @param moves
     * @return
     */
    public int solution(int n, int[][] pos, int m, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        // m의 크기만큼 for문을 돌린다.
        for (int i = 0; i < m; i++) {
            // 집게를 내려서 인형을 집어야 하기 때문에 N x N의 특정 열만 for문을 돌려준다.
            for (int j = 0; j < n; j++) {

                // 해당 값이 0이 아닐 때에만 진행해준다.
                // moves 배열에서의 숫자는 열을 의미하므로 숫자에 -1을 해줘야 해당 열을 찾을 수 있다.
                // moves[i] - 1 -> 해당 열
                // pos[j] -> 해당 열의 순서대로 탐색하기 위해 j를 넣어준다.
                if (pos[j][moves[i] - 1] != 0) {

                    // 스택이 비어있으면 그대로 넣어준다.
                    if (stack.isEmpty()) {
                        stack.push(pos[j][moves[i] - 1]);
                    } else {
                        // 아니면 스택에 제일 위에 값이랑 현재 값이랑 비교해준다.
                        // 같으면 answer를 +2 해주고 스택 제일 위에값만 스택에서 제거해준다.
                        if (pos[j][moves[i] - 1] == stack.peek()) {
                            stack.pop();
                            answer += 2;
                        } else {
                            // 같이 않으면 그대로 해당 값을 스택에 넣어준다.
                            stack.push(pos[j][moves[i] - 1]);
                        }
                    }

                    // 해당 값이 0이 아닌 경우에는 이미 해당 값을 꺼낸 것이므로 해당 값을 0으로 바꿔주고
                    // for문을 break 해준다.
                    pos[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        Test14 solution = new Test14();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /*StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());*/

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st3.nextToken());
        }
        System.out.println(solution.solution(n, arr, m, moves));
        /*for (int s : solution.solution(n, arr)) {
            System.out.println(s);
        }*/
    }
}
