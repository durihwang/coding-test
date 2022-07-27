import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public int solution(String s, String t) {

        int answer = 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    answer = Math.max(answer, dp[i + 1][j + 1]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        System.out.println(solution.solution(s, t));

    }
}
