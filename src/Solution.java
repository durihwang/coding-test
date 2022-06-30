import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        HashSet<Character> compare = new HashSet<>();
        int answer = 1;
        int i = 0;
        int j = 1;

        while (i < s.length() && j < s.length()) {
            if (!compare.contains(s.charAt(j)) && s.charAt(i) != s.charAt(j)) {
                compare.add(s.charAt(j));
                answer = Math.max(answer, j - i + 1);
                j++;
            } else {
                compare = new HashSet<>();
                i++;
                j = i + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(solution.lengthOfLongestSubstring(""));
    }
}
