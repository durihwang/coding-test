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
        for (int i = 1; i <= N; i++) {
            percent.put(i, 0);
            challenger.put(i, 0);
        }

        for (int i = 0; i < stages.length; i++) {
            if (stages[i] != N + 1) {
                percent.put(stages[i], percent.getOrDefault(stages[i], 0) + 1);
                for (int j = 1; j <= stages[i]; j++) {
                    challenger.put(j, challenger.getOrDefault(j, 0) + 1);
                }
            } else {
                for (int j = 1; j < stages[i]; j++) {
                    challenger.put(j, challenger.getOrDefault(j, 0) + 1);
                }
            }
        }

        percent.forEach((keys, values) -> {
            if (values == 0) {
                result.put(keys, 0.0);
            } else {
                Integer all = challenger.get(keys);
                double fail = values / (all * 1.0);
                result.put(keys, fail);
            }
        });

        // result 내림차순으로 정렬
        List<Map.Entry<Integer, Double>> collect = result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        ArrayList<Integer> answer_list = new ArrayList<>();

        for (Map.Entry<Integer, Double> s : collect) {
            answer_list.add(s.getKey());
        }

        answer = answer_list.stream().mapToInt(i -> i).toArray();

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));

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
