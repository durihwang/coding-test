import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public String[] solution(String[][] booked, String[][] unbooked) {

        ArrayList<String> answer = new ArrayList<>();
        int time;
        int bIndex = 0;
        int uIndex = 0;

        if (booked.length == 0) {
            for (String[] s : unbooked) {
                answer.add(s[1]);
            }
            return answer.toArray(String[]::new);
        } else {
            time = Math.min(convertTime(booked[bIndex][0]), convertTime(unbooked[uIndex][0]));
        }

        while (bIndex < booked.length || uIndex < unbooked.length) {
            if (bIndex < booked.length && time >= convertTime(booked[bIndex][0])) {
                time = addTime(booked[bIndex][0]);
                answer.add(booked[bIndex][1]);
                bIndex++;
            } else if (uIndex < unbooked.length && time >= convertTime(unbooked[uIndex][0])){
                time = addTime(unbooked[uIndex][0]);
                answer.add(unbooked[uIndex][1]);
                uIndex++;
            } else if (bIndex < booked.length) {
                time = addTime(booked[bIndex][0]);
                answer.add(booked[bIndex][1]);
                bIndex++;
            } else {
                time = addTime(unbooked[uIndex][0]);
                answer.add(unbooked[uIndex][1]);
                uIndex++;
            }
        }

        return answer.toArray(String[]::new);
    }

    private int addTime(String time) {
        String[] splitTime = time.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int min = Integer.parseInt(splitTime[1]) + 10;
        if (min >= 60) {
            hour++;
            min -= 60;
        }

        String resultTime = hour + String.format("%02d", min);
        return Integer.parseInt(resultTime);
    }

    private int convertTime(String time) {
        String replaceTime = time.replace(":", "");
        return Integer.parseInt(replaceTime);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] booked = {{"09:55","hae"}, {"10:05","jee"}};
        String[][] unbooked = {{"10:04","hee"}, {"14:07","eom"}};

        System.out.println(Arrays.toString(solution.solution(booked, unbooked)));
    }
}
