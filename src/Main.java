import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

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
        Main solution = new Main();
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
