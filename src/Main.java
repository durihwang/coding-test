import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public int solution(int m, Integer[][] n) {

        int answer = 0;
        Arrays.sort(n, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        for (Integer[] ints : n) {
            if (m >= ints[0]) {

            }
        }

        if (answer == 0) {
            return -1;
        } else {
            return answer;
        }
    }

    public static void main(String[] args) throws IOException {

        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer[][] nn = new Integer[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            Integer[] ints = new Integer[2];
            ints[0] = Integer.parseInt(stt.nextToken());
            ints[1] = Integer.parseInt(stt.nextToken());
            nn[i] = ints;
        }

        System.out.println(solution.solution(m, nn));

        br.close();
    }
}
