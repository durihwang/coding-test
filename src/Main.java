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
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        HashSet<Character> set = new HashSet<>();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
            char[] chars = s[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                set.add(chars[j]);
            }
        }

        Character[] chars = set.toArray(new Character[0]);
        check = new boolean[chars.length];

        HashSet<Character[]> characters = new HashSet<>();
        if (k < 5) {
            System.out.println(0);
        } else {
            recursive(0, chars, characters);
        }
    }

    static void recursive(int level, Character[] chars, HashSet<Character[]> characters) {

        if (level == k) {
            // 모든 단어를 순회하면서 조건 문자 배열에 값이 다 있는지 확인
            System.out.println(Arrays.toString(check));
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    recursive(level + 1, chars, characters);
                    check[i] = false;
                }
            }
        }
    }

    static void checkWord() {

    }

}