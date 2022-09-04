import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int[] answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        for (int i = 1; i <= n; i++) {
            answer[i - 1] = i;
        }

        do {
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        } while (go());

    }

    static boolean go() {
        // 1. 오른쪽부터 i와 i-1을 비교하여 i-1이 더 작을때까지 비교한다. (i찾기)
        int i = n - 1;
        while (i > 0 && answer[i] <= answer[i - 1]) {
            i--;
        }

        // 마지막 순열이라면 -1 리턴
        if (i <= 0) {
            return false;
        }

        // 2. i를 찾았으면 제일 끝에서부터 i-1보다 큰 값을 찾는다.
        // i 부터 끝까지지 내림차순이기 때문에 뒤에서부터 i-1보다 큰지만 비교하면 된다.
        int j = n - 1;
        while (answer[i - 1] >= answer[j]) {
            j--;
        }

        // 3. i-1과 j의 자리를 바꿔준다.
        int temp = answer[i - 1];
        answer[i - 1] = answer[j];
        answer[j] = temp;

        // 4. 그 다음 i부터 끝까지 자리를 하나씩 바꿔준다.
        j = n - 1;
        while (i < j) {
            temp = answer[i];
            answer[i] = answer[j];
            answer[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}