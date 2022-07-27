import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public void solution(String[] s, String[] t) {

        int answer = 0;

        HashSet<String> list = new HashSet<>(Arrays.asList(s));
        ArrayList<String> result = new ArrayList<>();
        list.addAll(Arrays.asList(s));

        for (String y : t) {
            if (list.contains(y)) {
                result.add(y);
                answer++;
            }
        }

        Collections.sort(result);
        System.out.println(answer);
        for (String z : result) {
            System.out.println(z);
        }
    }

    public static void main(String[] args) throws IOException {

        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] s = new String[n];
        String[] t = new String[m];

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            t[i] = br.readLine();
        }

        solution.solution(s, t);

    }
}
