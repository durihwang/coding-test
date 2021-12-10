import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

class Test13 {

    /**
     * 스택
     * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
     *
     * 명령은 총 다섯 가지이다.
     *
     * push X: 정수 X를 스택에 넣는 연산이다.
     * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * size: 스택에 들어있는 정수의 개수를 출력한다.
     * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
     * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     *
     * 풀이
     * 스택의 기본 구조만 알면 쉽게 풀 수 있다.
     * @param n
     * @param arr
     * @return
     */
    public ArrayList<Integer> solution(int n, String[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            String x = arr[i];
            String[] s = x.split(" ");

            if (s[0].equals("push")) {
                stack.push(Integer.parseInt(s[1]));
            } else if (s[0].equals("pop")){
                if (stack.isEmpty()) {
                    answer.add(-1);
                } else {
                    answer.add(stack.pop());
                }
            } else if (s[0].equals("size")){
                answer.add(stack.size());
            } else if (s[0].equals("empty")){
                if (stack.isEmpty()) {
                    answer.add(1);
                } else {
                    answer.add(0);
                }
            } else {
                if (stack.isEmpty()) {
                    answer.add(-1);
                } else {
                    int top = stack.peek();
                    answer.add(top);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Test13 solution = new Test13();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /*StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());*/

        String[] arr = new String[n];
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

//        System.out.println(solution.solution(n, arr));
        for (int s : solution.solution(n, arr)) {
            System.out.println(s);
        }
    }
}
