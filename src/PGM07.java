import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class PGM07 {

    /**
     * 다트 게임
     *
     * @param dartResult
     * @return
     */
    public int solution(String dartResult) {
        int answer = 0;
        int result[] = new int[3];
        int count = -1;
        char[] result_arr = dartResult.toCharArray();
        StringBuilder check_string = new StringBuilder();

        for (int i = 0; i < result_arr.length; i++) {
            if (Character.isDigit(result_arr[i])) {
                check_string.append(result_arr[i]);
            } else {
                if (result_arr[i] == '*' || result_arr[i] == '#') {
                    check_string.append(result_arr[i]).append(" ");
                } else {
                    check_string.append(" ").append(result_arr[i]).append(" ");
                }
            }
        }

        String[] s = check_string.toString().split(" ");
        for (String i : s) {
            boolean number = true;
            for (char j : i.toCharArray()) {
                if (!Character.isDigit(j)) {
                    number = false;
                }
            }
            if (number) {
                count++;
                result[count] = Integer.parseInt(i);
            } else if (i.equals("D")) {
                result[count] *= result[count];
            } else if (i.equals("T")) {
                result[count] *= result[count] * result[count];
            } else if (i.equals("*")) {
                if (count > 0) {
                    result[count - 1] *= 2;
                }
                result[count] *= 2;
            } else if (i.equals("#")) {
                result[count] *= -1;
            }
        }

        for (int a : result) {
            answer += a;
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        PGM07 solution = new PGM07();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String s = "1S2D*3T";
//        String s = "1D2S#10S";
        String s = "1S*2T*3S";
//        String s = "1S2D3T*";
        System.out.println(solution.solution(s));
    }
}
