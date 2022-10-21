import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int k;
    static int answer;
    static String[] s;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = new String[n];
        answer = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine().replace("anta", "").replace("tica", "");
            s[i] = word;
        }

        if (k < 5) {
            System.out.println(0);
            System.exit(0);
        } else if (k > 25) {
            System.out.println(n);
            System.exit(0);
        }

        check = new boolean[26];
        check['a' - 'a'] = true;
        check['c' - 'a'] = true;
        check['i' - 'a'] = true;
        check['n' - 'a'] = true;
        check['t' - 'a'] = true;

        recursive(0, 0);

        System.out.println(answer);
    }

    static void recursive(int level, int index) {

        if (level == k - 5) {
            // 모든 단어를 순회하면서 조건 문자 배열에 값이 다 있는지 확인
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean read = true;
                for (int j = 0; j < s[i].length(); j++) {
                    if (!check[s[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        } else {
            for (int i = index; i < 26; i++) {
                if (!check[i]) {
                    check[i] = true;
                    recursive(level + 1, i);
                    check[i] = false;
                }
            }
        }
    }


}