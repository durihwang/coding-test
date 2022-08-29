import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static String[] k;
    static boolean[] check;
    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        k = new String[n + 1];
        check = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            k[i] = st.nextToken();
        }

        go(0, "", n);

        Collections.sort(answer);
        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));

    }

    static void go(int level, String nums, int n) {
        if (level == n + 1) {
            if (ok(nums, n)) {
                answer.add(nums);
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                if (!check[i]) {
                    check[i] = true;
                    go(level + 1, nums + i, n);
                    check[i] = false;
                }
            }
        }
    }

    static boolean ok(String nums, int n) {
        for (int i = 0; i < n; i++) {
            int n1 = Character.getNumericValue(nums.charAt(i));
            int n2 = Character.getNumericValue(nums.charAt(i + 1));
            if (k[i].equals("<")) {
                if (n1 > n2) {
                    return false;
                }
            } else if (k[i].equals(">")) {
                if (n1 < n2) {
                    return false;
                }
            }
        }

        return true;
    }


}
