import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer = 0;
    static int[][] s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = go(0, new ArrayList<>(), new ArrayList<>(), n);

        System.out.println(answer);
    }

    static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second, int n) {

        // 인덱스와 주어진 n값이 같은 경우
        if (index == n) {
            if (first.size() != n / 2) {
                return -1;
            }
            if (second.size() != n / 2) {
                return -1;
            }

            int t1 = 0;
            int t2 = 0;

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    if (i == j) {
                        continue;
                    }
                    t1 += s[first.get(i)][first.get(j)];
                    t2 += s[second.get(i)][second.get(j)];
                }
            }

            System.out.println(t1);
            System.out.println(t2);
            System.out.println();
            return Math.abs(t1 - t2);

        } else {

            if (first.size() > n / 2) {
                return -1;
            }
            if (second.size() > n / 2) {
                return -1;
            }
            int ans = -1;

            // 첫번째 팀인 경우
            first.add(index);
            int team1 = go(index + 1, first, second, n);
            if (team1 != -1 && ans > team1) {
                ans = team1;
            }
            first.remove(first.size() - 1);

            // 두번째 팀인 경우
            second.add(index);
            int team2 = go(index + 1, first, second, n);
            if (team2 != -1 && ans > team2) {
                ans = team2;
            }
            second.remove(second.size() - 1);

            return ans;
        }
   }


}
