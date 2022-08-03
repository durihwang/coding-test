import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(br.readLine());
        int n = 0;
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            n += Character.getNumericValue(s.charAt(i));
        }
        System.out.println(n);
    }
}
