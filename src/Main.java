import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int[] numbers;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st2.nextToken());
        int minus = Integer.parseInt(st2.nextToken());
        int multi = Integer.parseInt(st2.nextToken());
        int divide = Integer.parseInt(st2.nextToken());

        recursive(0, plus, minus, multi, divide, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void recursive(int level, int plus, int minus, int multi, int divide, int sum) {
        if (level == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        } else {
            if (plus > 0)   recursive(level + 1, plus - 1, minus, multi, divide, sum + numbers[level+1]);
            if (minus > 0)   recursive(level + 1, plus, minus - 1, multi, divide, sum - numbers[level+1]);
            if (multi > 0)   recursive(level + 1, plus, minus, multi - 1, divide, sum * numbers[level+1]);
            if (divide > 0)   recursive(level + 1, plus, minus, multi, divide - 1, sum / numbers[level+1]);
        }
    }

}