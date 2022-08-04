import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringBuilder append = stringBuilder.append("*");
            String format = String.format("%" + n + "S", append);
            StringBuilder reverse = new StringBuilder(format).reverse();
            String convert = format + reverse.substring(1);
            System.out.println(convert);
        }
    }
}
