import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dfs04 {

    static String[] answer;
    ArrayList<String> answer_list = new ArrayList<>();
    static String[][] tickets_compare;
    static int[] ch;
    static int n, k;

    /**
     * 프로그래머스 여행 경로
     *
     * 풀이
     * 여기서 제일 중요한 것은 백트래킹이다.
     * 해당 지점에서 여러 갈래로 길이 나누어져 있기 떄문에 꼭 해당 방문을 해제해 주어야 한다.
     *
     * @param tickets
     * @return
     */
    public String[] solution(String[][] tickets) {

        ch = new int[tickets.length];
        tickets_compare = tickets;
        Arrays.sort(tickets_compare, (o1, o2) -> {
            if(o1[0].contentEquals(o2[0]))
                return o1[1].compareTo(o2[1]);
            else
                return o1[0].compareTo(o2[0]);
        });

        /*for (String[] s : tickets_compare) {
            System.out.println(s[0]);
            System.out.println(s[1]);
        }*/

        dfs(0, "ICN", "ICN");
        System.out.println("answer_list = " + answer_list);
        answer = answer_list.get(0).split(" ");

        return answer;
    }

    public int dfs(int v, String start, String result) {

        if (v == tickets_compare.length) {
            answer_list.add(result);
            return 0;
        }

        for (int i = 0; i < tickets_compare.length; i++) {
            if (tickets_compare[i][0].equals(start) && ch[i] == 0) {
                ch[i] = 1;
                dfs(v + 1, tickets_compare[i][1], result + " " + tickets_compare[i][1]);
                ch[i] = 0;
            }
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
        Dfs04 solution = new Dfs04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        k = Integer.parseInt(st.nextToken());
//        n = Integer.parseInt(st.nextToken());
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
        /*for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }*/
//        m = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
        /*for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
        }*/


//        String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
        String tickets[][] = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        String tickets[][] = {{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}};

        for (String s : solution.solution(tickets)) {
            System.out.println(s);
        }
    }
}
