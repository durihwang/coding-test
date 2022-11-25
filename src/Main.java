import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] d = new int[1000001];
        int mod = 15746;

        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= 1000000; i++) {
            d[i] = d[i - 1] + d[i - 2];
            d[i] %= mod;
        }

        System.out.println(d[n] % mod);


    }



}