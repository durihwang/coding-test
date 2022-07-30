import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public void solution(String s) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i));
        }

        Collections.sort(list);

        for (String t : list) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) throws IOException {

        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }*/

        String s = br.readLine();

        solution.solution(s);

    }
}
