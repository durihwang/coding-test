import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public void solution(String[] s) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            int result = checkPalindrome(0, s[i].length() - 1, 0, s[i]);

            if (result == 2) {

            } else {
                list.add(result);
            }
        }

        for (int x : list) {
            System.out.println(x);
        }
    }

    private int checkPalindrome(int left, int right, int check, String s) {

        int pseudo = 0;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                check++;
                pseudo = Math.min(checkPalindrome(left + 1, right, check, s),
                    checkPalindrome(left, right - 1, check, s));
            }
            left++;
            right--;
        }

        System.out.println("pseudo = " + pseudo);

        if (check >= 2) {
            return 2;
        } else if (check == 1){
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {

        Main solution = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        solution.solution(s);

    }
}
