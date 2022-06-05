import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public int solution(int[] rooms) {
        int answer = 0;
        int swap = 0;
        for (int i = 0; i < rooms.length; i++) {

            int room = i + 1;
            int key = rooms[i];
            if (room == key) {
                answer++;
            } else if (room > key) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] s = {3,1,2,4};
//        int[] s = {2,3,4,5,1};
//        int[] s = {1,2,3,4,5,6};
        System.out.println(solution.solution(s));
    }
}
