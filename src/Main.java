import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {

    public ArrayList<Integer> solution(int x, int[] n) {

        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < x; i++) {

            int tmp = n[i];
            int number = 0;

            while (tmp >  0) {
                number = number * 10 + (tmp % 10);
                tmp /= 10;
            }

            boolean isPrime = true;

            if (number == 1) {
                isPrime = false;
            } else {

                for (int j = 2; j < number; j++) {
                    if (number % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                answer.add(number);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int x : solution.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
