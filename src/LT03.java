import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class LT03 {

    public int solution(int n, int[] bankbook) {
        int answer = 0;
        Arrays.sort(bankbook);

        System.out.println(Arrays.toString(bankbook));
        return answer;
    }

    public static void main(String[] args) throws IOException {

        LT03 solution = new LT03();
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer[][] nn = new Integer[n][2];*/

        int[] bankbook = {8, 4, 2, 5, 3, 7};
        System.out.println(solution.solution(10, bankbook));

//        br.close();
    }
}
