import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {

    public String longestCommonPrefix(String[] strs) {

        String answer = "";
        int start = 0;
        int end = 0;

        while (start < strs.length && end < strs.length) {
            for (int i = 0; i < strs.length - 1; i++) {
                for (int j = 0; j < strs[i].length(); j++) {
                    System.out.println(strs[i].charAt(j));
                }
            }
        }


        return answer;

    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(s));
    }
}
