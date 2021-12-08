import java.util.Arrays;
import java.util.Scanner;

class Main {

    public int solution(int n, int[] arr, int x) {

        int answer = 0;
        int lt = 0, rt = n-1;

        Arrays.sort(arr);

        while (lt < rt) {
            int i = arr[rt] + arr[lt];
            if (i == x) {
                answer++;
                lt++;
            } else if (i < x) {
                lt++;
            } else if (i > x) {
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

//        int[] arr = new int[]{5, 12, 7, 10, 9, 1, 2, 3, 11};
//        int[] arr = new int[]{1, 2, 3, 5, 7, 9, 10, 11, 12};
        System.out.println(solution.solution(n, arr, x));
    }
}
