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
    static boolean check;
    static ArrayList<Long> reduction = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            recursive(1, i);
        }

        System.out.println(reduction.size());
        Collections.sort(reduction);

        if (n < 10) {
            System.out.println(n);
        } else {
            if (reduction.size() <= n) {
                System.out.println(-1);
            } else {
                System.out.println(reduction.get(n));
            }
        }
    }

    public static void recursive(int level, long number) {

        if (level > 10) {
            return;
        }

        reduction.add(number);

        for (int i = 0; i < number % 10; i++) {
            recursive(level + 1, (number * 10) + i);
        }
    }
}