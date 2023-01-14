import java.io.IOException;

public class Solution {

    public int solution(int N) {

        int answer = 0;
        int checkSum = sumOfDigits(N);
        N++;

        while (true) {
            int resultSum = sumOfDigits(N);
            if (checkSum == resultSum) {
                answer = N;
                break;
            }
            N++;
        }

        return answer;
    }

    private int numberOfDigits(int n) {
        int cnt = 0;

        while (n > 0) {
            cnt++;
            n /= 10;
        }

        return cnt;
    }
    
    private int sumOfDigits(int n) {

        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        System.out.println(solution.solution(535));
    }
}
