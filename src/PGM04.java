import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PGM04 {

    /**
     * 키패드 누르기
     *
     * @param numbers
     * @param hand
     * @return
     */
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 키패드를 좌표형식으로 바꿔준다. *과 #은 10, 11로 치환한다.
        int keypad[][] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        int left_lo[] = keypad[10];
        int right_lo[] = keypad[11];

        // 왼쪽 오른쪽은 지문에 나온대로 찍어주면 된다.
        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer.append("L");
                left_lo = keypad[i];
            } else if (i == 3 || i == 6 || i == 9) {
                answer.append("R");
                right_lo = keypad[i];
            } else {

                // 가운데인 경우 왼쪽과 오른쪽의 거리를 계산한다.
                // 현재 지점과 왼쪽 오른쪽의 좌표지점의 거리를 계산하여 작은 것으로 누른다.
                // 같으면 왼손잡이, 오른손잡이에 따라 눌러준다.
                int[] pre_lo = keypad[i];
                int left = Math.abs(left_lo[0] - pre_lo[0]) + Math.abs(left_lo[1] - pre_lo[1]);
                int right = Math.abs(right_lo[0] - pre_lo[0]) + Math.abs(right_lo[1] - pre_lo[1]);

                if (left > right) {
                    answer.append("R");
                    right_lo = keypad[i];
                } else if (left < right) {
                    answer.append("L");
                    left_lo = keypad[i];
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right_lo = keypad[i];
                    } else {
                        answer.append("L");
                        left_lo = keypad[i];
                    }
                }
            }
        }

        return answer.toString();
    }


    public static void main(String[] args) throws IOException {
        PGM04 solution = new PGM04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        solution.solution(numbers, "right");
    }
}
