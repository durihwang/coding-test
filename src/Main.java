import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long[] d = new long[n + 1];
        d[0] = 1;

        for (int i = 2; i <= n; i += 2) {
            d[i] = 3 * d[i - 2];
            for (int j = i - 4; j >= 0; j -= 2) {
                d[i] += d[j] * 2;
            }

        }

//        System.out.println(Arrays.toString(d));
        System.out.println(d[n]);


    }


}