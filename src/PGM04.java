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

        int keypad[][] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        int left_lo[] = keypad[10];
        int right_lo[] = keypad[11];

        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer.append("L");
                left_lo = keypad[i];
            } else if (i == 3 || i == 6 || i == 9) {
                answer.append("R");
                right_lo = keypad[i];
            } else {
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

        System.out.println("answer = " + answer);

        return answer.toString();
    }


    public static void main(String[] args) throws IOException {
        PGM04 solution = new PGM04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        solution.solution(numbers, "right");
    }
}
