import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CP01 {

    public int solution(int[] nums, int amount) {

        int result = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int answer = 0;
            int tempAmount = amount;
            answer += amount / nums[i];
            int n = amount % nums[i];
            tempAmount %= nums[i];
            if (n == 0) {
                result = Math.min(result, answer);
            } else {
                for (int j = 0; j < i; j++) {
                    answer += tempAmount / nums[j];
                    int m = tempAmount % nums[j];
                    tempAmount %= nums[j];
                    if (m == 0) {
                        result = Math.min(result, answer);
                        break;
                    }
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        CP01 solution = new CP01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = {8, 7, 5, 3, 2};
        System.out.println(solution.solution(nums, 12));
    }
}
