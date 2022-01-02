import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public String solution(String n, String k) {

        String answer = "";
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < n.length(); i++) {
            queue.add(n.charAt(i));
        }

        for (int i = 0; i < k.length(); i++) {
            if (queue.contains(k.charAt(i))) {
                if (queue.peek() == k.charAt(i)) {
                    queue.poll();
                } else {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        String k = br.readLine();

        System.out.println(solution.solution(n, k));
        /*for (int s : solution.solution(n, arr)) {
            System.out.println(s);
        }*/
    }
}
