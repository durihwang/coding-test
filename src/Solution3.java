import java.io.IOException;
import java.util.Arrays;

public class Solution3 {

    public int solution(int N, String S) {

        int answer = 0;
        int[][] tickets = new int[N][10];
        if (!S.equals("")) {
            String[] booked = S.split(" ");
            for (int i = 0; i < booked.length; i++) {
                int x = Integer.parseInt(booked[i].replaceAll("[^0-9]", "")) - 1;
                Character y = booked[i].replaceAll("[0-9]", "").charAt(0);
                tickets[x][stringToInt(y)] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (tickets[i][1] == 0 && tickets[i][2] == 0 && tickets[i][3] == 0
                && tickets[i][4] == 0) {
                answer++;
                tickets[i][1] = 1;
                tickets[i][2] = 1;
                tickets[i][3] = 1;
                tickets[i][4] = 1;
            }

            if (tickets[i][5] == 0 && tickets[i][6] == 0 && tickets[i][7] == 0
                && tickets[i][8] == 0) {
                answer++;
                tickets[i][5] = 1;
                tickets[i][6] = 1;
                tickets[i][7] = 1;
                tickets[i][8] = 1;
            }

            if (tickets[i][3] == 0 && tickets[i][4] == 0 && tickets[i][5] == 0
                && tickets[i][6] == 0) {
                answer++;
                tickets[i][3] = 1;
                tickets[i][4] = 1;
                tickets[i][5] = 1;
                tickets[i][6] = 1;
            }
        }

        return answer;
    }

    private int stringToInt(Character s) {

        // A부터 K까지 문자가 넘어오면 숫자로 변환 후 리턴
        // J와 K는 숫자에 -1을 해준다. (I가 비어있기 때문
        if (s <= 'H') {
            return s - 65;
        }

        return s - 66;
    }

    public static void main(String[] args) throws IOException {
        Solution3 solution = new Solution3();

        System.out.println(solution.solution(1, ""));
//        System.out.println(solution.solution(2, "1A 2F 1C"));
//        System.out.println(solution.solution(22, "1A 3C 2B 20G 5A"));
    }
}
