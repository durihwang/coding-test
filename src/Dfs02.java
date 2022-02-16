import java.io.IOException;

public class Dfs02 {
    public class Node {
        int value;
        Main.Node left;
        Main.Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(0, 0, target, numbers);
        return answer;
    }

    private void dfs(int sum, int depth, int target, int[] numbers) {

        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
        } else {
            dfs(sum + numbers[depth], depth + 1, target, numbers);
            dfs(sum - numbers[depth], depth + 1, target, numbers);
        }

    }

    public static void main(String[] args) throws IOException {
        Dfs02 solution = new Dfs02();
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n];
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }*/

        int[] numbers = {1, 1, 1, 1, 1};
        System.out.println(solution.solution(numbers, 3));
    }
}
