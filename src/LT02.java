import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class LT02 {

    public String solution(String s) {
        int answer = 0;
        String[] split = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (String x : split) {
            list.add(Integer.parseInt(x));
        }

        for (int i = 0; i < list.size(); i++) {
            Integer t = list.get(i);
            if (t > -200 && t < 200) {
                int first = 0;
                int second = 0;
                int third = 0;
                int last = 0;
                if (i - 2 >= 0) {
                    first = Math.abs(t - list.get(i - 2));
                }

                if (i - 1 >= 0) {
                    second = Math.abs(t - list.get(i - 1));
                }

                if (i + 1 < list.size()) {
                    third = Math.abs(t - list.get(i + 1));
                }

                if (i + 2 < list.size()) {
                    last = Math.abs(t - list.get(i + 1));
                }

                if (first < 3 && second < 3 && third < 3 && last < 3) {
                    result.add(t);
                }

            }
        }

        if (result.isEmpty()) {
            return "ERROR";
        }
        double average = result.stream().mapToInt(num -> num).summaryStatistics().getAverage();
        answer = (int) average;
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {

        LT02 solution = new LT02();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();

        System.out.println(solution.solution("10 13 9"));

//        br.close();
    }
}
