import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Test20 {

    /**
     * 수업계획
     *
     * 현수는 1년 과정의 수업계획을 짜야 합니다.
     * 수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
     * 만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
     * 여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
     * 현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
     * C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
     * 수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
     * 수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
     *
     * 풀이
     * 일단 필수과목을 큐에 넣는다.
     * 그리고 현수 수업계획을 돌리면서 큐에 있고 큐의 제일 첫번째와 해당 문자가 같으면 큐에 맨 처음을 poll해준다.
     * 만약 큐의 제일 처음과 해당 문자가 다르면 NO를 리턴해준다.
     * 현수 수업계획을 다 돌리고 나서 큐에 남아있는 게 있어도 NO를 리턴해준다.
     * @param n
     * @param k
     * @return
     */
    public String solution(String n, String k) {

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
        Test20 solution = new Test20();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        String k = br.readLine();

        System.out.println(solution.solution(n, k));
        /*for (int s : solution.solution(n, arr)) {
            System.out.println(s);
        }*/
    }
}
