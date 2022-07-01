import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static int[] check;
    List<List<Integer>> answer = new ArrayList<>();

    public int permute(int[] nums, int amount) {

        int result = Integer.MAX_VALUE;
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int s : nums) {
            list.add(s);
        }
        Collections.sort(list);

        for (int coin : list) {
            answer += amount / coin;
            int n = amount % coin;
            System.out.println(answer);
            if (n == 0) {
                result = Math.min(result, answer);
                answer = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = {8, 5, 3, 2, 1};
        System.out.println(solution.permute(nums, 12));
    }
}
