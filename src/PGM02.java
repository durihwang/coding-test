import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PGM02 {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static int n, m, k, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int ch[], dis[];
    static int ch2[];

    /**
     * 단어 변환
     *
     * @param begin
     * @param target
     * @param words
     * @return
     */
    public int solution(String begin, String target, String[] words) {

        int answer = 0;
        ch = new int[words.length];

        if (Arrays.asList(words).contains(target)) {
            answer = bfs(begin, target, words);
        } else {
            return 0;
        }

        return answer;
    }

    public int bfs(String begin, String target, String[] words) {

        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        int level = 0;
        while (!q.isEmpty()) {
            String change = q.poll();
            if (change.equals(target)) {
                return level;
            }
            for (int i = 0; i < words.length; i++) {
                if (ch[i] == 0) {
                    int chk = 0;
                    int chk_target = 0;
                    for (int j = 0; j < change.length(); j++) {
                        if (change.charAt(j) == words[i].charAt(j)) {
                            chk++;
                        }
                        if (target.charAt(j)  == words[i].charAt(j)) {
                            chk_target++;
                        }
                    }

                    if (chk == target.length() - 1) {
                        if (chk_target == target.length() - 1) {
                            return level + 2;
                        } else {
                            ch[i] = 1;
                            level++;
                            q.offer(words[i]);
                        }
                        break;
                    }
                }
            }
        }

        return 0;
    }

    public int dfs(int v) {

        if (n == v) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch2[nv] == 0) {
                    ch2[nv] = 1;
                    dfs(nv);
                    ch2[nv] = 0;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        PGM02 solution = new PGM02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        /*int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n];
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }*/

//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        ch = new int[n + 1];
        ch2 = new int[n + 1];
        dis = new int[n + 1];
        /*for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
        }*/

        String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] strings = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution.solution("hit", "cog", strings));
    }
}
