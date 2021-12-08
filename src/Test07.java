import java.util.Arrays;
import java.util.Scanner;

class Test07 {

    /**
     * 두 수의 합
     * n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
     * ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
     * 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.
     *
     * 풀이
     * 양쪽에 포인터를 두고 점점 좁혀 가면서 각 포인터의 자릿수를 더해서 x값이 나오는지 확인해준다.
     * 값을 확인하기 전에 배열을 한번 오름차순으로 정렬해야 한다.
     * 그래야 x보다 크면 오른쪽 포인터를 한칸 이동하고, 작으면 왼쪽 포인터를 한칸 이동할 수 있기 때문이다.
     * 두 수를 더한 값은 같을 수 없고 하나의 수가 하나의 수보다 작아야 하기 때문에 포인터를 양 끝에 놓았다.
     * @param n
     * @param arr
     * @param x
     * @return
     */
    public int solution(int n, int[] arr, int x) {

        int answer = 0;
        // lt는 0이고 rt는 arr의 크기만큼 지정해준다.
        int lt = 0, rt = n-1;

        // 오름차순으로 정렬한다.
        Arrays.sort(arr);

        // lt가 rt보다 작을때까지만 while문을 실행해야 한다.
        while (lt < rt) {
            int i = arr[rt] + arr[lt];
            // x와 값이 일치하면 왼쪽 포인터만 이동시킨다.
            if (i == x) {
                answer++;
                lt++;
            // i값이 더 작으면 왼쪽 포인터를 이동시켜 i값을 더 크게 만들어준다.
            } else if (i < x) {
                lt++;
            // i값이 더 크면 오른쪽 포인터를 이동시켜 i값을 더 작게 만들어준다.
            } else {
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test07 solution = new Test07();
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
