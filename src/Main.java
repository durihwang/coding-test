import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public long solution(long w, long h) {

        long gcd = 0;
        long a = w, b = h;

        while (b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        gcd = a;

        return (w * h) - (w + h - gcd);
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pm = new int[m];
        ch = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }*/

        int[] sizes1 = {1,2,3,9,10,12};
        int[] sizes2 = {4};
        System.out.println(solution.solution(3, 4));
    }
}
