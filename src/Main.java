import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int m;
    static List<Integer> numbers;
    static int[] check;
    static int[] visited;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        go(0, 0);

        System.out.println(answer);
    }

    static void go(int level, int sum) {

        // 첫번째와 마지막 값은 고를 수 없으니 n-2까지만 level을 돌리면 된다.
        if (level == n - 2) {
            // 최대값을 갱신해준다.
            answer = Math.max(answer, sum);
        } else {
            for (int i = 1; i < numbers.size() - 1; i++) {

                // x-1 곱하기 x+1의 값을 저장한다.
                int temp = numbers.get(i - 1) * numbers.get(i + 1);

                // i의 값을 따로 저장한다.
                int temp_index = numbers.get(i);

                // i 인덱스의 값을 빼준다.
                numbers.remove(i);

                // dfs를 실행한다.
                go(level + 1, sum + temp);

                // i 인덱스에 원래 값을 다시 넣어주어 백트래킹을 해준다.
                numbers.add(i, temp_index);
            }
        }

    }
}