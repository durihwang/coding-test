import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bfs02 {

    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] check;
    Node root;

    public int solution(int s, int e) {

//        dfs(0, 0, target, numbers);
        return bfs(s, e);

    }

    private int bfs(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        check = new int[10001];
        check[s] = 1;
        q.offer(s);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx == e) {
                        return level + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && check[nx] != 1) {
                        check[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            level++;
        }

        return 0;
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
        Bfs02 solution = new Bfs02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n];
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }*/

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(solution.solution(n, k));
    }
}
