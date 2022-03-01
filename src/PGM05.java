import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class PGM05 {

    /**
     * 실패율
     *
     * @param N
     * @param stages
     * @return
     */
    public int[] solution(int N, int[] stages) {
        int[] answer;
        HashMap<Integer, Integer> percent = new HashMap<>();
        HashMap<Integer, Integer> challenger = new HashMap<>();
        LinkedHashMap<Integer, Double> result = new LinkedHashMap<>();

        // 총 도전횟수와 실패한 사람의 숫자를 세기 위한 초기화
        for (int i = 1; i <= N; i++) {
            percent.put(i, 0);
            challenger.put(i, 0);
        }

        for (int i = 0; i < stages.length; i++) {

            // N+1과 현재 숫자가 같으면 모든 스테이지를 통과했다는 것이므로 전체 성공횟수 +1
            if (stages[i] != N + 1) {
                percent.put(stages[i], percent.getOrDefault(stages[i], 0) + 1);
                for (int j = 1; j <= stages[i]; j++) {
                    challenger.put(j, challenger.getOrDefault(j, 0) + 1);
                }
            } else {
                // 그게 아니면 현재 스테이지보다 밑에 스테이지들 모두 성공횟수 +1
                for (int j = 1; j < stages[i]; j++) {
                    challenger.put(j, challenger.getOrDefault(j, 0) + 1);
                }
            }
        }

        // 실패율을 구한다.
        // 실패횟수 / 성공한 스테이지 = 실패율
        // 순서를 보장하는 LinkedHashMap 으로 실패율을 담는다.
        // 스테이지와 실패율을 map에 담아준다.
        percent.forEach((keys, values) -> {
            if (values == 0) {
                result.put(keys, 0.0);
            } else {
                Integer all = challenger.get(keys);
                double fail = values / (all * 1.0);
                result.put(keys, fail);
            }
        });

        // result를 실패율 내림차순으로 정렬해준다.
        List<Map.Entry<Integer, Double>> collect = result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        // 위에서 정렬한 list의 스테이지(key)만 list로 다시 담는다.
        ArrayList<Integer> answer_list = new ArrayList<>();
        for (Map.Entry<Integer, Double> s : collect) {
            answer_list.add(s.getKey());
        }

        // answer array에 담는다.
        answer = answer_list.stream().mapToInt(i -> i).toArray();

        return answer;
    }


    public static void main(String[] args) throws IOException {
        PGM05 solution = new PGM05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numbers[] = {2, 1, 2, 6, 2, 4, 3, 3};
//        int numbers[] = {4,4,4,4,4};
        solution.solution(5, numbers);
    }
}
