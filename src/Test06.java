import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test06 {

    /**
     * 로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다.
     * 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
     * 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
     * 알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다.
     * 당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
     *
     * 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
     * 알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
     * 3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
     * 알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
     * 5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
     *
     * 풀이
     * 어려운 문제는 아니지만 역시나 주어진 문제를 잘 읽어보고 모든 경우의 수를 다 생각해야 한다.
     * 일반 배열은 다루기가 귀찮기 때문에 당첨번호를 ArrayList로 변환해서 푸는게 좋다.
     * 문제가 길다고 당황하지 말고 잘 읽어보자.
     * 일단 내 번호에서 닫첨번호에 들어있는 개수를 구한다.
     * 그리고 0의 개수를 구한다.
     * 두개를 더한 개수가 최대 맞은 개수이다.
     * 당첨번호에 들어있는 내 번호의 개수가 최저 맞은 개수이다.
     * 여기서 0이나 당첨번호에 들어있는 내 번호의 개수가 둘다 0인 경우도 있다.
     * 위 예외 경우만 잘 처리하면 쉽게 풀 수 있다.
     * @param lottos
     * @param win_nums
     * @return
     */
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int cnt = 0;
        int zero_cnt = 0;
        ArrayList<Integer> integers = new ArrayList<>();

        // 로또 등수를 hashMap에 담아둔다.
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(6, 1);
        result.put(5, 2);
        result.put(4, 3);
        result.put(3, 4);
        result.put(2, 5);
        result.put(1, 6);

        // 당첨번호를 ArrayList에 담아서 편하게 사용할 수 있도록 한다.
        for (int i = 0; i < win_nums.length; i++) {
            integers.add(win_nums[i]);
        }

        // 내 번호에서 0의 개수와 당첨번호에 있는 내 번호의 개수를 구해준다.
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero_cnt++;
            } else {
                if (integers.contains(lottos[i])) {
                    cnt++;
                }
            }
        }

        // 최대 순위와 최저 순위를 구해준다.
        Integer best = result.get(cnt + zero_cnt);
        Integer worst = result.get(cnt);

        // 0이 없는 경우아 당첨번호에 내 번호가 하나도 없는 경우의 null check를 해준다.
        if (best == null) {
            best = 6;
        }
        if (worst == null) {
            worst = 6;
        }

        // 결과 배열에 담아준다.
        answer[0] = best;
        answer[1] = worst;
        return answer;
    }

    public static void main(String[] args) {
        Test06 solution = new Test06();
        int[] s = {0,0,0,0,0,0};
        int[] v = {38, 19, 20, 40, 15, 25};

        for (int i : solution.solution(s, v)) {
            System.out.print(i + " ");
        }
    }
}
