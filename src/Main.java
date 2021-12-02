import java.util.Scanner;

class Main {

    public int solution(int n, int m, int[] arr) {

        return 0;
    }

    public static void main(String[] args) {
        Test03 solution = new Test03();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution.solution(n, m, arr));
    }
}
