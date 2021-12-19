import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Test15 {

    /**
     * 후위식 연산
     * 후위식 연산이랑 기본적인 중위식 연산에서 연산자를 가장 오른쪽에 두는 것.
     *
     * 풀이
     * 숫자가 아니면 연산자이기 때문에 숫자이면 스택에 쌓아둔다.
     * 연산자는 + - * / 4개이므로 해당하는 연산자가 오면 연산을 해준다.
     * 스택에서 두개의 숫자를 꺼낸다.
     * 후위식 연산은 마지막에 꺼낸 숫자에서 처음 꺼낸 숫자에 연산자를 이용해 연산해주어야 한다.
     * 그리고 나서 연산한 결과값을 다시 스택에 넣어준다.
     * @param n
     * @return
     */
    public int solution(String n) {

        int start = 0, last = 0;
        int result = 0;
        char[] chars = n.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                stack.push(Character.getNumericValue(chars[i]));
            } else {
                switch (chars[i]) {
                    case '+':
                        last = stack.pop();
                        start = stack.pop();
                        result = start + last;
                        stack.push(result);
                        break;
                    case '-':
                        last = stack.pop();
                        start = stack.pop();
                        result = start - last;
                        stack.push(result);
                        break;
                    case '/':
                        last = stack.pop();
                        start = stack.pop();
                        result = start / last;
                        stack.push(result);
                        break;
                    case '*':
                        last = stack.pop();
                        start = stack.pop();
                        result = start * last;
                        stack.push(result);
                        break;
                }
            }

        }

        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        Test15 solution = new Test15();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(br.readLine());
        String n = br.readLine();

        /*int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }*/

        System.out.println(solution.solution(n));
        /*for (int s : solution.solution(n, arr)) {
            System.out.println(s);
        }*/
    }
}
