import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

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
        Main solution = new Main();
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
